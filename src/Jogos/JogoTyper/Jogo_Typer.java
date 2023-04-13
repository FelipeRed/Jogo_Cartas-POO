/*ALGORITMO
tempo limite para responder é 5 segundos
a cada palavra acertada ganha um ponto
pegar uma palavra aleatória (P)
enquanto(input do usuario estiver errado) {
    pedir para que ele digite a palavra P
    se (enviou 10 inputs corretos) {
        diminuir o tempo limite em 1 segundo
        aumentar a quantidade de pontos por palavra correta em 1
        aumentar a dificuldade das palavras
        se (tempo para responder for 2 segundos) {
            dificuldade das palavras = média
        } ou se (tempo para responder for 1 segundo) {
            dificuldade das palavras = fácil
        }
    }
}
*/
package Jogos.JogoTyper;
import Classes.Jogador;
import java.util.Random;
import java.util.Scanner;

import static Classes.FuncoesComuns.atualizar_Ou_Adicionar_NovoRecorde;

public class Jogo_Typer {  //o algoritmo do jogo está comentado no início do código
    private static final String nomeJogo = "Typer";
    public static void main(String[] args, Jogador jogadorAtual) {
        Scanner teclado = new Scanner(System.in);
        Random rdn = new Random();
        Cronometro cronometro = new Cronometro();

        String[] facil = {"CASA", "AMIGO", "GATO", "CAMA", "RATO", "FLOR", "SOL", "RISO", "LUA", "BOM"};
        String[] medio = {"COMPUTADOR", "CAMPAINHA", "COLABORAÇÃO", "PROPRIEDADE", "UNIVERSIDADE", "INDÚSTRIA",
                          "SINCRONIZAÇÃO", "DESENVOLVIMENTO", "ACOMPANHAMENTO", "PRODUTIVIDADE"};
        String[] dificil = {"INCONSTITUCIONALMENTE", "PARALELEPÍPEDO", "INCOMPREENSIBILIDADE", "EXCEPCIONALIDADE",
                            "DESAGREGAÇÃO", "INTERCONEXÃO", "EXTRAVAGÂNCIA", "AUTOSSUFICIENTE", "INSTRANSIGÊNCIA",
                            "CONTEMPORANEIDADE"};
        String[][] niveis = {facil, medio, dificil};
        int x = 0;
        String[] palavras = niveis[x];
        int tempoLimite = 5;
        long tempoUtilizado = 0;
        int respostas = 0;
        int ponto = 1;
        int pontuacao = 0;

        while (tempoUtilizado < tempoLimite) {
            int random = rdn.nextInt(0, palavras.length-1);
            String palavra = palavras[random];
            String input = "";
            cronometro.iniciar();
            while (!palavra.equals(input)) {
                System.out.println("\nSegundos para responder: " + tempoLimite);
                System.out.println("A sua palavra é  : " + palavra);
                System.out.print  ("Digite a palavra : ");
                input = teclado.nextLine().toUpperCase();
            }
            cronometro.parar();
            tempoUtilizado = cronometro.getTempo();
            respostas++;
            if (tempoUtilizado < tempoLimite) {
                pontuacao += ponto;
            }
            if (respostas == 10) {
                x++;
                palavras = niveis[x];
                ponto++;
                tempoLimite--;
                respostas = 0;
                if (tempoLimite == 2) {
                    palavras = niveis[1];
                } else if (tempoLimite == 1) {
                    palavras = niveis[0];

                }
            }
        }
        atualizar_Ou_Adicionar_NovoRecorde(jogadorAtual, pontuacao, nomeJogo);
    }
    public static String getNome() {
        return nomeJogo;
    }
}
