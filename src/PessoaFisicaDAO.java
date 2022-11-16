public class PessoaFisicaDAO extends PessoaDAO {
    PessoaFisicaBD bancoDeDados = new PessoaFisicaBD();

    @Override
    public void adicionar(Pessoa p) {
        bancoDeDados.adicionarPessoa(p);
        
    }

    
}
