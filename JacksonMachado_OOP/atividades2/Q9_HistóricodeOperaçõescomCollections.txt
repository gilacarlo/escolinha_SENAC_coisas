package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Crie uma calculadora que execute operações de adição, subtração, multiplicação 
// e divisão. Cada resultado calculado deve ser armazenado em uma ArrayList<Double> 
// como parte de um histórico. O programa deve permitir realizar novas operações, 
// exibir o histórico, limpar o histórico e encerrar.
// Utilize switch para escolher a operação e um laço while ou do/while para repetir 
// o programa. Verifique a tentativa de divisão por zero com if/else e trate entradas 
// inválidas com try/catch. As entradas podem ser obtidas como String e convertidas 
// para double por meio de Double.parseDouble.

public class Q9_HistóricodeOperaçõescomCollections {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        int numero = scanner.nextInt();
    
        scanner.close();
    }
}
