package adaits.cursoJava.miscelaneas.garaje;

import adaits.cursoJava.Persona.Usuario;

/**
 * La Clase Calle representa una Calle de una Planta
 * Cada calle tendrá una o más plazas de aparcamiento. Todas las calles son iguales.
 * Las calles de cada planta estarán numeradas desde 1 hasta c (no desde 0)  debemos saber si están llenas o existe algún sitio libre.
 * Es necesario conocer la Planta a la que pertenece la Calle
 */
public class Calle {
    private final int numero;
    private final Plaza[] plazas;
    private final Planta planta;


    /**
     * Constructor de una Calle. Recibe la Planta a la que pertenece, el número de la Calle y el número de Plazas que
     * tiene la Calle
     * @param p Planta a la que pertenece la Calle
     * @param nCalle Número de Calle
     */
    public Calle(Planta p, int nCalle){
        planta = p;
        numero = nCalle;
        int nPlazas = p.getGaraje().getPLAZAS();
        plazas = new Plaza[nPlazas];


        for (int i = 0; i < nPlazas; i++) {
            plazas[i] = new Plaza(this,nPlazas * (numero-1) + i);
        }
    }

    public int getNumero() {
        return numero;
    }

    /**
     * Getter de planta
     *
     * @return planta
     */
    public Planta getPlanta() {
        return planta;
    }

    /**
     * Obtiene una Plaza determinada por su número de Plaza en la Calle
     * @param n Entero que indica el número de Plaza
     * @return La Plaza
     */
    public Plaza getUnaPlaza(int n){
        return plazas[n-1];
    }

    /**
     * Comprueba si una Calle está llena
     * @return Boolean
     */
    public boolean isFullStreet(){
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].isFree()) // si no está ocupado ni alquilado
                return false;
        }
        return true;
    }

    /**
     * Método que busca en la Calle la primera Plaza libre
     * @return Plaza libre o null
     */
    private Plaza buscaPlazaLibre() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].isFree())
                return plazas[i];
        }
        return null;
    }


    /**
     * Método que ocupa una Plaza libre
     * @return Devuelve la Plaza ocupada o null si no la encuentra
     */
    public Plaza ocuparUnaPlazaLibre(){
        Plaza p = buscaPlazaLibre();
        ocuparUnaPlaza(p);
        return p;
    }

    /**
     * Método que ocupa una Plaza determinada
     * @param plaza Plaza a ocupar
     */
    private void ocuparUnaPlaza(Plaza plaza){
        if (plaza != null) {
            plaza.ocupar();
        }
    }

    public void alquilarUnaPlaza(Plaza plaza, Usuario u){
        if (plaza != null) {
            plaza.alquilar(u);
        }
    }

    @Override
    public String toString() {
        String output ="";
        for (int i = 0; i < plazas.length; i++) {
            output += "|" + plazas[i];
        }
        output += "|";
        return output;
    }
}
