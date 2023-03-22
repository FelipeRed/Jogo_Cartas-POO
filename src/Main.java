import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Jogos:  1 - Quem tem a maior carta  |  2 - Jogo da senha");
        System.out.print("Qual jogo você deseja joga: ");
        int escolha = teclado.nextInt();

        if (escolha == 1){
            Baralhos baralho = new Baralhos();
            Jogo_Cartas jogo = new Jogo_Cartas();
            jogo.setBaralho(baralho);
            jogo.gerar_jogadores("Felipe", "João", "Maria", "Igor", "Nicole");

            jogo.distribuir_cartas();
            jogo.mostrar_maos();
            jogo.determinar_vencedor();
        } else {
            Jogo_Senha jogo = new Jogo_Senha();
            jogo.imprimir_regras();

            //lista que será usada como histórico de tentativas do jogador
            ArrayList<String> historico = new ArrayList<>();

            //variável que se tornada verdadeira significa que o jogador venceu
            boolean resultado = false;
            for (int i = 0; i < 10; i++) {
                System.out.print("Digite seu palpite: ");
                int input = teclado.nextInt();

                int[] analise = jogo.analisar_palpite(input);

                if (analise[0] == 4) { //verifica se o jogador acertou todas as posições (analise[0])
                    resultado = true;
                    break;
                } else {
                    //será gerado uma String explicando a tentativa do jogador e adicionada a seu histórico
                    String m = input + " | Números certos nas posições certas: " + analise[0] +
                            "  -  Números certos nas posições erradas: " + analise[1];
                    historico.add(m);
                }

                limpar_tela();
                //laço que irá imprimir o histórico de todas as jogadas do jogador
                for (String item : historico) {
                    System.out.println(item);
                }
                System.out.println("Tentativas restantes: " + (9 - i));
            }

            if (resultado) {
                System.out.println("Parabéns você descobriu a senha!");
            } else {
                System.out.println("Você falhou... A senha era " + jogo.getSenha().toString());
            }
        }
    }
    public static void limpar_tela() {  //método que irá imprimir várias linhas vazias para limpar a tela do terminal
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}