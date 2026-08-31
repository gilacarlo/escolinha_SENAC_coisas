package JacksonMachado_OOP.atividades2;

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
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
