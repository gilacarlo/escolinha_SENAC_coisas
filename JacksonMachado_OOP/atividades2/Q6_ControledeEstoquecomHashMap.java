package JacksonMachado_OOP.atividades2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Desenvolva um sistema simples de estoque utilizando um HashMap<String, Integer>, 
// no qual a chave representa o nome do produto e o valor representa a 
// quantidade disponível. O menu deve oferecer as opções de 
// cadastrar produto, 
// consultar estoque, 
// atualizar quantidade, 
// remover produto e 
// listar todos os produtos.
// Utilize switch para as opções do menu e um laço while ou do/while para manter 
// o sistema em execução. Ao consultar ou atualizar um produto, verifique sua 
// existência com if/else. Trate entradas numéricas inválidas com try/catch e 
// faça as conversões necessárias.

public class Q6_ControledeEstoquecomHashMap {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> estoque = new HashMap<>();
        estoque.put("banana", 12304);
        estoque.put("maça", 490);

        boolean sair = false;
        while(sair == false){
            System.out.print("\nescolha uma das opcoes:");
            System.out.print("\n(1) cadastrar produto.");
            System.out.print("\n(2) atualizar quantidade de um produto.");
            System.out.print("\n(3) remover produto.");
            System.out.print("\n(4) listar todos os produtos.");
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
                    if(estoque.containsKey(item) == false){
                        System.out.println("\nitem '" + item + "' adicionado!");
                        estoque.put(item, 0);
                    }else{
                        System.out.println("\nProduto '" + item + "' ja existe.");
                    }
                    break;
                case 2:
                    System.out.println("\nDigite o nome do produto: ");
                    item = scanner.next();
                    int quant = 0;
                    
                    if(estoque.containsKey(item) == true){
                        try{
                            quant = scanner.nextInt();
                        }catch(Exception e){
                            System.out.println("\nDigite algo válido!");
                            scanner.next();
                            continue;
                        }
                        System.out.println("\nProduto '" + item + "' quantidade mudado para: " + quant);
                        estoque.put(item, quant);
                    }else{
                        System.out.println("\nProduto '" + item + "' nao existe.  :(");
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o nome do produto: ");
                    item = scanner.next();
                    if(estoque.containsKey(item) == true){
                        System.out.println("\nitem '" + item + "' removido!");
                        estoque.remove(item);
                    }else{
                        System.out.println("\nProduto '" + item + "' nao existe.");
                    }
                    break;
                case 4:
                    System.out.println("\nListagem dos produtos: ");
                    for (Map.Entry<String, Integer> entry : estoque.entrySet()) { //
                        System.out.println(entry.getKey() + ": " + entry.getValue());
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
