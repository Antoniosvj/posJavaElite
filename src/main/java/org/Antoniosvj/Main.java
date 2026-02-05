package org.Antoniosvj;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ItemCardapio item1 = new ItemCardapio();
        item1.id = 1;
        item1.nome = "Refresco do Chaves";
        item1.descricao = "Suco de limão que parece tamarindo e tem gosto de groselia";
        item1.emPromocao = false;
        item1.preco = 1.99;
        item1.categoria = 1;

        ItemCardapio item2 = new ItemCardapio();
        item2.id = 2;
        item2.nome = "Sanduiche de presunto do Chaves";
        item2.descricao = "Sanduiche de presunto simples";
        item2.emPromocao = true;
        item2.preco = 3.50;
        item2.precoComDesconto = 2.99;
        item2.categoria = 2;


        IO.println("Nome: " + item1.nome);
    }
}
