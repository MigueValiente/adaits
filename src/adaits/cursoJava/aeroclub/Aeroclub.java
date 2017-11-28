package adaits.cursoJava.aeroclub;

import adaits.cursoJava.Persona.Usuario;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Aeroclub {
    private String name;
    private Aeronave [] aeronaves = new Aeronave[10];
    private static int iAero = 0;
    private Usuario[] socios = new Usuario[50];
    private static int iSocio = 0;
    private Reserva [] reservas = new Reserva[100];
    private static int iRes = 0;

    public Aeroclub(String n) {
        name = n;
    }

    public void addUser(Usuario u){
        socios[iSocio] = u;
        iSocio++;
    }
    public void addAeronave(Aeronave a){
        aeronaves[iAero] = a;
        iAero++;
    }

    public void reservar(Usuario u, Aeronave av, GregorianCalendar ini, GregorianCalendar fin){
        reservas[iRes] = new Reserva(u,av,ini,fin);
        iRes++;
    }
    public void listSocios(){
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] == null) break;
            System.out.println(socios[i].getName() + " " + socios[i].getApellido1() + " " + socios[i].getApellido2());
        }
    }

    public void listAeronaves(){
        for (int i = 0; i < aeronaves.length; i++) {
            if (aeronaves[i] == null) break;
            System.out.println(aeronaves[i].getMatricula() + " " + aeronaves[i].getModelo().getMarca().getMarca() + " " + aeronaves[i].getModelo().getModelo());
        }
    }

    public void listReservas(){
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) break;
            int iDIA = reservas[i].getFhInicio().get(Calendar.DATE);
            int iMES = reservas[i].getFhInicio().get(Calendar.MONTH);
            int iYEAR = reservas[i].getFhInicio().get(Calendar.YEAR);
            int iHORA = reservas[i].getFhInicio().get(Calendar.HOUR_OF_DAY);
            int iMIN = reservas[i].getFhInicio().get(Calendar.MINUTE);
            int fDIA = reservas[i].getFhFin().get(Calendar.DATE);
            int fMES = reservas[i].getFhFin().get(Calendar.MONTH);
            int fYEAR = reservas[i].getFhFin().get(Calendar.YEAR);
            int fHORA = reservas[i].getFhFin().get(Calendar.HOUR_OF_DAY);
            int fMIN = reservas[i].getFhFin().get(Calendar.MINUTE);
            String fechaIni = iDIA + "/" + iMES + "/" + iYEAR + "-->" + iHORA + ":" + iMIN;
            String fechaFin = fDIA + "/" + fMES + "/" + fYEAR + "-->" + fHORA + ":" + fMIN;
            System.out.println(reservas[i].getSocio().getNombreYApellidos() + " " + reservas[i].getAeronave()+ " " + fechaIni + " " + fechaFin);
        }
    }

    @Override
    public String toString() {
        return "Aeroclub " + name ;
    }
}
