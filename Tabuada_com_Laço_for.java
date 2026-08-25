// Implemente um programa que leia um número inteiro do usuário e 
// exiba a tabuada desse número (de 1 a 10) utilizando um laço for. 
// Valide a entrada com try/catch e utilize operadores de multiplicação.

import java.util.Scanner;

public class Tabuada_com_Laço_for {
    public static void main(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
