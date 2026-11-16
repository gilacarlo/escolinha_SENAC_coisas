package JacksonMachado_OOP.atividade_Avaliativa2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Integer intInput(Scanner scanner){
        int numero = 0;
        while(true){
            try {
                numero = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nTenta digitar um numero inteiro! ");
                scanner.next();
                continue;
            }
            return numero;
        }
    }

    ArrayList<Robo> robos = new ArrayList<>();
    int codigoMaximo = 1;

    // tipo: 1 = Ofensivo, 2 = Defensivo, 3 = Equilibrado
    public void cadastrarRobo(String nome, int ataque, int defesa, int tipo){
        if(!Robo.ataqueValido(ataque)){
            System.out.print("\nAtaque invalido!");
            return;
        }
        if(!Robo.defesaValida(defesa)){
            System.out.print("\nDefesa invalida!");
            return;
        }
        Robo novo;
        switch (tipo) {
            case 1: novo = new RoboOfensivo(this.codigoMaximo, nome, ataque, defesa); break;
            case 2: novo = new RoboDefensivo(this.codigoMaximo, nome, ataque, defesa); break;
            default: novo = new RoboEquilibrado(this.codigoMaximo, nome, ataque, defesa); break;
        }
        robos.add(novo);
        this.codigoMaximo++;
    }
    public Robo encontrarRobo(int codigo){
        for(Robo robo : robos){
            if(robo.getCodigo() == codigo){
                return robo;
            }
        }
        System.out.print("\nRobo nao existe");
        return null;
    }
    public void roboAtributosMostrar(Robo robo){
        System.out.print("\nNome: " + robo.getNome());
        System.out.print("\nTipo: " + robo.getTipo());
        System.out.print("\nCodigo: " + robo.getCodigo());
        System.out.print("\nAtaque: " + robo.getAtaque());
        System.out.print("\nDefesa: " + robo.getDefesa());
        System.out.print("\nEnergia: " + robo.getEnergia());
        if(robo.estaDisponivel()){
            System.out.print("\nSituação: disponível");
        }else{
            System.out.print("\nSituação: em recuperação");
        }
    }
    public void realizarCombate1v1(Robo robo1, Robo robo2, boolean mostrarPrint){
        if(!robo1.estaDisponivel() || !robo2.estaDisponivel()){
            if(mostrarPrint) System.out.print("\nSem energia no(s) robo(s)");
            return;
        }
        robo1.registrarInicioDuelo();
        robo2.registrarInicioDuelo();

        Robo primeiroRoboAtacar;
        if(robo1.getPontos() == robo2.getPontos()){
            if(robo1.getCodigo() < robo2.getCodigo()){
                primeiroRoboAtacar = robo1;
            }else{
                primeiroRoboAtacar = robo2;
            }
        }else if(robo1.getPontos() < robo2.getPontos()){
            primeiroRoboAtacar = robo1;
        }else{
            primeiroRoboAtacar = robo2;
        }
        Robo segundoRoboAtacar = primeiroRoboAtacar == robo1 ? robo2 : robo1;
        for(int i = 1; i <= 5; i++){
            // primeiro ataque (polimorfico: cada tipo aplica seu comportamento)
            primeiroRoboAtacar.atacar(segundoRoboAtacar, i, mostrarPrint);
            if(segundoRoboAtacar.getEnergia() == 0){
                if(mostrarPrint) System.out.print("\nRobo " + segundoRoboAtacar.getNome() + " desmaiou!");
                primeiroRoboAtacar.registrarVitoria();
                segundoRoboAtacar.registrarDerrota();
                return;
            }
            // segundo ataque
            segundoRoboAtacar.atacar(primeiroRoboAtacar, i, mostrarPrint);
            if(primeiroRoboAtacar.getEnergia() == 0){
                if(mostrarPrint) System.out.print("\nRobo " + primeiroRoboAtacar.getNome() + " desmaiou!");
                segundoRoboAtacar.registrarVitoria();
                primeiroRoboAtacar.registrarDerrota();
                return;
            }
        }
        // se nenhum desmaiar
        if(robo1.getEnergia() == robo2.getEnergia()){
            if(mostrarPrint) System.out.print("\nEmpatou!");
            robo1.registrarEmpate();
            robo2.registrarEmpate();
        }else if(robo1.getEnergia() > robo2.getEnergia()){
            if(mostrarPrint) System.out.print("\nRobo " + robo1.getNome() + " ganhou!");
            robo1.registrarVitoria();
            robo2.registrarDerrota();
        }else{
            if(mostrarPrint) System.out.print("\nRobo " + robo2.getNome() + " ganhou!");
            robo2.registrarVitoria();
            robo1.registrarDerrota();
        }
    }
    public Robo[] listaDeRobosEmSuasColocacoes(){
        Robo[] classificacaoRobos = new Robo[robos.size()];
        for(Robo robo : robos){
            int indexQPodeColocar = 0;
            for(Robo roboCla : classificacaoRobos){
                if(roboCla == null){
                    break;
                }
                boolean achou = false;
                if(robo.getPontos() == roboCla.getPontos()){
                    if(robo.getVitorias() == roboCla.getVitorias()){
                        if(robo.getEnergia() == roboCla.getEnergia()){
                            if(robo.getCodigo() > roboCla.getCodigo()){
                                achou = true;
                            }
                        }else if(robo.getEnergia() < roboCla.getEnergia()){
                            achou = true;
                        }
                    }else if(robo.getVitorias() < roboCla.getVitorias()){
                        achou = true;
                    }
                }else if(robo.getPontos() < roboCla.getPontos()){
                    achou = true;
                }
                if(achou == true){
                    // shiftar todos os valores para direita
                    for(int i = robos.size() - 2; i >= indexQPodeColocar; i--){
                        classificacaoRobos[i + 1] = classificacaoRobos[i];
                    }
                    break;
                }
                indexQPodeColocar++;
            }
            classificacaoRobos[indexQPodeColocar] = robo;
        }
        return classificacaoRobos;
    }
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cadastrarRobo("Jorge", 30, 10, 1);
        cadastrarRobo("Roberto", 20,15, 2);
        cadastrarRobo("Maria", 20,15, 3);
        cadastrarRobo("Deus", 30,20, 1);
        cadastrarRobo("Matheus", 15, 15, 2);
        boolean sair = false;
        while(sair == false){
            System.out.print("\nEscolha uma das opcoes:");
            System.out.print("\n(1) Cadastrar robo.");
            System.out.print("\n(2) Consultar robo.");
            System.out.print("\n(3) Listar todos os robos.");
            System.out.print("\n(4) Realizar um combate.");
            System.out.print("\n(5) Recuperar energia de um robo.");
            System.out.print("\n(6) Executar uma rodada geral.");
            System.out.print("\n(7) Exibir a classificação.");
            System.out.print("\n(8) Emitir estatísticas.");
            System.out.print("\n(9) Excluir robo.");
            System.out.print("\n(10) Sair.");

            int numero = intInput(scanner);
            switch (numero) {
                case 1:
                    System.out.print("\nDigite o nome do robo:");
                    String nome;
                    do{
                        nome = scanner.nextLine();
                        if(nome.trim().isEmpty()){
                            System.out.println("\nO nome não pode estar vazio.");
                        }
                    }while(nome.trim().isEmpty());
                    System.out.print("\nDigite o ataque do robo:");
                    int ataque = intInput(scanner);
                    System.out.print("\nDigite a defesa do robo:");
                    int defesa = intInput(scanner);
                    int tipo;
                    do{
                        System.out.print("\nEscolha o tipo do robo: (1) Ofensivo (2) Defensivo (3) Equilibrado: ");
                        tipo = intInput(scanner);
                    }while(tipo < 1 || tipo > 3);
                    cadastrarRobo(nome, ataque, defesa, tipo);
                    break;
                case 2:
                    if(robos.size() == 0) {System.out.print("\nAinda não existem robos."); break;}
                    System.out.print("\nDigite o codigo do robo:");
                    Robo roboConsultar = encontrarRobo(intInput(scanner));
                    if(roboConsultar != null){
                        roboAtributosMostrar(roboConsultar);
                    }
                    break;
                case 3:
                    if(robos.size() == 0) {System.out.print("\nAinda não existem robos."); break;}
                    for(Robo robo : robos){
                        roboAtributosMostrar(robo);
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    if(robos.size() < 2) {System.out.print("\nAinda não existem robos suficientes."); break;}
                    Robo robo1; Robo robo2;
                    do{
                        System.out.print("\nDigite o codigo do robo1:");
                        robo1 = encontrarRobo(intInput(scanner));
                    }while(robo1 == null);
                    do{
                        System.out.print("\nDigite o codigo do robo2:");
                        do{
                            robo2 = encontrarRobo(intInput(scanner));
                        }while(robo2 == null);
                    }while(robo1.getCodigo() == robo2.getCodigo());
                    realizarCombate1v1(robo1, robo2, true);
                    break;
                case 5:
                    if(robos.size() == 0) {System.out.print("\nAinda não existem robos."); break;}
                    Robo roboE;
                    do{
                        System.out.print("\nDigite o codigo do robo:");
                        roboE = encontrarRobo(intInput(scanner));
                    }while(roboE == null);
                    System.out.print("\nQuantidade de energia para recuperar: ");
                    int energiaRecuperar = intInput(scanner);
                    roboE.recuperarEnergia(energiaRecuperar);
                    break;
                case 6:
                    Robo[] todosRobos = listaDeRobosEmSuasColocacoes();
                    ArrayList<Robo> robosDisponiveis = new ArrayList<>();
                    for(int i = 0; i < todosRobos.length; i++){
                        if(todosRobos[i].estaDisponivel()){
                            robosDisponiveis.add(todosRobos[i]);
                        }
                    }
                    if(robosDisponiveis.size() < 2){
                        System.out.print("\nNão existem robos disponíveis suficientes.");
                        break;
                    }
                    Robo[] robosParaDuelar = new Robo[robosDisponiveis.size()];
                    for(int i = 0; i < robosDisponiveis.size(); i++){
                        robosParaDuelar[i] = robosDisponiveis.get(i);
                    }
                    if(robosParaDuelar.length % 2 != 0){
                        Robo roboDaFolga = robosParaDuelar[robosParaDuelar.length - 1];
                        roboDaFolga.registrarFolga(); // folga + 1 ponto
                        System.out.print("\n" + roboDaFolga.getNome() + " ficou de folga e ganhou 1 ponto.");
                        Robo[] savedBruh = robosParaDuelar;
                        robosParaDuelar = new Robo[robosParaDuelar.length - 1];
                        for(int i = 0; i < robosParaDuelar.length; i++){
                            robosParaDuelar[i] = savedBruh[i];
                        }
                    }
                    for(int i = 0; i < robosParaDuelar.length; i += 2){
                        Robo roboUM = robosParaDuelar[i];
                        Robo roboDois = robosParaDuelar[i + 1];
                        realizarCombate1v1(roboUM, roboDois, true);
                    }

                    break;
                case 7:
                    Robo[] robosColocacoes = listaDeRobosEmSuasColocacoes();
                    int posicaoRoboPontos = 1;
                    System.out.print("\nClassificação dos robos: ");
                    for(int i = robos.size() - 1; i >= 0; i--){
                        System.out.print("\n" + posicaoRoboPontos + " " + robosColocacoes[i].getNome() + " (" + robosColocacoes[i].getTipo() + ")  pontos: " + robosColocacoes[i].getPontos());
                        posicaoRoboPontos++;
                    }
                    break;
                case 8:
                    if(robos.size() == 0){
                        System.out.println("Ainda não existem robos.");
                        break;
                    }
                    System.out.print("\nQuantidade de robos cadastrados: " + robos.size());
                    float mediaDeEnergiaDeTodos = 0;
                    for(Robo robo : robos){
                        mediaDeEnergiaDeTodos += robo.getEnergia();
                    }
                    mediaDeEnergiaDeTodos /= robos.size();
                    System.out.print("\nMedia de energia dos robos: " + mediaDeEnergiaDeTodos);
                    float maiorAproveitamento = 0;
                    ArrayList<Robo> robosEmpatados = new ArrayList<>();
                    for(Robo robo : robos){
                        int partidasTotaisRobo = robo.getDuelos();
                        if(partidasTotaisRobo == 0) continue;
                        float aproveitamentoRobo = (float) robo.getVitorias() / (float) partidasTotaisRobo;
                        if(aproveitamentoRobo > maiorAproveitamento){
                            maiorAproveitamento = aproveitamentoRobo;
                            robosEmpatados.clear();
                            robosEmpatados.add(robo);
                        }else if(aproveitamentoRobo == maiorAproveitamento){
                            robosEmpatados.add(robo);
                        }
                        if(!robo.estaDisponivel()){
                            System.out.print("\nRobo " + robo.getNome() + " esta em recuperação.");
                        }
                    }
                    for(Robo robo : robosEmpatados){
                        System.out.print("\nRobo " + robo.getNome() + " esta com o maior aproveitamento de " + (maiorAproveitamento * 100));
                    }
                    break;
                case 9:
                    Robo roboExcuir;
                    if(robos.size() == 0) {System.out.print("\nAinda não existem robos."); break;}
                    do{
                        System.out.print("\nDigite o codigo do robo:");
                        roboExcuir = encontrarRobo(intInput(scanner));
                    }while(roboExcuir == null);
                    if(roboExcuir.getDuelos() == 0){
                        robos.remove(roboExcuir);
                    }else{
                        System.out.print("\nEsse robo ja duelou entao nao pode deleta-lo!");
                    }
                    break;
                case 10:
                    sair = true;
                    break;
                default:
                    break;
            }
            String clicarParaSkipar = scanner.next();
        }

        scanner.close();
    }
}