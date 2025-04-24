package dominio;

import java.util.Random;

public class Conta {

    protected int numero;

    protected double saldo;

    public Conta() {
        Random random = new Random();
        this.numero = 10000 + random.nextInt(90000);
        this.saldo = 0;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        System.out.println("Saldo atual: R$ " + this.saldo);
    }

    public void sacar(double valor){}

    public void consultarSaldo(){
        System.out.println("Saldo disponível: R$ " + this.saldo);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor){}

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
