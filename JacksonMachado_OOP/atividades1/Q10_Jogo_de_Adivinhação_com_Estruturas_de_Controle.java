package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Desenvolva um jogo em que o programa gera um número aleatório 
// entre 1 e 100, e o usuário tenta adivinhar. Utilize while para 
// repetir até acertar, if/else para comparar o palpite com o número secreto, 
// Scanner para entrada e 
// try/catch para validação. Exiba dicas ("maior" ou "menor") a cada tentativa.

public class Q10_Jogo_de_Adivinhação_com_Estruturas_de_Controle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
