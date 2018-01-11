package adaits.cursoJava.aeroclub;

/**
 * Clase derivada de la Aeronave
 */
public class Helicoptero extends Aeronave {
    /**
     * Constructor parametrizado
     * @param matricula Matrícula del helicóptero
     * @param modelo ModeloHeli del helicóptero
     */
    public Helicoptero(String matricula, ModeloHeli modelo) {
            super(matricula, modelo);
    }
}
