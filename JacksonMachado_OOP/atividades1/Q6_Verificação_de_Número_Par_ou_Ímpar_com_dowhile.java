package JacksonMachado_OOP.atividades1;
// Implemente um programa que utilize um laço do/while
// para ler números do usuário e verificar se são pares ou ímpares. 
// O programa deve continuar até que o usuário digite -1. 
// Utilize o operador módulo (%) e try/catch para validação.

import java.util.Scanner;

public class Q6_Verificação_de_Número_Par_ou_Ímpar_com_dowhile {
  public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        
        int numero = 0;
        boolean sair = false;
        while (sair == false) {
            try{
                System.out.print("\n digite um numero inteiro:");
                numero = scanner.nextInt();
                if(numero == -1){
                    sair = true;
                    continue;
                }
                if(numero % 2 == 0){
                    System.out.print("\n o numero é par:");
                }else{
                    System.out.print("\n o numero é impar:");
                }
            }catch(Exception e){
                System.out.print("digite algo valido");
                scanner.next();
            }
        }
        scanner.close();
    }  
}
