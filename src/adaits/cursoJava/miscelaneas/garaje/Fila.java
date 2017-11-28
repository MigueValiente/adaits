package adaits.cursoJava.miscelaneas.garaje;


public class Fila {
    private int numero;
    private Ubicacion[] plazas;

    public Fila (int f, int ub){
        numero = f;
        plazas = new Ubicacion[ub];
        for (int i = 0; i < ub; i++) {
            plazas[i] = new Ubicacion(i);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Ubicacion[] getPlazas() {
        return plazas;
    }

    public boolean isFullRow(){
        for (int i = 0; i < plazas.length; i++) {
            if (!(plazas[i].isOcupado()) && !(plazas[i].isAlquilado())) // si no está ocuado ni alquilado
                return false;
        }
        return true;
    }

    public Ubicacion buscaUbicacion() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i].isFree())
                return plazas[i];
        }
        return null;
    }

    @Override
    public String toString() {
        String output ="";
        for (int i = 0; i < plazas.length; i++) {
            output += plazas[i] + " ";
        }
        return output;
    }
}
