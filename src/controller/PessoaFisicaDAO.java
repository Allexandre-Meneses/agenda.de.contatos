package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Pessoa;
import model.db.PessoaFisicaBD;

public class PessoaFisicaDAO extends PessoaDAO {
    
    public PessoaFisicaDAO() {
        super.bd = new PessoaFisicaBD();
    }

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

    @Override
    public boolean remover(Pessoa pessoa) {
        return bd.removerPessoa(pessoa);
    }

    @Override
    public boolean alterar(Pessoa pessoa) {
        return bd.alterarPessoa(pessoa);
    }

    
}
