package JacksonMachado_OOP.atividades2;

import java.util.Scanner;

// Desenvolva um programa que solicite ao usuário a quantidade de alunos 
// de uma turma e armazene as notas deles em um array de double. 
// O programa deve calcular e exibir a média da turma, a maior nota, a 
// menor nota e a quantidade de alunos aprovados, considerando média mínima igual a 6,0.
// Utilize Scanner para a entrada, try/catch para tratar valores inválidos, 
// conversão de tipos quando necessário e um laço for para percorrer o array. 
// Use if/else para classificar os alunos como aprovados ou reprovados.

public class Q1_Cadastro_e_Análise_de_Notas_com_Array {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite a quatidade de alunos:");
        int quatAlunos = scanner.nextInt();

        double[] lista = new double[quatAlunos];
        double maiorNota = -1;
        double menorNota = 999;
        double totalNotas = 0;
        int aprovados = 0;

        for(int i = 0; i < lista.length; i++){
            System.out.print("digite a nota do alunos:");
            try{
                double notaAluno = scanner.nextDouble();
                lista[i] = notaAluno;
            }catch(Exception e){
                System.out.println("Digite algo válido!");
                scanner.next();
                lista[i] = 0;
            }
            if( lista[i] > maiorNota){
                maiorNota = lista[i];
            }
            if( lista[i] < menorNota){
                menorNota = lista[i];
            }
            if( lista[i] >= 6.0){
                aprovados++;
            }
            totalNotas += lista[i];
        }

        System.out.print("\nMedia da truma: " + totalNotas / quatAlunos);
        System.out.print("\nMaior nota: " + maiorNota);
        System.out.print("\nMenor nota: " + menorNota);
        System.out.print("\naprovados: " + aprovados);
        scanner.close();
    }
}
