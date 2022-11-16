public class App {
    public static void main(String[] args) throws Exception {

        Agenda agenda = new AgendaPessoaFisica();

        agenda.adicionar(new PessoaFisica("Allexandre"));
        agenda.adicionar(new PessoaFisica("Aailane"));
    }

}
