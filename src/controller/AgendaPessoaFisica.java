package controller;

import model.PessoaFisica;
import view.Agenda;
import view.IU;

public class AgendaPessoaFisica extends Agenda {

    public AgendaPessoaFisica() {
        super.pessoaDAO = new PessoaFisicaDAO();
    } 

    public void alterarNome(PessoaFisica p) {
        p.setNome(IU.pegaNome());
    }
}
