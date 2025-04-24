package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;

    private int idade;

    private List<Conta> contas;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public Conta getConta(int numeroConta){
        for (Conta conta : contas) {
            if(conta.getNumero() == numeroConta){
                return conta;
            }
        }
        return null;
    }

    public static Cliente buscarClientePorNumeroConta(List<Cliente> clientes, int numeroConta) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void imprimirExtrato(int numeroConta){
        Conta conta = getConta(numeroConta);
        if(conta != null){
            System.out.println("Cliente: " + this.nome);
            System.out.println("Número da Conta: " + conta.getNumero());
            conta.consultarSaldo();
        } else{
            System.out.println("Conta não encontrada!");
        }
    }
}
