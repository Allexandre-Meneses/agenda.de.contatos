package controller;

import model.PessoaJuridica;
import view.Agenda;

public class AgendaPessoaJuridica extends Agenda {

    public AgendaPessoaJuridica() {
        super.pessoaDAO = new PessoaJuridicaDAO();
    }

    public void alterarNomeFantasia(PessoaJuridica p) {
        super.pegaNome(p);
    }
    
}
