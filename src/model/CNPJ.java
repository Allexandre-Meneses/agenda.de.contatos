package model;

public class CNPJ extends Documento{

    @Override
    protected boolean validaNumero(String numero) {
        return numero.length() == 14;
    }    
}
