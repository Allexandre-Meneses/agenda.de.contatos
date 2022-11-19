package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import controller.PessoaDAO;
import model.Pessoa;

public abstract class Agenda {

    protected PessoaDAO pessoaDAO;

    public abstract void adicionar();

    public abstract List<Pessoa> buscar(Character inicial);

    public abstract Collection<ArrayList<Pessoa>> buscarTodosContatos();
}
