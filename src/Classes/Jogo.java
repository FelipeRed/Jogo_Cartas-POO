package Classes;
import java.util.Random;

public class Jogo {
    private Jogadores[] jogadores;
    private Baralhos baralho;

    public Jogo(Jogadores[] jogadores, Baralhos baralho) {
        this.jogadores = jogadores;
        this.baralho = baralho;
    }

    public Baralhos getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralhos baralho) {
        this.baralho = baralho;
    }

    public Jogadores[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogadores[] jogadores) {
        this.jogadores = jogadores;
    }

    public void distribuir_cartas(Jogadores[] jogadores, Baralhos baralho1) {
        Random random = new Random();
        Cartas[][] baralho = baralho1.getBaralho();


        for (int i = 0; i < jogadores.length; i++) {
            int num = random.nextInt(12);
            int naip = random.nextInt(3);

            while (baralho[num][naip].isComprada()) {
                num = random.nextInt(12);
                naip = random.nextInt(3);
            }

            Jogadores j = jogadores[i];
            j.setCarta(baralho[num][naip]);
            baralho[num][naip].setComprada(true);
        }
    }

    public void mostrar_maos(Jogadores[] jogadores) {
        for (int i = 0; i < jogadores.length; i++) {
            Jogadores j = jogadores[i];
            String n = j.getNome();
            Cartas carta = j.getCarta();

            System.out.println(n + ": " + carta.toString());
        }
    }

    public Jogadores determinar_vencedor(Jogadores[] jogadores){
        System.out.println("Falta arrumar aqui determinar_vencedor()");
        int count = 0;

        for (int i = 0; i < jogadores.length; i++) {
            if (count != 0) {
                count = i - 1;
                break;
            }

            Jogadores j = jogadores[i];
            Cartas carta_jog1 = j.getCarta();

            for (int k = 0; k <jogadores.length; k++) {
                Cartas carta_jog_x = jogadores[k].getCarta();

                if (carta_jog1.getValor() == carta_jog_x.getValor()) {
                    if (carta_jog1.getNaipe() < carta_jog_x.getNaipe()) {
                        count = 0;
                        break;
                    }
                } else if (carta_jog1.getValor() < carta_jog_x.getValor()) {
                    count = 0;
                    break;
                } else {
                    count += 1;
                }
            }
        }

        return jogadores[count];
    }
}
