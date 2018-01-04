package adaits.cursoJava;

import adaits.cursoJava.mvc.agenda.controller.Agenda;
import adaits.cursoJava.mvc.agenda.controller.Tarea;

import java.util.GregorianCalendar;

class MainAgenda {
    public static void main(String[] args) {
        Agenda a = new Agenda(2017);
        System.out.println(a);

        GregorianCalendar fechaABuscar = new GregorianCalendar(2013,10,5,17,5);

        Tarea t = new Tarea("Hacer algo",new GregorianCalendar(2017,10,5,17,5),new GregorianCalendar(2017,10,5,18,45));
        Tarea t1 = new Tarea("Hacer algo1",fechaABuscar,new GregorianCalendar(2017,10,5,18,45));
        Tarea t2 = new Tarea("Hacer algo2",new GregorianCalendar(2019,10,5,17,5),new GregorianCalendar(2017,10,5,18,45));
        Tarea t3 = new Tarea("Hacer algo3",new GregorianCalendar(2011,10,5,17,5),new GregorianCalendar(2017,10,5,18,45));
        Tarea t4 = new Tarea("Hacer algo4",new GregorianCalendar(2010,10,5,17,5),new GregorianCalendar(2017,10,5,18,45));

        a.addTarea(t);
        a.addTarea(t1);
        a.addTarea(t3);
        a.addTarea(t4);
        a.addTarea(t2);

        System.out.println(a.listTasks());

        System.out.println(a.seek(fechaABuscar));
    }
}
