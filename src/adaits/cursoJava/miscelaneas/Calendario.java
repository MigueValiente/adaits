package adaits.cursoJava.miscelaneas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calendario {
    public static void main(String[] args) {
        Calendar fecha = new GregorianCalendar(2017,0,21);
        Locale idioma = new Locale("es");


        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String mes = fecha.getDisplayName(Calendar.MONTH,Calendar.LONG, idioma);
        int anno = fecha.get(Calendar.YEAR);

        System.out.println(dia + " de " + mes + " de " + anno);

        // Modificamos la fecha sumando meses
        fecha.add(Calendar.MONTH,3);
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.getDisplayName(Calendar.MONTH,Calendar.LONG, idioma);
        anno = fecha.get(Calendar.YEAR);

        System.out.println(dia + " de " + mes + " de " + anno);

    }
}