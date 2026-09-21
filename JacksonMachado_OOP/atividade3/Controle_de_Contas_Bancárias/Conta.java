package JacksonMachado_OOP.atividade3.Controle_de_Contas_Bancárias;
    
public class Conta {
    int numero;
    String titular;
    double saldo;
    
    Conta(int numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    public void depositar(double valor){
        if(valor <= 0){
            return;
        }
        this.saldo += valor;
    }
    public void sacar(double valor){
        if(this.saldo < valor){
            return;
        }
        this.saldo -= valor;
    }
    public void consultarSaldo(){
        System.out.print("saldo: " + this.saldo);
    }
    public void exibirDados(){
        System.out.print("titular: " + this.titular);
        System.out.print("numero: " + this.numero);
        System.out.print("saldo: " + this.saldo);
    }
}
