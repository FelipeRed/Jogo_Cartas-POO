package Jogos.JogoCartas;

public class Carta {
    private int valor;
    private int naipe;
    private boolean comprada;

    public Carta(int valor, int naipe) {
        this.valor = valor;
        this.naipe = naipe;
        this.comprada = false;
    }

    public boolean isComprada() {
        return comprada;
    }

    public void setComprada(boolean comprada) {
        this.comprada = comprada;
    }

    public int getValor() {
        return valor;
    }

    public int getNaipe() {
        return naipe;
    }

    @Override
    public String toString() {
        String[] naipes = {"Ouros", "Espadas", "Copas", "Paus"};
        String nome = "";

        switch (valor){
            case 1:
                nome = "Ás";
                break;
            case 11:
                nome = "Valete";
                break;
            case 12:
                nome = "Dama";
                break;
            case 13:
                nome = "Rei";
                break;
            default:
                nome = Integer.toString(valor);
        }

        return nome + " de " + naipes[naipe];
    }
}
