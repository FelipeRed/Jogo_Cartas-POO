package JogoTyper;

public class Cronometro {
    private long inicio;
    private long fim;

    public void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public void parar() {
        fim = System.currentTimeMillis();
    }

    public long getTempo() {
        return (fim - inicio) / 1000;
    }
}
