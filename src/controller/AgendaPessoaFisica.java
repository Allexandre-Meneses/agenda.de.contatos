package controller;

import view.Agenda;

public class AgendaPessoaFisica extends Agenda {

    public AgendaPessoaFisica() {
        super.pessoaDAO = new PessoaFisicaDAO();
    } 
}
