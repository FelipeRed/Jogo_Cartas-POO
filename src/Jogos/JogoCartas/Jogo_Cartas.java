package Jogos.JogoCartas;
import Classes.Jogador;
import java.util.ArrayList;
import java.util.Random;

public class Jogo_Cartas {

    public static void main(String[] args) {
        //algum jogo usando cartas
    }

    public void distribuir_cartas(ArrayList<Jogador> jogadores, Baralho baralho) {
        Random random = new Random();
        Carta[][] cartas = baralho.getCartas();


        for (int i = 0; i < jogadores.size(); i++) {
            int num = random.nextInt(12);
            int naip = random.nextInt(3);

            while (cartas[num][naip].isComprada()) {
                num = random.nextInt(12);
                naip = random.nextInt(3);
            }

            Jogador j = jogadores.get(i);
            //j.setCarta(cartas[num][naip]);
            cartas[num][naip].setComprada(true);
        }
    }

    public void mostrar_maos(ArrayList<Jogador> jogadores) {
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador j = jogadores.get(i);
            String n = j.getNome();
            //Carta carta = j.getCarta();

            //System.out.println(n + " | " + carta.toString());
        }
    }

    /*public void quem_Tem_A_Maior_Carta(ArrayList<Jogador> jogadores){
        int x = 0;

        for (int i = 0; i < jogadores.size(); i++) {
            if (x != 0) {
                x = i - 1;
                break;
            }
            Jogador jog = jogadores.get(i);
            Carta carta_jog = jog.getCarta();

            for (int j = 0; j < jogadores.size(); j++) {
                Carta carta_jog_x = jogadores.get(j).getCarta();

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
    }*/
}
