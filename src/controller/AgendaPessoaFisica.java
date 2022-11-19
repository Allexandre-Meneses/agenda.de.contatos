package controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.CPF;
import model.Pessoa;
import model.PessoaFisica;
import view.Agenda;
import view.IU;

public class AgendaPessoaFisica extends Agenda {

    public AgendaPessoaFisica() {
        super.pessoaDAO = new PessoaFisicaDAO();
    }

    @Override
    public void adicionar() {
        Pessoa p = new PessoaFisica();

        p.setNome(IU.pegaNome());
        p.setEndereco(IU.pegaEndereco());

        do {
            p.setTelefone(IU.pegaTelefone());
        } while (IU.querAddOutroTelefone());
        
        CPF cpf = new CPF();
  
        p.setDocumento(IU.pegaNumeroCPF(cpf));
        pessoaDAO.adicionar(p);
    }

    @Override
    public
    List<Pessoa> buscar(Character inicial) {
        return pessoaDAO.buscar(inicial);
    }

    @Override
    public Collection<ArrayList<Pessoa>> buscarTodosContatos() {
        return pessoaDAO.buscarTodosContatos();
    }

}
