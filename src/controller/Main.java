package controller;

import dominio.Cliente;
import dominio.Conta;
import dominio.ContaCorrente;
import dominio.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();

        int opcao = -1;

        while(opcao != 7){
            System.out.println("BANCO DIO");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Abertura de Conta");
            System.out.println("2 - Depósitos");
            System.out.println("3 - Saques");
            System.out.println("4 - Transferências");
            System.out.println("5 - Consultar Saldo");
            System.out.println("6 - Consultar Extrato");
            System.out.println("7 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Informe seu nome completo:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Informe sua idade atual:");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                    clientes.add(cliente);
                    System.out.println("Informe o tipo de conta que deseja abrir:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int opcaoConta = scanner.nextInt();
                    scanner.nextLine();
                    if(opcaoConta == 1){
                        Conta novaConta = new ContaCorrente();
                        cliente.adicionarConta(novaConta);
                        System.out.println("Conta Corrente " + novaConta.getNumero() + " criada com sucesso!");
                    } else if(opcaoConta == 2){
                        Conta novaConta = new ContaPoupanca();
                        cliente.adicionarConta(novaConta);
                        System.out.println("Conta Poupança " + novaConta.getNumero() + " criada com sucesso!");
                    } else{
                        System.out.println("Opção inválida! Informe uma opção válida");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Informe o número da conta:");
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o valor do depósito:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    cliente = Cliente.buscarClientePorNumeroConta(clientes, numeroConta);
                    if (cliente == null) {
                        System.out.println("Cliente ou conta não encontrada!");
                    } else {
                        Conta conta = cliente.getConta(numeroConta);
                        if (conta != null) {
                            conta.depositar(valor);
                        } else {
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o número da conta:");
                    numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o valor do saque:");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    cliente = Cliente.buscarClientePorNumeroConta(clientes, numeroConta);
                    if (cliente == null) {
                        System.out.println("Cliente ou conta não encontrada!");
                    } else {
                        Conta conta = cliente.getConta(numeroConta);
                        if (conta != null) {
                            conta.sacar(valor);
                        } else {
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Informe o número da conta de origem");
                    int origem = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o número da conta de destino");
                    int destino = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o valor a ser transferido:");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    Cliente clienteOrigem = Cliente.buscarClientePorNumeroConta(clientes, origem);
                    Cliente clienteDestino = Cliente.buscarClientePorNumeroConta(clientes, destino);
                    Conta contaOrigem = clienteOrigem.getConta(origem);
                    Conta contaDestino = clienteDestino.getConta(destino);
                    if(contaOrigem == null || contaDestino == null){
                        System.out.println("Conta de origem ou conta de destino não encontrada!");
                    } else{
                        contaOrigem.transferir(contaOrigem, contaDestino, valor);
                    }
                    break;
                case 5:
                    System.out.println("Informe o número da conta:");
                    numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    cliente = Cliente.buscarClientePorNumeroConta(clientes, numeroConta);
                    cliente.getConta(numeroConta).consultarSaldo();
                    break;
                case 6:
                    System.out.println("Informe o número da conta:");
                    numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    cliente = Cliente.buscarClientePorNumeroConta(clientes, numeroConta);
                    cliente.imprimirExtrato(numeroConta);
                    break;
                case 7:
                    System.out.println("Obrigado por utilizar os serviços do Banco DIO!");
                    break;
                default:
                    System.out.println("Opção inválida! Informe uma opção válida.");
                    break;
            }
        }
    }
}
