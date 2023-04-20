package Classes;

import Jogos.JogoSenha.Jogo_Senha;
import Jogos.JogoTyper.Jogo_Typer;

import java.util.ArrayList;
import java.util.HashMap;

public class Ranking {
    private ArrayList<Recorde> ranking;

    public Ranking(Players players) { //cria um novo ranking com todos os recordes de todos os jogadores
        ranking = new ArrayList<>();
        String[] jogos = {Jogo_Senha.getNome(), Jogo_Typer.getNome()};
        for (Jogador j : players.getAllPlayers()) { //irá navegar por cada jogador do sistema
            HashMap<String, Recorde> recordes = j.getRecordes(); //pegar a lista de recordes dele
            for (String jogo : jogos) {
                Recorde r = recordes.get(jogo);
                if (r != null) { //caso exista um recorde no jogo pesquisado irá adicioná-lo ao ranking
                    ranking.add(r);
                }
            }
        }
    }
    public void printRankingDoJogo(String jogo) { //receberá um jogo em seu parâmetro e printar os recordes desse jogo
        ArrayList<Recorde> records = new ArrayList<>();
        for (Recorde r : ranking) { //laço que irá capturar os recordes do jogo no parâmetro da função
            if (r.getNomeJogo().equals(jogo)) {
                records.add(r);
            }
        }
        boolean emOrdem = verificarSeOrdenado(records);
        while (!emOrdem) { //laço que irá ordenar a lista de records
            records = ordenarRecords(records);
            emOrdem = verificarSeOrdenado(records);
        }
        System.out.println(jogo.toUpperCase());
        for (Recorde r : records) { //quando estiver ordenado, irá printar os recordes
            System.out.println(r.getDataFormatada() + " | " + r.getJogador().getNickname() + " | " + r.getPontuacao());
        }
    }
    public static boolean verificarSeOrdenado(ArrayList<Recorde> records) {
        //função que retorna se a lista de recordes está em ordem decrescente
        for (int i = 0; i < records.size()-1; i++) {
            if (records.get(i).getPontuacao() < records.get(i + 1).getPontuacao()) {
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Recorde> ordenarRecords(ArrayList<Recorde> records) {
        //verificará se pode trocar o records.get(i) com o próximo recorde records.get(i+1)
        //a ideia é colocar os maiores recordes no início da lista
        for (int i = 0; i < records.size()-1; i++) {
            if (records.get(i).getPontuacao() < records.get(i + 1).getPontuacao()) {
                Recorde temp = records.get(i);
                records.set(i, records.get(i + 1));
                records.set(i + 1, temp);
            }
        }
        return records;
    }
}
