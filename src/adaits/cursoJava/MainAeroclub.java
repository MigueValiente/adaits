package adaits.cursoJava;

import adaits.cursoJava.Persona.Usuario;
import adaits.cursoJava.aeroclub.*;

import java.util.GregorianCalendar;


public class MainAeroclub {
    public static void main(String[] args) {
        TipoAeronave avioneta = new TipoAeronave("Avioneta");
        TipoAeronave helicoptero = new TipoAeronave("Helicoptero");

        Marca cessna = new Marca("Cessna",avioneta);
        Marca pipper = new Marca("Pipper",avioneta);
        Marca robinson = new Marca("Robinson",helicoptero);

        Modelo c152 = new Modelo(cessna,"152");
        Modelo c172 = new Modelo(cessna,"172");
        Modelo c172rg = new Modelo(cessna,"172RG");
        Modelo r44 = new Modelo(robinson,"44");

        Aeronave ecjbg = new Aeronave("EC-JBG",c152);
        Aeronave ecqwe = new Aeronave("EC-QWE",c172);

        Usuario pepe = new Usuario("12345678G","Pepe","Pérez","Pi","qwerty","asdfg");
        Usuario paco = new Usuario("12097678T","Paco","Paco","Quemepaco","qwerty","asdfg");

        Aeroclub pollo = new Aeroclub("El Pollo");
        pollo.addAeronave(ecjbg);
        pollo.addAeronave(ecqwe);
        pollo.addUser(pepe);
        pollo.addUser(paco);

        pollo.listSocios();
        pollo.listAeronaves();

        pollo.reservar(pepe,ecjbg,new GregorianCalendar(2017,11,27,15,30),new GregorianCalendar(2017,11,27,17,0));
        pollo.reservar(pepe,ecjbg,new GregorianCalendar(2017,11,29,12,30),new GregorianCalendar(2017,11,29,11,0));

        System.out.println(pollo);
        pollo.listReservas();
    }
}
