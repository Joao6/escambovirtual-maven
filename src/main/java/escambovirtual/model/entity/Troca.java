package escambovirtual.model.entity;

import escambovirtual.model.base.BaseEntity;
import java.util.Date;

/**
 *
 * @author Joao
 */
public class Troca extends BaseEntity{
    
    private Oferta oferta;    
    private String status;
    private Integer nivel_satisfacao;
    private Date avaliacao_data_hora;
    private String avaliacao_descricao;

    public Integer getNivel_satisfacao() {
        return nivel_satisfacao;
    }

    public void setNivel_satisfacao(Integer nivel_satisfacao) {
        this.nivel_satisfacao = nivel_satisfacao;
    }

    public Date getAvaliacao_data_hora() {
        return avaliacao_data_hora;
    }

    public void setAvaliacao_data_hora(Date avaliacao_data_hora) {
        this.avaliacao_data_hora = avaliacao_data_hora;
    }

    public String getAvaliacao_descricao() {
        return avaliacao_descricao;
    }

    public void setAvaliacao_descricao(String avaliacao_descricao) {
        this.avaliacao_descricao = avaliacao_descricao;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
