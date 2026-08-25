// Crie um programa de menu que oferece as seguintes opções: 
// (1) Calcular área de um quadrado, 
// (2) Calcular área de um círculo, 
// (3) Calcular perímetro de um retângulo, (4) Sair. 
// Utilize switch para controlar o fluxo, 
// Scanner para entrada e try/catch para tratamento de erros.

import java.util.Scanner;

public class Menu_com_switch {
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

        System.out.print("digite um numero inteiro:");
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
                System.out.print("area quadrado: " + areaQuadrado(23.3f));
                break;
        
            default:
                break;
        }
        scanner.close();
    }
}
