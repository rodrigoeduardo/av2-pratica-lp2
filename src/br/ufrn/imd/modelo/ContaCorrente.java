package br.ufrn.imd.modelo;

public class ContaCorrente implements ITributavel {
    private String agencia;
    private String numero;
    private double saldo;

    public ContaCorrente() {}

    public ContaCorrente(String agencia, String numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
        System.out.printf("R$%.2f foi sacado da conta corrente de número %s.\n", valor, this.numero);
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("R$%.2f foi depositado na conta corrente de número %s.\n", valor, this.numero);
    }

    public boolean transferir(double valor, ContaCorrente cc) {
        double saldoFinal = this.saldo - valor;

        if (saldoFinal < 0) {
            System.out.printf("Não há saldo suficiente para realizar transferẽncia de R$%.2f.\n", valor);
            return false;
        }

        sacar(valor);
        cc.depositar(valor);

        System.out.printf("R$%.2f foi transferido da conta corrente de número %s para a conta corrente de número %s.\n", valor, this.numero, cc.getNumero());

        return true;
    }

    @Override
    public double calcularTributos() {
        return this.saldo * 0.0038;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
