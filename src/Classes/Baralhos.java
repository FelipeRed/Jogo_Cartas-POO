package Classes;

public class Baralhos {
    private Cartas[][] baralho;

    public Baralhos() {
        this.baralho = gerar_baralho();
    }

    public Cartas[][] getBaralho() {
        return baralho;
    }

    public void setBaralho(Cartas[][] baralho) {
        this.baralho = baralho;
    }

    private Cartas[][] gerar_baralho() {
        Cartas[][] baralho = new Cartas[13][4];

        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++){
                Cartas carta = new Cartas(i, j);
                baralho[i-1][j] = carta;
            }
        }

        return baralho;
    }
}
