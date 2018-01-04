package adaits.cursoJava.mvc.agenda.controller;

import adaits.cursoJava.mvc.agenda.model.ModelAgenda;
import adaits.cursoJava.mvc.agenda.model.NodoArbolTarea;
import adaits.cursoJava.mvc.agenda.model.TareasWithArbol;
import adaits.cursoJava.mvc.agenda.view.viewAgenda;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Agenda {
    private final ModelAgenda tareas;
    private final viewAgenda vista;
    private final controllerAgenda controlador;
    private final int year;
    public static Locale idioma;

    public Agenda(int year) {
        this.year = year;
        idioma = new Locale("es");
        tareas = new TareasWithArbol();
        vista = new viewAgenda();
        controlador = new controllerAgenda();
    }

    public void addTarea(Tarea tarea){
        tareas.add(tarea);
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
        int firstDay = fecha.get(Calendar.DAY_OF_WEEK);//
        if (firstDay == DOMINGO)
            output += "\t\t\t\t\t\t";
        else
            for (int i = 0; i < firstDay -2; i++) {
                output += "\t";
            }
        while(!fecha.equals(fechaFin)){
            output += fecha.get(Calendar.DATE)+"\t";
            if(fecha.get(Calendar.DAY_OF_WEEK)==GregorianCalendar.SUNDAY)
                output += "\n";
            fecha.add(Calendar.DATE,1);
        }
        return output;
    }

    public String listTasks(){
        return tareas.listTasks();
    }

    public ModelAgenda getTareas() {
        return tareas;
    }

    public Tarea seek (Calendar fecha){
        return ((NodoArbolTarea)tareas.seek(fecha)).getTarea();
    }

    @Override
    public String toString() {
        return printYear(year);
    }
}
