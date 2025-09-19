package model.classes;

/**
 *
 * @author aluno
 */
public abstract class Pessoas {
    protected String cpf;
    protected String nome;
    protected String telefone;
    

    public Pessoas(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        
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
        return "Pessoas{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
    
    
}
