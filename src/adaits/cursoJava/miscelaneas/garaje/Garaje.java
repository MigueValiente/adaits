package adaits.cursoJava.miscelaneas.garaje;

import adaits.cursoJava.Persona.Usuario;
import adaits.cursoJava.algoritmos.otros.numerosAleatorios.Random;

/**
 * El garaje tendrá una (1) o más plantas.
 * Cada planta tendrá una o más calles, todas las plantas son iguales.
 * Cada calle tendrá una o más plazas de aparcamiento. Todas las calles son iguales.
 * Las plantas estarán numeradas desde 1 hasta p (no desde 0)  y debemos poder saber si están llenas.
 * Las calles de cada planta estarán numeradas desde 1 hasta c (no desde 0)  debemos saber si están llenas o existe algún sitio libre.
 * Las plazas están numeradas y pueden estar libres u ocupadas. La numeración de las plazas de cada planta será la misma en cada una de ellas e irán desde 1 hasta el total de plazas de cada planta
 * Deberá poder saberse si existe alguna plaza libre en el Garaje.
 * Se deberá poder asignar una plaza libre.
 * Cuando un vehículo quiere acceder al garaje, sacará un ticket que contendrá la hora de entrada al garaje
 * (la hora del sistema proporcionada por la clase GregorianCalendar. Ver la API de Java), la planta asignada,
 * la calle y la plaza. En caso de que no haya plaza emitirá un mensaje en consola informando de este hecho
 * @author José Espejo Roig
 * @version 17/12/2017
 */
public class Garaje {
    private Planta[] plantas;
    private  final  int PLANTAS;
    private  final  int CALLES;
    private   final  int PLAZAS;

    /**
     * Constructor por defecto
     */
    public Garaje(){
        this(1,1,1);
    }

    /**
     * Constructor con parámetros
     * @param PLANTAS Número de Plantas del Garaje
     * @param CALLES Número de Calles de  cada Planta
     * @param PLAZAS N0 de Plazas de cada Calle
     */
    public Garaje(int PLANTAS, int CALLES, int PLAZAS) {
        if (PLANTAS < 1) PLANTAS = 1;
        if (CALLES < 1) CALLES = 1;
        if (PLAZAS < 1) PLAZAS = 1;
        this.PLANTAS = PLANTAS;
        this.CALLES = CALLES;
        this.PLAZAS = PLAZAS;
        populate();
    }

    /**
     * Getter de PLANTAS
     * @return PLANTAS
     */
    public int getPLANTAS() {
        return PLANTAS;
    }

    /**
     * Getter de CALLES
     * @return CALLES
     */
    public int getCALLES() {
        return CALLES;
    }

    /**
     * Getter del atributo PLAZAS
     * @return atributo PLAZAS
     */
    public int getPLAZAS() {
        return PLAZAS;
    }

    /**
     * Obtiene una Planta determinada por su número de Planta
     * @param n nümero de Planta
     * @return La Planta obtenida
     */
    private Planta getUnaPlanta(int n){
        return plantas[n-1];
    }

    /**
     * Método que se encarga de crear las Plantas del garaje
     */
    private void populate(){
        plantas = new Planta[PLANTAS];
        for (int i = 0; i < PLANTAS; i++) {
            plantas[i] = new Planta(this,i + 1);
        }
    }

    // Asignación de Plazas ------------------------

    /**
     * Busca una Plaza libre para ocuparla en la primera Planta que tenga hueco
     * @return La plaza ocupada, o null si no encuentra ninguna Plaza Libre
     */
    private Plaza asignaPlazaLibre(){
            return ocupaPlazaEnPlantaLibre(buscarPlantaLibre());
    }

    /**
     * Ocupa una Plaza en la Planta que disponga de una Calle con Plazas libres
     * @param planta con Plazas Libres
     * @return La Plaza ocupada o null
     */
    private Plaza ocupaPlazaEnPlantaLibre(Planta planta){
        return planta.ocuparUnaPlazaEnCalleLibre();
    }


    /**
     * Ocupa una plaza determinada sin realizar ningún control
     * @param planta Planta
     * @param calle Calle
     * @param plaza Plaza a ocupar
     */
    private void ocupaUnaPlaza(int planta, int calle, int plaza){
        getPlaza(planta,calle,plaza).ocupar();
    }


    /**
     * Alquila una plaza determinada, sin realizar ningún control, a un Usuario
     * @param planta concreta
     * @param calle concreta
     * @param plaza concreta
     * @param u Usuario que realiza el alquiler
     */
    private void alquilaPlaza(int planta, int calle, int plaza, Usuario u){
        getPlaza(planta,calle,plaza).alquilar(u);
    }



