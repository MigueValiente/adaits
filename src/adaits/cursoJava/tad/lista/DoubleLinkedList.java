package adaits.cursoJava.tad.lista;

import adaits.cursoJava.tad.nodos.NodoDL;
import adaits.cursoJava.tad.nodos.NodoL;

public class DoubleLinkedList extends LinkedList {


    public DoubleLinkedList(NodoDL n) {
        setInicio(n);
        setUltimo(n);
    }

    public DoubleLinkedList(Object o) {
        NodoL n = new NodoDL(o);
        super.add(n);

    }


    @Override
    public void add(Object o) {
        NodoL n = new NodoDL(o);
        add(n);
    }

    public void add(NodoDL n){
        n.setAnterior(ultimo);
        super.add(n);
    }

    public NodoL prev(NodoDL n){
        return (n.getAnterior());
    }

    public void deletePrev(NodoDL n){
        ((NodoDL)n.getAnterior()).getAnterior().setSiguiente(n);
        ((NodoDL)n.getSiguiente()).setAnterior(((NodoDL)n.getAnterior()).getAnterior());
        size--;
    }


    public void delete(NodoDL n){
        n.getAnterior().setSiguiente(n.getSiguiente());
        ((NodoDL)n.getSiguiente()).setAnterior(n.getAnterior());
        size--;
    }
}
