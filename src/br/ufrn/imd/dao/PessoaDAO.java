package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.modelo.Pessoa;
import br.ufrn.imd.controle.GeradorImpostoRenda;

public class PessoaDAO {
    private List<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<Pessoa>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        this.pessoas.remove(pessoa);
    }

    public void listarPessoas() {
        System.out.println("PESSOAS CADASTRADAS:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
    }

    public double calcularTributosPessoas() {
        double total = 0.0;
        //Instanciando o gerador
        GeradorImpostoRenda gerador = new GeradorImpostoRenda();

        //Iterando e somando
        for (Pessoa pessoa : pessoas) {
            total += gerador.CalcularValorTotalTributo(pessoa);
        }
        return total;
    }

    public void imprimeImpostoTotal() {
        //Instanciando o gerador de imposto, maior tributado e beneficiado (arbitrariamente como o primeiro)
        GeradorImpostoRenda gerador = new GeradorImpostoRenda();
        Pessoa maiorTributado = pessoas.get(0);
        Pessoa maiorBeneficiado = pessoas.get(0);

        //Itera, sempre calculando o tributo total, se for maior, faz a troca do maiorTributado
        for (Pessoa pessoa : pessoas) {
            if(gerador.CalcularValorTotalTributo(pessoa) > gerador.CalcularValorTotalTributo(maiorTributado))
            {
                maiorTributado = pessoa;
            }
            if(pessoa.getSeguro().getValor() > maiorBeneficiado.getSeguro().getValor())
            {
                maiorBeneficiado = pessoa;
            }
        }
        //Saida
        System.out.println("Tributos Totais: " + calcularTributosPessoas());
        System.out.println("Maior Tributado: " + maiorTributado.getNome());
        System.out.println("Maior Beneficiado pelo seguro: " + maiorBeneficiado.getNome());
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
