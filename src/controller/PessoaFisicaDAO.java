package controller;
import java.util.List;

import model.Pessoa;
import model.db.PessoaFisicaBD;

public class PessoaFisicaDAO extends PessoaDAO {
    PessoaFisicaBD bancoDeDados = new PessoaFisicaBD();

    @Override
    public void adicionar(Pessoa p) {
        bancoDeDados.adicionarPessoa(p);
    }

    @Override
    public List<Pessoa> buscar(Character inicial) {
        return bancoDeDados.buscarPessoa(inicial);
    }

    
}
