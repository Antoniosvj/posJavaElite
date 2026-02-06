package com.antoniosvj.isento;

import com.antoniosvj.CategoriaCardapio;
import com.antoniosvj.ItemCardapio;

public class ItemCardapioIsento extends ItemCardapio {

    public ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);
    }
    //@Override //é opcional colocar, mas indica que isso esta sendo sobrescrito da classe mãe
    public double calculaImposto(){
        return 0.0;
    }
}
