package adaits.cursoJava.mvc.agenda.model;

import adaits.cursoJava.mvc.agenda.controller.Tarea;
import adaits.cursoJava.mvc.CRUDable;
import adaits.cursoJava.tad.arbol.ArbolAVL;
import adaits.cursoJava.tad.nodos.NodoArbol;
import adaits.cursoJava.tad.nodos.NodoArbolAVL;

import java.lang.reflect.Field;

public class TareasWithArbol extends ArbolAVL implements ModelAgenda{


    @Override
    public String listTasks() {
        return inOrden((NodoArbolTarea) getRoot());
    }

    public int getSize (){
        return 0;
    }

    @Override
    public Tarea getTarea(int key) {
        return null;
    }


    public void add(Object obj) {
        Tarea nuevaTarea = (Tarea) obj;
        NodoArbolTarea nodo = new NodoArbolTarea(nuevaTarea.getDiaHoraInicio(),nuevaTarea);
        insert(nodo);
    }

    @Override
    public int getIndex(Object obj) {
        return -1;
    }

    @Override
    public Object seek(Object key) {
        return findNode((Comparable) key);
    }

    @Override
    public int delete(Object obj) {
//        int i = getIndex(obj);
//        if (i != -1) {
//            tareas.remove(i);
//        }
        return 0;
    }

    private String inOrden(NodoArbolTarea nodo){
        String output = "";
        if (nodo.getLeft()!= null)
            output += inOrden((NodoArbolTarea) nodo.getLeft());
        output += (nodo.getTarea() + "\n");
        if (nodo.getRigth()!= null)
            output += inOrden((NodoArbolTarea)nodo.getRigth());
        return output;
    }

    @Override
    public void set(Object key, String campo, String valor) {
        Tarea tarea = (Tarea)this.seek(key);
        try {
            Class c = tarea.getClass();
            Field f = c.getDeclaredField(campo);
            f.setAccessible(true);
            f.set(tarea,valor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
