package com.antoniosvj;
import com.antoniosvj.isento.ItemCardapioIsento;

import java.util.ArrayList;
public class Cardapio {
    ItemCardapio[] itens;

    Cardapio(){
        ItemCardapio item1 = new ItemCardapioBedida(1, "Refresco do Chaves", "Suco de limão que parece tamarindo e tem gosto de groselia", 1.99, CategoriaCardapio.BEBIDAS);

        ItemCardapio item2 = new ItemCardapio(2, "Sanduiche de presunto do Chaves","Sanduiche de presunto simples, mas feito com muito amor", 3.50, CategoriaCardapio.PRATOS_PRINCIPAIS );
        item2.definePromocao(2.99);

        ItemCardapio item3 = new ItemCardapio(3, "Torta de Frango da Dona Florinda", "Torta de frango com recheio cremoso e massa crocante", 12.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item3.definePromocao(10.99);

        ItemCardapio item4 = new ItemCardapio(4, "Pipoca do Quico", "Balde de pipoca preparado com carinho pelo Quico", 4.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item4.definePromocao(3.99);

        ItemCardapio item5 = new ItemCardapioBedida(5, "Água de Jamaica", "Água aromatizada com hibisco e toque de açucar", 2.50, CategoriaCardapio.BEBIDAS);
        item5.definePromocao(2.00);

        ItemCardapioIsento item6 = new ItemCardapioIsento(6, "Churros do Chaves", "Churros recheado com doce de leite, classico e irresistivel", 4.99, CategoriaCardapio.SOBREMESAS);
        item6.definePromocao(3.99);

        ItemCardapioIsento item7 = new ItemCardapioIsento(7, "Tacos de Carnitas", "Tacos recheados com carne tnra", 25.90, CategoriaCardapio.PRATOS_PRINCIPAIS);

        itens = new ItemCardapio[7];
        itens[0] = item1;
        itens[1] = item2;
        itens[2] = item3;
        itens[3] = item4;
        itens[4] = item5;
        itens[5] = item6;
        itens[6] = item7;
    }

    double obtemSomaDosPrecos(){
        double totalDePrecos = 0.0;
        for(ItemCardapio item: itens) totalDePrecos += item.preco;
        return totalDePrecos;
    }

    int obtemTotalItensEmPromocao(){
        int totalItensEmPromocao = 0;
        for(ItemCardapio item: itens){
            if (item.emPromocao) totalItensEmPromocao++;
        }
        return totalItensEmPromocao;
    }

    double obtemMenorPreco() {
        double menorPreco = Double.MAX_VALUE; //INICIALIZA COM MAIOR PREÇO POSSIVEL
        for(ItemCardapio item: itens){
            double preco;
            if(item.emPromocao) {
                preco = item.precoComDesconto;
            } else{
                preco = item.preco;
            }

            if (preco < menorPreco) menorPreco = preco;
        }
        return menorPreco;
    }

    ItemCardapio[] imprimeItensPorCategoria(CategoriaCardapio categoria) {
        ArrayList<ItemCardapio> lista = new ArrayList<>();

        for (ItemCardapio item : itens) {
            if (item.categoria == categoria) {
                lista.add(item);
            }
        }
        return lista.toArray(new ItemCardapio[0]);
    }

}
