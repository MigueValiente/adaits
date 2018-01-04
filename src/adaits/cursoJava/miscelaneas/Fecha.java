package adaits.cursoJava.miscelaneas;

import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar {

    public Fecha (int day,int month,int year){
        super(year,month,day);
    }
    public Fecha (int day,int month,int year,int hora, int min){
        super(year,month,day,hora,min);
    }

    @Override
    public String toString() {
        return getTime().toString();
    }
}
