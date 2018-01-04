package adaits.cursoJava.miscelaneas.garaje;

/**
 * Cada planta tendrá una o más calles, todas las plantas son iguales.
 * Las plantas estarán numeradas desde 1 hasta p (no desde 0)  y debemos poder saber si están llenas.
 *
 */
public class Planta {
    private final int numero;
    private final Calle[] calles;
    private final Garaje garaje;

    /**
     * Constructor de la Planta que requiere el garaje al que pertenece, El número de Planta asignado, las Calles que
     * va a tener y las Plazas por Calle que va a tener
     * @param g Garaje al que pertenece
     * @param n Número de Planta en el Garaje
     * @param calles Número de Calles que tiene la Planta
     * @param plazas Número de Plazas que tiene cada Calle
     */
    public Planta(Garaje g, int n,int calles,int plazas) {
        garaje = g;
        numero = n;
        this.calles = new Calle[calles];
        for (int i = 0; i < calles; i++) {
            this.calles[i] = new Calle(this,i + 1,plazas);
        }
    }

    public int getNumero() {
        return numero;
    }

    /**
     * Método que devuelve una calle
     * @param n Número de la calle
     * @return Calle buscada
     */
    public Calle getUnaCalle(int n){
        return calles[n-1];
    }

    /**
     * Método que comprueba si una Planta está completa
     * @return Boolean
     */
    public boolean isFullPlanta(){
        for (int i = 0; i < calles.length; i++) {
            if (!calles[i].isFullStreet())
                return false;
        }
        return true;
    }

    /**
     * Método que busca una Calle libre en la Planta
     * @return Calle Libre o null si no la encuentra
     */
    private Calle buscaCalleLibre(){
        for (int i = 0; i < calles.length; i++) {
            if (!calles[i].isFullStreet()){
                return calles[i];
            }
        }
        return null;
    }

    /**
     * Método que busca una Calle donde haya Plazas libres y ocupa una Plaza libre en esa Calle
      * @return La Plaza Ocupada
     */
    public Plaza ocuparUnaPlazaEnCalleLibre(){
        Calle c = buscaCalleLibre();
        if (c != null)
            return c.ocuparUnaPlazaLibre();
        return null;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < garaje.getPLAZAS(); i++) {
            output += "__";
        }
        output += "_\n";
        // Para cada calle
        for (int i = 0; i < calles.length; i++) {
            output += calles[i] + "\n";
            if (i%2 == 0)
                output += "\n";
        }
        for (int i = 0; i < garaje.getPLAZAS(); i++) {
            output += "¯¯";
        }
        output += "¯\n";
        return output;
    }
}
