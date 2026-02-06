package com.antoniosvj;

public class ItemCardapioBedida extends  ItemCardapio{
    ItemCardapioBedida(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);
    }

    @Override
    double calculaImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto *0.05;
        } else{
            imposto = preco * 0.05;
        }
        return imposto;
    }
}
