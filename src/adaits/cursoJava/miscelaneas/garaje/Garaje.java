package adaits.cursoJava.miscelaneas.garaje;

import adaits.cursoJava.Persona.Usuario;

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
        Planta pLibre = buscarPlantaLibre();
        Fila fLibre = pLibre.buscaFilaLibre();
        Ubicacion libre = fLibre.buscaUbicacion();
        libre.ocupar();
    }

    public Ubicacion buscarAparcamientoLibre(){
        return buscarPlantaLibre().buscaFilaLibre().buscaUbicacion();
    }

    public void asignaPlaza(int planta, int fila, int columna){
        aparcamiento[planta].getFilas()[fila].getPlazas()[columna].ocupar();
    }

    public void reservaPlaza(Usuario u, int planta, int fila, int columna){
        aparcamiento[planta].getFilas()[fila].getPlazas()[columna].alquilar(u);
    }

    public boolean isFullGaraje(){
        for (int i = 0; i < aparcamiento.length; i++) {
            if (!aparcamiento[i].isFullPlanta())
                return false;
        }
        return true;
    }

    public Planta buscarPlantaLibre(){
        for (int i = 0; i < aparcamiento.length; i++) {
            if (aparcamiento[i].buscaFilaLibre() != null)
                return aparcamiento[i];
        }
        return null;
    }

    public void listUsers(){

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
