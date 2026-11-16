package JacksonMachado_OOP.atividade_Avaliativa2;
 
public class RoboOfensivo extends Robo {
    private static final int BONUS_ATAQUE = 5;
 
    public RoboOfensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }
 
    @Override
    public String getTipo() {
        return "Ofensivo";
    }
 
    @Override
    protected int calcularAtaque() {
        return super.calcularAtaque() + BONUS_ATAQUE;
    }
}
 