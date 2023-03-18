package Classes;

public class Cartas {
    private int valor;
    private int naipe;
    private boolean comprada;

    public Cartas(int valor, int naipe) {
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

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNaipe() {
        return naipe;
    }

    public void setNaipe(int naipe) {
        this.naipe = naipe;
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
