package adaits.cursoJava.aeroclub;

public class TipoAeronave {
    final private int AVION = 0;
    final private int HELICOPTERO = 1;
    final private int DRON = 2;

    private final String tipo;

    public TipoAeronave(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
