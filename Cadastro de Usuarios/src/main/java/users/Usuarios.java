package users;

public class Usuarios {
    private int Id;
    private String nome;
    private String email;
    private String password;

    public Usuarios(){
    }

    public Usuarios(String nome, String email, String password){
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public int getId(){
        return Id;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
