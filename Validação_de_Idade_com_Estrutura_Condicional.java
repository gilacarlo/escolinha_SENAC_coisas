// Crie um programa que solicite a idade do usuário e determine se é maior 
// de idade (≥ 18 anos), menor de idade ou idoso (≥ 60 anos). Utilize 
// estruturas if/else para implementar a lógica e trate erros de 
// entrada com try/catch.

import java.util.Scanner;

public class Validação_de_Idade_com_Estrutura_Condicional {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite uma idade:");
        int idade = scanner.nextInt();
        
        try{
            if(idade >= 18){
                if(idade >= 60){
                    System.out.print("Idoso.");
                }else{
                    System.out.print("Maior de idade.");
                }
            }else {
                System.out.print("Menor de idade.");
            }
        }catch(ArithmeticException e){
            System.out.print("seu jumento.");
        }
        scanner.close();
    }
}
