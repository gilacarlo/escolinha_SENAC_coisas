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
    public void excluirRobo(int codRobo){

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
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cadastrarRobo("Jorge", 30, 10);
        cadastrarRobo("Roberto", 20,15);

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
                    System.out.print("\nDigite o codigo do robo:");
                    Robo roboConsultar = encontrarRobo(intInput(scanner));
                    if(roboConsultar != null){
                        roboAtributosMostrar(roboConsultar);
                    }
                    break;
                case 3:
                    for(Robo robo : robos){
                        roboAtributosMostrar(robo);
                    }
                    break;
                case 4:
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

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    Robo roboExcuir;
                    do{
                        System.out.print("\nDigite o codigo do robo:");
                        roboExcuir = encontrarRobo(intInput(scanner));
                    }while(roboExcuir == null);
                    excluirRobo(roboExcuir.codigo);
                    break;
                default:
                    break;
            }
            String clicarParaSkipar = scanner.next();
        }

        scanner.close();
    }
}
