package Classes;
import java.util.HashMap;

public class Jogador {
    private String nome;
    private String nickname;
    private String email;
    private String senha;
    private HashMap<String, Recorde> recordes;

    public Jogador(String nome, String nickname, String email, String senha) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
    }
    public void addRecord(String jogo, Recorde record) {
        recordes.put(jogo, record);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public HashMap<String, Recorde> getRecordes() {
        return recordes;
    }

}
