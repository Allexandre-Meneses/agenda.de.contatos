package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import controller.PessoaDAO;
import model.CNPJ;
import model.CPF;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

public abstract class Agenda {

    protected PessoaDAO pessoaDAO;

    // Método para adicionar um Contato a agenda
    public void adicionar(Pessoa p) {

        pegaNome(p);

        p.setEndereco(IU.pegaEndereco());

        do {
            p.setTelefone(IU.pegaTelefone());
        } while (IU.querAddOutroTelefone());
        
        pegaDocumento(p);
      

        pessoaDAO.adicionar(p);
    }

    // Método para buscar Contatos na agenda pela inicial do nome
    public List<Pessoa> buscar(Character inicial) {
        return pessoaDAO.buscar(inicial);
    }

    // Método que retorna todos os Contatos da Base de Dados
    public Collection<ArrayList<Pessoa>> buscarTodosContatos() {
        return pessoaDAO.buscarTodosContatos();
    }

    // Método para remover um contato da Base de Dados
    public boolean remover(Pessoa pessoa) {
        return pessoaDAO.remover(pessoa);
    }

    // Método para alterar um contato da Base de Dados
    public boolean alterar(Pessoa pessoa) {
        return pessoaDAO.alterar(pessoa);
    }

    // Método para Setar CPF ou CPNJ no Objeto pessoa
    private void pegaDocumento(Pessoa p) {

        if ( p instanceof PessoaFisica ) {
            CPF cpf = new CPF();
            p.setDocumento(IU.pegaNumeroCPF(cpf));
        }

        if ( p instanceof PessoaJuridica ) {
            CNPJ cnpj = new CNPJ();
            p.setDocumento(IU.pegaNumeroCNPJ(cnpj));
        }

    }    

    // Método para Setar Nome ou Nome Fantasia no Objeto Pessoa
    private void pegaNome(Pessoa p) {
        if ( p instanceof PessoaFisica ) {
            PessoaFisica pessoaFisica = (PessoaFisica) p;
            pessoaFisica.setNome(IU.pegaNome());
        } else {
            if ( p instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) p;
                pessoaJuridica.setNomeFantasia(IU.pegaRazaoSocial());
            }
        }
    }
}
