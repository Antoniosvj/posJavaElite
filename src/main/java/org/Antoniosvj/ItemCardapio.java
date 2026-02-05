package org.Antoniosvj;

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

    void definePromocao(double precoComDesconto){
        this.emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    CategoriaCardapio obtemCategoria(){
        return categoria;
    }

    //construtor
    ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
