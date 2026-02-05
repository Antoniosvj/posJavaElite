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
    int categoria;

    //metodos
    double calculaPorcentagemDesconto(){
        return (preco - precoComDesconto) / preco;
    }

    String obtemCategoria(){
        String nomeCategoria;
        switch (categoria){
            case 1:
                nomeCategoria = "Bebidas";
                break;
            case 2:
                nomeCategoria = "Pratos Principais";
                break;
            case 3:
                nomeCategoria = "Sobremesa";
                break;
            default:
                nomeCategoria = "Não existe...";
                break;
        }
        return nomeCategoria;
    }

    void definePromocao(double precoComDesconto){
        this.emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    //construtor
    ItemCardapio(long id, String nome, String descricao, double preco, int categoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
