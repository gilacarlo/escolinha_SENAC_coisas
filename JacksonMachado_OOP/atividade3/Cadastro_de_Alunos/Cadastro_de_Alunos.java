package JacksonMachado_OOP.atividade3.Cadastro_de_Alunos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro_de_Alunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Aluno> list = new ArrayList<>();
        
        list.add(new Aluno("Gian", 10, 0.0f, 10.0f));
        list.add(new Aluno("Gian2", 101, 10.0f,50.0f));
        list.add(new Aluno("Gian3", 20, 10.0f, 9.0f));
        list.add(new Aluno("Gian4", 30, 8.0f, 8.0f));
        list.add(new Aluno("Gian5", 18, 6.0f, 3.0f));

        int aprovados = 0;
        int reprovados = 0;
        for(Aluno alu : list){
            alu.exibirSituacao();
            if(alu.estaAprovado()){
                aprovados++;
            }else{
                reprovados++;
            }
        }
        System.out.print("\nAlunos aprovados: " + aprovados);
        System.out.print("\nAlunos reprovados: " + reprovados);
        scanner.close();
    }
}
