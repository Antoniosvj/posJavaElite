package com.antoniosvj;

// classe funciona como molde do objeto
public class ItemCardapio {
    //atributos são as características
    long id;
    String nome;
    String descricao;
    boolean emPromocao;
    double preco;
    double precoComDesconto;
    CategoriaCardapio categoria;

    //metodos
    double calculaPorcentagemDesconto(){
        return (preco - precoComDesconto) / preco;
    }

    public void definePromocao(double precoComDesconto){
        this.emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    CategoriaCardapio obtemCategoria(){
        return categoria;
    }

    double calculaImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto *0.1;
        } else{
            imposto = preco * 0.1;
        }
        return imposto;
    }


    //construtor -> nesse caso apesar de ser protected ele é acessivel a outros itens que sejam
    // classes filhas dessa classe
    //mesmo estando em outro pacote
    protected ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
