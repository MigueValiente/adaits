package adaits.cursoJava.mvc.agenda.model;

import adaits.cursoJava.mvc.CRUDable;
import adaits.cursoJava.mvc.agenda.controller.Tarea;

public interface ModelAgenda extends CRUDable {
    @Override
    public abstract void add(Object obj);

    @Override
    public abstract int getIndex(Object obj);

    @Override
    public abstract Object seek(Object key);

    @Override
    public abstract int delete(Object obj);

    @Override
    public abstract void set(Object key, String campo, String valor);

    public abstract int getSize();

    public abstract Tarea getTarea(int key);

    public abstract String listTasks();
}
