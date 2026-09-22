package JacksonMachado_OOP.atividade3.Sistema_de_Funcionários;

import java.util.ArrayList;

public class Sistema_de_Funcionários {
    public static void main(String[] args) {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("João", "Analista", 3000, 1));
        funcionarios.add(new Funcionario("Maria", "Gerente", 6000, 6));
        funcionarios.add(new Funcionario("Carlos", "Desenvolvedor", 4500, 3));
        funcionarios.add(new Funcionario("Ana", "Designer", 3500, 5));
        funcionarios.add(new Funcionario("Pedro", "Estagiário", 1800, 1));

        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirDados();
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                funcionario.nome + " - Bônus: R$ " + funcionario.calcularBonus()
            );
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentarSalario(10);
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                funcionario.nome + " - Novo salário: R$ " + funcionario.salario
            );
        }

        Funcionario maiorSalario = funcionarios.get(0);

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.salario > maiorSalario.salario) {
                maiorSalario = funcionario;
            }
        }

        System.out.println("Funcionário: " + maiorSalario.nome);
        System.out.println("Cargo: " + maiorSalario.cargo);
        System.out.println("Salário: R$ " + maiorSalario.salario);
    }
}
