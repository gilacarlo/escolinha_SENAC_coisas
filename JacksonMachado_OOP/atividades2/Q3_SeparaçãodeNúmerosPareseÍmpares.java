package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Desenvolva um programa que leia 15 números inteiros e armazene-os em um array. Depois, percorra 
// o array e exiba separadamente os números pares e os números ímpares. Ao final, informe a 
// quantidade de elementos de cada grupo.
// Utilize o operador módulo (%) para identificar a paridade. O preenchimento do 
// array deve ser feito com for, e o programa deve tratar entradas inválidas usando try/catch.

public class Q3_SeparaçãodeNúmerosPareseÍmpares {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
