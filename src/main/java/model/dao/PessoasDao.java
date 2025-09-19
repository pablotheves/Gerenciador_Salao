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

/**
 *
 * @author aluno
 */
public class PessoasDao {
    private Connection con;

    public PessoasDao(Connection con) {
        this.con = con;
    }
    
    public List<Pessoas> getAll(){
        List<Pessoas> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;
        
        try {
            String sql = "select * from Pessoas";
            stmt = con.prepareStatement(sql);
            
            res = stmt.executeQuery();
            
            while(res.next()){
                Pessoas p;
                
                if (res.getInt("tipo") == 1) {
                    p = new Clientes(res.getString("cpf"),
                                                    res.getString("nome"),
                                                    res.getString("telefone"));
                }else{
                    p = new Funcionarios(res.getString("cargo"),//cria uma lista para 
                                                    res.getString("senhaEntrada"),
                                                    res.getString("cpf"),
                                                    res.getString("nome"),
                                                    res.getString("telefone"));
                }   
                System.out.println(p);
                list.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally{
           DB.closeResultSet(res);
           DB.closeStatement(stmt);
           return list;
           
        }
    }
    
    //inserir
    public boolean inserir(Pessoas pessoa){
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            
            String sql = "insert into Pessoas(cpf, nome, telefone, tipo, cargo, senhaEntrada)" +
                    "values (?,?,?,?,?,?)";

            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getTelefone());
            
            if(pessoa instanceof Clientes){
                // setando o campo tipo (4) para o número 1 (cliente)
                stmt.setInt(4, 1);
                stmt.setNull(5, java.sql.Types.NULL);
                stmt.setNull(6, java.sql.Types.NULL);
                
            }else if(pessoa instanceof Funcionarios){
                stmt.setInt(4, 2);
                stmt.setString(5, ((Funcionarios) pessoa).getCargo());
                stmt.setString(6, ((Funcionarios) pessoa).getSenhaEntrada());
            }
           
            stmt.executeUpdate();
            
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
            
        }
    }
    
     public boolean editar(Pessoas pessoa){
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            
            String sql = "update Pessoas set nome = ? , telefone = ?, tipo = ?, cargo = ?, senhaEntrada = ?" +
                    " WHERE cpf = ?";

            stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getTelefone());
            
            if(pessoa instanceof Clientes){
                // setando o campo tipo (4) para o número 1 (cliente)
                stmt.setInt(3, 1);
                stmt.setNull(4, java.sql.Types.NULL);
                stmt.setNull(5, java.sql.Types.NULL);
                
            }else if(pessoa instanceof Funcionarios){
                stmt.setInt(3, 2);
                stmt.setString(4, ((Funcionarios) pessoa).getCargo());
                stmt.setString(5, ((Funcionarios) pessoa).getSenhaEntrada());
            }
            
            stmt.setString(6, pessoa.getCpf());//é o responsavel do where
            
            stmt.executeUpdate();
            
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
            
        }
    }
    
    public boolean excluir(Pessoas pessoa){
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "delete from Pessoas where cpf = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, pessoa.getCpf());

            stmt.executeUpdate();
            result = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }
    
    
}
