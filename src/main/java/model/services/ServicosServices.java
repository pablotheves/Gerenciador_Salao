/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.util.List;
import model.DB.DB;
import model.classes.Servicos;
import model.dao.ServicosDao;

/**
 *
 * @author aluno
 */
public class ServicosServices {
    private ServicosDao dao = new ServicosDao(DB.getConnection());
    
    public List<Servicos> getAll(){
        return dao.getAll();
        
    }
    
    
}
