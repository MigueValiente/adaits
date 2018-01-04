package adaits.cursoJava.miscelaneas.direccion;

/**
 * La Clase direccion modela una dirección de correo
 * La Clase Dirección incluirá el Código postal, La Calle y el número del domicilio.
 */
public class Direccion {
    private final CP cp;
    private final Calle calle;
    private final int numero;

    /**
     *Constructor que recibe el cúmero del Código postal, la Calle y el número del domicilio
     * @param cp Entero que representa un código postal
     * @param calle Cadena con el nombre de la Calle
     * @param numero del domicilio
     */
    public Direccion(CP cp, Calle calle,int numero) {
        this.cp = cp;
        this.calle = calle;
        this.numero = numero;
        // Se agrega el domicilio al array de Domicilios de la clase CP
        cp.add(this);
    }

    public Calle getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    /**
     * Devuelve una Cadena con la Dirección completa, con CP, Localidad y Provincia
     * @return Cadena
     */
    public String getFullDireccion(){
        String output = "" + this;
        output += " CP: " + cp;
        output+= " " + cp.getLocalidad() + " (" + cp.getLocalidad().getProvincia() + ")";
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        output += calle.getTipoShort() + calle;
        if (numero != 0)
            output += " nº " + numero;
        return output;
    }
}
