package JacksonMachado_OOP.atividades1;
// Implemente um programa que leia um número inteiro do usuário e 
// exiba a tabuada desse número (de 1 a 10) utilizando um laço for. 
// Valide a entrada com try/catch e utilize operadores de multiplicação.

import java.util.Scanner;

public class Q3_Tabuada_com_Laço_for {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = 0;
        try{
            numero = scanner.nextInt();
            for(int i = 1; i <= 10; i++){
                System.out.print("\n"+numero+" vezes "+i+" é: "+(numero*i));
            }
        }catch(ArithmeticException e){
            System.out.print("burro demais");
        }
        
        scanner.close();
    }
}
