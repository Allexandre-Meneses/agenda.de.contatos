package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.AgendaPessoaFisica;
import model.CPF;
import model.Endereco;
import model.Pessoa;
import model.PessoaFisica;
import model.Telefone;


public class IU {

    static Scanner sc = new Scanner(System.in);

    // Instância de AgendaPessoaFisica()
    Agenda agendaPF = new AgendaPessoaFisica();

    // Método para exibir e coletar a opção do menu
    public boolean menu() {
        System.out.println("-------------------------------------");
        System.out.println("|1| Adicionar Contato");
        System.out.println("|2| Buscar Contato");
        System.out.println("|3| Mostrar todos os COntatos");
        System.out.println("|4| Remover Contato");
        System.out.println("|5| Alterar Contato");
        System.out.println("|0| Sair");

        int opcao = sc.nextInt();

        switch(opcao) {
            case 1: 
                menuAdicionar();
                return this.menu();
            case 2:
                buscarPessoa();
                return this.menu();
            case 3:
                mostrarTodosContatos();
                return this.menu();
            case 4:
                removerPessoa();
                return this.menu();
            case 5:
            case 0:
            return false;
        }
        return true;
    }


    // Método para escolher qual tipo de Pessoa Adicionar, PF/PJ
    private void menuAdicionar() {
        System.out.println("|1| Pessoa Física");
        System.out.println("|2| Pessoa Juridica");

        int opcao = sc.nextInt();

        switch(opcao) {
            case 1:
                agendaPF.adicionar();
            case 2:
                //agendaPJ.adicionar();
        }
    }

    // Método para buscar Contatos a partir da primeira letra
    private void buscarPessoa() {
        System.out.println("Digite a Primeira letra do Nome da Pessoa:");
        List<Pessoa> busca = agendaPF.buscar(sc.next().charAt(0));
        if (busca != null) {
            for (Pessoa tmp : busca) {
                System.out.println("-------------------------------------------------");
                mostrarNome(tmp);
                mostrarEndereco(tmp);
                mostraDocumento(tmp);
                mostraTelefones(tmp);
            }
        } else {
            System.out.println("Não existe contatos cadastrados com essa Inical!");
        }

    }
    
    // Método para mostrar todos os contatos 
    private void mostrarTodosContatos() {
        Collection<ArrayList<Pessoa>> todosContatos = agendaPF.buscarTodosContatos();
        for (ArrayList<Pessoa> tmpList : todosContatos) {
            for (Pessoa p : tmpList) {
                System.out.println("-------------------------------------------------");
                mostrarNome(p);
                mostrarEndereco(p);
                mostraDocumento(p);
                mostraTelefones(p);
            }
        }
    }

    // Método para Remover Contatos da Agenda
    private void removerPessoa() {
    }

    // Método para mostrar o nome da Pessoa
    private void mostrarNome(Pessoa tmp) {
        System.out.println("Nome:" + tmp.getNome());
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
        return sc.next();
    }

    // Método para pegar o Endereço da Pessoa
    public static Endereco pegaEndereco() {
        System.out.println("Deseja adicionar o endereço da Pessoa?(S/N)");
        Endereco e = new Endereco();
        if (sc.next().equalsIgnoreCase("S")) {
            System.out.println("Estado:");
            e.setEstado(sc.next());
            System.out.println("Cidade:");
            e.setCidade(sc.next());
            System.out.println("Cep:");
            e.setCep(sc.next());
            System.out.println("Bairro:");
            e.setBairro(sc.next());
            System.out.println("Rua:");
            e.setRua(sc.next());
            System.out.println("Número da Casa/Apartamento: ");
            e.setNumero(sc.next());
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
            System.out.println("Digite o número do CPF");
            if( cpf.setNumero(sc.next()) ) {
                return cpf;
            }
            System.err.println("CPF inválido!");
            return pegaNumeroCPF(cpf);
    }
    
}
