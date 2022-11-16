import java.util.List;

import controller.AgendaPessoaFisica;
import model.Pessoa;
import model.PessoaFisica;

public class App {
    public static void main(String[] args) throws Exception {

        AgendaPessoaFisica agenda = new AgendaPessoaFisica();

        
        agenda.adicionar(new PessoaFisica("Allexandre"));
        agenda.adicionar(new PessoaFisica("Aailane"));

        List<Pessoa> busca = agenda.buscar('A');

        for (Pessoa tmp : busca) {
            System.out.println(tmp.nome);
        }
    }

}
