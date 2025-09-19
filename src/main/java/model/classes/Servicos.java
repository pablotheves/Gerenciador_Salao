package model.classes;

/**
 *
 * @author aluno
 */
public class Servicos {
    private int codServico;
    private String tipoServico;
    private float preco;

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }
    
    public String getTipoServico() {
        return tipoServico;
    }
    
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    public float getPreco() {
        return preco;
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Servicos{" + "tipoServico=" + tipoServico + ", preco=" + preco + '}';
    }

    public Servicos(String tipoServico, float preco) {
        this.tipoServico = tipoServico;
        this.preco = preco;
    }

    public Servicos(int codServico, String tipoServico, float preco) {
        this.codServico = codServico;
        this.tipoServico = tipoServico;
        this.preco = preco;
    }
    
    
}
