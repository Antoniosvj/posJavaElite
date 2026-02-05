package org.Antoniosvj;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        /*
        ItemCardapio item1 = new ItemCardapio();
        item1.id = 1;
        item1.nome = "Refresco do Chaves";
        item1.descricao = "Suco de limão que parece tamarindo e tem gosto de groselia";
        item1.emPromocao = false;
        item1.preco = 1.99;
        item1.categoria = 1;
        */
        ItemCardapio item1 = new ItemCardapio(1, "Refresco do Chaves", "Suco de limão que parece tamarindo e tem gosto de groselia", 1.99, 1);
        /*
        ItemCardapio item2 = new ItemCardapio();
        item2.id = 2;
        item2.nome = "Sanduiche de presunto do Chaves";
        item2.descricao = "Sanduiche de presunto simples";
        item2.emPromocao = true;
        item2.preco = 3.50;
        item2.precoComDesconto = 2.99;
        item2.categoria = 2;


        *
        * IO.println("Nome: " + item2.nome);
        double porcentagemDesconto = item2.calculaPorcentagemDesconto();
        IO.println("Porcentagem de desconto? " + porcentagemDesconto);

        IO.println("Categoria: " + item2.obtemCategoria());
        * */

        ItemCardapio item2 = new ItemCardapio(2, "Sanduiche de presunto do Chaves","Sanduiche de presunto simples", 3.50, 2 );
        item2.definePromocao(2.99);
        IO.println("Item " + item2.nome + " está em promoção... Preço R$" + item2.precoComDesconto);

        ItemCardapio item3 = new ItemCardapio(3, "Sorvete", "Sorvete bem gelado", 5.00, 3);

        //IO.println("Nome: " + item3.nome);
    }
}
