package model;

public class PessoaJuridica extends Pessoa {
    String nomeFantasia;
    PessoaFisica pessoa;

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
