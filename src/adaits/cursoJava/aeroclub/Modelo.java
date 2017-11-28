package adaits.cursoJava.aeroclub;

public class Modelo {
    private Marca marca;
    private String modelo;

    public Modelo(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }
}
