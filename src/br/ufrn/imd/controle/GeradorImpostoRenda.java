package br.ufrn.imd.controle;
import br.ufrn.imd.modelo.Pessoa;

public class GeradorImpostoRenda {
    private double totalTributo = 0.0;

    public double getTotalTributo() {
        return totalTributo;
    }
    public void setTotalTributo(double totalTributo) {
        this.totalTributo = totalTributo;
    }

    public double CalcularValorTotalTributo(Pessoa p)
    {
        //Calcula e guarda o valor dos tributos conforme a questão pede
        setTotalTributo(p.getConta().calcularTributos() + p.getSeguro().calcularTributos() + (p.getSalario()*0.11));
        
        return getTotalTributo();
    }

}
