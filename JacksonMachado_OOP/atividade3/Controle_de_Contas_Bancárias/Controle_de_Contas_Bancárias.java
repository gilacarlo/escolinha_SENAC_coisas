package JacksonMachado_OOP.atividade3.Controle_de_Contas_Bancárias;

import java.util.ArrayList;
import java.util.Scanner;

public class Controle_de_Contas_Bancárias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Conta> list = new ArrayList<>();

        list.add(new Conta(9193321, "Renan", 0));
        list.add(new Conta(3283812, "Renan", 10));
        list.add(new Conta(1239841, "Renan", 980));
        list.add(new Conta(4321450, "Renan", 76000));
        list.add(new Conta(8421985, "Renan", 9320));

        double maiorSaldo = 0;
        for(Conta con : list){
            System.out.print("\nsaldo: " + con.saldo);
            if(con.saldo > maiorSaldo){
                maiorSaldo = con.saldo; 
            }
        }
        System.out.print("\n maior saldo: " + maiorSaldo);
        scanner.close();
    }
}
