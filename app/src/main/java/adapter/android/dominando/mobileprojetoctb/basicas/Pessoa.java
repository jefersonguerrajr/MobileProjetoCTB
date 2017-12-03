package adapter.android.dominando.mobileprojetoctb.basicas;

/**
 * Created by Jeferson on 25/10/2017.
 */

public class Pessoa {
    private Long id;
    private String email;
    private String senha;

    // Construtor
    public Pessoa() {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
