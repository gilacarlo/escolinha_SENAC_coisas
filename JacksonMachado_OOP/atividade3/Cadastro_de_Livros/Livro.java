package JacksonMachado_OOP.atividade3.Cadastro_de_Livros;

public class Livro {
    String titulo;
    String autor;
    int anoPublicacao;
    double preco;
    
    Livro(String titulo, String autor, int anoPublicacao, double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
    }
    
    public void exibirDados(){
        System.out.print("titulo: " + this.titulo);
        System.out.print("autor: " + this.autor);
        System.out.print("preco: " + this.preco);
        System.out.print("anoPublicacao: " + this.anoPublicacao);
    }
    public boolean ehAntigo(){
        if(this.anoPublicacao < 2006){
            return true;
        }else{
            return false;
        }
    }
    public double aplicarDesconto(double percentual){
        return this.preco * (1 - percentual / 100);
    }
}