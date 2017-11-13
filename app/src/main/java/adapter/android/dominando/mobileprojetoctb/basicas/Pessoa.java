package adapter.android.dominando.mobileprojetoctb.basicas;

/**
 * Created by Jeferson on 25/10/2017.
 */

public class Pessoa {
    private String nome;
    private int cpf;
    private String email;
    private String senha;

    // Construtor
    public Pessoa() {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    // M
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
