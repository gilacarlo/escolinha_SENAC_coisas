package JacksonMachado_OOP.atividade_Avaliativa2;

public class RoboDefensivo extends Robo {
    private static final int REDUCAO_DANO = 3;
    private static final int DANO_FINAL_MINIMO = 2;

    public RoboDefensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Defensivo";
    }

    @Override
    protected int ajustarDanoRecebido(int dano) {
        return Math.max(DANO_FINAL_MINIMO, super.ajustarDanoRecebido(dano) - REDUCAO_DANO);
    }
}