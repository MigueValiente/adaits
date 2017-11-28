package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.Agenda.Agenda;
import adaits.cursoJava.miscelaneas.Agenda.Tarea;

import java.util.GregorianCalendar;

public class MainAgenda {
    public static void main(String[] args) {
        Agenda a = new Agenda(2017);
        System.out.println(a);

        Tarea t = new Tarea("Hacer algo",new GregorianCalendar(2017,10,5,17,5),new GregorianCalendar(2017,10,5,18,45));
        Tarea t2 = new Tarea();
        System.out.println(t);
        System.out.println(t2);
    }
}
