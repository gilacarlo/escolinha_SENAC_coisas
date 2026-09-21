package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Desenvolva um programa que leia cinco números inteiros e armazene-os 
// simultaneamente em um array de int e em uma ArrayList<Integer>. Depois, 
// exiba os valores das duas estruturas, calcule a soma dos elementos e 
// informe o maior valor armazenado.
// O programa deve possuir um menu com switch para permitir: inserir valores, 
// listar estruturas, calcular estatísticas e encerrar. Utilize for para percorrer 
// as estruturas e try/catch para tratar erros de conversão. 
// Ao trabalhar com ArrayList<Integer>, 
// observe a conversão automática entre int e Integer.

public class Q8_ComparaçãoentreArrayeArrayList {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
