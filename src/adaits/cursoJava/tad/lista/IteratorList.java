package adaits.cursoJava.tad.lista;

import adaits.cursoJava.tad.nodos.NodoL;

import java.util.Iterator;

class IteratorList implements Iterator<NodoL> {
    private final LinkedList lista;
    private NodoL posicionActual;

    public IteratorList(LinkedList lista) {
        posicionActual = new NodoL();
        posicionActual.setSiguiente(lista.inicio);
        this.lista = lista;
    }

    public NodoL getPosicionActual() {
        return posicionActual;
    }

    @Override
    public boolean hasNext() {
        return posicionActual != lista.ultimo ;
    }

    @Override
    public NodoL next() {
        //NodoL aux = posicionActual;
        posicionActual = posicionActual.getSiguiente();
        return posicionActual;
    }
}
