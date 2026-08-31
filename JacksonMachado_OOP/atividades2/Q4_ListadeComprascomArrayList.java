package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Crie um programa que utilize uma ArrayList<String![alt text](https://example.com)> 
// para representar uma lista de compras. O programa deve 
// apresentar um menu com as opções: 
// adicionar produto, remover produto pelo nome, 
// listar produtos, consultar se um produto está na lista e encerrar.
// Utilize switch para controlar o menu, Scanner 
// para ler as informações e try/catch para tratar opções inválidas. 
// O programa deve continuar executando dentro de um laço do/while 
// até que o usuário escolha a opção de encerramento.

public class Q4_ListadeComprascomArrayList {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
