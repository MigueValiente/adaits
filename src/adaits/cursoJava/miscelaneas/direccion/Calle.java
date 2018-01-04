package adaits.cursoJava.miscelaneas.direccion;

/**
 * La Clase Calle representa una Calle de un domicilio
 * De La Calle es necesario conocer su nombre y el Tipo de Calle.
 * El Tipo de Calle podrá ser de alguno de estos 4 tipos: Calle, Avenida, Plaza o Ronda y además, para cada uno de esos
 * tipos, se dispondrá de una abreviatura que nos sirva para cuando se desee su impresión.
 */
public class Calle {
    static public final int AVENIDA = 0;
    static public final int CALLE = 1;
    static public final int PLAZA = 2;
    static public final int RONDA = 3;
    private final TipoCalle tipo;
    private final String nombre;

    /**
     * Constructor de la Calle que recibe el tipo de Calle, según los tipos definidos como static, y el nombre de la Calle
     * @param tipo Entero (Calle, Avenida, Plaza o Ronda)
     * @param nombre Cadena
     */
    public Calle(TipoCalle tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de la calle en formato String y texto completo
     * @return Cadena de Texto
     */
    public String  getTipo() {
        switch (tipo){
            case AVENIDA: return "Avenida";
            case CALLE: return "Calle";
            case PLAZA: return "Plaza";
            case RONDA: return "Ronda";
            default: return "Calle";
        }
    }

    /**
     * Devuelve el tipo de la calle en formato String y texto abreviado
     * @return Cadena de Texto
     */
    public String  getTipoShort() {
        switch (tipo){
            case AVENIDA: return "Av. ";
            case CALLE: return "C/ ";
            case PLAZA: return "Plz. ";
            case RONDA: return "Rnd. ";
            default: return "C/ ";
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
