package adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia;

public abstract class Tipo {

    private final String tipoShort;

    public Tipo(String tipoShort) {
        this.tipoShort = tipoShort;
    }
    public String getTipoShort(){
        return tipoShort;
    }

    // Método abstracto
    public abstract String getTipo();
}
