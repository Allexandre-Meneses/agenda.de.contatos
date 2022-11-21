package controller;

import view.Agenda;

public class AgendaPessoaJuridica extends Agenda {

    public AgendaPessoaJuridica() {
        super.pessoaDAO = new PessoaJuridicaDAO();
    }
    
}
