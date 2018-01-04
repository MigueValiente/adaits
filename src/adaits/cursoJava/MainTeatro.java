package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.teatro.Teatro;
import adaits.cursoJava.miscelaneas.teatro.Zona;

class MainTeatro {
    public static void main(String[] args) {
        Zona vip = new Zona(3,20);
        Zona patio = new Zona(10,30);
        Zona terraza = new Zona(5,36);
        Zona paraiso = new Zona(2,32);

        vip.setPrecio(100.5);
        patio.setPrecio(80.75);
        terraza.setPrecio(65.05);
        paraiso.setPrecio(42.0);

        Zona[] zonas = {vip,patio,terraza,paraiso};
        Teatro t = new Teatro(zonas);

        t.ocupar(vip,2,0);
        t.reservar(terraza,0,4);
        t.romper(terraza,2,27);
        t.liberar(vip, 2, 1);
        t.ocupar(paraiso,0,0);

        t.ocupar(29);
        t.reservar(1112);
        t.romper(2006);
        t.liberar(40);
        t.ocupar(3019);

        t.populateRandom();

        double recaudacion = t.caja();
        System.out.println(t);

        System.out.println("La recaudación hasta ahora es " + recaudacion);

        //t.listarTeatro();

    }
}
