package controller;
import java.util.List;

import model.CPF;
import model.Pessoa;
import model.PessoaFisica;
import view.Agenda;
import view.IU;

public class AgendaPessoaFisica extends Agenda {

    PessoaDAO pDAO = new PessoaFisicaDAO();

    @Override
    public
    void adicionar() {
        Pessoa p = new PessoaFisica();

        p.setNome(IU.pegaNome());
        p.setEndereco(IU.pegaEndereco());

        do {
            p.setTelefone(IU.pegaTelefone());
        } while (IU.querAddOutroTelefone());
        
        CPF cpf = new CPF();
  
        p.setDocumento(IU.pegaNumeroCPF(cpf));
        pDAO.adicionar(p);
    }

    @Override
    public
    List<Pessoa> buscar(Character inicial) {
        return pDAO.buscar(inicial);
    }

}
