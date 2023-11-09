package br.ufrn.imd.modelo;

public class SeguroVida {
    private int numero;
    private String beneficiado;
    private double valor;
    private double taxa;

    public SeguroVida() {
        this.taxa = 31.5;
    }

    public SeguroVida(int numero, String beneficiado, double valor) {
        this.numero = numero;
        this.beneficiado = beneficiado;
        this.valor = valor;
        this.taxa = 31.5;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(String beneficiado) {
        this.beneficiado = beneficiado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
}
