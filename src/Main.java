import Classes.Players;
import Classes.Jogador;
import Jogos.JogoTyper.Jogo_Typer;
import Jogos.JogoSenha.Jogo_Senha;
import java.util.ArrayList;
import java.util.Scanner;

import static Classes.FuncoesComuns.limpar_tela;
import static Classes.FuncoesComuns.pausarPrograma;

public class Main {
    private static Jogador jogadorAtivo;
    private static final String[] jogos = {Jogo_Senha.getNome(), Jogo_Typer.getNome()};
    public static void main(String[] args) {
        Players players = new Players();
        int resposta = criarConta_Ou_LogarSe();
        limpar_tela();
        if (resposta == 1) {
            createAccount(players);
        } else {
            login(players);
        }
        limpar_tela();
        //para facilitar os testes comentar tudo que está acima desta linha e descomentar a linha de baixo
        //jogadorAtivo = new Jogador("Felipe", "Phelpsklm", "fe_red@gmail.com", "12345");
        int escolha = 3;
        while (escolha == 3) {
            escolha = escolherJogo();
            limpar_tela();
            switch (escolha) {
                case 1:
                    while (escolha == 1) {
                        Jogo_Senha.main(jogadorAtivo);
                        escolha = escolherProximoPasso();
                    }
                    break;
                default:
                    escolha = 1;
                    while (escolha == 1) {
                        Jogo_Typer.main(jogadorAtivo);
                        escolha = escolherProximoPasso();
                    }
                    break;
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
        setJogadorAtivo(j);
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
        setJogadorAtivo(player);
        limpar_tela();
    }
    public static int escolherJogo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Biblioteca de jogos:");
        int x = 1;
        for (String jogo : jogos) {
            System.out.println(x + "- " + jogo);
            x++;
        }
        System.out.print("Qual jogo você gostaria de jogar: ");
        return teclado.nextInt();
    }
    public static int escolherProximoPasso() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("OPÇÕES:");
        System.out.println("1- jogar novamente\n2- consultar seus recordes\n3- jogar outro jogo\n4- Sair");
        System.out.print("O que gostaria de fazer: ");
        int escolha = teclado.nextInt();
        limpar_tela();
        if (escolha == 2) {
            jogadorAtivo.mostrarRecordes();
            pausarPrograma();
            escolha = escolherProximoPasso();
        }
        return escolha;
    }
    public static void setJogadorAtivo(Jogador jogador) {
        jogadorAtivo = jogador;
    }
}
