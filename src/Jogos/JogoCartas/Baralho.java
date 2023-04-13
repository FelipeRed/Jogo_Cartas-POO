package Jogos.JogoCartas;

public class Baralho {
    private final Carta[][] cartas;

    public Baralho() {
        this.cartas = gerar_baralho();
    }

    public Carta[][] getCartas() {
        return cartas;
    }

    private Carta[][] gerar_baralho() {
        Carta[][] baralho = new Carta[13][4];
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++){
                Carta carta = new Carta(i, j);
                baralho[i-1][j] = carta;
            }
        }
        return baralho;
    }
}
