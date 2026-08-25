// Implemente um programa que utilize um laço do/while
//  para ler números do usuário e verificar se são pares ou ímpares. 
//  O programa deve continuar até que o usuário digite -1. 
// Utilize o operador módulo (%) e try/catch para validação.

import java.util.Scanner;

public class Q6_Verificação_de_Número_Par_ou_Ímpar_com_dowhile {
  public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }  
}
