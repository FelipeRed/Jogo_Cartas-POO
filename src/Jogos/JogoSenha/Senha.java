package Jogos.JogoSenha;
import java.util.Random;

public class Senha {
    private final int posicao1;
    private final int posicao2;
    private final int posicao3;
    private final int posicao4;

    public Senha() {
        Random random = new Random();
        this.posicao1 = random.nextInt(3) + 1;
        this.posicao2 = random.nextInt(3) + 1;
        this.posicao3 = random.nextInt(3) + 1;
        this.posicao4 = random.nextInt(3) + 1;
    }

    public int getPosicao1() {
        return posicao1;
    }

    public int getPosicao2() {
        return posicao2;
    }

    public int getPosicao3() {
        return posicao3;
    }

    public int getPosicao4() {
        return posicao4;
    }

    public int[] get_posicoes() {
        return new int[] {getPosicao1(), getPosicao2(), getPosicao3(), getPosicao4()};
    }

    @Override
    public String toString() {
        return Integer.toString(posicao1) + Integer.toString(posicao2) +
                Integer.toString(posicao3) + Integer.toString(posicao4);
    }
}
