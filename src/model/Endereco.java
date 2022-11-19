package model;

public class Endereco {
    String estado;
    String cidade;
    String cep;
    String bairro;
    String rua;
    String numero;

    public Endereco() {
        this.estado = "";
        this.cidade = "";
        this.cep = "";
        this.bairro = "";
        this.rua = "";
        this.numero = "";
    }    

    public boolean enderecoIsEmpty() {
        if (this.estado.isEmpty() || this.cidade.isEmpty() || this.cep.isEmpty() || this.bairro.isEmpty() || this.rua.isEmpty() || this.numero.isEmpty()) {
            return true;
        }
        return false;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
