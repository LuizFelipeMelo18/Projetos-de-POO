public class Artista {
    private int Id;
    private static int count = 1;
    private String nome;
    private int idade;
    private String nacionalidade;
    private int qtdAlbuns;
    private int qtdPremios;

    public Artista(String nome, String nacionalidade, int idade, int qtdAlbuns, int qtdPremios){
        this.Id = count;
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.qtdAlbuns = qtdAlbuns;
        this.qtdPremios = qtdPremios;
        Artista.count += 1;
    }

    public int getId(){
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getQtdAlbuns() {
        return qtdAlbuns;
    }

    public void setQtdAlbuns(int qtdAlbuns) {
        this.qtdAlbuns = qtdAlbuns;
    }

    public int getQtdPremios() {
        return qtdPremios;
    }

    public void setQtdPremios(int qtdPremios) {
        this.qtdPremios = qtdPremios;
    }

    @Override
    public String toString(){
        return "Id: " + this.Id +
                "\nNome do Artista: " + getNome() +
                "\nIdade: " + getIdade() +
                "\nNacionalidade: " + getNacionalidade() +
                "\nQuantidade de Premios: " + getQtdPremios() +
                "\nQuantidade de Albuns: " + getQtdAlbuns();
    }
}
