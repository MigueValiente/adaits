package adaits.cursoJava.aeroclub;

/**
 * Clase derivada de la Aeronave
 */
public class Avion extends Aeronave {
    /**
     * Constructor parametrizado
     * @param matricula Matrícula del avión
     * @param modelo Modelo del avión
     */
    public Avion(String matricula, ModeloAvion modelo) {
        super(matricula, modelo);
    }
}
