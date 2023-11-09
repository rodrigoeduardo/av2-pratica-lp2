package br.ufrn.imd.modelo;

public class Pessoa implements ITributavel {
    private String nome;
    private double salario;
    private ContaCorrente conta;
    private SeguroVida seguro;

    public Pessoa() {}

    public Pessoa(String nome, double salario, ContaCorrente conta, SeguroVida seguro) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
        this.seguro = seguro;
    }

    @Override
    public double calcularTributos() {
        double tributosCC = conta.getSaldo() * 0.0038;
        double tributosSeguro = seguro.getTaxa();

        return tributosCC + tributosSeguro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public SeguroVida getSeguro() {
        return seguro;
    }

    public void setSeguro(SeguroVida seguro) {
        this.seguro = seguro;
    }
}
