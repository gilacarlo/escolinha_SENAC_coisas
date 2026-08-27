package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Crie um programa que leia um número inteiro positivo e conte quantos 
// dígitos ele possui. Utilize um laço for com conversão de String, 
// operadores relacionais e try/catch para validação de entrada.

public class Q8_Contagem_de_Dígitos_com_for {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
