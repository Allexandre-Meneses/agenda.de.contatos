package model;

public class CPF extends Documento {

    public String getNumero() {
        return numero;
    }

    @Override
    protected boolean validaNumero(String numero) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected boolean validaQtdPartes(String numero) {
        // TODO Auto-generated method stub
        return true;
    }



}
