package dominio;

public class ContaPoupanca extends Conta{
    public ContaPoupanca() {
        super();
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo){
            System.out.println("Saldo insuficiente para saque do valor solicitado.");
            consultarSaldo();
        } else{
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            consultarSaldo();
        }
    }

    @Override
    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        if(valor > contaOrigem.saldo){
            System.out.println("Saldo insuficiente para transferência do valor solicitado");
            contaOrigem.consultarSaldo();
        } else{
            contaOrigem.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência de R$ " + valor + " para a conta " + contaDestino.getNumero() +
                    " realizada com sucesso");
            contaOrigem.consultarSaldo();
        }
    }
}
