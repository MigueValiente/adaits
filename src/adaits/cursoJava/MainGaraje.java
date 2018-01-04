package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.garaje.*;

class MainGaraje {
    public static void main(String[] args) {
        Garaje g = new Garaje(2,3,20);

        // Ocupación aleatoria
        g.randomRent(20);

        g.randomOcuppy(30);


        System.out.println(g);

        g.sacarTicket();

        System.out.println(g);

    }
}

