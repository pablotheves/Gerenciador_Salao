/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.classes;

/**
 *
 * @author pablo
 */
public class Clientes extends Pessoas{


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

    

    public Clientes(String cpf, String nome, String telefone) {
        super(cpf, nome, telefone);
    }
    
    public void teste(){
        
    }
    
    @Override
    public String toString() {
        return "Clientes{" + " cpf: " + cpf + " nome: " + "telefone: " + telefone + '}';
    }
    
    
    
    
}
