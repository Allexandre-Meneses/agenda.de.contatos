import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BD {
    HashMap<Character, List<Pessoa>> contatos = new HashMap<Character, List<Pessoa>>();

    List<Pessoa> buscarPessoa(Pessoa p) {
        return null;
    }

    boolean adicionarPessoa(Pessoa p) {
        if (contatos.get(p.nome.charAt(0)) == null){
            contatos.put(p.nome.charAt(0), new ArrayList<Pessoa>());
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
