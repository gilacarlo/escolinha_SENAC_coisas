package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Implemente um programa que leia três números decimais do usuário 
// e calcule a média aritmética. Utilize múltiplos 
// blocos try/catch para tratar diferentes tipos de exceção 
// (NumberFormatException, InputMismatchException). 
// Valide se os números são positivos com if/else.

public class Q9_Validação_de_Entrada_com_Múltiplos_trycatch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
