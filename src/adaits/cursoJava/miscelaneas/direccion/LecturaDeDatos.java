package adaits.cursoJava.miscelaneas.direccion;

import java.util.Scanner;

public class LecturaDeDatos {
    public Provincia leerProvincia(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la Provincia: ");
        String name = input.nextLine();
        System.out.println("Introduzca el código de la Provincia " + name);
        int code = input.nextInt();
        return new Provincia(code,name);
    }
    public Localidad leerLocalidad(Provincia p){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca un nombre de Localidad perteneciente a la provincia " + p.getNombreProvincia());
        String name = input.nextLine();
        return new Localidad(name,p);
    }

    private TipoCalle defineTipoCalle(String calle){
        return TipoCalle.whatTipe(calle);
    }
    public Calle leerCalle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca tipo de la calle (Avenida, Calle, Plaza, Ronda, Carretera): ");
        String tipo = input.nextLine();

        System.out.println("Introduzca el nombre de la calle: ");
        String name = input.nextLine();
        return new Calle(defineTipoCalle(tipo), name);
    }
}
