package controller;
import java.util.List;

import model.Pessoa;

public interface DAO {

    void adicionar(Pessoa p);

    List<Pessoa> buscar(Character inicial);

    void remover();

    void alterar();
    
}
