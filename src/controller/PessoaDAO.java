package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Pessoa;
import model.db.BD;

public abstract class PessoaDAO implements DAO { 

    BD bd;

    @Override
    public abstract void adicionar(Pessoa p);

    @Override
    public abstract List<Pessoa> buscar(Character inicial);

    @Override
    public abstract Collection<ArrayList<Pessoa>> buscarTodosContatos();
    

    @Override
    public abstract boolean remover(Pessoa pessoa);

    @Override
    public abstract boolean alterar(Pessoa pessoa);

}
