package JacksonMachado_OOP.atividade_Avaliativa1;

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
    int codigoMaximo = 0;
    public void cadastrarRobo(String nome, int ataque, int defesa){
        if(ataque < 10 || ataque > 30){
            System.out.print("\nAtaque invalido!");
            return;
        }
        if(defesa < 0 || defesa > 20){
            System.out.print("\nDefesa invalida!");
            return;
        }
        robos.add(new Robo(this.codigoMaximo, nome, ataque, defesa));
        this.codigoMaximo++;
    }
    public Robo encontrarRobo(int codigo){
        for(Robo robo : robos){
            if(robo.codigo == codigo){
                return robo;
            }
        }
        System.out.print("\nRobo nao existe");
        return null;
    }
    public void roboAtributosMostrar(Robo robo){
        System.out.print("\nNome: " + robo.nome);
        System.out.print("\nCodigo: " + robo.codigo);
        System.out.print("\nAtaque: " + robo.ataque);
        System.out.print("\nDefesa: " + robo.defesa);
        System.out.print("\nEnergia: " + robo.energia);
        if(robo.energia >= 30){
            System.out.print("\nSituação: disponível");
        }else{
            System.out.print("\nSituação: em recuperação");
        }
    }
    public void realizarCombate1v1(Robo robo1, Robo robo2, boolean mostrarPrint){
        if(robo1.energia < 30 || robo2.energia < 30){
            if(mostrarPrint) System.out.print("\nSem energia no(s) robo(s)");
            return;
        }
        Robo primeiroRoboAtacar;
        if(robo1.pontos == robo2.pontos){
            if(robo1.codigo < robo2.codigo){
                primeiroRoboAtacar = robo1;
            }else{
                primeiroRoboAtacar = robo2;
            }
        }else if(robo1.pontos > robo2.pontos){
            primeiroRoboAtacar = robo1;
        }else{
            primeiroRoboAtacar = robo2;
        }
        Robo segundoRoboAtacar = primeiroRoboAtacar == robo1 ? robo2 : robo1;
        for(int i = 1; i <= 5; i++){
            // primeiro ataque
            int ataque1 = primeiroRoboAtacar.ataque;
            if(i % 2 == 0) ataque1 += 5;
            segundoRoboAtacar.DefenderAtaque(ataque1, true);
            if(segundoRoboAtacar.energia == 0){
                if(mostrarPrint) System.out.print("\nRobo " + segundoRoboAtacar.nome + " desmaiou!");
                primeiroRoboAtacar.ganhouDuleo();
                segundoRoboAtacar.perdeuDuelo();
                return;
            }
            // segundo ataque
            int ataque2 = segundoRoboAtacar.ataque;
            if(i % 2 == 0) ataque2 += 5;
            primeiroRoboAtacar.DefenderAtaque(ataque2, true);
            if(primeiroRoboAtacar.energia == 0){
                if(mostrarPrint) System.out.print("\nRobo " + primeiroRoboAtacar.nome + " desmaiou!");
                segundoRoboAtacar.ganhouDuleo();
                primeiroRoboAtacar.perdeuDuelo();
                return;
            }
        }
        // se nenhum desmaiar
        if(robo1.energia == robo2.energia){
            if(mostrarPrint) System.out.print("\nEmpatou!");
            robo1.empatouDuelo();
            robo2.empatouDuelo();
        }else if(robo1.energia > robo2.energia){
            if(mostrarPrint) System.out.print("\nRobo " + robo1.nome + " ganhou!");
            robo1.ganhouDuleo();
            robo2.perdeuDuelo();
        }else{
            if(mostrarPrint) System.out.print("\nRobo " + robo2.nome + " ganhou!");
            robo2.ganhouDuleo();
            robo1.perdeuDuelo();
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
                if(robo.pontos == roboCla.pontos){
                    if(robo.vitorias == roboCla.vitorias){
                        if(robo.energia == roboCla.energia){
                            if(robo.codigo > roboCla.codigo){
                                achou = true;
                            }
                        }else if(robo.energia < roboCla.energia){
                            achou = true;
                        }
                    }else if(robo.vitorias < roboCla.vitorias){
                        achou = true;
                    }
                }else if(robo.pontos < roboCla.pontos){
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
        cadastrarRobo("Jorge", 30, 10);
        cadastrarRobo("Roberto", 20,15);
        cadastrarRobo("Maria", 20,15);
        cadastrarRobo("Deus", 30,20);


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
                    String nome = scanner.next();
                    System.out.print("\nDigite o ataque do robo:");
                    int ataque = intInput(scanner);
                    System.out.print("\nDigite a defesa do robo:");
                    int defesa = intInput(scanner);
                    cadastrarRobo(nome, ataque, defesa);
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
                    }while(robo1.codigo == robo2.codigo);
                    realizarCombate1v1(robo1, robo2, true);
                    break;
                case 5:
                    Robo roboE;
                    do{
                        System.out.print("\nDigite o codigo do robo:");
                        roboE = encontrarRobo(intInput(scanner));
                    }while(roboE == null);
                    int energiaRecuperar = intInput(scanner);
                    roboE.recuperarEnergia(energiaRecuperar);
                    break;
                case 6:
                    Robo[] robosParaDuelar = listaDeRobosEmSuasColocacoes();
                    if(){
                        
                    }
                    break;
                case 7:
                    Robo[] robosColocacoes = listaDeRobosEmSuasColocacoes();
                    int posicaoRoboPontos = 1;
                    System.out.print("\nClassificação dos robos: ");
                    for(int i = robos.size() - 1; i >= 0; i--){
                        System.out.print("\n" + posicaoRoboPontos + " " + robosColocacoes[i].nome + "  pontos: " + robosColocacoes[i].pontos);
                        posicaoRoboPontos++;
                    }
                    break;
                case 8:
                    System.out.print("\nQuantidade de robos cadastrados: " + robos.size());
                    float mediaDeEnergiaDeTodos = 0;
                    for(Robo robo : robos){
                        mediaDeEnergiaDeTodos += robo.energia;
                    }
                    mediaDeEnergiaDeTodos /= robos.size();
                    System.out.print("\nMedia de energia dos robos: " + mediaDeEnergiaDeTodos);
                    float maiorAproveitamento = 0;
                    ArrayList<Robo> robosEmpatados = new ArrayList<>();
                    for(Robo robo : robos){
                        int partidasTotaisRobo = robo.vitorias + robo.derrotas + robo.empates;
                        if(partidasTotaisRobo == 0) continue;
                        float proveitamentoRobo = robo.vitorias / partidasTotaisRobo;
                        if(proveitamentoRobo > maiorAproveitamento){
                            maiorAproveitamento = proveitamentoRobo; 
                            robosEmpatados.clear();
                            robosEmpatados.add(robo);
                        }else if(proveitamentoRobo == maiorAproveitamento){
                            robosEmpatados.add(robo);
                        }
                        if(robo.energia < 30){
                            System.out.print("\nRobo " + robo.nome + " esta em recuperação.");
                        }
                    }
                    for(Robo robo : robosEmpatados){
                        System.out.print("\nRobo " + robo.nome + " esta com o maior aproveitamento de " + (maiorAproveitamento * 100));
                    }
                    break;
                case 9:
                    Robo roboExcuir;
                    if(robos.size() == 0) {System.out.print("\nAinda não existem robos."); break;}
                    do{
                        System.out.print("\nDigite o codigo do robo:");
                        roboExcuir = encontrarRobo(intInput(scanner));
                    }while(roboExcuir == null);
                    robos.remove(roboExcuir);
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
