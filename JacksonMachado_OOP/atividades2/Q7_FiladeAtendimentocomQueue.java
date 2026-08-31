package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Crie um programa que simule uma fila de atendimento utilizando uma collection 
// compatível com a interface Queue<String>, como LinkedList<String>. O sistema 
// deve permitir adicionar um cliente ao final da fila, atender o próximo cliente, 
// consultar quem será atendido em seguida, listar a fila e encerrar o programa.
// Utilize switch para controlar as opções e do/while para repetir o menu. Antes de 
// remover ou consultar o próximo cliente, verifique se a fila está vazia para 
// evitar erros. As entradas devem ser lidas com Scanner e protegidas com try/catch 
// quando necessário.

public class Q7_FiladeAtendimentocomQueue {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
