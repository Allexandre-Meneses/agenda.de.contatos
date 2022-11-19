package model;

public abstract class Documento {
    String nome;
    String numero;

    public String getNumero() {
        return numero;
    }
    
    public boolean setNumero(String numero) {
        if( validaNumero(numero) && validaQtdPartes(numero) ) {
            this.numero = numero;
            return true;
        }
        return false;
    }

    protected abstract boolean validaNumero(String numero);

    protected abstract boolean validaQtdPartes(String numero);


}
