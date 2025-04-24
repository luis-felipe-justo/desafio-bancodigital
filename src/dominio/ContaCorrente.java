package dominio;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente() {
        super();
        this.limite = -500;
    }

    @Override
    public void sacar(double valor) {
        if ((saldo - valor) < limite) {
            System.out.println("Saldo insuficiente para saque do valor solicitado.");
            consultarSaldo();
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            consultarSaldo();
        }
    }

    @Override
    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        if ((contaOrigem.saldo - valor) < limite) {
            System.out.println("Saldo insuficiente para transferência do valor solicitado");
            contaOrigem.consultarSaldo();
        } else {
            contaOrigem.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência de R$ " + valor + " para a conta " + contaDestino.getNumero() +
                    " realizada com sucesso");
            contaOrigem.consultarSaldo();
        }
    }

    public double getLimite() {
        return limite;
    }

    public void aumentarLimite(double limite) {
        this.limite = limite;
        System.out.println("Seu novo limite é: R$ " + this.limite);
    }

    public void consultarLimiteAtual(){
        System.out.println("Limite atual da conta " + this.getNumero() + " : R$ " + this.getLimite());
    }
}
