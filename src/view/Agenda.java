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
import model.Telefone;

public abstract class Agenda {

    protected PessoaDAO pessoaDAO;

    // Método para adicionar um Contato a agenda
    public boolean adicionar(Pessoa p) {

        pegaNome(p);

        p.setEndereco(IU.pegaEndereco());

        do {
            p.setTelefone(IU.pegaTelefone());
        } while (IU.querAddOutroTelefone());
        
        pegaDocumento(p);
      

        return pessoaDAO.adicionar(p);
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

    // Métodos para para alterar um contato da Base de Dados
    public void alterarEndereco(Pessoa p) {
        p.setEndereco(IU.pegaEndereco());
    }

    public void adicionarTelefone(Pessoa p) {
        p.setTelefone(IU.pegaTelefone());
    }

    public void removerTelefone(Pessoa p, int index) {
        p.getTelefones().remove(index);
    }

    public void alterarTelefone(Telefone t) {
        t = IU.pegaTelefone();
    }

    public void alterarDocumento(Pessoa p) {
        if ( p instanceof PessoaFisica ) {
            p.setDocumento(IU.pegaNumeroCPF((CPF) p.getDocumento()));
        } else if ( p instanceof PessoaJuridica ) {
            p.setDocumento(IU.pegaNumeroCNPJ((CNPJ) p.getDocumento()));
        }
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
    protected void pegaNome(Pessoa p) {
        if ( p instanceof PessoaFisica ) {
            PessoaFisica pessoaFisica = (PessoaFisica) p;
            pessoaFisica.setNome(IU.pegaNome());
        } else {
            if ( p instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) p;
                pessoaJuridica.setNomeFantasia(IU.pegaNomeFantasia());
            }
        }
    }

}
