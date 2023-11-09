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
        // TODO
    }

    public void imprimeImpostoTotal() {
        // TODO
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
