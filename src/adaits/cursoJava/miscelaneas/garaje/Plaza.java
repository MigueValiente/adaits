package adaits.cursoJava.miscelaneas.garaje;

import adaits.cursoJava.Persona.*;

/**La Clase Plaza define una Plaza de aparcamiento.
 * Tiene un número asignado correlativo en toda la Planta
 * Conoce la Calle y la Planta en la que se ubica
 * Sabemos si está cupada y si tiene propietario.
 * Las plazas están numeradas y pueden estar libres u ocupadas. La numeración de las plazas de cada planta será la
 * misma en cada una de ellas e irán desde 1 hasta el total de plazas de cada planta
 * Deberá poder saberse si existe alguna plaza libre en el Garaje.
 * Se deberá poder asignar una plaza libre.
 */
public class Plaza {
    private final int numero;
    private final Calle calle;
    private boolean ocupado;
    private Usuario propietario;

    /**
     * Constructor que hrecibe el número de Plaza la Planta y la Calle en la que se ubica
     * @param c Calle
     * @param n Número de la Plaza
     */
    public Plaza(Calle c, int n){
        calle = c;
        numero = n + 1;
        ocupado = false;
        propietario = null;
    }

    public Calle getCalle() {
        return calle;
    }


    public int getNumero() {
        return numero;
    }

    private boolean isOcupado() {
        return ocupado;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    /**
     * Determina si la plaza está alquilada
     * @return Boolean
     */
    private boolean isAlquilado(){
        return propietario != null;
    }

    /**
     * Ocupa una Plaza
     */
    public void ocupar(){
        ocupado = true;
    }

    /**
     * Libera una Plaza
     */
    public void liberar(){
        ocupado = false;
    }

    /**
     * Alquila una Plaza al Usuario u
     * @param u Usuario
     */
    public void alquilar(Usuario u){
        propietario = new Usuario(u);
    }

    /**
     * Una Plaza alquilada deja de estarlo
     */
    public void vender(){
        propietario = null;
    }

    /**
     * Comprueba si una Plaza es ocupable. No está ocupada ni alquilada
     * @return Boolean
     */
    public boolean isFree(){
        return (!isOcupado() && !isAlquilado());
    }

    @Override
    public String toString() {
        if (ocupado) return "H";
        if (propietario != null) return "R";
        return " ";
    }
}
