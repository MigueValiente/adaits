package adaits.cursoJava.miscelaneas.garaje;

public class Garaje {
    private Planta[] aparcamiento;
    public static   int PLANTAS;
    public static   int FILAS;
    public static   int COLUMNAS;

    public static int ocupacion;

    public Garaje(){
        PLANTAS = 3;
        FILAS = 10;
        COLUMNAS = 10;
        populate();
    }

    public Garaje(int PLANTAS, int FILAS, int COLUMNAS) {
        this.PLANTAS = PLANTAS;
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        populate();
    }

    private void populate(){
        aparcamiento = new Planta[PLANTAS];
        for (int i = 0; i < PLANTAS; i++) {
            aparcamiento[i] = new Planta(i,FILAS,COLUMNAS);
        }
    }

    public void asignaPlazaLibre(){
        Planta pLibre = buscarPlazaLibre();
        Fila fLibre = pLibre.buscaFilaLibre();
        Ubicacion libre = fLibre.buscaUbicacion();
        libre.ocupar();
    }

    public void asignaPlaza(int planta, int fila, int columna){
        aparcamiento[planta].getFilas()[fila].getPlazas()[columna].ocupar();
    }

    public boolean isFullGaraje(){
        for (int i = 0; i < aparcamiento.length; i++) {
            if (!aparcamiento[i].isFullPlanta())
                return false;
        }
        return true;
    }

    public Planta buscarPlazaLibre(){
        for (int i = 0; i < aparcamiento.length; i++) {
            if (aparcamiento[i].buscaFilaLibre() != null)
                return aparcamiento[i];
        }
        return null;
    }

    @Override
    public String toString() {
        String output="";
        for (int i = 0; i < PLANTAS; i++) {
            output += "Planta " + (aparcamiento[i].getNumero() +1) + "\n";
            output += aparcamiento[i] + "\n\n\n";
        }
        return output;
    }
}
