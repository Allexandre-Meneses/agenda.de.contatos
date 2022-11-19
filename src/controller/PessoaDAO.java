package controller;
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
    public void remover() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void alterar() {
        // TODO Auto-generated method stub
        
    }
    
}
