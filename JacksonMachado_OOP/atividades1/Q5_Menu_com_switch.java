package JacksonMachado_OOP.atividades1;
// Crie um programa de menu que oferece as seguintes opções: 
// (1) Calcular área de um quadrado, 
// (2) Calcular área de um círculo, 
// (3) Calcular perímetro de um retângulo, (4) Sair. 
// Utilize switch para controlar o fluxo, 
// Scanner para entrada e try/catch para tratamento de erros.

import java.util.Scanner;

public class Q5_Menu_com_switch {
    public static float areaQuadrado(float tamanho){
        return (tamanho * tamanho);
    }
    public static float areaCirculo(float raio){
        return (raio * 2) * 3.14f;
    }
    public static float perimetroRetangulo(float ladoA, float ladoB){
        return (ladoB * 2) + (ladoA * 2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (sair == false) {
            try{
            System.out.print("\n(1) Calcular área de um quadrado, \r\n" + 
                            "(2) Calcular área de um círculo, \r\n" + 
                            "(3) Calcular perímetro de um retângulo,  \r\n"+
                            "(4) Sair. :");
            int opcao = scanner.nextInt();
            float num = 0.0f;
                switch (opcao) {
                case 1:
                    System.out.print("digite o tamanho do quadrado");
                    num = scanner.nextFloat();
                    System.out.print("area quadrado: " + areaQuadrado(num));
                    break;
                case 2:
                    System.out.print("digite o raio do circulo");
                    num = scanner.nextFloat();
                    System.out.print("area circulo: " + areaCirculo(num));
                    break;  
                case 3:
                    System.out.print("digite o lado A do retangulo");
                    num = scanner.nextFloat();
                    System.out.print("digite o lado B do retangulo");
                    float num2 = scanner.nextFloat();
                    System.out.print("area circulo: " + perimetroRetangulo(num,num2));
                    break;
                case 4:
                    sair = true;
                default:
                    break;
                }
            }catch(Exception e){
                System.out.print("digite algo valido");
                scanner.next();
            }
        }
        scanner.close();
    }
}
