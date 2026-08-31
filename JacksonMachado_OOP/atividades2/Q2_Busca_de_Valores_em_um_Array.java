package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Crie um programa que leia 10 números inteiros e armazene-os em um array. 
// Em seguida, solicite outro número ao usuário e informe se ele está presente no array. 
// Caso esteja, exiba todas as posições em que foi encontrado; 
// caso contrário, informe que o número não foi localizado.
// O programa deve utilizar um laço for para preencher e percorrer o array. 
// A entrada dos números deve ser protegida por try/catch, e a comparação deve 
// ser realizada com operadores relacionais e if/else.

public class Q2_Busca_de_Valores_em_um_Array {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite a quatidade de alunos:");
        int quatAlunos = scanner.nextInt();

        int[] lista = new int[quatAlunos];

        for(int i = 0; i < lista.length; i++){
            System.out.print("digite um numero inteiro:");
            try{
                int numInt = scanner.nextInt();
                lista[i] = numInt;
            }catch(Exception e){
                System.out.println("Digite algo válido!");
                scanner.next();
                lista[i] = 0;
            }
        }

        System.out.print("digite um numero inteiro para procurar:");
        int numProcurar = scanner.nextInt();
        int[] listaAchado = new int[lista.length];
        int quantAchado = 0;

        
        for(int i = 0; i < lista.length; i++){
            if(numProcurar == lista[i]){
                
                listaAchado[quantAchado] = lista[i];
                quantAchado++;
            }
        }
        if(quantAchado == 0){
            System.out.print("\nNada achado. ");    
        }else{
            System.out.print("\nlugar achado em index: ");
            for(int i = 0; i < quantAchado; i++){
                System.out.print("\nIndex: " + i);
            }
        }
        scanner.close();
    }
}
