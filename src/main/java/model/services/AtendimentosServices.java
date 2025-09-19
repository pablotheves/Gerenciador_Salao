/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.util.List;
import model.DB.DB;
import model.classes.Atendimentos;
import model.dao.AtendimentosDao;

/**
 *
 * @author aluno
 */
public class AtendimentosServices {
    private AtendimentosDao dao = new AtendimentosDao(DB.getConnection());
    
    public List<Atendimentos> getAll(){
        return dao.getAll();        
    }
    
    public boolean salvar(Atendimentos atend){
        
        return dao.inserir(atend);            
        
    }
    
    public boolean excluir(Atendimentos atend){
        return dao.excluir(atend);
    }



}



