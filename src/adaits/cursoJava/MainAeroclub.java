package adaits.cursoJava;

import adaits.cursoJava.Persona.Usuario;
import adaits.cursoJava.aeroclub.*;
import adaits.cursoJava.miscelaneas.Fecha;

import java.util.GregorianCalendar;


class MainAeroclub {
    public static void main(String[] args) {
        Marca cessna = new MarcaAvion("Cessna");
        Marca piper = new MarcaAvion("Pipper");
        Marca robinson = new MarcaHeli("Robinson");

        Modelo c152 = new ModeloAvion((MarcaAvion) cessna,"152");
        Modelo c172 = new ModeloAvion((MarcaAvion) cessna,"172");
        Modelo c172rg = new ModeloAvion((MarcaAvion) cessna,"172RG");
        Modelo r44 = new ModeloHeli((MarcaHeli) robinson,"44");
        Modelo pa28 = new ModeloAvion((MarcaAvion) piper,"PA 28");

        Aeronave ecjbg = new Avion("EC-JBG",c152);
        Aeronave ecqwe = new Avion("EC-QWE",c172);
        Aeronave ecpdf = new Helicoptero("EC-PDF",r44);
        Aeronave ecyth = new Avion("EC-YTH",pa28);

        Piloto pepe = new Socio("12345678G","Pepe","Pérez","Pi","qwerty","asdfg");
        Piloto paco = new Socio("12097678T","Paco","Paco","Quemepaco","qwerty","asdfg");

        pepe.habilitar(c152);

        Aeroclub pollo = new Aeroclub("El Pollo");
        pollo.addAeronave(ecjbg);
        pollo.addAeronave(ecqwe);
        pollo.addAeronave(ecpdf);
        pollo.addAeronave(ecyth);
        pollo.addUser(pepe);
        pollo.addUser(paco);

        pollo.listSocios();
        pollo.listAeronaves();

        Fecha horaIni = new Fecha(05,10,1961,15,00);
        Fecha horaFin = new Fecha(05,10,1961,17,30);
        pollo.reservar(pepe,ecjbg,horaIni,horaFin);
        pollo.reservar(pepe,ecpdf,new GregorianCalendar(2017,11,29,12,30),new GregorianCalendar(2017,11,29,11,0));

        System.out.println(pollo);
        pollo.listReservas();
    }
}
