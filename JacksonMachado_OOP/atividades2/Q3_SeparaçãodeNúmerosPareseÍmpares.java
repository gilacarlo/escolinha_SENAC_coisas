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
        
        int taman = 15;
        int[] lista = new int[taman];

        for(int i = 0; i < lista.length; i++){
            System.out.print("\n" + (i + 1) + ". digite um numero inteiro:");
            try{
                int numInt = scanner.nextInt();
                lista[i] = numInt;
            }catch(Exception e){
                System.out.println("Digite algo válido!");
                scanner.next();
            }
        }

        int numerosPares = 0;
        int numerosimpares = 0;
        for(int i = 0; i < lista.length; i++){
            if(lista[i] % 2 == 0){
                System.out.print("\n" + lista[i] + " esse numero é par.");
                numerosPares++;
            }else{
                System.out.print("\n" + lista[i] + " esse numero é impar.");
                numerosimpares++;
            }
        }
        System.out.print("\nQuatidade de numeros pares: " + numerosPares );
        System.out.print("\nQuatidade de numeros impares: " + numerosimpares );
        scanner.close();
    }
}
