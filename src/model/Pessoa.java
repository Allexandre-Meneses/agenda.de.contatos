package model;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    public String nome;
    List<Telefone> telefones = new ArrayList<Telefone>();
}
