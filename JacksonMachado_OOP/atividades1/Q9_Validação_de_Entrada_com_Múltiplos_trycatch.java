package JacksonMachado_OOP.atividades1;

import java.util.Scanner;

// Implemente um programa que leia três números decimais do usuário 
// e calcule a média aritmética. Utilize múltiplos 
// blocos try/catch para tratar diferentes tipos de exceção 
// (NumberFormatException, InputMismatchException). 
// Valide se os números são positivos com if/else.

public class Q9_Validação_de_Entrada_com_Múltiplos_trycatch {
    public static float varUsuario(Scanner scanner) {
        float num;

        while (true) {
            try {
                System.out.print("\nDigite um número: ");
                num = scanner.nextFloat();
                return num;

            } catch (Exception e) {
                System.out.println("Digite algo válido!");
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float num1 = varUsuario(scanner);
        float num2 = varUsuario(scanner);
        float num3 = varUsuario(scanner);

        float resultado = (num1 + num2 + num3) / 3;

        System.out.println("A média é: " + resultado);

        scanner.close();
    }
}
