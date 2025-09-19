/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cadm.gerenciadorsalao;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.classes.Atendimentos;
import model.exceptions.ValidacaoException;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class TelaCadastroAtendimentoController implements Initializable {
    
    private List<Atendimentos> listaAtendimento;
    private ObservableList<Atendimentos> listaCombo;
    
    private Atendimentos atend;
    
    
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnSair;
    
    @FXML
    private Button btnClientes;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnClientes.setOnAction((t) -> {
            try {
                
                Parent parent = FXMLLoader.load(getClass().getResource("TelaCadastroCliente.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Cadastro de Clientes");
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
//        btnSair.setOnAction((t) -> {
//            try {
//                
//                
//                
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
    }

}
