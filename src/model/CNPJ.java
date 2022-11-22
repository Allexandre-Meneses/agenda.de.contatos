package model;

public class CNPJ extends Documento{

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
