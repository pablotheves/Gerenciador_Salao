/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cadm.gerenciadorsalao;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.classes.Atendimentos;
import model.services.AtendimentosServices;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class TelaConsultaAtendimentosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Atendimentos> tableViewAtend;

    @FXML
    private TableColumn<Atendimentos, Integer> tableColumnCod;

    @FXML
    private TableColumn<Atendimentos, String> tableColumnNome;
    
    @FXML
    private TableColumn<Atendimentos, LocalDateTime> tableColumnDataHora;
    
    @FXML
    private TableColumn<Atendimentos, String> tableColumnObservacoes;
    
    private ObservableList<Atendimentos> listaTabela;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnAddAtend;

    @FXML
    private Button btnExcAtend;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tableColumnCod.setCellValueFactory(new PropertyValueFactory<>("codAtendimento"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nomeAtend"));
        tableColumnDataHora.setCellValueFactory(new PropertyValueFactory<>("dataHora"));
        tableColumnObservacoes.setCellValueFactory(new PropertyValueFactory<>("observacoes"));
        
        atualizarTabela();
        var lista = new AtendimentosServices().getAll();
        System.out.println("Total de atendimentos carregados: " + lista.size());

        listaTabela = FXCollections.observableArrayList(lista);
        tableViewAtend.setItems(listaTabela);
        
        btnAddAtend.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaCadastroAtendimento.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Cadastro de Atendimentos");
                stage.setScene(scene);
                stage.show();
                
//                Parent parent = FXMLLoader.load(getClass().getResource("TelaVendedores.fxml"));
//                Scene scene = new Scene(parent);
//                Stage stage = new Stage();
//                stage.setTitle("Consulta de Vendedores");
//                stage.setScene(scene);
//                stage.show();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnExcAtend.setOnAction((t) -> {

            if (tableViewAtend.getSelectionModel().getSelectedItem() != null) {
                Atendimentos atend = tableViewAtend.getSelectionModel().getSelectedItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText(null);
                alert.setContentText(atend.toString() + " será excluido! Tem certeza?");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    if (new AtendimentosServices().excluir(atend)) {
                        Alert mens = new Alert(Alert.AlertType.INFORMATION);
                        mens.setTitle("Excluído");
                        mens.setHeaderText(null);
                        mens.setContentText("Registro excluído!");
                        mens.showAndWait();
                        atualizarTabela();
                    }
                }
            }

        });

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

    }

    public void atualizarTabela() {
        // associando lista a tabela utilizando um ObservableList
        listaTabela = FXCollections.observableArrayList(new AtendimentosServices().getAll());
        tableViewAtend.setItems(listaTabela);

    }

}
