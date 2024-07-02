public class Cd {
    private final Artista artista;
    private final Genero genero;
    private int Id;
    private static int count = 1;
    private String nome;

    public Cd(String nome, Artista artista, Genero genero) {
        Id = count;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
        Cd.count += 1;
    }



    public int getId(){
        return Id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public Artista getArtista() {
        return artista;
    }


    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString(){
        return "Id: " + this.Id +
                "\nNome do CD: " + getNome() +
                "\nNome do Artista: " + getArtista().getNome() +
                "\nGenero: " + getGenero().getNome();
    }
}
