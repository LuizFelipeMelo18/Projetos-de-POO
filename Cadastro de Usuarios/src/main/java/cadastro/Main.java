package cadastro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import users.*;

public class Main {
    private static Scanner leitura =  new Scanner(System.in);
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void main(String[] args) {
        try(Connection connection = dataBaseConnection.getConnection()){
            if (connection != null){
                System.out.println("Conexão estabelecida!");
            }else {
                System.out.println("Falha ao estabelecer a conexão!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        menu();
    }

    private static void menu(){
        System.out.println("----- CADASTRO DE USUARIOS -----");
        System.out.println("---- 1 - Cadastrar Usuarios ----");
        System.out.println("---- 2 - Listar Usuarios    ----");
        System.out.println("---- 3 - Atualizar Usuarios ----");
        System.out.println("---- 4 - Apagar Usuarios    ----");
        System.out.println("---- 0 - Sair               ----");
        int opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao) {
            case 1:
                cadastrarUsuarios();
                break;

            case 2:
                listarUsuarios();
                break;

            case 3:
                atualizarUsuarios();
                break;

            case 4:
                apagarUsuarios();
                break;

            case 0:
                System.out.println("Obrigado por usar o nosso sistema!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }
    }

    private static void cadastrarUsuarios(){
        System.out.println("BEM VINDO A ARREA DE CADASTRAR USUARIOS");
        System.out.print("Digite o nome: ");
        String name = leitura.nextLine();

        System.out.print("Digite o email: ");
        String email = leitura.nextLine();

        System.out.print("Digite sua senha: ");
        String password = leitura.nextLine();

        Usuarios usuarios = new Usuarios(name, email, password);
        usuarioDAO.cadastrarUsuario(usuarios);

        menu();
    }

    private static void listarUsuarios(){
        List<Usuarios> usuarios = usuarioDAO.listarUsuarios();

        if (usuarios.size() > 0){
            for (Usuarios user : usuarios){
                System.out.println("Id: " + user.getId());
                System.out.println("Nome: " + user.getNome());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Senha: " + user.getPassword());
            }

            menu();
        } else {
            System.out.println("Não há usuarios cadastrados!");
            menu();
        }
    }

    private static void atualizarUsuarios(){
        System.out.print("Digite o ID do usuario que quer atualizar: ");
        int id = leitura.nextInt();
        leitura.nextLine();

        System.out.print("Deseja alterar o nome (S/N): ");
        String nomeOp = leitura.nextLine();
        String novoNome = "";

        if (nomeOp.equalsIgnoreCase("S")){
            System.out.println("Digite o novo nome: ");
            novoNome = leitura.nextLine();
        }


        System.out.print("Deseja alterar o email (S/N):");
        String emailOp = leitura.nextLine();
        String novoEmail = "";

        if (emailOp.equalsIgnoreCase("S")){
            System.out.print("Digite o novo email: ");
            novoEmail = leitura.nextLine();
        }

        System.out.print("Deseja alterar a senha (S/N): ");
        String passOp = leitura.nextLine();
        String novaSenha = "";

        if (passOp.equalsIgnoreCase("S")){
            System.out.print("Digite a nova senha: ");
            novaSenha = leitura.nextLine();
        }

        usuarioDAO.atualizarCadastro(id, novoNome,novoEmail, novaSenha);
        menu();

    }

    private static void apagarUsuarios(){
        System.out.print("Digite o ID do usuario que deseja apagar: ");
        int id = leitura.nextInt();
        leitura.nextLine();

        usuarioDAO.apagarUsuario(id);
        menu();
    }
}

