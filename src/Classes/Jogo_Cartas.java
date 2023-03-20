package Classes;
import java.util.Random;

public class Jogo_Cartas {
    private Jogadores[] jogadores;
    private Baralhos baralho;

    public Jogo_Cartas() {
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

    public void gerar_jogadores(String nome1, String nome2, String nome3, String nome4, String nome5) {
        Jogadores jog1 = new Jogadores("Felipe");
        Jogadores jog2 = new Jogadores("Vidal");
        Jogadores jog3 = new Jogadores("Juliana");
        Jogadores jog4 = new Jogadores("Zizá");
        Jogadores jog5 = new Jogadores("Nicole");

        Jogadores[] jogadores = {jog1, jog2, jog3, jog4, jog5};

        this.jogadores = jogadores;
    }

    public void distribuir_cartas() {
        Random random = new Random();
        Cartas[][] cartas = this.baralho.getCartas();


        for (int i = 0; i < jogadores.length; i++) {
            int num = random.nextInt(12);
            int naip = random.nextInt(3);

            while (cartas[num][naip].isComprada()) {
                num = random.nextInt(12);
                naip = random.nextInt(3);
            }

            Jogadores j = jogadores[i];
            j.setCarta(cartas[num][naip]);
            cartas[num][naip].setComprada(true);
        }
    }

    public void mostrar_maos() {
        for (int i = 0; i < this.jogadores.length; i++) {
            Jogadores j = this.jogadores[i];
            String n = j.getNome();
            Cartas carta = j.getCarta();

            System.out.println(n + " | " + carta.toString());
        }
    }

    public void determinar_vencedor(){
        int count = 0;

        for (int i = 0; i < this.jogadores.length; i++) {
            if (count != 0) {
                count = i - 1;
                break;
            }

            Jogadores j = jogadores[i];
            Cartas carta_jog1 = j.getCarta();

            for (int k = 0; k < this.jogadores.length; k++) {
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

        System.out.println("");
        System.out.println("O vencedor é: " + this.jogadores[count].getNome() + " com a carta " + this.jogadores[count].getCarta().toString());
    }
}
