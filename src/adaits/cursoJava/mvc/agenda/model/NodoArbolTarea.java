package adaits.cursoJava.mvc.agenda.model;

import adaits.cursoJava.mvc.agenda.controller.Tarea;
import adaits.cursoJava.tad.nodos.NodoArbol;
import adaits.cursoJava.tad.nodos.NodoArbolAVL;

public class NodoArbolTarea extends NodoArbolAVL {
    Tarea tarea;

    public NodoArbolTarea(Comparable value,Tarea tarea) {
        this(value,null,null,tarea);

    }

    public NodoArbolTarea(Comparable value, NodoArbol left, NodoArbol rigth, Tarea tarea) {
        super(value, left, rigth);
        this.tarea = tarea;
    }

    public Tarea getTarea() {
        return tarea;
    }
}

