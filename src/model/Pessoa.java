package model;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    String nome;
    Endereco endereco;
    List<Telefone> telefones = new ArrayList<Telefone>();
    Documento documento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }
}
