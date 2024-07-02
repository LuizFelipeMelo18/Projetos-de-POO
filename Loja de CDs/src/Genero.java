public class Genero {
    private int Id;
    private static int count;
    private String nome;
    private final String descricao;
    private int popularidade;
    private String origem;
    private int anoOrigem;

    public Genero(String nome, String descricao, String origem, int popularidade, int anoOrigem){
        this.Id = count;
        this.nome = nome;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.origem = origem;
        this.anoOrigem = anoOrigem;
        Genero.count += 1;
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

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.nome = nome;
    }

    public String getOrigem(){
        return origem;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }

    public int getPopularidade(){
        return popularidade;
    }

    public void setPopularidade(int popularidade){
        this.popularidade = popularidade;
    }

    public int getAnoOrigem(){
        return anoOrigem;
    }

    public void setAnoOrigem(int anoOrigem){
        this.anoOrigem = anoOrigem;
    }


    @Override
    public String toString(){
        return "Id: " + this.Id +
                "\nNome do genero: " + getNome() +
                "\nDescrição: " + getDescricao() +
                "\nOrigem: " + getOrigem() +
                "\nPopularidade de 0 a 10: " + getPopularidade() +
                "\nAno de Origem: " + getAnoOrigem();
    }
}