    // Búsqueda de plazas ----------------------

    /**
     * Busca la primera Planta que tiene plazas libres
     * @return Una Planta con Plazas Libres
     */
    private Planta buscarPlantaLibre(){
        for (int i = 0; i < plantas.length; i++) {
            if (!plantas[i].isFullPlanta())
                return plantas[i];
        }
        return null;
    }

    /**
     * Obtiene una Plaza a partir de una Planta y del número de Plaza en la Planta
     * @param p Planta
     * @param n Número de Plaza en la Planta
     * @return la Plaza obtenida
     */
    public Plaza getPlaza(Planta p, int n){
        // Necesitamos calcular el número de Calle y el número de plaza en la Calle
        int nCalle = (n -1)/CALLES;
        int nPlaza = (n -1)%CALLES;
        return getPlaza(p.getNumero(),nCalle,nPlaza);
    }

    /**
     * Obtiene una Plaza a partir del número de Plaza, Calle y Plaza en la Calle
     * @param p Entero que define la Plaza
     * @param c Entero que defina la Calle
     * @param pz Entero que define la Plaza
     * @return Plaza
     */
    private Plaza getPlaza(int p, int c, int pz){
        return getUnaPlanta(p).getUnaCalle(c).getUnaPlaza(pz);
    }

    /**
     * Método que comprueba si el garaje está lleno, mirando si todas la plantas están ocupadas
     * @return Boolean
     */
    private boolean isFullGaraje(){
        for (int i = 0; i < plantas.length; i++) {
            if (!plantas[i].isFullPlanta())
                return false;
        }
        return true;
    }

    /**
     * Método que saca un Ticket. Compruba si hay alguna Plaza. Si es así asigna una Plaza Libre, Crea el Ticket y lo
     * imprime
     */
    public void sacarTicket(){
        if (!isFullGaraje()){
            Plaza p = asignaPlazaLibre();
            Ticket t = new Ticket(p.getCalle().getPlanta(),p.getCalle(),p);
            System.out.println(t);
        }else{
            System.out.println("¡GARAJE LLENO!");
        }
    }

    // Métodos para llenar aleatoriamente el garaje

    /**
     * Método que ocupa de forma aleatoria el garaje, según el procentaje que se le pase. Utiliza la Clase Random que
     * obtiene enteros sin repetición.
     * @param percent Entero que determina el porcentaje de ocupación
     */
    public void randomOcuppy(int percent) {
        for (int planta = 1; planta <= PLANTAS; planta++) {
            for (int calle = 1; calle <= CALLES; calle++) {
                Random rPlazas = new Random(PLAZAS);
                int k = 0;
                // Comprueba que no esté llena la Calle
                while (k < PLAZAS * percent / 100 && !getUnaPlanta(planta).getUnaCalle(calle).isFullStreet()) {
                    int plaza = rPlazas.getNumeroSinRepeticion();
                    if (getPlaza(planta, calle, plaza).isFree()) {
                        ocupaUnaPlaza(planta, calle, plaza);
                        k++;
                    }
                }
            }
        }
    }

    /**
     * Método que alquila de forma aleatoria el garaje, según el procentaje que se le pase. Utiliza la Clase Random que
     * obtiene enteros sin repetición. Se emplea un Ususario Fijo para todas las Plazas
     * @param percent Entero que determina el porcentaje de plazas alquiladas
     */
    public void randomRent(int percent){
        // Recorremos todas las Plantas
        for (int planta = 1; planta <= PLANTAS; planta++) {
            // recorremos cada Calle
            for (int calle = 1; calle <= CALLES; calle++) {
                Random rPlazas = new Random(PLAZAS);
                int k = 0;
                while (k < PLAZAS * percent / 100 && !getUnaPlanta(planta).getUnaCalle(calle).isFullStreet()){
                    Usuario u = new Usuario("65004204V","Garaje","Perico","S.L.","garaje","qwerty");
                    int plaza = rPlazas.getNumeroSinRepeticion();
                    if (getPlaza(planta,calle,plaza).isFree()) {
                        alquilaPlaza(planta,calle,plaza,u);
                        k++;
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        String output="";
        for (int i = 0; i < PLANTAS; i++) {
            output += "Planta " + (plantas[i].getNumero()) + "\n";
            output += plantas[i] + "\n\n\n";
        }
        return output;
    }
}
