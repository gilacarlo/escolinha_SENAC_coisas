package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Desenvolva um sistema simples de estoque utilizando um HashMap<String, Integer>, 
// no qual a chave representa o nome do produto e o valor representa a 
// quantidade disponível. O menu deve oferecer as opções de cadastrar produto, 
// consultar estoque, atualizar quantidade, remover produto e listar todos os produtos.
// Utilize switch para as opções do menu e um laço while ou do/while para manter 
// o sistema em execução. Ao consultar ou atualizar um produto, verifique sua 
// existência com if/else. Trate entradas numéricas inválidas com try/catch e 
// faça as conversões necessárias.

public class Q6_ControledeEstoquecomHashMap {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
