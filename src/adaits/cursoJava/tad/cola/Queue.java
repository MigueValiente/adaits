package adaits.cursoJava.tad.cola;

import adaits.cursoJava.tad.nodos.NodoL;
import adaits.cursoJava.tad.lista.LinkedList;

public class Queue extends LinkedList {


    public void enqueue(Object obj){
        NodoL n = new NodoL(obj);
        this.add(n);
    }

    public Object dequeue(){
        NodoL n = this.getInicio();
        this.deleteFirst();
        return n.getValue();
    }
}
