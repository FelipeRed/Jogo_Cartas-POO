import Classes.Players;
import Classes.Jogador;
import Jogos.JogoTyper.Jogo_Typer;
import Jogos.JogoSenha.Jogo_Senha;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Jogador jogadorAtivo;
    public static void main(String[] args) {
        Players players = new Players();
        int resposta = criarConta_Ou_LogarSe();
        if (resposta == 1) {
            createAccount(players);
        } else {
            login(players);
        }
        int escolha = escolherJogo();
        limparTela();
        switch (escolha) {
            case 1:
                Jogo_Senha.main(args, jogadorAtivo);
                break;
            default:
                Jogo_Typer.main(args, jogadorAtivo);
        }
    }
    public static int criarConta_Ou_LogarSe() {
        Scanner input = new Scanner(System.in);
        System.out.println("Seja bem vindo ao XXXX!");
        System.out.println("Você já possui uma conta?");
        System.out.print("Digite 1 para NÃO e 2 para SIM: ");
        return input.nextInt();
    }
    public static int escolherJogo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Biblioteca de jogos:");
        System.out.println("1 - Jogo da Senha\n2 - Jogo da digitação");
        System.out.print("Qual jogo você gostaria de jogoar: ");
        return input.nextInt();
    }
    public static void login(Players players) {
        Scanner input = new Scanner(System.in);
        Jogador player = players.getAllPlayers().get(0);
        ArrayList<String> all_nicknames = players.get_All_Nicknames();
        String nick1 = "a";
        String nick2 = "";
        while (!nick1.equals(nick2)) {  //verificar se o nickname inserido existe
            System.out.print("Insira seu nick: ");
            nick1 = input.nextLine();
            for (String n : all_nicknames) {
                if (n.equals(nick1)) {
                    nick2 = n;
                }
            }
            if (!nick1.equals(nick2)) {
                System.out.println("Nickname não encontrado, tente novamente.");
            }
        }
        //validação da senha
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
            senha1 = input.nextLine();
            if (!senha1.equals(senha2)) {
                System.out.println("Senha inválida, tente novamente.");
            }
        }
        setJogadorAtivo(player);
        limparTela();
    }
    public static void createAccount(Players players) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> all_nicknames = players.get_All_Nicknames();
        ArrayList<String> all_Emails = players.get_All_Emails();
        System.out.print("Insira seu nome completo: ");
        String nome = input.nextLine();
        String nick1 = "";
        String nick2 = "";
        while (nick1.equals(nick2)) {  //verificar se o nickname desejado já não foi utilizado
            System.out.print("Insira seu nick: ");
            nick1 = input.nextLine();
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
            email1 = input.nextLine();
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
            senha1 = input.nextLine();
            System.out.print("Confirme sua senha: ");
            senha2 = input.nextLine();
            if (!senha1.equals(senha2)) {
                System.out.println("As senhas não bateram, preencha novamente.");
            }
        }
        Jogador j = new Jogador(nome, nick1, email1, senha1);
        players.add_conta_BD(j);
        setJogadorAtivo(j);
        limparTela();
    }
    public Jogador getJogadorAtivo() {
        return jogadorAtivo;
    }
    public static void setJogadorAtivo(Jogador jogador) {
        jogadorAtivo = jogador;
    }
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
