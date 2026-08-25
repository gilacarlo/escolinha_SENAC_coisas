package JacksonMachado_OOP.atividades1;
// Desenvolva um programa que leia números inteiros do usuário 
// em um laço while até que ele digite 0 (zero). Ao final, 
// exiba a soma de todos os números digitados. 
// Utilize try/catch para tratar entradas inválidas.

import java.util.Scanner;

public class Q4_Soma_de_Números_com_while {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numero = -9;
        int resultado = 0;
        while(numero != 0){
            System.out.print("digite um numero inteiro:");
            try{
                numero = scanner.nextInt();
                resultado += numero;
            }catch(Exception  e){
                System.out.print("digite um numero meu deus:");
                scanner.next();
            }
        }
        System.out.print("somatorio: "+resultado);
        scanner.close();
    }
}
