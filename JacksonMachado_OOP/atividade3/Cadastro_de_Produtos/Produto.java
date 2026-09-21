package JacksonMachado_OOP.atividade3.Cadastro_de_Produtos;

public class Produto {
    String nome;
    float preco;
    int quantidade;
    
    Produto(String nome, float preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(int quantidade){
        this.quantidade += quantidade;
    };
    public void removerEstoque(int quantidade){
        this.quantidade -= quantidade;
    };
    public float calcularValorEstoque(){
        return this.quantidade * this.preco;
    };
    public void exibirDados(){
        System.out.print("nome: " + this.nome);
        System.out.print("preco: " + this.preco);
        System.out.print("quantidade: " + this.quantidade);
    };
}
