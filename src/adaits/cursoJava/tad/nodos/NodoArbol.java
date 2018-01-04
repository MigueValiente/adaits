package adaits.cursoJava.tad.nodos;

import adaits.cursoJava.tad.arbol.ObjectSortable;

import java.util.GregorianCalendar;

public class NodoArbol extends Nodo implements Comparable{
    private NodoArbol left,rigth;
    private final Comparable value;


    public NodoArbol(Comparable value) {
        this(value,null,null);
    }

    public NodoArbol( Comparable value, NodoArbol left, NodoArbol rigth) {
        this.left = left;
        this.rigth = rigth;
        this.value = value;
    }

    @Override
    public Comparable getValue() {
        return value;
    }

    public void setLeft(NodoArbol left) {
        this.left = left;
    }

    public void setRigth(NodoArbol rigth) {
        this.rigth = rigth;
    }

    public NodoArbol getLeft() {
        return left;
    }

    public NodoArbol getRigth() {
        return rigth;
    }
//
//    public void insert(NodoArbol newNode){
//        Comparable valueRootNode =  this.value;
//        Comparable valueNewNode =  newNode.value;
//        if (valueRootNode.compareTo(valueNewNode) == 1){
//            left = newNode;
//        }else {
//            rigth = newNode;
//        }
//    }
//
    public boolean esNodoHoja(){
        return this.rigth == null && left == null;
    }

    @Override
    public String toString() {
        if (this.value.getClass().getSimpleName().equals("GregorianCalendar")){
            return ((GregorianCalendar)(this.value)).getTime().toString();
        }
        return value.toString();
    }

    @Override
    public int compareTo(Object o) {
        return  (this.value.compareTo(((NodoArbol)o).value));
    }
}
