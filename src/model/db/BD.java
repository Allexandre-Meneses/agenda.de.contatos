package model.db;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Pessoa;

public abstract class BD {
    HashMap<Character, List<Pessoa>> contatos = new HashMap<Character, List<Pessoa>>();

    public List<Pessoa> buscarPessoa(Character inicial) {
        if (contatos.get(inicial) == null) {
            return null;
        } else {
            return contatos.get( inicial );
        }
    }

    public boolean adicionarPessoa(Pessoa p) {
        if (contatos.get(p.nome.charAt(0)) == null){
            contatos.put(p.nome.charAt(0), new ArrayList<Pessoa>());
            List<Pessoa> listaDePessoas = contatos.get(p.nome.charAt(0));
            listaDePessoas.add(p);     
        } else {
            List<Pessoa> listaDePessoas = contatos.get(p.nome.charAt(0));
            listaDePessoas.add(p);          
        }
        return true;
    }

    boolean alterarPessoa(Pessoa p) {
        return true;
    }

    boolean removerPessoa(Pessoa p) {
        return true;
    }
}
