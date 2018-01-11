package adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia;

public class TipoAvenida extends Tipo {
    public TipoAvenida() {
        super("Av.");
    }

    @Override
    public String getTipo() {
        return "Avenida";
    }
}
