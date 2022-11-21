package model.db;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import model.Pessoa;

public abstract class BD {
    HashMap<Character, ArrayList<Pessoa>> contatos = new HashMap<Character, ArrayList<Pessoa>>();

    // Método para Adicionar Pessoas ao Mapa: contatos
    public boolean adicionarPessoa(Pessoa p, Character inicial) {
        if (contatos.get(inicial) == null){
            contatos.put(inicial, new ArrayList<Pessoa>());
            List<Pessoa> listaDePessoas = contatos.get(inicial);
            listaDePessoas.add(p);     
        } else {
            List<Pessoa> listaDePessoas = contatos.get(inicial);
            listaDePessoas.add(p);          
        }
        return true;
    }

    // Método para buscar Pessoa do Mapa: contatos
    public List<Pessoa> buscarPessoa(Character inicial) {
        return contatos.get(Character.toUpperCase(inicial));
    }

    // Método para recuperar todas as Pessoas do Mapa: contatos
    public Collection<ArrayList<Pessoa>> buscarTodosContatos() {
        return contatos.values();
    }
    
    // Método para alterar um contato da base de dados
    public boolean alterarPessoa(Pessoa p) {
        return true;
    }

    // Método para remover um contato da base de dados
    public boolean removerPessoa(Pessoa p, Character inicial) {
        List<Pessoa> listRemover = contatos.get(inicial);
        return listRemover.remove(p);
    }
}
