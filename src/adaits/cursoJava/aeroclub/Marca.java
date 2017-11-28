package adaits.cursoJava.aeroclub;

public class Marca {
    final private int CESSNA = 0;
    final private int ROBINSON = 1;
    final private int PIPPER = 2;

    private String marca;
    private TipoAeronave tipo;

    public Marca(String marca, TipoAeronave tipo) {
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public TipoAeronave getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return marca;
    }
}
