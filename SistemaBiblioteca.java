import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {
    private ArrayList<Item> acervo; // Lista que guarda todos os itens
    private ArrayList<Usuario> usuarios; // Lista que guarda todos os usuários

    public SistemaBiblioteca() {
        acervo = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        acervo.add(item); // Adiciona o item ao acervo
        System.out.println(item.getTitulo() + " adicionado ao acervo.");
    }

    public void listarItens() {
        System.out.println("Acervo de Itens:");
        for (Item item : acervo) {
            System.out.println(item); // Lista todos os itens no acervo
        }
    }

    public void emprestarItem(Usuario usuario, String titulo) {
        for (Item item : acervo) {
            if (item.getTitulo().equals(titulo) && item.empresta(usuario)) {
                System.out.println("Item " + titulo + " emprestado a " + usuario.getNome() + ".");
                return;
            }
        }
        System.out.println("Item não disponível para empréstimo.");
    }

    public void devolverItem(Usuario usuario, String titulo) {
        for (Item item : acervo) {
            if (item.getTitulo().equals(titulo) && item.retorna(usuario)) {
                System.out.println("Item " + titulo + " devolvido por " + usuario.getNome() + ".");
                return;
            }
        }
        System.out.println("Item não encontrado ou não foi emprestado a " + usuario.getNome() + ".");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Modo Administrador");
            System.out.println("2. Modo Atendimento");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;
                case 1:
                    modoAdministrador(scanner);
                    break;
                case 2:
                    modoAtendimento(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void modoAdministrador(Scanner scanner) {
        while (true) {
            System.out.println("Modo Administrador:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Periódico");
            System.out.println("3. Listar Itens");
            System.out.println("0. Voltar");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 0:
                    return;
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    adicionarItem(new Livro(tituloLivro));
                    break;
                case 2:
                    System.out.print("Digite o título do periódico: ");
                    String tituloPeriodico = scanner.nextLine();
                    adicionarItem(new Periodico(tituloPeriodico));
                    break;
                case 3:
                    listarItens();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void modoAtendimento(Scanner scanner) {
        while (true) {
            System.out.println("Modo Atendimento:");
            System.out.println("1. Listar Itens");
            System.out.println("2. Emprestar Item");
            System.out.println("3. Devolver Item");
            System.out.println("0. Voltar");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 0:
                    return;
                case 1:
                    listarItens();
                    break;
                case 2:
                    System.out.print("Digite seu nome: ");
                    String nomeUsuario = scanner.nextLine();
                    Usuario usuarioEmprestimo = buscarUsuarioOuCriar(nomeUsuario); // Busca usuário
                    System.out.print("Digite o título do item: ");
                    String tituloEmprestimo = scanner.nextLine();
                    emprestarItem(usuarioEmprestimo, tituloEmprestimo);
                    break;
                case 3:
                    System.out.print("Digite seu nome: ");
                    String nomeUsuarioDevolucao = scanner.nextLine();
                    Usuario usuarioDevolucao = buscarUsuarioOuCriar(nomeUsuarioDevolucao); // Busca usuário
                    System.out.print("Digite o título do item: ");
                    String tituloDevolucao = scanner.nextLine();
                    devolverItem(usuarioDevolucao, tituloDevolucao);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private Usuario buscarUsuarioOuCriar(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        Usuario novoUsuario = new Usuario(nome);
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        sistema.menu(); // Inicia o sistema de menu
    }
}

