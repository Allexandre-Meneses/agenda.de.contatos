package controller;

import model.PessoaJuridica;
import view.Agenda;
import view.IU;

public class AgendaPessoaJuridica extends Agenda {

    public AgendaPessoaJuridica() {
        super.pessoaDAO = new PessoaJuridicaDAO();
    }

    public void alterarNomeFantasia(PessoaJuridica p) {
        p.setNomeFantasia(IU.pegaNomeFantasia());
    }
    
}
