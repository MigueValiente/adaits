package adaits.cursoJava.tad.arbol;


import adaits.cursoJava.miscelaneas.Fecha;
import adaits.cursoJava.tad.nodos.Nodo;
import adaits.cursoJava.tad.nodos.NodoArbol;
import adaits.cursoJava.tad.nodos.NodoArbolAVL;

import java.util.ArrayList;

public class ArbolB {
    private NodoArbol root;


    public NodoArbol getRoot() {
        return root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(Comparable value){
        NodoArbol nodo = new NodoArbol(value);
        insert(nodo);
    }


    public void insert(NodoArbol nodo){
        root = insert(nodo,root);
    }

    private NodoArbol insert (NodoArbol nodo, NodoArbol padre){
        if (padre == null){
            return nodo;
        }else{
            if (nodo.compareTo(padre) == -1){
                padre.setLeft(insert(nodo,padre.getLeft()));
            }
            if (nodo.compareTo(padre) == 1){
                padre.setRigth(insert(nodo,padre.getRigth()));
            }
            return padre;
        }
    }

    public Comparable findMin(){
        return value(findMin (root));
    }

    public Comparable findMax(){
        return value(findMax (root));
    }

    private Comparable value(NodoArbol nodo){
        return nodo == null ? null : nodo.getValue();
    }

    private NodoArbol findMin(NodoArbol padre){
        NodoArbol result;
        if (padre == null)
            result = padre;
        else
        if (padre.getLeft() != null)
            result = findMin(padre.getLeft());
        else
            result = padre;
        return result;
    }

    private NodoArbol findMax(NodoArbol padre){
        NodoArbol result;
        if (padre == null)
            result = padre;
        else
        if (padre.getRigth() != null)
            result = findMax(padre.getRigth());
        else
            result = padre;
        return result;
    }

    public Comparable find( Comparable value )
    {
        return value(find(new NodoArbol(value), root ));
    }


    public NodoArbol findNode( Comparable value )
    {
        return find(new NodoArbol(value), root );
    }


    private NodoArbol find( NodoArbol nodo, NodoArbol padre )
    {
        NodoArbol result = padre;

        if (padre == null) result = null; // No match
        else {
            if (nodo.compareTo(padre) < 0)
                result = find(nodo, padre.getLeft());
            if (nodo.compareTo(padre) > 0)
                result = find(nodo, padre.getRigth());
        }
        return result;
    }

    public String printTree( )
    {
        if( isEmpty( ) )
            return ( "Empty tree" );
        else
            return printTree( root ,0);
    }

    private String printTree(NodoArbol t,int level ) {
        String output="";
        if( t != null ) {
            output += printNode(t,level);
            if (!t.esNodoHoja()) {
                level++;
                output += printTree(t.getLeft(), level);
                output += printTree(t.getRigth(), level);
            }
        }else{
            output += printNode(t,level);
        }
        return output;
    }

    private String printNode (NodoArbol nodo, int level){
        String output = "";
        for (int i = 1; i < level; i++) {
            output += ("\t");
        }
        if (level > 0)
            output += ("│_\t");
        else
            output += ("");
        if (nodo != null)
            output += (nodo + "\n");
        else
            output += "\n";
        return output;
    }


    public static void main(String[] args) {
        NodoArbol n = new NodoArbol(4);
        NodoArbol n1 = new NodoArbol(3);
        NodoArbol n2 = new NodoArbol(9);
        NodoArbol n3 = new NodoArbol(5);
        NodoArbol n4 = new NodoArbol(7);
        NodoArbol n5 = new NodoArbol(12);

        NodoArbol d1 = new NodoArbol(new Fecha(1961,10,5));
        NodoArbol d2 = new NodoArbol(new Fecha(1967,6,5));
        NodoArbol d3 = new NodoArbol(new Fecha(1961,5,5));
        NodoArbol d4 = new NodoArbol(new Fecha(1956,1,5));
        NodoArbol d5 = new NodoArbol(new Fecha(1952,6,5));
        NodoArbol d6 = new NodoArbol(new Fecha(1987,9,5));
        NodoArbol d7 = new NodoArbol(new Fecha(1945,10,5));
        ArbolB a = new ArbolB();
        ArbolB b = new ArbolB();
        ArbolAVL c = new ArbolAVL();

        a.insert(4);
        a.insert(3);
        a.insert(9);
        a.insert(5);
        a.insert(7);
        a.insert(12);
        a.insert(58);
        a.insert(62);
        a.insert(9);
        a.insert(23);
        a.insert(51);
        a.insert(60);
        a.insert(33);
        a.insert(67);
        a.insert(88);
        a.insert(11);
        a.insert(43);

        b.insert(d1);
        b.insert(d2);
        b.insert(d3);
        b.insert(d4);
        b.insert(d5);
        b.insert(d6);
        b.insert(d7);
        b.insert(new Fecha(1935,10,5));

        c.insert(4);
        c.insert(3);
        c.insert(9);
        c.insert(5);
        c.insert(7);
        c.insert(12);
        c.insert(58);
        c.insert(62);
        c.insert(9);
        c.insert(23);
        c.insert(51);
        c.insert(60);
        c.insert(33);
        c.insert(67);
        c.insert(88);
        c.insert(11);
        c.insert(43);

        c.postOrden(a.root);

        System.out.println();
        a.inOrden(a.root);
        System.out.println();
        a.preOrden(a.root);

        b.postOrden(b.root);
        System.out.println();
        b.inOrden(b.root);
        System.out.println();
        b.preOrden(b.root);

        c.postOrden(c.getRoot());
        System.out.println();
        c.inOrden(c.getRoot());
        System.out.println();
        c.preOrden(c.getRoot());

        System.out.println(((NodoArbolAVL)c.getRoot()).getAltura());

        System.out.println(a.findMin());
        System.out.println(a.findMax());
        System.out.println(b.findMin().toString());
        System.out.println(b.findMax().toString());

        System.out.println(a.find(52));

        a.printTree();
        b.printTree();
        c.printTree();


        ArbolB a1 = new ArbolB();
        ArbolAVL a2 = new ArbolAVL();

        for (int i = 0; i < 100; i++) {
            a1.insert(i);
            a2.insert(i);
        }

        a1.printTree();
        a2.printTree();
    }

    protected void postOrden(NodoArbol nodo) {
        if (nodo.getLeft()!= null)
            postOrden(nodo.getLeft());
        if (nodo.getRigth()!= null)
            postOrden(nodo.getRigth());
        System.out.println(nodo);
    }

    protected String inOrden(NodoArbol nodo){
        String output = "";
        if (nodo.getLeft()!= null)
            output += inOrden(nodo.getLeft());
        output += (nodo.toString() + "\n");
        if (nodo.getRigth()!= null)
            output += inOrden(nodo.getRigth());
        return output;
    }

    protected void preOrden(NodoArbol nodo){
        System.out.println(nodo);
        if (nodo.getLeft()!= null)
            preOrden(nodo.getLeft());
        if (nodo.getRigth()!= null)
            preOrden(nodo.getRigth());
    }
//
//    public ArrayList<NodoArbol> getArbolInOrden(){
//        ArrayList<NodoArbol>
//        return getArbolInOrden(root);
//    }
//
//
//    private ArrayList<NodoArbol> getArbolInOrden(NodoArbol nodo){
//
//    }

}
