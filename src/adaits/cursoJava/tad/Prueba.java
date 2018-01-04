package adaits.cursoJava.tad;

import adaits.cursoJava.tad.cola.Queue;
import adaits.cursoJava.tad.lista.DoubleLinkedList;
//import adaits.cursoJava.tad.lista.IteratorList;
import adaits.cursoJava.tad.lista.LinkedList;
import adaits.cursoJava.tad.nodos.NodoDL;
import adaits.cursoJava.tad.nodos.NodoL;
import adaits.cursoJava.tad.pila.Stack;

import java.util.Iterator;

class Prueba{
    public static void main(String[] args) {
        String value = "Nodo 1";
        NodoL n = new NodoL(value);
        NodoL n2 = new NodoL("Nodo 2");

        LinkedList l = new LinkedList("Inicio");



        l.add(n2);
        //l.insert(n,new NodoL("Nodo 15"));
        l.insert(new NodoL("Nodo 0"));

        System.out.println(l);

        LinkedList l2 = new LinkedList();
        System.out.println(l2.isEmpty());

        l2.add("Otro inicio");
        System.out.println(l2.isEmpty());

        Stack pila = new Stack();

        pila.push("Apilado 1");
        pila.push("Apilado 2");
        pila.push("Nodo 3");
        pila.push("Nodo 4");

        System.out.println(pila);

        pila.pop();
        System.out.println(pila);
        Iterator itr = l2.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        Queue q = new Queue();
        q.enqueue("Encolado 1");
        q.enqueue("Encolado 2");
        q.enqueue("Encolado 3");
        q.enqueue("Encolado 4");
        System.out.println(q);

        q.dequeue();
        System.out.println(q);

        int n1 = 100;
        DoubleLinkedList dll = new DoubleLinkedList(100);
        System.out.println(dll.size());
        dll.add(200);
        System.out.println(dll.size());
        dll.add(300);
        System.out.println(dll.size());
        dll.add(400);
        System.out.println(dll.size());
        dll.add(500);
        System.out.println(dll.size());
        System.out.println(dll);

        NodoL ndl =  dll.getInicio();
        System.out.println(ndl);
        //System.out.println(dll.prev(dll.next(dll.next(dll.getInicio()))));

        //dll.deleteNext(dll.getInicio().getSiguiente().getSiguiente());
        System.out.println(dll);
    }
}


