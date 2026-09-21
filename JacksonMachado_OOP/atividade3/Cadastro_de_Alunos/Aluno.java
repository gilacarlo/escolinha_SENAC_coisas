package JacksonMachado_OOP.atividade3.Cadastro_de_Alunos;

public class Aluno {
    String nome;
    int idade;
    float nota1;
    float nota2;

    Aluno(String nome, int idade, float nota1, float nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public float calcularMedia(){
        return (this.nota1 + this.nota2) / 2;
    }
    public boolean estaAprovado(){
        if(calcularMedia() >= 7){
            return true;
        }else{
            return false;
        }
    }
    public void exibirSituacao(){
        if(estaAprovado()){
            System.out.print("\nO alunos" + this.nome + " com a media " + calcularMedia() + " esta aprovado.");
        }else{
            System.out.print("\nO alunos" + this.nome + " com a media " + calcularMedia() + " esta reprovado.");
        }
    }
}