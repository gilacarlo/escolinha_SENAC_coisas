package JacksonMachado_OOP.atividades2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// Implemente um programa que utilize um HashSet<String> para cadastrar nomes de pessoas. 
// O programa deve permitir inserir nomes, listar todos os nomes cadastrados, 
// verificar se determinado nome já foi inserido e exibir a quantidade total de pessoas.
// Como o HashSet não permite elementos repetidos, o programa deve 
// informar ao usuário quando ele tentar cadastrar um nome já existente. 
// Utilize um menu com switch, repetição com while e 
// tratamento de erros com try/catch.

public class Q5_CadastrodePessoassemNomesRepetidos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        

        HashSet<String> nomesLista = new HashSet<>();

        boolean sair = false;
        while(sair == false){
            System.out.print("\nescolha uma das opcoes:");
            System.out.print("\n(1) cadastrar nome.");
            System.out.print("\n(2) listar todos os nomes.");
            System.out.print("\n(3) consultar se um nome ja está na lista.");
            System.out.print("\n(4) listar quantidade total de pessoas.");
            System.out.print("\n(5) sair.");
            int numero = 0;
            try{
                numero = scanner.nextInt();
            }catch(Exception e){
                System.out.println("\nDigite algo válido!");
                scanner.next();
                continue;
            }
            String nome = "";
            switch (numero) {
                case 1:
                    System.out.println("\nDigite o nome da pessoa: ");
                    nome = scanner.next();
                    if(nomesLista.contains(nome) == false){
                        System.out.println("\nitem '" + nome + "' adicionado!");
                        nomesLista.add(nome);
                    }else{
                        System.out.println("\nNome ja existente, coloque outro... ");
                    }
                    break;
                case 2:
                    System.out.println("\nListagem dos nomes: ");
                    int i = 0;
                    for(String nomeL : nomesLista){
                        i++;
                        System.out.println(i + "- '" + nomeL + "' ");
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o nome da pessoa: ");
                    nome = scanner.next();
                    if(nomesLista.contains(nome)){
                        System.out.println("\nO nome '" + nome + "' ja existe  :D");
                    }else{
                        System.out.println("\nNao existe o nome '" + nome + "'  :(");
                    }
                    break;
                case 4:
                    System.out.println("\nQuantidade de pessoas : " + nomesLista.size());
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("\nDigite algo válido!");
                    break;
            }
        }
        scanner.close();
    }
}
