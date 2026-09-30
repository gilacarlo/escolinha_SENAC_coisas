package JacksonMachado_OOP.atividade_Avaliativa1;

public class Robo {
    int codigo; 
    String nome; 
    int ataque; //deverá estar entre 10 e 30
    int defesa; // entre 0 e 20
    int energia = 100; // maximo 100
    int vitorias = 0;
    int derrotas = 0;
    int empates = 0;
    int folgas = 0;
    float pontos = 0;

    Robo(int codigo, String nome, int ataque, int defesa){
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque; 
        this.defesa = defesa; 
    }

    void DefenderAtaque(int ataqueOponente, boolean mostrarPrint){
        int danoReceber = ataqueOponente - this.defesa;
        if(danoReceber < 5 /*dano minimo */){
            danoReceber = 5;
        }
        if(danoReceber > this.energia){
            if(mostrarPrint) System.out.print("\n" + this.nome + " tomou " + (danoReceber - this.energia) + " de dano!");
            this.energia = 0;
        }else{
            if(mostrarPrint) System.out.print("\n" + this.nome + " tomou " + danoReceber + " de dano!");
            this.energia -= danoReceber;
        }
    }
    void recuperarEnergia(int energia){
        if(energia % 10 != 0){
            System.out.print("\nTem que ser multiplo de 10.");
            return;
        }
        if(energia + this.energia > 100){
            System.out.print("\nNao pode ser maior que 100.");
            return;
        }
        if(energia < 10){
            System.out.print("\nNao pode ser menor que 0.");
            return;
        }
        int pontosQueVaiGastar = energia/10;
        if(pontosQueVaiGastar <= this.pontos){
            this.energia += energia;
            this.pontos -= pontosQueVaiGastar;
            System.out.print("\nEnergia total : " + this.energia);
        }else{
            System.out.print("\nNao tem pontos suficientes.");
        }
    }
    void ganhouDuleo(){
        this.pontos += 3;
        this.vitorias++;
    }
    void perdeuDuelo(){
        this.derrotas++;
    }
    void empatouDuelo(){
        this.pontos += 1;
        this.empates++;
    }
}
