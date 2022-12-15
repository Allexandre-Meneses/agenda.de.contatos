package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import controller.AgendaPessoaFisica;
import controller.AgendaPessoaJuridica;
import model.CNPJ;
import model.CPF;
import model.Endereco;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Telefone;


public class IU {

    static Scanner sc = new Scanner(System.in);

    // Instância das Agendas
    AgendaPessoaFisica agendaPF = new AgendaPessoaFisica();
    AgendaPessoaJuridica agendaPJ = new AgendaPessoaJuridica();

    // Método para exibir e coletar a opção do menu
    public boolean menu() {
        System.out.println("-------------------------------------");
        System.out.println("|1| Adicionar Contato");
        System.out.println("|2| Buscar Contato");
        System.out.println("|3| Mostrar todos os Contatos");
        System.out.println("|4| Remover Contato");
        System.out.println("|5| Alterar Contato");
        System.out.println("|0| Sair");

        String opcao = sc.next();

        switch(opcao) {
            case "1": 
                menuAdicionar();
                return true;
            case "2":
                buscarPessoa();
                return true;
            case "3":
                mostrarTodosContatos();
                return true;
            case "4":
                removerPessoa();
                return true;
            case "5":
                alterarPessoa();
                return true;
            case "0":
            return false;
            default:
                System.out.println("Opção inválida");
                return this.menu();
        }
    }

    // Método para escolher qual tipo de Pessoa Adicionar, PF/PJ
    private boolean menuAdicionar() {
        System.out.println("|1| Pessoa Física");
        System.out.println("|2| Pessoa Juridica");

        String opcao = sc.next();

        switch(opcao) {
            case "1":
                return agendaPF.adicionar(new PessoaFisica());
            case "2":
                return agendaPJ.adicionar(new PessoaJuridica());
            default:
                System.out.println("Opção inválida");
                return this.menuAdicionar();
        }
    }

    // Método para obter do usuario qual dado do Contato ele quer alterar
    private Pessoa menuAlterar(Pessoa p) {
        System.out.println("Qual atributo do COntato deseja Alterar?");
        System.out.println("|1| Nome");
        System.out.println("|2| endereço");
        System.out.println("|3| Adicionar Telefone");
        System.out.println("|4| Remover Telefone");
        System.out.println("|5| Alterar Telefone");
        System.out.println("|6| Documento");
        System.out.println("|0| Sair");

        String opcao = sc.next();

        switch(opcao) {
            case "1": 
                if ( p instanceof PessoaFisica) {
                    agendaPF.alterarNome((PessoaFisica) p);
                } else if ( p instanceof PessoaJuridica ) {
                        agendaPJ.alterarNomeFantasia((PessoaJuridica) p);
                }
                return this.menuAlterar(p);

            case "2": 
                if ( p instanceof PessoaFisica ) {
                    agendaPF.alterarEndereco(p);
                } else if ( p instanceof PessoaJuridica ) {
                    agendaPJ.alterarEndereco(p);
                }
                return this.menuAlterar(p);

            case "3":
                if ( p instanceof PessoaFisica ) {
                    agendaPF.adicionarTelefone(p);
                } else if ( p instanceof PessoaJuridica ) {
                    agendaPJ.adicionarTelefone(p);
                }
                return this.menuAlterar(p);

            case "4": 
                removerTelefone(p);
                return this.menuAlterar(p);

            case "5":
                alterarTelefone(p);
                return this.menuAlterar(p);
            case "6":
                if ( p instanceof PessoaFisica ) {
                    agendaPF.alterarDocumento(p);
                } else if ( p instanceof PessoaJuridica) {
                    agendaPJ.alterarDocumento(p);
                }
                return this.menuAlterar(p);

            case "0":
                return p;
            
            default:
                System.out.println("Opção Inválida");
                return this.menuAlterar(p);
        }
    }

    // Método para buscar Contatos a partir da primeira letra
    private List<Pessoa> buscarPessoa() {
        System.out.println("Digite a Primeira letra do Nome da Pessoa:");
        Character inicial = sc.next().charAt(0);
        List<Pessoa> buscaPF = agendaPF.buscar(inicial);
        List<Pessoa> buscaPJ = agendaPJ.buscar(inicial);
        List<Pessoa> busca = new ArrayList<Pessoa>();

        if ( buscaPF != null ) {
            for ( Pessoa tmp : buscaPF ) {
                busca.add(tmp);
            }
        }

        if ( buscaPJ != null ) {
            for ( Pessoa tmp : buscaPJ ) {
                busca.add(tmp);
            }
        }
        
        if (!busca.isEmpty()) {
            for (Pessoa tmp : busca) {
                System.out.println("-------------------------------------------------");
                System.out.println(busca.indexOf(tmp)+1);
                mostrarNome(tmp);
                mostrarEndereco(tmp);
                mostraDocumento(tmp);
                mostraTelefones(tmp);
            }
            return busca;
        } else {
            System.out.println("Não existe contatos cadastrados com essa Inical!");
        }
        return new ArrayList<Pessoa>();

    }
    
