package com.antoniosvj;

import java.io.IOException;

public class Main {
    void main() throws IOException {

        final String nomeArquivo = IO.readln("Digite o nome do arquivo de itens de cardápio: ");

        Cardapio cardapio = new Cardapio(nomeArquivo);//foi passado o nome do arquivo aqui
        //como foi lançado uma exceção na main também devemos tratar ela

        //lê o que o usuario digitou
        String linha = IO.readln("Digite um id de um item do cardápio: ");

        //pegue a linha que o usuario digitar
        long idSelecionado = Long.parseLong(linha);

        ItemCardapio itemSelecionado = null;
        for(ItemCardapio item: cardapio.itens){
            if(item.id == idSelecionado){
                itemSelecionado = item;
                break;
            }
        }
        IO.println("=== Item do Cardápio ===");
        IO.println("Dados do item de id: "+ itemSelecionado.id);
        IO.println("Nome: " + itemSelecionado.nome);
        IO.println("Descrição: " + itemSelecionado.descricao);
        IO.println("Categoria: " + itemSelecionado.obtemCategoria());
        if(itemSelecionado.emPromocao){
            IO.println("Preco de R$" + itemSelecionado.preco + " por R$" + itemSelecionado.precoComDesconto);
        } else{
            IO.println("Preço: R$" + itemSelecionado.preco);
        }
        IO.println("Imposto do produto: " + itemSelecionado.calculaImposto());

        IO.println("========================================");
        IO.println("Soma dos preços: " + cardapio.obtemSomaDosPrecos());
        IO.println("Total de itens em promoção: " + cardapio.obtemTotalItensEmPromocao());
        IO.println("Menor preço: " + cardapio.obtemMenorPreco());

        IO.println("---EXERCICIO---");
        IO.println("Imprimir item por categoria:");
        ItemCardapio[] itens = cardapio.imprimeItensPorCategoria(CategoriaCardapio.BEBIDAS);
        for(ItemCardapio item: itens){
            IO.println("Nome: " + item.nome);
        }


    }
}
