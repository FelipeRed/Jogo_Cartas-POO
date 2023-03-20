package Classes;
import java.util.Random;

public class Senha {
    int posicao1;
    int posicao2;
    int posicao3;
    int posicao4;

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

    public void setPosicao1(int posicao1) {
        this.posicao1 = posicao1;
    }

    public int getPosicao2() {
        return posicao2;
    }

    public void setPosicao2(int posicao2) {
        this.posicao2 = posicao2;
    }

    public int getPosicao3() {
        return posicao3;
    }

    public void setPosicao3(int posicao3) {
        this.posicao3 = posicao3;
    }

    public int getPosicao4() {
        return posicao4;
    }

    public void setPosicao4(int posicao4) {
        this.posicao4 = posicao4;
    }

    public int[] get_posicoes() {
        return new int[] {this.posicao1, this.posicao2, this.posicao3, this.posicao4};
    }

    @Override
    public String toString() {
        return Integer.toString(posicao1) + Integer.toString(posicao2) +
                Integer.toString(posicao3) + Integer.toString(posicao4);
    }
}
