package JogoTyper;

import java.util.Random;
import java.util.Scanner;

public class Jogo_Typer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rdn = new Random();
        Cronometro cronometro = new Cronometro();
        String[] palavras = {"oi", "tudo", "bem", "com", "você"};

        int x = 5;
        int y = 0;
        int incremento = 0;
        int pontuacao = 0;
        long tempo = 0;
        while (tempo < x) {
            pontuacao += incremento;
            int random = rdn.nextInt(0, palavras.length-1);
            String palavra = palavras[random].toUpperCase();
            String digitado = "";

            cronometro.iniciar();
            while (!palavra.equals(digitado)) {
                System.out.println("\nSegundos para responder: " + x);
                System.out.println("A sua palavra é  : " + palavra);
                System.out.print  ("Digite a palavra : ");
                digitado = input.nextLine().toUpperCase();
            }
            cronometro.parar();
            tempo = cronometro.getTempo();

            y++;
            if (y == 10) {
                incremento++;
                x--;
                y = 0;
            }
        }
        System.out.println("Sua pontuação foi: " + pontuacao);
    }
}
