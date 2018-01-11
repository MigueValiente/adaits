package adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia;

public class TipoFactory {
    static public final int AVENIDA = 0;
    static public final int CALLE = 1;
    static public final int PLAZA = 2;
    static public final int RONDA = 3;

    public Tipo getTipo(int tipo){
        switch (tipo) {
            case AVENIDA:
                return new TipoAvenida();
            case CALLE:
                return new TipoCalle();
            //-----
            default:
                return  new TipoCalle();
        }
    }
}