    // Método para mostrar todos os contatos 
    private void mostrarTodosContatos() {
        Collection<ArrayList<Pessoa>> todosContatosPF = agendaPF.buscarTodosContatos();
        Collection<ArrayList<Pessoa>> todosContatosPJ = agendaPJ.buscarTodosContatos();
        Collection<ArrayList<Pessoa>> todosContatos = new ArrayList<ArrayList<Pessoa>>();

        if ( todosContatosPF != null ) {
            for (ArrayList<Pessoa> tmpList : todosContatosPF) {
                todosContatos.add(tmpList);
            }
        }

        if ( todosContatosPJ != null ) {
            for (ArrayList<Pessoa> tmpList : todosContatosPJ) {
                todosContatos.add(tmpList);
            }
        }

        if (!todosContatos.isEmpty()) {
            for (ArrayList<Pessoa> tmpList : todosContatos) {
                for (Pessoa p : tmpList) {
                    System.out.println("-------------------------------------------------");
                    mostrarNome(p);
                    mostrarEndereco(p);
                    mostraDocumento(p);
                    mostraTelefones(p);
                }
            }
        } else {
            System.out.println("Nenhum Contato Cadastrado!");
        }

    }

    // Método para Remover Contatos da Agenda
    private void removerPessoa() {
        System.out.println("Selecione o Contato que Deseja Remover!");
        List<Pessoa> escolher = buscarPessoa();
        System.out.println("Qual o Índice do Contato que você deseja remover?");
        Pessoa remover = escolher.get(sc.nextInt()-1);
        if (remover instanceof PessoaFisica) {
            agendaPF.remover(remover);
        } else if ( remover instanceof PessoaJuridica ) {
            agendaPJ.remover(remover);
        }
    }

    // Método para Alterar um Contato da Agenda
    private void alterarPessoa() {
        System.out.println("Selecione o Contato que Deseja Alterar!");
        List<Pessoa> escolher = buscarPessoa();
        System.out.println("Qual o Índice do Contato que você deseja Alterar?");
        Pessoa alterar = escolher.get(sc.nextInt()-1);
        alterar = menuAlterar(alterar);
    }

