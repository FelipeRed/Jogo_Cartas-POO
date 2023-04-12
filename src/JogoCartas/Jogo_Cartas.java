package JogoCartas;
import java.util.ArrayList;
import java.util.Random;

public class Jogo_Cartas {
    private ArrayList<Jogadores> jogadores;
    private Baralho baralho;

    public static void main(String[] args) {
        Jogo_Cartas jogo = new Jogo_Cartas();
        String[] nomes = {"Felipe", "João", "Maria", "Igor", "Nicole"};
        jogo.gerar_jogadores(nomes);

        jogo.distribuir_cartas();
        jogo.mostrar_maos();
        jogo.determinar_vencedor();
    }
    public Jogo_Cartas() {
        this.baralho = new Baralho();
    }

    public ArrayList<Jogadores> getJogadores() {
        return jogadores;
    }

    public void gerar_jogadores(String[] nomes) {
        ArrayList<Jogadores> jogadores = new ArrayList<>();
        for (String nome : nomes) {
            Jogadores jog = new Jogadores(nome);
            jogadores.add(jog);
        }

        this.jogadores = jogadores;
    }

    public void distribuir_cartas() {
        Random random = new Random();
        Carta[][] cartas = this.baralho.getCartas();


        for (int i = 0; i < jogadores.size(); i++) {
            int num = random.nextInt(12);
            int naip = random.nextInt(3);

            while (cartas[num][naip].isComprada()) {
                num = random.nextInt(12);
                naip = random.nextInt(3);
            }

            Jogadores j = jogadores.get(i);
            j.setCarta(cartas[num][naip]);
            cartas[num][naip].setComprada(true);
        }
    }

    public void mostrar_maos() {
        for (int i = 0; i < this.jogadores.size(); i++) {
            Jogadores j = this.jogadores.get(i);
            String n = j.getNome();
            Carta carta = j.getCarta();

            System.out.println(n + " | " + carta.toString());
        }
    }

    public void determinar_vencedor(){
        int x = 0;

        for (int i = 0; i < this.jogadores.size(); i++) {
            if (x != 0) {
                x = i - 1;
                break;
            }
            Jogadores j = jogadores.get(i);
            Carta carta_jog1 = j.getCarta();

            for (int k = 0; k < this.jogadores.size(); k++) {
                Carta carta_jog_x = jogadores.get(k).getCarta();

                if (carta_jog1.getValor() == carta_jog_x.getValor()) {
                    if (carta_jog1.getNaipe() < carta_jog_x.getNaipe()) {
                        x = 0;
                        break;
                    }
                } else if (carta_jog1.getValor() < carta_jog_x.getValor()) {
                    x = 0;
                    break;
                } else {
                    x += 1;
                }
            }
        }

        System.out.println("\nO vencedor é: " + this.jogadores.get(x).getNome() + " com a carta " +
                this.jogadores.get(x).getCarta().toString());
    }
}
