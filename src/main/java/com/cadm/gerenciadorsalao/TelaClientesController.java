/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cadm.gerenciadorsalao;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.classes.Clientes;
import model.classes.Pessoas;
import model.exceptions.ValidacaoException;
import model.services.PessoasServices;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class TelaClientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Clientes cliente;

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;

    }

    @FXML
    private TableView<Pessoas> tableViewClientes;

    @FXML
    private TableColumn<Clientes, String> tableColumnNome;

    @FXML
    private TableColumn<Clientes, String> tableColumnCpf;

    @FXML
    private TableColumn<Clientes, String> tableColumnTelefone;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblErroNome;

    @FXML
    private Label lblErroCpf;

    @FXML
    private Label lblErroTelefone;

    @FXML
    private TextField txtTelefone;

    private ObservableList<Pessoas> listaTabela;
    private PessoasServices pessoasService = new PessoasServices();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        atualizarTabela();

        btnSalvar.setOnAction((t) -> {
            limparErros();
            
            try {
                ValidacaoException exc = new ValidacaoException("Erro Validação!");

                System.out.println("clicou em salvar");

                if (cliente == null) {
                    cliente = new Clientes(null, null, null);
                    System.out.println("criou novo");
                }

                if (txtNome.getText() == null) {
                    exc.adicionarErro("Nome", "O campo nao pode ser vazio!");
                } else if (txtNome.getText().equals("")) {
                    exc.adicionarErro("Nome", "O campo nao pode ser vazio!");
                } else {
                    cliente.setNome(txtNome.getText());
                }

                if (txtCpf.getText() == null) {
                    exc.adicionarErro("Cpf", "O campo nao pode ser vazio!");
                } else if (txtCpf.getText().equals("")) {
                    exc.adicionarErro("Cpf", "O campo nao pode ser vazio!");
                } else {
                    cliente.setCpf(txtCpf.getText());
                }

                if (txtTelefone.getText() == null) {
                    exc.adicionarErro("Telefone", "O campo nao pode ser vazio!");
                } else if (txtTelefone.getText().equals("")) {
                    exc.adicionarErro("Telefone", "O campo nao pode ser vazio!");
                } else {
                    cliente.setTelefone(txtTelefone.getText());
                }

                if (!exc.getErrors().isEmpty()) {
                    throw exc;
                }

                //atualiza no banco
                PessoasServices service = new PessoasServices();
                service.salvarOuAtualizar(cliente);

                // atualizar tabela após salvar
                atualizarTabela();
                limparCampos();

            } catch (ValidacaoException ev) {
                setErrorMessages(ev.getErrors());

            }

        });
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        cliente = null;
    }
    
    private void limparErros() {
        lblErroCpf.setText("");
        lblErroNome.setText("");
        lblErroTelefone.setText("");
    }

    public void atualizarTabela() {
        List<Pessoas> listaPessoas = pessoasService.getAll();

        listaTabela = FXCollections.observableArrayList(listaPessoas);
        tableViewClientes.setItems(listaTabela);

    }

    private void setErrorMessages(Map<String, String> errors) {
        Set<String> fields = errors.keySet();

        lblErroNome.setText(fields.contains("Nome") ? errors.get("Nome") : "");
        lblErroCpf.setText(fields.contains("Cpf") ? errors.get("Cpf") : "");
        lblErroTelefone.setText(fields.contains("Telefone") ? errors.get("Telefone") : "");

    }
}
