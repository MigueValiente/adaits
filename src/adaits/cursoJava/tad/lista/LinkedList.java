package adaits.cursoJava.tad.lista;

import adaits.cursoJava.tad.nodos.NodoL;

import java.util.Iterator;

public class LinkedList implements Iterable<NodoL> {

    NodoL inicio = null;
    NodoL ultimo = null;
    int size = 0;


    public LinkedList(Object o){
        NodoL n = new NodoL(o);
        add(n);
    }

    public LinkedList() {
    }

    public int size() {
        return size;
    }

    void setInicio(NodoL inicio) {
        this.inicio = inicio;
    }

    void setUltimo(NodoL ultimo) {
        this.ultimo = ultimo;
    }

    public NodoL getInicio() {
        return inicio;
    }

    protected NodoL getUltimo() {
        return ultimo;
    }

    public boolean isEmpty(){
        return (inicio == null);
    }

    /**
     * Borra el nodo siguiente al nodo del parámetro
     * @param n NodoL
     */
    protected void deleteNext(NodoL n){
        n.setSiguiente(n.getSiguiente().getSiguiente());
        size--;
    }

    public  void deleteFirst(){
        inicio = inicio.getSiguiente();
        size--;
    }


    protected void add(NodoL n){
        if (isEmpty()) {
            inicio = n;
            ultimo = inicio;
        }else {
            ultimo.setSiguiente(n);
            ultimo = n;
        }
        size++;
    }

    public void add(Object o){
        if (o.getClass().getSimpleName().equals("NodoL"))
            add((NodoL)o);
        else {
            NodoL n = new NodoL(o);
            add(n);
        }
    }

    private void insert(NodoL lugar, NodoL nuevoNodo){
        nuevoNodo.setSiguiente(lugar.getSiguiente());
        lugar.setSiguiente(nuevoNodo);
        size++;
    }

    protected void insert (NodoL lugar, Object obj){
        NodoL n = new NodoL(obj);
        insert(lugar, n);
    }

    /**
     * Inaerta un NodoL al principio de la Lista
     * @param n NodoL
     */
    public void insert(NodoL n){
        n.setSiguiente(inicio);
        if (isEmpty()) {
            ultimo = n;
        }
        inicio = n;
        size++;
    }

    private NodoL next(NodoL n){
        return n.getSiguiente();
    }

    protected boolean endList(NodoL n){
        return (n.getSiguiente() == null);
    }

    @Override
    public String toString() {
        String output = "";
        NodoL n = inicio;
        while (n != null){
            output += n + " ";
            n = this.next(n);
        }
        return output;
    }

    @Override
    public Iterator<NodoL> iterator() {
        return new IteratorList(this);
    }

}
