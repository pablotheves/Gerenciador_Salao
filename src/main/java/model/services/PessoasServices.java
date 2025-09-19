/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.util.List;
import model.DB.DB;
import model.classes.Atendimentos;
import model.classes.Pessoas;
import model.dao.PessoasDao;

/**
 *
 * @author aluno
 */
public class PessoasServices {
    private PessoasDao dao = new PessoasDao(DB.getConnection());
    
    public List<Pessoas> getAll(){
        return dao.getAll();        
    }
    
    public boolean inserir(Pessoas p){
        
        return dao.inserir(p);            
        
    }
    
    public boolean editar(Pessoas p){
        return dao.editar(p);
        
    }
    
    public boolean excluir(Pessoas p){
        return dao.excluir(p);
    }
}
