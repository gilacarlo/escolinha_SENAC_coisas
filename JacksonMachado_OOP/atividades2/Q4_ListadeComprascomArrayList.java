package JacksonMachado_OOP.atividades2;

import java.util.ArrayList;
import java.util.Scanner;

// Crie um programa que utilize uma ArrayList<String![alt text](https://example.com)> 
// para representar uma lista de compras. O programa deve 
// apresentar um menu com as opções: 
// adicionar produto, remover produto pelo nome, 
// listar produtos, consultar se um produto está na lista e encerrar.
// Utilize switch para controlar o menu, Scanner 
// para ler as informações e try/catch para tratar opções inválidas. 
// O programa deve continuar executando dentro de um laço do/while 
// até que o usuário escolha a opção de encerramento.

public class Q4_ListadeComprascomArrayList {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite um numero inteiro:");
        
    
        ArrayList<String> list = new ArrayList<>();

        boolean sair = false;
        while(sair == false){
            System.out.print("\nescolha uma das opcoes:");
            System.out.print("\n(1) adicionar produto.");
            System.out.print("\n(2) remover produto pelo nome.");
            System.out.print("\n(3) listar produtos.");
            System.out.print("\n(4) consultar se um produto está na lista.");
            System.out.print("\n(5) sair.");
            int numero = 0;
            try{
                numero = scanner.nextInt();
            }catch(Exception e){
                System.out.println("\nDigite algo válido!");
                scanner.next();
                continue;
            }
            String item = "";
            switch (numero) {
                case 1:
                    System.out.println("\nDigite o nome do produto: ");
                    item = scanner.next();
                    System.out.println("\nitem '" + item + "' adicionado!");
                    list.add(item);
                    break;
                case 2:
                    System.out.println("\nDigite o nome do produto: ");
                    item = scanner.next();
                    System.out.println("\nitem '" + item + "' removido!");
                    list.remove(item);
                    break;
                case 3:
                    System.out.println("\nListagem dos produtos: ");
                    for(int i = 0; i < list.size(); i++){
                        System.out.println((i + 1) + "- '" + list.get(i) + "' ");
                    }
                    break;
                case 4:
                    System.out.println("\nDigite o nome do produto: ");
                    item = scanner.next();
                    if(list.contains(item)){
                        System.out.println("\nO item " + item + " existe  :D");
                    }else{
                        System.out.println("\nNao existe o item " + item + "  :(");
                    }
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("\nDigite algo válido!");
                    break;
            }
        }

        scanner.close();
    }
}
