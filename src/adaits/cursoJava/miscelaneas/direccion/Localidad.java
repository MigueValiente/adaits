package adaits.cursoJava.miscelaneas.direccion;

/**
 * La Clase Localidad modela las poblaciones de una Provincia
 * De la Localidad se necesita conocer su nombre, la Provincia a la que pertenece y la relación de códigos postales
 * incluidos en ella, que serán uno o más.
 * Necesita un nombre (String) una Provincia a la que pertenece y un array de Códigos Postales que pertenecen a
 * la Localidad
 */
public class Localidad {
    private final String nombreLoc;
    private final Provincia provincia;
    private CP[] cps;

    /**
     * Constructor que recibe el nombre de la Localidad y la Provincia a la que pertenece. Permite agregar la Localidad
     * al array de Localidades de la provincia que recibe por parámetro
     * @param nombreLoc Cadena
     * @param provincia Provincia
     */
    public Localidad(String nombreLoc, Provincia provincia) {
        this.nombreLoc = nombreLoc;
        this.provincia = provincia;
        // Se agrega La Localidad al array de localidades de la Provincia
        this.provincia.add(this);
    }

    public Provincia getProvincia() {
        return provincia;
    }

    /**
     * Agrega un Código postal al array de Códigos Postales. Crea un nuevo array mayor, copia los elementos que ya
     * había y agrega el nuevo CP
      * @param cp Código Postal
     */
    public void add(CP cp){
        if (cps == null){
            cps = new CP[1];
            cps[0] = cp;
        }
        else {
            CP [] cps2 = new CP[cps.length + 1];
            System.arraycopy(cps,0,cps2,0,cps.length);
            cps2[cps2.length - 1] = cp;
            cps = cps2;
        }
    }

    /**
     * Lista todos los Códigos Postales de la Localidad
     */
    public void listarCPs(){
        System.out.println(nombreLoc);
        for (CP c: cps) {
            c.listDirecciones();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return nombreLoc;
    }
}
