package com.antoniosvj;

import com.antoniosvj.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Cardapio {
    public final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        //IO.println((nomeArquivo));

        //ler arquivo
        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo); //aqui lança uma exceção por isso o throws

        //IO.println(conteudoArquivo);
        String[] linhasArquivo = conteudoArquivo.split("\n"); //fazendo split pela quebra de linha

        itens = new ItemCardapio[linhasArquivo.length];

        for(int i = 0; i < linhasArquivo.length; i++){
            String linha = linhasArquivo[i];

            linha = linha.replace("[", "");
            linha = linha.replace("]", "");
            linha = linha.replace("\"", "");
            linha = linha.replace("{", "");
            linha = linha.replace("}", "");

            if(nomeArquivo.endsWith(".csv")){

                String[] partes = linha.split(";");

                    //String parte = partes[j];
                    //IO.println("Parte " + j + " : " + parte);
                    Long id = Long.parseLong(partes[0]); //transforma a string em Long
                    String nome = partes[1];
                    String descricao = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    CategoriaCardapio categoria = CategoriaCardapio.valueOf(partes[4]); //pega a string e encontra qual o enum correto

                    ItemCardapio item;
                    boolean isento = Boolean.parseBoolean(partes[7]);
                    if(isento){
                        item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);//cria o item
                    } else{
                        item = new ItemCardapio(id, nome, descricao, preco, categoria);//cria o item

                    }

                    boolean emPromocao = Boolean.parseBoolean(partes[5]);
                    if(emPromocao){
                        double precoDesconto = Double.parseDouble(partes[6]);
                        item.definePromocao(precoDesconto);
                    }

                    itens[i] = item;
            } else if(nomeArquivo.endsWith(".json")){
                //IO.println("linha " + i + ": " + linha);

                String[] partes = linha.split(",");

                String parteId = partes[0];
                String[] propriedadeEValorId = parteId.split(":");
                String valorId = propriedadeEValorId[1].trim();
                Long id = Long.parseLong(valorId);
                //IO.println(id);

                String parteNome = partes[1];
                String[] propriedadeEValorNome = parteNome.split(":");
                String nome = propriedadeEValorNome[1].trim();

                String parteDescricao = partes[2];
                String[] propriedadeEValorDescricao = parteDescricao.split(":");
                String descricao = propriedadeEValorDescricao[1].trim();

                String partePreco = partes[3];
                String[] propriedadeEValorPreco = partePreco.split(":");
                String valorPreco = propriedadeEValorPreco[1].trim();
                double preco = Double.parseDouble(valorPreco);

                String parteCategoria = partes[4];
                String[] propriedadeEValorCategoria = parteCategoria.split(":");
                String valorCategoria = propriedadeEValorCategoria[1].trim();
                CategoriaCardapio categoria = CategoriaCardapio.valueOf(valorCategoria);

                ItemCardapio item;
                String parteIsento = partes[7];
                String[] propriedadeEValorIsento = parteIsento.split(":");
                String valorIsento = propriedadeEValorIsento[1].trim();
                boolean isento = Boolean.parseBoolean(valorIsento);
                if(isento){
                    item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
                }else{
                    item = new ItemCardapio(id, nome, descricao, preco, categoria);
                }

                String partePromocao = partes[5];
                String[] propriedadeEValorPromocao = partePromocao.split(":");
                String valorPromocao = propriedadeEValorPromocao[1].trim();
                boolean emPromocao = Boolean.parseBoolean(valorPromocao);
                if(emPromocao){
                    String partePrecoDesconto = partes[6];
                    String[] propriedadeEValorPrecoDesconto = partePrecoDesconto.split(":");
                    String valorPrecoDesconto = propriedadeEValorPrecoDesconto[1].trim();
                    double precoDesconto = Double.parseDouble(valorPrecoDesconto);
                    item.definePromocao(precoDesconto);
                }


                itens[i] = item;

            }else{
                IO.println("Extensão de arquivo inválida: " + nomeArquivo);
            }
           // IO.println("-------------");
        }

        /*
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
        itens[6] = item7;*/
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
