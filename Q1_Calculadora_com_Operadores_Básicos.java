// Desenvolva um programa em Java que leia dois números inteiros do usuário 
// e exiba o resultado das operações básicas (adição, subtração, multiplicação, 
// divisão e módulo). Utilize Scanner para entrada de dados e trate possíveis 
// exceções com try/catch.

import java.util.Scanner;

public class Q1_Calculadora_com_Operadores_Básicos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();

        System.out.print("digite um numero inteiro:");
        int numero2 = scanner.nextInt();

        System.out.print("escolha a opracao:    "+
            "1 = adicao"+
            "2 = subitracao"+
            "3 = divisao"+
            "4 = multiplicacao"    
        );
        int opcao = scanner.nextInt();
        float resultado = 0;
        switch (opcao) {
            case 1:
                resultado = numero + numero2;
                break;
            case 2:
                resultado = numero - numero2;
                break;
            case 3:
                resultado = numero / numero2;
                break;
            case 4:
                resultado = numero * numero2;
                break;
            default:
                break;
        }

        System.out.print("resultado: " + resultado);

        scanner.close();
    }
}