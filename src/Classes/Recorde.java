package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recorde {
    private Jogador jogador;
    private String jogo;
    private int pontuacao;
    private String data;

    public Recorde(int pontuacao, Jogador jogador, String jogo) {
        this.pontuacao = pontuacao;
        this.jogador = jogador;
        this.jogo = jogo;
        this.data = getDataAtual();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public String getNomeJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getData() {
        return data;
    }
    public void setData() {
        this.data = getDataAtual();
    }
    public void atualizarRecorde(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    private String getDataAtual() {
        Date dataAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dataAtual);
    }
}
