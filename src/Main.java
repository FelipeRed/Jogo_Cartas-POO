import Classes.Players;
import Classes.Jogador;
import Classes.Ranking;
import Classes.Recorde;
import Jogos.JogoTyper.Jogo_Typer;
import Jogos.JogoSenha.Jogo_Senha;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Classes.FuncoesComuns.limpar_tela;
import static Classes.FuncoesComuns.pausarPrograma;

public class Main {
    private static Jogador jogadorAtivo;
    private static Players players = new Players();
    private static Ranking ranking;
    private static final String[] jogos = {Jogo_Senha.getNome(), Jogo_Typer.getNome()};
    public static void main(String[] args) {
        criarAlgunsJogadores();
        int resposta = criarConta_Ou_LogarSe();
        limpar_tela();
        if (resposta == 1) {
            createAccount(players);
        } else {
            login(players);
        }
        //para facilitar os testes comentar as linhas acima e descomentar da linha 26 a 31
        //jogadorAtivo = new Jogador("Sacy", "sacypere", "sacy@gmail.com", "12345");
        //jogadorAtivo.addRecord(jogos[0], new Recorde(40, jogadorAtivo, jogos[0]));
        //players.add_conta_BD(jogadorAtivo);
        ranking = new Ranking(players);
        escolherProximoPasso();
        limpar_tela();

        int escolha = 4;
        while (escolha == 4) {
            escolha = escolherJogo("jogar");
            limpar_tela();
            switch (escolha) {
                case 1 -> {
                    while (escolha == 1) {
                        Jogo_Senha.main(jogadorAtivo, players, ranking);
                        escolha = escolherProximoPasso();
                    }
                }
                default -> {
                    escolha = 1;
                    while (escolha == 1) {
                        Jogo_Typer.main(jogadorAtivo, players, ranking);
                        escolha = escolherProximoPasso();
                    }
                }
            }
        }
        System.out.println("Volte sempre!");
    }
    public static int criarConta_Ou_LogarSe() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seja bem vindo ao XXXX!");
        System.out.println("Você já possui uma conta?");
        System.out.print("Digite 1 para NÃO e 2 para SIM: ");
        return teclado.nextInt();
    }
    public static void createAccount(Players players) {
        /*ALGORITMO
          - capturar o nome completo, nickname, email, senha e instanciar um objeto Jogador com esses dados
          - adicionar esse jogador a ColeçãoJogadores e setar o jogador criado como jogadorAtivo
        */
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> all_nicknames = players.get_All_Nicknames();
        ArrayList<String> all_Emails = players.get_All_Emails();
        System.out.print("Insira seu nome completo: ");
        String nome = teclado.nextLine();
        String nick1 = "";
        String nick2 = "";
        while (nick1.equals(nick2)) {  //verificar se o nickname desejado já não foi utilizado
            System.out.print("Insira seu nick: ");
            nick1 = teclado.nextLine();
            for (String n : all_nicknames) {
                if (n.equals(nick1)) {
                    nick2 = n;
                    System.out.println("Este nickname já está sendo utilizado.");
                }
            }
        }

        String email1 = "";
        String email2 = "";
        while (email1.equals(email2)) {  //verificar se o email inserido já não foi utilizado
            System.out.print("Insira seu email: ");
            email1 = teclado.nextLine();
            for (String e : all_Emails) {
                if (e.equals(email1)) {
                    email2 = e;
                    System.out.println("Este email já está sendo utilizado.");
                }
            }
        }
        String senha1 = "a";
        String senha2 = "";

        while (!senha1.equals(senha2)) {  //realizar a confirmação de senha
            System.out.print("Insira sua senha: ");
            senha1 = teclado.nextLine();
            System.out.print("Confirme sua senha: ");
            senha2 = teclado.nextLine();
            if (!senha1.equals(senha2)) {
                System.out.println("As senhas não bateram, preencha novamente.");
            }
        }

        Jogador j = new Jogador(nome, nick1, email1, senha1);
        players.add_conta_BD(j);
        jogadorAtivo = j;
        limpar_tela();
    }
    public static void login(Players players) {
        /*ALGORITMO
          - verificar se o nickname inserido existe na ColecaoJogadores
          - verificar se a senha inserida corresponde a senha do jogador com esse nickname
        */
        Scanner teclado = new Scanner(System.in);
        Jogador player = players.getAllPlayers().get(0);
        ArrayList<String> all_nicknames = players.get_All_Nicknames();
        String nick1 = "a";
        String nick2 = "";
        while (!nick1.equals(nick2)) {  //verificar se o nickname inserido existe
            System.out.print("Insira seu nick: ");
            nick1 = teclado.nextLine();
            for (String n : all_nicknames) {
                if (n.equals(nick1)) {
                    nick2 = n;
                }
            }
            if (!nick1.equals(nick2)) {
                System.out.println("Nickname não encontrado, tente novamente.");
            }
        }
        String senha1 = "";
        String senha2 = "";
        for (Jogador j : players.getAllPlayers()) {
            if (j.getNickname().equals(nick1)) {
                player = j;
                senha2 = j.getSenha();
            }
        }
        while (!senha1.equals(senha2)) {  //verificar se a senha inserida está correta
            System.out.print("Insira sua senha: ");
            senha1 = teclado.nextLine();
            if (!senha1.equals(senha2)) {
                System.out.println("Senha inválida, tente novamente.");
            }
        }
        jogadorAtivo = player;
        limpar_tela();
    }
    public static int escolherJogo(String acao) {
        //imprime os jogos disponíveis na biblioteca e retorna o escolhido
        //o parâmetro ação indicara se essa função está sendo usada para escolher um jogo a ser jogado
        //ou um jogo a ser consultado
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        while ((escolha < 1) || (escolha > jogos.length)) {
            limpar_tela();
            System.out.println("Biblioteca de jogos:");
            int i = 1;
            for (String jogo : jogos) {
                System.out.println(i + "- " + jogo);
                i++;
            }
            if (acao.equals("jogar")) {
                System.out.print("Insira o número do jogo você gostaria de jogar: ");
            } else {
                System.out.print("Insira o número do jogo você gostaria de consultar o ranking: ");
            }
            escolha = teclado.nextInt();
        }
        return escolha;
    }
    public static int escolherProximoPasso() {
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        while ((escolha < 1) || (escolha > 5)) {
            limpar_tela();
            System.out.println("OPÇÕES:");
            System.out.println("""
                1- Jogar novamente
                2- Consultar seus recordes
                3- Consultar o ranking
                4- Jogar outro jogo
                5- Sair""");
            System.out.print("O que gostaria de fazer: ");
            escolha = teclado.nextInt();
        }
        limpar_tela();
        if (escolha == 2) {
            jogadorAtivo.mostrarRecordes();
            pausarPrograma();
            escolha = escolherProximoPasso();
        } else if (escolha == 3) {
            escolha = 1;
            //escolha = escolherJogo("consultar ranking");
            ranking.printRankingDoJogo(jogos[escolha-1]); //escolha-1 pq o array de jogos começa em 0
            pausarPrograma();
            escolha = escolherProximoPasso();
        }
        return escolha;
    }
    public static void criarAlgunsJogadores() { //irá criar alguns jogadores com recordes aleatórios
        Random rdn = new Random();
        String[] nomes = {"Breno", "Diogo", "Felipe", "Gabriel"};
        String[] nicknames = {"brenors", "bonet-", "phelpsklm", "gebex"};
        int i = 0;
        for (String nome : nomes) {
            String email = nome.toLowerCase() + "gmail.com";
            String senha = nome.toLowerCase() + "123";
            Jogador j = new Jogador(nome, nicknames[i], email, senha);
            players.add_conta_BD(j);
            Recorde r1 = new Recorde(rdn.nextInt(10)*10, j, jogos[0]);
            Recorde r2 = new Recorde(rdn.nextInt(10)*10, j, jogos[1]);
            j.addRecord(jogos[0], r1);
            j.addRecord(jogos[1], r2);
            i++;
        }
    }
}
