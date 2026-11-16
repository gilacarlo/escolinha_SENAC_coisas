package JacksonMachado_OOP.atividade_Avaliativa2;

public abstract class Robo {
    public static final int ENERGIA_MAXIMA = 100;
    public static final int ENERGIA_MINIMA_DUELO = 30;
    private static final int DANO_MINIMO = 5;
    private static final int BONUS_RODADA_PAR = 5;

    private final int codigo;
    private final String nome;
    private final int ataque;   // entre 10 e 30
    private final int defesa;   // entre 0 e 20
    private int energia = ENERGIA_MAXIMA;
    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int folgas = 0;
    private int duelos = 0;
    private float pontos = 0;

    protected Robo(int codigo, String nome, int ataque, int defesa) {
        if (!ataqueValido(ataque)) throw new IllegalArgumentException("Ataque invalido!");
        if (!defesaValida(defesa)) throw new IllegalArgumentException("Defesa invalida!");
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // ---------- validações comuns ----------
    public static boolean ataqueValido(int ataque) {
        return ataque >= 10 && ataque <= 30;
    }

    public static boolean defesaValida(int defesa) {
        return defesa >= 0 && defesa <= 20;
    }

    // ---------- comportamentos sobrescrevíveis (polimorfismo) ----------
    public abstract String getTipo();

    /** Ataque usado no cálculo de um golpe (não altera o atributo ataque). */
    protected int calcularAtaque() {
        return getAtaque();
    }

    /** Ajuste final aplicado ao dano que este robô receberia. */
    protected int ajustarDanoRecebido(int dano) {
        return dano;
    }

    // ---------- combate ----------
    /**
     * Ordem: ataque do agressor (com modificador) -> menos defesa do alvo -> dano minimo 5
     * -> bonus de 5 em rodadas pares -> reducao do alvo (se houver).
     */
    public final void atacar(Robo alvo, int rodada, boolean mostrarPrint) {
        int dano = this.calcularAtaque() - alvo.getDefesa();
        if (dano < DANO_MINIMO) {
            dano = DANO_MINIMO;
        }
        if (rodada % 2 == 0) {
            dano += BONUS_RODADA_PAR;
        }
        dano = alvo.ajustarDanoRecebido(dano);
        alvo.receberDano(dano, mostrarPrint);
    }

    private void receberDano(int dano, boolean mostrarPrint) {
        int danoReal = Math.min(dano, this.energia);
        if (mostrarPrint) System.out.print("\n" + this.nome + " tomou " + danoReal + " de dano!");
        this.energia -= danoReal;
    }

    public boolean estaDisponivel() {
        return this.energia >= ENERGIA_MINIMA_DUELO;
    }

    public void recuperarEnergia(int energia) {
        if (energia % 10 != 0) {
            System.out.print("\nTem que ser multiplo de 10.");
            return;
        }
        if (energia + this.energia > ENERGIA_MAXIMA) {
            System.out.print("\nNao pode ser maior que 100.");
            return;
        }
        if (energia <= 0) {
            System.out.print("\nNao pode ser menor que 0.");
            return;
        }
        int pontosQueVaiGastar = energia / 10;
        if (pontosQueVaiGastar <= this.pontos) {
            this.energia += energia;
            this.pontos -= pontosQueVaiGastar;
            System.out.print("\nEnergia total : " + this.energia);
        } else {
            System.out.print("\nNao tem pontos suficientes.");
        }
    }

    // ---------- registro de resultados ----------
    public void registrarInicioDuelo() { this.duelos++; }

    public void registrarVitoria() {
        this.pontos += 3;
        this.vitorias++;
    }

    public void registrarDerrota() { this.derrotas++; }

    public void registrarEmpate() {
        this.pontos += 1;
        this.empates++;
    }

    public void registrarFolga() {
        this.folgas++;
        this.pontos += 1;
    }

    // ---------- getters ----------
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getEnergia() { return energia; }
    public int getVitorias() { return vitorias; }
    public int getDerrotas() { return derrotas; }
    public int getEmpates() { return empates; }
    public int getFolgas() { return folgas; }
    public int getDuelos() { return duelos; }
    public float getPontos() { return pontos; }
}