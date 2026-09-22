package JacksonMachado_OOP.atividade3.Sistema_de_Funcionários;

public class Funcionario {
    String nome;
    String cargo;
    double salario;
    int anosEmpresa;
    
    public Funcionario(String nome, String cargo, double salario, int anosEmpresa) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anosEmpresa = anosEmpresa;
    }

    public void aumentarSalario(double percentual) {
        salario += salario * percentual / 100;
    }

    public double calcularBonus() {
        if (anosEmpresa < 2) {
            return salario * 0.05;
        } else if (anosEmpresa <= 5) {
            return salario * 0.10;
        } else {
            return salario * 0.15;
        }
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Anos na empresa: " + anosEmpresa);
        System.out.println("Bônus: R$ " + calcularBonus());
    }
}
