import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner leitura = new Scanner(System.in);
    private static ArrayList<Contato> contatos = new ArrayList<>();
    public static void main(String[] args) {
        menuInicial();
    }

    private static void menuInicial(){
        System.out.println("-------------------------------------------");
        System.out.println("-- Bem vindo ao Gerenciador de contatos ---");
        System.out.println("-------------------------------------------");
        System.out.println("|  Opção 1 - Adicionar  |");
        System.out.println("|  Opçãp 2 - Editar     |");
        System.out.println("|  Opção 3 - Remover    |");
        System.out.println("|  Opção 4 - Buscar     |");
        System.out.println("|  Opção 5 - Sair       |");
        System.out.println("------- Selecione a opção desejada --------");
        System.out.println("-------------------------------------------");
        int opcao = leitura.nextInt();

        switch (opcao){
            case 1:
                adicionarContato();
                break;

            case 2:
                editarContato();
                break;

            case 3:
                removerContato();
                break;


            case 4:
                buscarContato();
                break;

            case 5:
                System.out.println("Obrigado por usar o nosso gerenciador <3");
                System.exit(0);
        }
    }

    private static void adicionarContato(){
        System.out.print("Digite o nome do contato: ");
        String nomeContato = leitura.next();

        System.out.print("Digite o telefone do contato: ");
        long telefoneContato = leitura.nextLong();

        System.out.print("Digite o email do contato: ");
        String emailContato = leitura.next();

        Contato contato = new Contato(nomeContato, telefoneContato, emailContato);
        contatos.add(contato);
        System.out.println("Contato criado!");

        menuInicial();
    }

    private static void editarContato(){
        System.out.print("Digite o Id do contato que quer editar: ");
        int opcaoId = leitura.nextInt();
        leitura.nextLine();  // Consumir a nova linha deixada pelo nextInt()

        Contato encontrarId = encontrarContatoPorId(opcaoId);

        if (encontrarId != null) {
            System.out.println("Contato encontrado!");

            System.out.print("Digite o novo nome para o contato ou pressione enter para manter o mesmo: ");
            String novoNome = leitura.nextLine();
            if (!novoNome.isEmpty()) {
                encontrarId.setNome(novoNome);
                System.out.println("Nome atualizado!");
            }

            System.out.print("Digite o novo telefone para o contato ou pressione enter para manter o mesmo: ");
            String novoTelefoneInput = leitura.nextLine();
            if (!novoTelefoneInput.isEmpty()) {
                long novoTelefone = Long.parseLong(novoTelefoneInput);
                encontrarId.setTelefone(novoTelefone);
                System.out.println("Telefone atualizado!");
            }

            System.out.print("Digite o novo email para o contato ou pressione enter para manter o mesmo: ");
            String novoEmail = leitura.nextLine();
            if (!novoEmail.isEmpty()) {
                encontrarId.setEmail(novoEmail);
                System.out.println("Email atualizado!");
            }

            System.out.println("Contato atualizado!");
        } else {
            System.out.println("Contato não encontrado!");
        }

        menuInicial();
    }

    private static Contato encontrarContatoPorId(int Id){
        for (Contato c : contatos){
            if (c.getId() == Id){
                return c;
            }
        }
        return null;
    }

    private static void removerContato(){
        System.out.print("Digite o Id do contato que quer editar: ");
        int opcaoId = leitura.nextInt();

        Contato encontrarId = encontrarContatoPorId(opcaoId);

        System.out.println("Contato encontrado!");
        System.out.println("Deseja apagar o contato?" + "\n1 - Apagar" + "\n0 - Manter");
        int escolha = leitura.nextInt();

        if (escolha == 1){
            contatos.remove(encontrarId);
        } else if(escolha == 2){
            System.out.println("Contato mantido!");
            menuInicial();
        } else {
            System.out.println("Opção invalida!");
            menuInicial();
        }

        menuInicial();
    }

    private static void buscarContato(){
        if (contatos.size() > 0){
            System.out.println("---- Lista de contatos ----");

            for (Contato c : contatos){
                System.out.println(c + "\n");
            }
        } else {
            System.out.println("Sem contatos cadastrados!");
        }

        menuInicial();
    }
}