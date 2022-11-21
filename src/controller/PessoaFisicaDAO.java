package controller;

import model.db.PessoaFisicaBD;

public class PessoaFisicaDAO extends PessoaDAO {
    
    public PessoaFisicaDAO() {
        super.bd = new PessoaFisicaBD();
    }    
}
