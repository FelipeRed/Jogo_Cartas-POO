import Classes.*;

public class Main {
    public static void main(String[] args) {
        Baralhos baralho = new Baralhos();

        Jogadores felipe = new Jogadores("Felipe");
        Jogadores vidal = new Jogadores("Vidal");
        Jogadores juliana = new Jogadores("Juliana");
        Jogadores ziza = new Jogadores("Zizá");
        Jogadores nicole = new Jogadores("Nicole");

        Jogadores[] jogadores = {felipe, vidal, juliana, ziza, nicole};

        Jogo jogo = new Jogo(jogadores, baralho);

        jogo.distribuir_cartas(jogadores, baralho);
        jogo.mostrar_maos(jogadores);
        jogo.determinar_vencedor(jogadores);
    }
}