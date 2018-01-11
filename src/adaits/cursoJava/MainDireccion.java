/**
 * La Clase Dirección incluirá el Código postal, La Calle y el número del domicilio.
 * Del Código Postal, que representa un área que cubre total o parcialmente una Localidad, se deberá conocer su número,
 * la Localidad a la que pertenece y todas las Direcciones que tengan ese código postal.
 * De La Calle es necesario conocer su nombre y el Tipo de Calle.
 * El Tipo de Calle podrá ser de alguno de estos 4 tipos: Calle, Avenida, Plaza o Ronda y además, para cada uno de esos
 * tipos, se dispondrá de una abreviatura que nos sirva para cuando se desee su impresión.
 * De la Localidad se necesita conocer su nombre, la Provincia a la que pertenece y la relación de códigos postales
 * incluidos en ella, que serán uno o más.
 * De la Provincia se deberá conocer un código, que se corresponde con los dos primeros dígitos del código postal
 * (41 para Sevilla), el nombre  de la Provincia y la relación de todas las Localidades incluidas en dicha Provincia.
 */


package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.direccion.*;
import adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia.Tipo;
import adaits.cursoJava.miscelaneas.direccion.factoryTipoDeVia.TipoFactory;

class MainDireccion {
    public static void main(String[] args) {

        LecturaDeDatos entrada = new LecturaDeDatos();
        Calle c9 = entrada.leerCalle();

        TipoCalle av = TipoCalle.AVENIDA;
        TipoCalle c = TipoCalle.CALLE;

        // Empleando la factory de tipo de calle
        TipoFactory factory = new TipoFactory();
        Tipo r = factory.getTipo(TipoFactory.AVENIDA);

        // Creamos una Provincia
        Provincia sevillaP = new Provincia(41,"Sevilla");

        // Creamos un par de Localidades de la Provincia ya creada
        Localidad sevillaL = new Localidad("Sevilla",sevillaP);
        Localidad tomares = new Localidad("Tomares",sevillaP);

        // Creamos las Calles con su tipo
        Calle c1 = new Calle(av,"La Ola");
        Calle c3 = new Calle(c,"Gato");
        Calle c2 = new Calle(c,"Reina Mercedes");

        // Creamos los Códigos Postales indicándoles las Localidades a las que pertenecen
        CP cp012 = new CP(12,sevillaL);
        CP cp011 = new CP(11,sevillaL);
        CP cp940 = new CP(940,tomares);

        // Creamos las Direcciones con su CP, las Calles y sus números
        Direccion d1 = new Direccion(cp940,c1,77);
        new Direccion(cp940,c1,75);
        new Direccion(cp012,c2,50);
        new Direccion(cp011,c3,22);
        new Direccion(cp012,c9,1);
        new Direccion(cp012,new Calle(c,"La Pera"),3);

        // Vemos una dirección
        System.out.println(d1.getFullDireccion());

        // Listamos las Direcciones de todas las Localidades de la Provincia sevillaP
        sevillaP.listarLocalidades();
    }
}
