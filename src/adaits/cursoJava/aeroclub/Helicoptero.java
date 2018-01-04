package adaits.cursoJava.aeroclub;

/**
 * Clase derivada de la Aeronave
 */
public class Helicoptero extends Aeronave {
    /**
     * Constructor parametrizado
     * @param matricula Matrícula del helicóptero
     * @param modelo Modelo del helicóptero
     */
    public Helicoptero(String matricula, Modelo modelo) {
            super(matricula, modelo);
    }
}
