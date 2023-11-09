package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.modelo.Pessoa;

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
        double tributosPessoas = 0;

        for (Pessoa pessoa : pessoas) {
            tributosPessoas += pessoa.calcularTributos();
        }

        return tributosPessoas;
    }

    public void imprimeImpostoTotal() {
        double valorTotal = 0;
        Pessoa pessoaComMaiorImposto = pessoas.get(0);
        Pessoa pessoaComMaiorSeguro = pessoas.get(0);

        for (Pessoa pessoa : pessoas) {
            double tributosPessoaAtual = pessoa.calcularTributos();

            valorTotal += tributosPessoaAtual;
            if (tributosPessoaAtual > pessoaComMaiorImposto.calcularTributos()) pessoaComMaiorImposto = pessoa;
            if (pessoa.getSeguro().getValor() > pessoaComMaiorSeguro.getSeguro().getValor()) pessoaComMaiorSeguro = pessoa;
        }

        System.out.println("VALOR TOTAL DE IMPOSTO A SER RECOLHIDO: " + valorTotal);
        System.out.println("PESSOA QUE PAGARÁ O MAIOR IMPOSTO: " + pessoaComMaiorImposto.getNome());
        System.out.println("PESSOA COM MAIOR VALOR DE SEGURO: " + pessoaComMaiorSeguro.getNome());
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
