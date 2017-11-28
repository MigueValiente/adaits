package adaits.cursoJava;

import adaits.cursoJava.Persona.Usuario;
import adaits.cursoJava.miscelaneas.garaje.Garaje;

public class MainGaraje {
    public static void main(String[] args) {
        Garaje g = new Garaje(2,3,20);

        // Ocupación aleatoria
        int porcentajeOcupacion = 30;
        for (int i = 0; i <Garaje.PLANTAS*Garaje.FILAS* Garaje.COLUMNAS*porcentajeOcupacion/100 ; i++) {
            int planta = (int)(Math.random()*Garaje.PLANTAS);
            int fila = (int)(Math.random()*Garaje.FILAS);
            int col = (int)(Math.random()*Garaje.COLUMNAS);

            g.asignaPlaza(planta,fila,col);
        }

        for (int i = 0; i < 50; i++) {
            Usuario u = new Usuario("27271949K","PP","ESpejo","Roig","espejor","qwerty");
            g.buscarAparcamientoLibre().alquilar(u);
        }

        System.out.println(g);



    }
}

