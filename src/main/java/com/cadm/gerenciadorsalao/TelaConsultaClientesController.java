/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cadm.gerenciadorsalao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.classes.Clientes;
import model.classes.Pessoas;import model.services.PessoasServices;


/**
 * FXML Controller class
 *
 * @author aluno
 */
public class TelaConsultaClientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML 
    private TableView<Pessoas> tableViewClientes;
    
    @FXML
    private TableColumn<Clientes, String> tableColumnNome;
    
    @FXML
    private TableColumn<Clientes, String> tableColumnCpf;
    
    @FXML
    private TableColumn<Clientes, String> tableColumnTelefone;
    
    
    @FXML
    private Button btnNovo;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;
    
    private ObservableList<Pessoas> listaTabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
    }    
    
    public void atualizarTabela() {
        
        listaTabela = FXCollections.observableArrayList(new PessoasServices().getAll());
        tableViewClientes.setItems(listaTabela);

    }
    
    
    
}
