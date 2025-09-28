package model.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Atendimentos {

    private int codAtendimento;
    private LocalDateTime dataHora;
    private String observacoes;
    private Pessoas pessoa;
    private ArrayList<Servicos> servicos;

    public ArrayList<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servicos> servicos) {
        this.servicos = servicos;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public int getCodAtendimento() {
        return codAtendimento;
    }

    public void setCodAtendimento(int codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getNomeAtend() {
        if (pessoa != null) {
            return pessoa.getNome();
        } else {
            return "";
        }
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Atendimentos(int codAtendimento, LocalDateTime dataHora, String observacoes, Pessoas pessoa) {
        this.codAtendimento = codAtendimento;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.pessoa = pessoa;
        this.servicos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Atendimentos{" + "data=" + dataHora + ", observacoes=" + observacoes + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAtendimento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimentos other = (Atendimentos) obj;
        return Objects.equals(this.codAtendimento, other.codAtendimento);
    }
}
