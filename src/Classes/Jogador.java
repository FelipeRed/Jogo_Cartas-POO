package Classes;
import Jogos.JogoSenha.Jogo_Senha;
import Jogos.JogoTyper.Jogo_Typer;
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
        this.recordes = new HashMap<>();
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
    public void mostrarRecordes() {
        System.out.println("       Jogo       |  Nickname   |  Score  |  Data");
        String[] jogos = {Jogo_Senha.getNome(), Jogo_Typer.getNome()};
        HashMap<String, Recorde> recordes = this.getRecordes();
        for (String nomeJogo : jogos) {
            Recorde r = recordes.get(nomeJogo);  //vai procurar a chave "nomeJogo" no Hashmap
            if (r != null) {  //caso a chave exista
                System.out.println(r);
            }
        }
    }
}
