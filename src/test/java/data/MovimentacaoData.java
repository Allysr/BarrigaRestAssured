package data;

import entities.Movimentacao;

public class MovimentacaoData {

    private Movimentacao movimentacao = new Movimentacao();

    public Movimentacao novaMovimentacao(){
        movimentacao.setConta_id(1897946);
        movimentacao.setDescricao("Descrição");
        movimentacao.setEnvolvido("Envolvido");
        movimentacao.setTipo("REC");
        movimentacao.setData_transacao("07/09/2023");
        movimentacao.setData_pagamento("07/10/2023");
        movimentacao.setValor(1000f);
        movimentacao.setStatus(true);

        return movimentacao;
    }
}
