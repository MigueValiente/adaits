package adaits.cursoJava.miscelaneas.direccion;

/**
 * La clase CP modela un Código Postal.
 * El código (numero) es un entero de tres cifras que junto a las dos cifras del código de la Provincia nos proporciona
 * el Código postal correspondient
 * Del Código Postal, que representa un área que cubre total o parcialmente una Localidad, se deberá conocer su número,
 * la Localidad a la que pertenece y todas las Direcciones que tengan ese código postal.
 */
public class CP {
    private final int numero;
    private final Localidad localidad;
    private Direccion[] direcciones;

    public CP(int numero, Localidad localidad) {
        this.numero = numero;
        this.localidad = localidad;
        localidad.add(this);
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * Agrega Direcciones al array de direcciones. Crea un array mayor, copia los elementos que ya existían y agrega
     * el nuevo elemento Localidad
     * @param d direccion
     */
    public void add(Direccion d){
        if (direcciones == null){
            direcciones = new Direccion[1];
            direcciones[0] = d;
        }
        else {
            Direccion [] direcciones2 = new Direccion[direcciones.length + 1];
            System.arraycopy(direcciones,0,direcciones2,0,direcciones.length);
            direcciones2[direcciones2.length - 1] = d;
            direcciones = direcciones2;
        }
    }

    /**
     * Lista las Direcciones de un Código Postal
     */
    public void listDirecciones(){
        System.out.println("CP: " + getCP());
        for (Direccion d: direcciones) {
            System.out.println("\t" + d);
        }
    }

    /**
     * Calcula el código agregando el prefijo del código de la Provincia
     * @return Entero CP
     */
    private int getCP(){
        return localidad.getProvincia().getCodigo() * 1000 + numero;
    }


    @Override
    public String toString() {
        return "" + getCP();
    }
}
