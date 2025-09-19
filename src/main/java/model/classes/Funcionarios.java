/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.classes;

/**
 *
 * @author aluno
 */
public class Funcionarios extends Pessoas {
    private String cargo;
    private String senhaEntrada;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenhaEntrada() {
        return senhaEntrada;
    }

    public void setSenhaEntrada(String senhaEntrada) {
        this.senhaEntrada = senhaEntrada;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
   

    @Override
    public String toString() {
        return "Funcionarios{" + "cpf: " + cpf + "nome: " + nome + "telefone: " + telefone + " cargo=" + cargo + ", senhaEntrada=" + senhaEntrada + '}';
    }
    
    public Funcionarios(String cargo, String senhaEntrada, String cpf, String nome, String telefone) {
        super(cpf, nome, telefone);
        this.cargo = cargo;
        this.senhaEntrada = senhaEntrada;
    }
    
}
