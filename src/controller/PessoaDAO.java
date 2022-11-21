package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Pessoa;
import model.db.BD;

public abstract class PessoaDAO implements DAO { 

    // Base de Dados
    BD bd;

    @Override
    public void adicionar(Pessoa p) {
        bd.adicionarPessoa(p);
    }

    @Override
    public List<Pessoa> buscar(Character inicial) {
        return bd.buscarPessoa(inicial);
    }

    @Override
    public Collection<ArrayList<Pessoa>> buscarTodosContatos() {
        return bd.buscarTodosContatos();
    }    

    public boolean remover(Pessoa pessoa) {
        return bd.removerPessoa(pessoa);
    }

    @Override
    public boolean alterar(Pessoa pessoa) {
        return bd.alterarPessoa(pessoa);
    }

}
