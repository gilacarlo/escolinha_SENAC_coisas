package JacksonMachado_OOP.atividade3.Cadastro_de_Livros;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> livros = new ArrayList<>();

        // Cadastrando 5 livros
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", 1899, 40.00));
        livros.add(new Livro("Harry Potter", "J.K. Rowling", 1997, 60.00));
        livros.add(new Livro("O Hobbit", "J.R.R. Tolkien", 1937, 50.00));
        livros.add(new Livro("Clean Code", "Robert C. Martin", 2008, 90.00));
        livros.add(new Livro("Java Como Programar", "Deitel", 2020, 100.00));

        for (Livro livro : livros) {
            livro.exibirDados();
        }

        for (Livro livro : livros) {
            if (livro.ehAntigo()) {
                livro.exibirDados();
            }
        }

        for (Livro livro : livros) {
            if (livro.ehAntigo()) {
                livro.aplicarDesconto(10);
            }
        }

        for (Livro livro : livros) {
            System.out.println(
                livro.titulo + " - R$ " + livro.preco
            );
        }
    }
}
