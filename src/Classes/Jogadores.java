package Classes;

public class Jogadores {
    private String nome;
    private Cartas carta;

    public Jogadores(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cartas getCarta() {
        return carta;
    }

    public void setCarta(Cartas carta) {
        this.carta = carta;
    }
}
