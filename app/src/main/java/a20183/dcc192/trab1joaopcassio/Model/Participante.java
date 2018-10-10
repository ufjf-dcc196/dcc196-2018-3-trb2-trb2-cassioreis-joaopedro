package a20183.dcc192.trab1joaopcassio.Model;

public class Participante {

    String nome,email;
    Integer CPF;

    public Participante(String nome, String email, Integer CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
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

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }
}
