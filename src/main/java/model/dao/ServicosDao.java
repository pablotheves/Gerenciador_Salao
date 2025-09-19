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
import model.classes.Servicos;

/**
 *
 * @author aluno
 */
public class ServicosDao {
    private Connection con;

    public ServicosDao(Connection con) {
        this.con = con;
    }
    
    public List<Servicos> getAll(){
        List<Servicos> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;
        
        try {
            String sql = "select * from Servicos";
            
            stmt = con.prepareCall(sql);
            
            res = stmt.executeQuery(sql);
            
            while(res.next()) {
                Servicos servico = new Servicos(res.getString("descricao"), res.getFloat("preco"));
                System.out.println(servico);
                list.add(servico);
                
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DB.closeResultSet(res);
            DB.closeStatement(stmt);
            return list;
        }
        
    }
    
    public boolean excluir(Servicos serv){
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "delete from Servicos where codServicos = ?";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, serv.getCodServico());

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
