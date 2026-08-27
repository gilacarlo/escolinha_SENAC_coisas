package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Desenvolva um jogo em que o programa gera um número aleatório 
// entre 1 e 100, e o usuário tenta adivinhar. Utilize while para 
// repetir até acertar, if/else para comparar o palpite com o número secreto, 
// Scanner para entrada e 
// try/catch para validação. Exiba dicas ("maior" ou "menor") a cada tentativa.
import java.util.Random;

public class Q10_Jogo_de_Adivinhação_com_Estruturas_de_Controle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randNum = random.nextInt(100);
        
        int numero = 0;
        while (true) {
            System.out.print("\ndigite um numero inteiro entre 0 e 100:");
            try{
                numero = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Digite algo válido!");
            }

            if(numero == randNum){
                System.out.print("\nvoce ganhou:");
                break;
            }else if(numero < randNum){
                System.out.print("\no numero esta acima desse:");
            }else if(numero > randNum){
                System.out.print("\no numero esta abaixo desse:");
            }
        }

        scanner.close();
    }
}
