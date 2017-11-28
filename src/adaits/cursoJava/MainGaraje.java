package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.garaje.*;

public class MainGaraje {
    public static void main(String[] args) {
        Garaje g = new Garaje();

        // Ocupación aleatoria
        int porcentajeOcupacion = 30;
        for (int i = 0; i <Garaje.PLANTAS*Garaje.FILAS* Garaje.COLUMNAS*porcentajeOcupacion/100 ; i++) {
            int planta = (int)(Math.random()*Garaje.PLANTAS);
            int fila = (int)(Math.random()*Garaje.FILAS);
            int col = (int)(Math.random()*Garaje.COLUMNAS);

            g.asignaPlaza(planta,fila,col);
        }
        System.out.println(g);
        while (!g.isFullGaraje())
            g.asignaPlazaLibre();
        System.out.println(g);

    }
}

