package adaits.cursoJava.mvc.agenda.model;

import adaits.cursoJava.mvc.agenda.controller.Tarea;
import adaits.cursoJava.mvc.CRUDable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TareasWithArrayList implements ModelAgenda{
    private final ArrayList<Tarea> tareas;

    public TareasWithArrayList() {
        tareas = new ArrayList<>();
    }

    public Tarea getTarea (int i){
        return tareas.get(i);
    }

    @Override
    public String listTasks() {
        return null;
    }

    public int getSize (){
        return tareas.size();
    }

    @Override
    public void add(Object obj) {
        tareas.add((Tarea)obj);
    }

    @Override
    public int getIndex(Object obj) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).equals(obj)) return i;
        }
        return -1;    }

    @Override
    public Object seek(Object key) {
        for (Tarea tarea:tareas) {
            if (((Integer)tarea.getKey()).equals((Integer)key))
                return tarea;
        }
        return null;    }

    @Override
    public int delete(Object obj) {
        int i = getIndex(obj);
        if (i != -1) {
            tareas.remove(i);
        }
        return i;
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
