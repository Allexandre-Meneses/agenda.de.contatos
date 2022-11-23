package model;

public class CPF extends Documento {

    public String getNumero() {
        return numero;
    }

    @Override
    protected boolean validaNumero(String numero) {
        return numero.length() == 11;
    }
}
