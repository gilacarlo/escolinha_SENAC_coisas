package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Desenvolva um programa que converta temperaturas entre Celsius e Fahrenheit. 
// Ofereça um menu com switch para escolher a conversão desejada. 
// Utilize Scanner para entrada, 
// operadores aritméticos para cálculo e try/catch para tratamento de exceções.

public class Q7_Conversão_de_Temperatura {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (sair == false) {
            System.out.print("\ndigite uma temperatura:");
            float temperatura = 0.0f;
            try{
                temperatura = scanner.nextFloat();
            }catch(Exception e){
                System.out.print("\ndigite algo valido:");
                scanner.next();
                continue;
            }

            System.out.print("\n(1) Celsius para Fahrenheit. "+
                            "\n(2) Fahrenheit para Celsius");
            int escolha = 0;
            try{
                escolha = scanner.nextInt();
            }catch(Exception e){
                System.out.print("\ndigite algo valido:");
                scanner.next();
                continue;
            }
            if(escolha == 1){
                temperatura = (temperatura * 1.8f) + 32;
            }else if(escolha == 2){
                temperatura = (temperatura - 32) * (5/9);
            }else{
                System.out.print("\ndigite algo valido:");
                continue;
            }
            System.out.print("\nTemperatura convertida: " + temperatura);
        }

        scanner.close();
    }
}