    // Método para mostrar o nome da Pessoa
    private void mostrarNome(Pessoa tmp) {
        if ( tmp instanceof PessoaFisica ) {
            PessoaFisica pessoaFisica = (PessoaFisica) tmp;
            System.out.println("Nome:" + pessoaFisica.getNome());
        } else {
            if ( tmp instanceof PessoaJuridica ) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) tmp;
                System.out.println("Nome:" + pessoaJuridica.getNomeFantasia());
            }
        }

    }
    
    // Método para mostrar o Endereço da Pessoa
    private void mostrarEndereco(Pessoa tmp) {
        if(!tmp.getEndereco().enderecoIsEmpty()) {
            System.out.println("Estado: " + tmp.getEndereco().getEstado());
            System.out.println("Cidade: " + tmp.getEndereco().getCidade());
            System.out.println("Cep: " + tmp.getEndereco().getCep());
            System.out.println("Bairro: " + tmp.getEndereco().getBairro());
            System.out.println("Rua: " + tmp.getEndereco().getRua());
            System.out.println("Numero da Casa: " + tmp.getEndereco().getNumero());
        }   
    }

    // Método para mostrar o Documento da Pessoa
    private void mostraDocumento(Pessoa tmp) {
        if (tmp instanceof PessoaFisica) {
            System.out.println("CPF: " + tmp.getDocumento().getNumero());
        } else {
            System.out.println("CNPJ: " + tmp.getDocumento().getNumero());
        }
    }

    // Método para mostrar o(s) Telefone(s) da Pessoa
    private void mostraTelefones(Pessoa tmp) {
        System.out.println("Telefone(s)");
        for (Telefone tel : tmp.getTelefones()) {
            System.out.println("(" + tel.getDdd() + ") " + tel.getNumero());
        }
        System.out.println("--------------------------------------------------");
    }

    // Método para Pegar o nome da Pessoa
    public static String pegaNome() {
        System.out.println("Digite o nome da Pessoa:");
        sc.nextLine();
        return sc.nextLine();
    }

    // Método para pegar Razão social da PJ
    public static String pegaNomeFantasia() {
        System.out.println("Digite a Razão Social ou Nome Fantasia:");
        sc.nextLine();
        return sc.nextLine();
    }

    // Método para pegar o Endereço da Pessoa
    public static Endereco pegaEndereco() {
        System.out.println("Deseja adicionar o endereço da Pessoa?(S/N)");
        Endereco e = new Endereco();
        if (sc.next().equalsIgnoreCase("S")) {
            System.out.println("Estado:");
            sc.nextLine();
            e.setEstado(sc.next());
            System.out.println("Cidade:");
            sc.nextLine();
            e.setCidade(sc.next());
            System.out.println("Cep:");
            sc.nextLine();
            e.setCep(sc.next());
            System.out.println("Bairro:");
            sc.nextLine();
            e.setBairro(sc.next());
            System.out.println("Rua:");
            sc.nextLine();
            e.setRua(sc.next());
            System.out.println("Número da Casa/Apartamento: ");
            sc.nextLine();
            e.setNumero(sc.next());
            sc.nextLine();
            return e;
        } else {
            return e;
        }
    }

    // Método para pegar o(s) Telefone(s) da Pessoa
    public static Telefone pegaTelefone() {
        Telefone telefone = new Telefone();
        System.out.println("Digite o DDD");
        telefone.setDdd(sc.next());
        System.out.println("Digite o Número");
        telefone.setNumero(sc.next());
        return telefone;
    }

    // Método para verificar se o Usuário quer add outro telefone a Pessoa
    public static boolean querAddOutroTelefone() {
        System.out.println("Deseja adicionar outro telefone?(S/N)");
        if (sc.next().equalsIgnoreCase("S")){
            return true;
        } else {
            return false;
        }
    }

    // Método para pegar o número do Cpf da Pessoa
    /**
     * O método recebe um CPF e faz o SetNumero no CPF, caso o número seja validado,
     * o método retorna o mesmo CPF, com o número já setado
     * 
     * @param cpf
     * @return cpf
     */
    public static CPF pegaNumeroCPF(CPF cpf) {
        System.out.println("Digite o número do CPF:");
        if( cpf.setNumero(sc.next()) ) {
            return cpf;
        }
        System.err.println("CPF inválido!");
        return pegaNumeroCPF(cpf);
    }

    // Método para pegar o número do Cpf da Pessoa
    /**
     * O método recebe um CNPJ e faz o SetNumero no CNPJ, caso o número seja validado,
     * o método retorna o mesmo CNPJ, com o número já setado
     * 
     * @param cnpj
     * @return cnpj
     */
    public static CNPJ pegaNumeroCNPJ(CNPJ cnpj) {
        System.out.println("Digite o número do CNPJ:");
        if( cnpj.setNumero(sc.next()) ) {
            return cnpj;
        }
        System.err.println("CNPJ inválido!");
        return pegaNumeroCNPJ(cnpj);
    }
    
    // Método para remover o número de Telefone de um contato
    private void removerTelefone(Pessoa p) {
        List<Telefone> telefones = p.getTelefones();
        for ( Telefone tmp : telefones ) {
            System.out.println("--------------------------------------------");
            System.out.println(telefones.indexOf(tmp) + 1);
            System.out.println("( " + tmp.getDdd() + " ) " + tmp.getNumero());
        }
        System.out.println("Qual o índice do Telefone que você deseja remover?");
        if ( p instanceof PessoaFisica ) {
            agendaPF.removerTelefone(p, sc.nextInt() - 1);
        } else if ( p instanceof PessoaJuridica ) {
            agendaPJ.removerTelefone(p, sc.nextInt() - 1);
        }
    }

    // Método para alterar o número de Telefone de um contato
    private void alterarTelefone(Pessoa p) {
        List<Telefone> telefones = p.getTelefones();
        for ( Telefone tmp : telefones ) {
            System.out.println("--------------------------------------------");
            System.out.println(telefones.indexOf(tmp) + 1);
            System.out.println("( " + tmp.getDdd() + " ) " + tmp.getNumero());
        }
        System.out.println("Qual o índice do Telefone que você deseja alterar?");
        Telefone alterar = telefones.get(sc.nextInt() - 1);
        
        if ( p instanceof PessoaFisica ) {
            agendaPF.alterarTelefone(alterar);
        } else if ( p instanceof PessoaJuridica ) {
            agendaPJ.alterarTelefone(alterar);
        }
    }

}
