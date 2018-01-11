package adaits.cursoJava.miscelaneas.direccion;

/**
 * La Clase Provincia Modela una Provincia con un código, 41 para Sevilla, el nombre de la provincia y un Array de
 * Localidades que hay dentro de la Provincia
 * De la Provincia se deberá conocer un código, que se corresponde con los dos primeros dígitos del código postal
 * (41 para Sevilla), el nombre  de la Provincia y la relación de todas las Localidades incluidas en dicha Provincia.
 */
public class Provincia {
    private final int codigo;
    private final String nombreProvincia;
    private Localidad [] localidades;

    /**
     * Constructor que recibe el código y el Nombre de la Provincia
     * @param codigo Entero
     * @param nombreProvincia Cadena (String)
     */
    public Provincia(int codigo, String nombreProvincia) {
        this.codigo = codigo;
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public int getCodigo() {
        return codigo;
    }

    /**
     * Agrega una localidad al array de localidades. Para agregarla crea un nuevo array con un tamaño mayor, copia
     * los elementos que ya tenía y le agrega la nueva localidad al final
     * @param localidad Localidad a agregar
     */
    public void add(Localidad localidad){
        if (localidades == null){
            localidades = new Localidad[1];
            localidades[0] = localidad;
        }
        else {
            Localidad [] localidades2 = new Localidad[localidades.length + 1];
            System.arraycopy(localidades,0,localidades2,0,localidades.length);
            localidades2[localidades2.length - 1] = localidad;
            localidades = localidades2;
        }
    }

    /**
     * Método que lista las Localidades de una Provincia
     */
    public void listarLocalidades(){
        System.out.println("Direcciones de la provincia de " + nombreProvincia);
        System.out.println("-----------------------------------------------");
        for (Localidad l:localidades) {
            l.listarCPs();
        }
    }

    @Override
    public String toString() {
        return nombreProvincia;
    }
}
