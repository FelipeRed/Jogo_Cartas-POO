package Classes;

import java.util.ArrayList;

public class Players {
    private ArrayList<Jogador> contas;

    public Players() {
        contas = new ArrayList<>();
    }

    public void add_conta_BD(Jogador jogador) {
        contas.add(jogador);
    }

    public void excluirConta(Jogador jogador) {
        for (Jogador j : contas) {
            if (j == jogador) {
                contas.remove(j);
            }
        }
    }

    public ArrayList<Jogador> getAllPlayers() {
        return contas;
    }

    public ArrayList<String> get_All_Nicknames() {
        ArrayList<String> nicknames = new ArrayList<>();
        for (Jogador jogador : contas) {
            nicknames.add(jogador.getNickname());
        }
        return nicknames;
    }

    public ArrayList<String> get_All_Emails() {
        ArrayList<String> emails = new ArrayList<>();
        for (Jogador jogador : contas) {
            emails.add(jogador.getEmail());
        }
        return emails;
    }
}
