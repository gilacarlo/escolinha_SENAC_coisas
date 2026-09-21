package JacksonMachado_OOP.atividade3.Cadastro_de_Produtos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro_de_Produtos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto> list = new ArrayList<>();

        list.add(new Produto("banana", 10.0f, 1323));
        list.add(new Produto("escavadeira", 100000.0f, 1));
        list.add(new Produto("bolo", 50.0f, 1));
        list.add(new Produto("bomba", 500.0f, 1));
        list.add(new Produto("arma", 4000.0f, 4892));
       
        float totalValor = 0;
        for(Produto pro : list){
            pro.exibirDados();
            totalValor += pro.calcularValorEstoque();
        }
        System.out.print("Valor total: " + totalValor);

        scanner.close();
    }
}


