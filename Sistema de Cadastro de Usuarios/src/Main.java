import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    String nome;
    String email;
    int idade;

    public Usuario(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Idade: " + idade;
    }
}

class UsuarioService {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }
    }

    public void buscarUsuario(String nome) {
        for (Usuario u : usuarios) {
            if (u.nome.equalsIgnoreCase(nome)) {
                System.out.println("Usuário encontrado: " + u);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void removerUsuario(String email) {
        for (Usuario u : usuarios) {
            if (u.email.equalsIgnoreCase(email)) {
                usuarios.remove(u);
                System.out.println("Usuário removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioService service = new UsuarioService();
        int opcao;

        System.out.println("Hello and welcome!"); // mensagem de boas-vindas

        do {
            System.out.println("\n1 - Adicionar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário");
            System.out.println("4 - Remover usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    service.adicionarUsuario(new Usuario(nome, email, idade));
                }
                case 2 -> service.listarUsuarios();
                case 3 -> {
                    System.out.print("Nome para buscar: ");
                    String nome = scanner.nextLine();
                    service.buscarUsuario(nome);
                }
                case 4 -> {
                    System.out.print("Email para remover: ");
                    String email = scanner.nextLine();
                    service.removerUsuario(email);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
