package adaits.cursoJava;

import adaits.cursoJava.geometria.*;

class Geometria {
    public static void main(String[] args){
        /*  Podemos hacer  final los objetos (final Punto p1) en el entendimiento de un objeto final no puede ser
            reasignado sin que de un error. Sin embargo el objeto sí puede cambiar sus atributos p1.setX(2);
         */
        Punto p1,p2,p3,p4;
        Linea l1, l2;
        Poligono pol1, pol2;

        // Creamos 4 puntos. Uno con coordenadas por defecto y resto con coordenadas explícitas
        p1 = new Punto();
        p2 = new Punto(2,3);
        p3 = new Punto(1,1);
        p4 = new Punto(4,1);


        // Los vemos en pantalla
        System.out.println("Punto p1 = " + p1);
        System.out.println("Punto p2 = " + p2);
        System.out.println("Punto p3 = " + p3);
        System.out.println("Punto p4 = " + p4);

        // Creamos 2 líneas, una (l2) con puntos por defectos y la otra (l1) con puntos explícitos
        l1 = new Linea(p1,p2);
        l2 = new Linea();
        System.out.println("Línea l2 = " + l2);
        // Copiamos la línea l1 en la l2
        l2 = l1;
        // Vemos las líneas en pantalla
        System.out.println("Línea l1 = " + l1);
        System.out.println("Línea l2 = " + l2);
        // Cambiamos el primer punto de la segunda línea por el punto p3
        l2.setP1(p3);
        // Vemos en pantalla la línea l2
        System.out.println("Línea l2 = " + l2);

        // Creamos dos arrays de puntos. Uno con los puntos p1, p2, p3 y otro con los puntos p1, p2, p3, p4
        Punto[] puntos1 = {p2,p1,p3};
        Punto[] puntos2 = {p1,p2,p3,p4};
        // Creamos dos polígonos uno por defecto y el otro a partir del segundo array
        pol1 = new Poligono();
        pol2 = new Poligono(puntos2);
        // Ver los dos polígonos
        System.out.println("Polígono pol1 = " + pol1);
        System.out.println("Polígono pol2 = " + pol2);
        // Actualizar el polígono 1
        pol1.setPuntos(puntos1);
        // Mover el 3º punto del 2º polígono al punto p4
        pol2.movePoint(2,p4);
        // Ver el polígono en pantalla
        System.out.println("Polígono pol1 = " + pol1);
        System.out.println("Polígono pol2 = " + pol2);

        System.out.println("Longitud de pol1 = " + pol1.dimTrack());
        System.out.println("Longitud de pol2 = " + pol2.dimTrack());
    }
}
