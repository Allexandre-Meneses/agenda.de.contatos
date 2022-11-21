package controller;

import model.db.PessoaJuridicaBD;

public class PessoaJuridicaDAO extends PessoaDAO {

    PessoaJuridicaDAO() {
        super.bd = new PessoaJuridicaBD();
    }
}
