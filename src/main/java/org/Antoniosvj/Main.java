package org.Antoniosvj;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        /*
        String nome2 = "Sanduiche de mortadela";
        String descricao2 = "pao e mortadela";
        boolean emPromocao2 = true;
        double preco2 = 3.50;
        double precoComDesconto2 = 2.99;
        int categoria2 = 2;
        var id = 2;

        String nome1 = "Suco do chaves";
        String descricao1 = "Suco de groselia";
        boolean emPromocao1 = false;
        double preco1 = 2.99;
        int categoria1 = 1;
        var id1 = 1;

        IO.println("Nome: " + nome2);

        if(emPromocao2) {
            var porcentagemDesconto = (preco2 - precoComDesconto2) /preco2;
            IO.println("Porcentagem de desconto: " + porcentagemDesconto);

            IO.println("Preço de " + preco2 + " por " + precoComDesconto2);
        } else{
            IO.println("Preço " + preco2);
        }
        IO.println("-----------");
        IO.println("-----ARRAY------");
        IO.println("-----------");

        double[] precos = new double[7];
        precos[0] = 2.99;
        precos[1] = 3.50;
        precos[2] = 12.99;
        precos[3] = 4.99;
        precos[4] = 2.50;
        precos[5] = 4.99;
        precos[6] = 25.90;

        IO.println("Preço do item 3 = " + precos[2]);
        IO.println(precos.length);

        boolean[] emPromocao = { false, true, true, false};
        IO.println(emPromocao.length);

        int contador = 0;
        double totalDtPrecos = 0.0;
        while(contador < precos.length){
            double precos = precos[contador];
            totalPrecos = totalPrecos + precos;
            contador++;
        }

        IO.println("Total de precos? " + totalPrecos);*/

       // for (int i = 0; i <10; i++) IO.println(i);

        double[] precos = new double[7];
        precos[0] = 2.99;
        precos[1] = 3.50;
        precos[2] = 12.99;
        precos[3] = 4.99;
        precos[4] = 2.50;
        precos[5] = 4.99;
        precos[6] = 25.90;

        double precoLimite = 10.0;
        for(double preco: precos){
            if(preco > precoLimite) {
                precoLimite = preco;
                IO.println(precoLimite);

            }
        }
    }
}
