package controller;
import java.util.List;

import model.Pessoa;
import view.Agenda;

public class AgendaPessoaFisica extends Agenda {

    PessoaDAO pDAO = new PessoaFisicaDAO();

    @Override
    public
    void adicionar(Pessoa p) {
        pDAO.adicionar(p);
    }

    @Override
    public
    List<Pessoa> buscar(Character inicial) {
        return pDAO.buscar(inicial);
    }

}
