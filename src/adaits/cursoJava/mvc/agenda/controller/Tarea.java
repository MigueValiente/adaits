package adaits.cursoJava.mvc.agenda.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.util.Calendar.*;

public class Tarea {
    private String descripcion;
    private Calendar diaHoraInicio;
    private Calendar diaHoraFin;
    private int key = 0;
    private static int lastKey = 0;

    public Tarea(String descripcion, Calendar diaHoraInicio, Calendar diaHoraFin) {
        this.descripcion = descripcion;
        diaHoraInicio.roll(Calendar.MONTH,-1);
        this.diaHoraInicio = diaHoraInicio;
        diaHoraFin.roll(Calendar.MONTH,-1);
        this.diaHoraFin = diaHoraFin;
        key = lastKey++;
    }
    public Tarea(){
        this(getDescriptionScanner(),getDiaHoraInicioScanner(),getDiaHoraFinScanner());
    }
    private static String getDescriptionScanner(){
        Scanner input = new Scanner(System.in);
        System.out.print("Tarea: ");
        return input.nextLine();
    }

    private static Calendar getDiaHoraInicioScanner(){
        Scanner input = new Scanner(System.in);
        System.out.print("Fecha de Inicio:\nDia: ");
        int d = input.nextInt();
        System.out.println("Mes: ");
        int m = input.nextInt();
        System.out.println("Año: ");
        int y = input.nextInt();
        System.out.print("Hora de inicio:\nHora: ");
        int h = input.nextInt();
        System.out.println("Minutos: ");
        int min = input.nextInt();
        return new GregorianCalendar(y,m,d,h,min);
    }

    private static Calendar getDiaHoraFinScanner(){
        Scanner input = new Scanner(System.in);
        System.out.print("Fecha de Fin:\nDia: ");
        int d = input.nextInt();
        System.out.println("Mes: ");
        int m = input.nextInt();
        System.out.println("Año: ");
        int y = input.nextInt();
        System.out.print("Hora de fin:\nHora: ");
        int h = input.nextInt();
        System.out.println("Minutos: ");
        int min = input.nextInt();
        return new GregorianCalendar(y,m,d,h,min);
    }

    public int getKey() {
        return key;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getDiaHoraInicio() {
        return diaHoraInicio;
    }

    public void setDiaHoraInicio(Calendar diaHoraInicio) {
        this.diaHoraInicio = diaHoraInicio;
    }

    public Calendar getDiaHoraFin() {
        return diaHoraFin;
    }

    public void setDiaHoraFin(Calendar diaHoraFin) {
        this.diaHoraFin = diaHoraFin;
    }

    @Override
    public String toString() {
        String output = descripcion + "\n";
        String mes = diaHoraInicio.getDisplayName(Calendar.MONTH,Calendar.LONG, Agenda.idioma);
        String diaSemana = diaHoraInicio.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Agenda.idioma);
        int diaMes = diaHoraInicio.get(DATE);
        int year = diaHoraInicio.get(YEAR);
        output += diaSemana + ", " + diaMes + " de " + mes + " de " + year + "\n";
        int hIni = diaHoraInicio.get(HOUR_OF_DAY);
        int mIni = diaHoraInicio.get(MINUTE);
        String mIniStr = mIni < 10?"0"+mIni:mIni+"";
        int hFin = diaHoraFin.get(HOUR_OF_DAY);
        int mFin = diaHoraFin.get(MINUTE);
        String mFinStr = mFin < 10?"0"+mFin:mFin+"";
        output += hIni + ":" + mIniStr + " - " + hFin + ":" + mFinStr;

        return output;
    }
}
