package adaits.cursoJava.miscelaneas.Agenda;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Agenda {
    private Tarea [] tareas;
    private int year;
    public static Locale idioma;

    public Agenda(int year) {
        this.year = year;
        idioma = new Locale("es");
    }

    private String printYear(int y){
        String output = "";
        for (int i = 0; i < 12; i++) {
            output += printMes(y,i) + "\n";
        }
        return output;
    }

    private String printMes(int year, int mes){
        final int DOMINGO = 1;
        String output = "";
        Calendar fecha = new GregorianCalendar(year,mes,1);
        Calendar fechaFin = new GregorianCalendar(year,mes+1,1);
        String mesStr = fecha.getDisplayName(Calendar.MONTH,Calendar.LONG, idioma);
        output += "\n" + mesStr.toUpperCase() + "\n";
        output += "L\tM\tX\tJ\tV\tS\tD\n";
        int firstDay = fecha.get(fecha.DAY_OF_WEEK);//
        if (firstDay == DOMINGO)
            output += "\t\t\t\t\t\t";
        else
            for (int i = 0; i < firstDay -2; i++) {
                output += "\t";
            }
        while(fecha.equals(fechaFin)==false){
            output += fecha.get(fecha.DATE)+"\t";
            if(fecha.get(fecha.DAY_OF_WEEK)==GregorianCalendar.SUNDAY)
                output += "\n";
            fecha.add(fecha.DATE,1);
        }
        return output;
    }


    @Override
    public String toString() {
        return printYear(year);
    }
}
