package org.jala.moduloservico.model.DTO;

import org.jala.moduloservico.model.enums.TipoServicos;
import org.jala.moduloservico.model.enums.TipoPagamento;
/**
 * Classe DTO (Data Transfer Object) para transferência de dados de transação.
 */
public class TransacaoDTO {
    /**
     * Atributos
     */
    private String valor;
    private TipoPagamento tipoPagamento;
    private TipoServicos tipoServicos;
    private String descricao;

    /**
     * gettes e setters
     * @return
     */
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoServicos getTipoServicos() {
        return tipoServicos;
    }

    public void setTipoServicos(TipoServicos tipoServicos) {
        this.tipoServicos = tipoServicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
