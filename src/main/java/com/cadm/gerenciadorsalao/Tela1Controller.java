/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cadm.gerenciadorsalao;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class Tela1Controller implements Initializable {

    private volatile boolean stop = false;

    @FXML
    private Label time;
    
    @FXML
    private Button btnAtend;
    
    @FXML
    private Button btnClientes;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeNow();
        
        btnAtend.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaConsultaAtendimentos.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Consulta de Atendimentos");
                stage.setScene(scene);
                stage.show();
               
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        btnClientes.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaConsultaClientes.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Consulta de Clientes.");
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void timeNow() {//mostrar o horário
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("");
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    time.setText(timenow);

                });

            }
        });
        thread.start();
    }
    
    
    
}
