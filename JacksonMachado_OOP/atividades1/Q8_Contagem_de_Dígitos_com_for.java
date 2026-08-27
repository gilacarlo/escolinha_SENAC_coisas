package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Crie um programa que leia um número inteiro positivo e conte quantos 
// dígitos ele possui. Utilize um laço for com conversão de String, 
// operadores relacionais e try/catch para validação de entrada.

public class Q8_Contagem_de_Dígitos_com_for {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numero = 0;
        try{
            System.out.print("digite um numero inteiro e positivo:");
            numero = scanner.nextInt();
            if(numero < 0){
              System.out.print("\ndigite algo valido:");  
            }else{
                String texto = Integer.toString(numero);
                System.out.print("algarismos: " + texto.length());
            }
            
        }catch(Exception e){
            System.out.print("\ndigite algo valido:");
            scanner.next();
        }
        scanner.close();
    }
}
