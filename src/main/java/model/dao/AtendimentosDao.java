/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DB.DB;
import model.classes.Funcionarios;
import model.classes.Clientes;
import model.classes.Servicos;
import model.classes.Atendimentos;
import model.classes.Pessoas;

import java.sql.Connection;

/**
 *
 * @author aluno
 */
public class AtendimentosDao {

    private Connection con;

    public AtendimentosDao(Connection con) {
        this.con = con;
    }

    public List<Atendimentos> getAll() {
        List<Atendimentos> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT Atendimentos.*, Pessoas.* FROM Atendimentos "
                    + "JOIN Pessoas ON (Pessoas.cpf = Atendimentos.cpfCliente)";
            stmt = con.prepareStatement(sql);
            res = stmt.executeQuery();

            while (res.next()) {
                Pessoas p;
                if (res.getInt("tipo") == 1) {
                    p = new Clientes(res.getString("cpf"), res.getString("nome"), res.getString("telefone"));
                } else {
                    p = new Funcionarios(res.getString("cargo"), res.getString("senhaEntrada"), res.getString("cpf"), res.getString("nome"), res.getString("telefone"));
                }

                Atendimentos atendimento = new Atendimentos(
                        res.getInt("codAtendimento"),
                        res.getTimestamp("dataAtendimento").toLocalDateTime(),
                        res.getString("observacoes"),
                        p
                );

                // ## CORREÇÃO: Usando novas variáveis (stmt2, res2) para a consulta interna ##
                PreparedStatement stmt2 = null;
                ResultSet res2 = null;

                try {
                    String sql2 = "SELECT * FROM AtendimentosServicos "
                            + "JOIN servicos ON (servicos.codServico = AtendimentosServicos.fk_codServico) "
                            + "WHERE fk_codAtendimento = ?";

                    stmt2 = con.prepareStatement(sql2);
                    stmt2.setInt(1, atendimento.getCodAtendimento()); // Usando PreparedStatement corretamente

                    res2 = stmt2.executeQuery();

                    while (res2.next()) {
                        Servicos servico = new Servicos(res2.getInt("codServico"), res2.getString("descricao"), res2.getFloat("preco"));
                        atendimento.getServicos().add(servico);
                    }
                } finally {
                    // Fechamos os recursos da consulta interna aqui dentro
                    DB.closeResultSet(res2);
                    DB.closeStatement(stmt2);
                }

                list.add(atendimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(res);
            DB.closeStatement(stmt);
        }
        return list;
    }

    public boolean inserir(Atendimentos atend) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "insert into Atendimentos(observacoes, dataAtendimento, cpfCliente) "
                    + "values (?,?,?)";
            stmt = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, atend.getObservacoes());
            stmt.setDate(2, Date.valueOf(atend.getDataHora().toLocalDate()));
            stmt.setString(3, atend.getPessoa().getCpf());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    atend.setCodAtendimento(id);
                    result = true;
                }
            } else {
                throw new SQLException("Não foi possível inserir");
            }
            // inserir os servicos
            for (int i = 0; i < atend.getServicos().size(); i++) {

                sql = "insert into AtendimentosServicos (fk_codServico,fk_codAtendimento) values (?,?)";

                stmt = con.prepareStatement(sql);

                stmt.setInt(1, atend.getServicos().get(i).getCodServico());
                stmt.setInt(2, atend.getCodAtendimento());
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;

        }

    }

    public boolean excluir(Atendimentos atend) {
        PreparedStatement stmt1 = null; 
        PreparedStatement stmt2 = null; 
        boolean result = false;

        try {
            con.setAutoCommit(false);

            String sql1 = "DELETE FROM AtendimentosServicos WHERE fk_codAtendimento = ?";
            stmt1 = con.prepareStatement(sql1);
            stmt1.setInt(1, atend.getCodAtendimento());
            stmt1.executeUpdate();

            String sql2 = "DELETE FROM Atendimentos WHERE codAtendimento = ?";
            stmt2 = con.prepareStatement(sql2);
            stmt2.setInt(1, atend.getCodAtendimento());
            stmt2.executeUpdate();

            con.commit();
            result = true;

        } catch (SQLException e) {
            try {
                con.rollback();
                System.err.println("A transação foi revertida (rollback).");
            } catch (SQLException ex) {
                System.err.println("Erro ao tentar reverter a transação: " + ex.getMessage());
            }
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt1);
            DB.closeStatement(stmt2);
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
