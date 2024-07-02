import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner leitura = new Scanner(System.in);
    private static ArrayList<Cd> cds;
    private static ArrayList<Artista> artistas;
    private static ArrayList<Genero> generos;
    private static Map<Cd, Integer> carrinhoCompra;

    public static void main(String[] args) {
        cds = new ArrayList<>();
        artistas = new ArrayList<>();
        generos = new ArrayList<>();
        menu();
    }

    private static void menu(){
        System.out.println("-------------------------------------------");
        System.out.println("----------- Bem vindo a Loja de CDs ----------");
        System.out.println("-------------------------------------------");
        System.out.println("|  Opção 1 - Listar CDs           |");
        System.out.println("|  Opçãp 2 - Cadastrar CDs        |");
        System.out.println("|  Opção 3 - Cadastrar Generos    |");
        System.out.println("|  Opção 4 - Cadastrar Artistas   |");
        System.out.println("|  Opção 5 - Sair                 |");
        System.out.println("------- Selecione a opção desejada --------");
        System.out.println("-------------------------------------------");
        int opcao = leitura.nextInt();

        switch (opcao){
            case 1:
                listarCds();
                break;

            case 2:
                cadastrarCds();
                break;

            case 3:
                cadastrarGeneros();
                break;

            case 4:
                cadastrarArtistas();
                break;

            case 5:
                System.out.println("Obrigado por escolher nossa loja, volte ssempre!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção Invalida!");
                menu();
                break;
        }
    }

    private static void listarCds(){
        if (cds.size() > 0){
            for (Cd c : cds){
                System.out.println(c + "\n");
            }
        } else {
            System.out.println("Não há CDs cadastrados!");
        }

        menu();
    }

    private static void cadastrarCds(){
        System.out.println("Bem vindo a area de cadastrar os CDs!");
        System.out.print("Digite o nome do CD: ");
        String nomeCd = leitura.nextLine();

        System.out.print("Digite o ID do Artista: ");
        int idArtista = leitura.nextInt();

        Artista encontrarArtistaId = encontrarArtistaPorId(idArtista);

        if (encontrarArtistaId != null){
            System.out.println("Artista encontrado!");

            System.out.println("Digite o ID do genero:");
            int idGenero = leitura.nextInt();

            Genero encontrarGeneroId = encontrarGeneroPorId(idGenero);

            if (encontrarGeneroId != null){
                System.out.println("Genero encontrado!");
                Cd gerarCd = new Cd(nomeCd,encontrarArtistaId,encontrarGeneroId);
                cds.add(gerarCd);

                System.out.println("CD criado com sucesso!");

                menu();

            } else {
                System.out.println("Genero não encontrado!");
                menu();
            }
        } else {
            System.out.println("Artista não encontrado, não é possivel cadastrar o CD!");
            menu();
        }
    }


    private static void cadastrarArtistas(){
        System.out.println("Bem vindo a area de cadastrar artistas!");
        System.out.print("Digite o nome do artista: ");
        String nomeArtista = leitura.nextLine();

        System.out.print("Digite a idade do artista: ");
        int idadeArtista = leitura.nextInt();
        leitura.nextLine();

        System.out.print("Digite a nacionalidade do artista: ");
        String nacArtista = leitura.nextLine();

        System.out.print("Digite a quantidade de albuns: ");
        int qtdAlbuns = leitura.nextInt();
        leitura.nextLine();

        System.out.print("Digite a quantidade de premios: ");
        int qtdPremios = leitura.nextInt();
        leitura.nextLine();

        Artista gerarArtista = new Artista(nomeArtista, nacArtista,idadeArtista, qtdAlbuns, qtdPremios);
        artistas.add(gerarArtista);
        System.out.println("Artista criado com sucesso!");

        menu();
    }
    private static Artista encontrarArtistaPorId(int Id){
        for (Artista artista : artistas){
            if (artista.getId() == Id){
                return artista;
            }
        }

        return null;
    }

    private static void cadastrarGeneros(){
        System.out.println("Bem vindo a parte de cadastrar generos!");
        System.out.print("Digite o nome do genero: ");
        String nomeGenero = leitura.next();

        System.out.print("Descrava o genero: ");
        String descGenero = leitura.next();

        System.out.print("Lugar de origem do genero: ");
        String localOrigem = leitura.next();
        leitura.nextLine();

        System.out.print("Digite o nivel de popularidade de 0 a 10: ");
        int nivelPopu = leitura.nextInt();
        leitura.nextLine();

        System.out.print("Digite o ano de origem: ");
        int anoOrigem = leitura.nextInt();
        leitura.nextLine();

        Genero gerarGenero = new Genero(nomeGenero, descGenero, localOrigem, nivelPopu, anoOrigem);
        generos.add(gerarGenero);
        System.out.println(gerarGenero + " Genero adicionado!");

        menu();
    }

    private static Genero encontrarGeneroPorId(int Id){
        for (Genero genero : generos){
            if (genero.getId() == Id){
                return genero;
            }
        }

        return null;
    }
}