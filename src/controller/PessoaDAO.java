package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.db.BD;

public abstract class PessoaDAO implements DAO { 

    // Base de Dados
    BD bd;

    @Override
    public boolean adicionar(Pessoa p) {
        Character inicial;

        if ( p instanceof PessoaFisica ) {
            PessoaFisica pessoaFisica = (PessoaFisica) p;
            inicial = pessoaFisica.getNome().toUpperCase().charAt(0);
            return bd.adicionarPessoa(p, inicial);
        } else {
            if ( p instanceof PessoaJuridica ) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) p;
                inicial = pessoaJuridica.getNomeFantasia().toUpperCase().charAt(0);
                return bd.adicionarPessoa(p, inicial);
            }
        }
        return false;
    }

    @Override
    public List<Pessoa> buscar(Character inicial) {
        return bd.buscarPessoa(inicial);
    }

    @Override
    public Collection<ArrayList<Pessoa>> buscarTodosContatos() {
        return bd.buscarTodosContatos();
    }    

    @Override
    public boolean remover(Pessoa pessoa) {
        Character inicial;
        
        if ( pessoa instanceof PessoaFisica ) {
            PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
            inicial = pessoaFisica.getNome().toUpperCase().charAt(0);
            return bd.removerPessoa(pessoa, inicial);
        } else {
            if ( pessoa instanceof PessoaJuridica ) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
                inicial = pessoaJuridica.getNomeFantasia().toUpperCase().charAt(0);
                return bd.removerPessoa(pessoa, inicial);
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Pessoa pessoa) {
        return bd.alterarPessoa(pessoa);
    }

}
