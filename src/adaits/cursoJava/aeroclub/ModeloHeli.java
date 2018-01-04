package adaits.cursoJava.aeroclub;

/**
 * Clase heredada de la Clase Modelo que establece el modelo de un Helicóptero
 */
public class ModeloHeli extends Modelo {
    /**
     * Constructor parametrizado del Modelo de un Helicóptero
     * @param marca Marca
     * @param modelo String
     */
    public ModeloHeli(MarcaHeli marca, String modelo) {
        super(marca, modelo);
    }
}
