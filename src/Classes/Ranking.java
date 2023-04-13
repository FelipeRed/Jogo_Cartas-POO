package Classes;

import Jogos.JogoSenha.Jogo_Senha;
import Jogos.JogoTyper.Jogo_Typer;

import java.util.ArrayList;
import java.util.HashMap;

public class Ranking {
    private ArrayList<Recorde> ranking;

    public Ranking(Players players) {
        ranking = new ArrayList<>();
        String[] jogos = {Jogo_Typer.getNome(), Jogo_Senha.getNome()};
        for (Jogador j : players.getAllPlayers()) {
            HashMap<String, Recorde> recordes = j.getRecordes();
            for (String jogo : jogos) {
                Recorde r = recordes.get(jogo);
                if (r != null) {
                    ranking.add(r);
                }
            }
        }
    }
    public void rankingDoJogo(String jogo) {
        ArrayList<Recorde> records = new ArrayList<>();
        for (Recorde r : ranking) {
            if (r.getNomeJogo().equals(jogo)) {
                records.add(r);
            }
        }
        boolean emOrdem = verificarSeOrdenado(records);
        while (!emOrdem) {
            records = ordenarRecords(records);
            emOrdem = verificarSeOrdenado(records);
        }
        for (Recorde r : records) {
            System.out.println(r.getData() + " | " + r.getJogador().getNickname() + " | " + r.getPontuacao());
        }
    }
    public static boolean verificarSeOrdenado(ArrayList<Recorde> records) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getPontuacao() < records.get(i + 1).getPontuacao()) {
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Recorde> ordenarRecords(ArrayList<Recorde> records) {
        //verificará se pode trocar o records.get(i) com o próximo recorde records.get(i+1)
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getPontuacao() < records.get(i + 1).getPontuacao()) {
                Recorde temp = records.get(i);
                records.set(i, records.get(i + 1));
                records.set(i + 1, temp);
            }
        }
        return records;
    }
}
