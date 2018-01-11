package adaits.cursoJava;

import adaits.cursoJava.aeroclub.*;
import adaits.cursoJava.miscelaneas.Fecha;

import java.util.GregorianCalendar;


class MainAeroclub {
    public static void main(String[] args) {
        MarcaAvion cessna = new MarcaAvion("Cessna");
        MarcaAvion piper = new MarcaAvion("Pipper");
        MarcaHeli robinson = new MarcaHeli("Robinson");

        ModeloAvion c152 = new ModeloAvion( cessna,"152");
        ModeloAvion c172 = new ModeloAvion(cessna,"172");
        ModeloAvion c172rg = new ModeloAvion( cessna,"172RG");
        ModeloHeli r44 = new ModeloHeli( robinson,"44");
        ModeloAvion pa28 = new ModeloAvion( piper,"PA 28");

        Aeronave ecjbg = new Avion("EC-JBG",c152);
        Aeronave ecqwe = new Avion("EC-QWE",c172);
        Aeronave ecpdf = new Helicoptero("EC-PDF", r44);
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
        Fecha horaIni2 = new Fecha(05,10,1961,16,00);
        Fecha horaFin2 = new Fecha(05,10,1961,17,20);
        Fecha horaIni3 = new Fecha(05,10,1961,15,00);
        Fecha horaFin3 = new Fecha(05,10,1961,10,30);
        pollo.reservar(pepe,ecjbg,horaIni,horaFin);
        pollo.reservar(pepe,ecjbg,horaIni2,horaFin2);
        pollo.reservar(pepe,ecjbg,horaIni3,horaFin3);
        pollo.reservar(pepe,ecpdf,new GregorianCalendar(2017,11,29,12,30),new GregorianCalendar(2017,11,29,13,0));

        System.out.println(pollo);
        pollo.listReservas();
    }
}
