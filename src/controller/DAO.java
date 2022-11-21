package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Pessoa;

public interface DAO {

    boolean adicionar(Pessoa p);

    List<Pessoa> buscar(Character inicial);

    Collection<ArrayList<Pessoa>> buscarTodosContatos();

    boolean remover(Pessoa pessoa);

    boolean alterar(Pessoa pessoa);
    
}
