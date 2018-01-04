package adaits.cursoJava.tad.pila;

import adaits.cursoJava.tad.nodos.NodoL;
import adaits.cursoJava.tad.lista.LinkedList;

public class Stack extends LinkedList {
    public void push(Object obj){
        NodoL n = new NodoL(obj);
        this.insert(n);
    }

    public Object pop(){
        NodoL n = this.getInicio();
        this.deleteFirst();
        return n.getValue();
    }
}
