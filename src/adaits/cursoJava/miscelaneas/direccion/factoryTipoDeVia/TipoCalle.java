package adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia;

public class TipoCalle extends Tipo {
    public TipoCalle() {
        super("C/");
    }

    @Override
    public String getTipo() {
        return "Calle";
    }

}
