public class Contato {
    private int Id;
    private static int count = 1;
    private String nome;
    private long telefone;
    private String email;

    public Contato(String nome, long telefone, String email){
        this.Id = count;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        Contato.count += 1;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public long getTelefone(){
        return telefone;
    }

    public void setTelefone(long telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getId(){
        return Id;
    }

    public String toString(){
        return "Id: " + this.Id +
                "\nNome: " + getNome() +
                "\nTelefone: " + getTelefone() +
                "\nEmail: " + getEmail();
    }

}
