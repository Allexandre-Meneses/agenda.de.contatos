
public class AgendaPessoaFisica extends Agenda {

    PessoaDAO pDAO = new PessoaFisicaDAO();

    @Override
    void adicionar(Pessoa p) {
        pDAO.adicionar(p);
    }

}
