package adaits.cursoJava.tad.arbol;

import adaits.cursoJava.tad.nodos.NodoArbol;
import adaits.cursoJava.tad.nodos.NodoArbolAVL;

public class ArbolAVL extends ArbolB {


    public void insert(NodoArbolAVL nodo){
        setRoot((insert(nodo,(NodoArbolAVL)getRoot())));
    }


    public void insert(Comparable value){
        NodoArbolAVL nodo = new NodoArbolAVL(value);
        insert(nodo);
    }


    private NodoArbolAVL insert (NodoArbolAVL nodo, NodoArbolAVL padre){
        if (padre == null){
            return nodo;
        }else{
            if (nodo.compareTo(padre) == -1){
                padre.setLeft(insert(nodo,(NodoArbolAVL) padre.getLeft()));
                if( height((NodoArbolAVL) padre.getLeft() ) - height((NodoArbolAVL) padre.getRigth() ) == 2 )
                    if(nodo.compareTo(padre.getLeft()) < 0 )
                        padre = rotateWithLeftChild(padre);
                    else
                        padre = doubleWithLeftChild(padre);
            }
            if (nodo.compareTo(padre) == 1){
                padre.setRigth(insert(nodo,(NodoArbolAVL)padre.getRigth()));
                if( height((NodoArbolAVL) padre.getRigth() ) - height((NodoArbolAVL) padre.getLeft() ) == 2 )
                    if(nodo.compareTo(padre.getRigth()) > 0 )
                        padre = rotateWithRightChild(padre);
                    else
                        padre = doubleWithRightChild(padre);
            }
            padre.setAltura(max( height((NodoArbolAVL) padre.getLeft()), height((NodoArbolAVL) padre.getRigth()) ) + 1);
            return padre;
        }
    }

    private static NodoArbolAVL rotateWithLeftChild( NodoArbolAVL k2 ) {
        NodoArbolAVL k1 = (NodoArbolAVL)k2.getLeft();
        k2.setLeft(k1.getRigth());
        k1.setRigth(k2);
        k2.setAltura(max( height( (NodoArbolAVL)k2.getLeft()), height((NodoArbolAVL) k2.getRigth()) ) + 1);
        k1.setAltura(max( height((NodoArbolAVL)k1.getLeft()), k2.getAltura() ) + 1);
        return k1;
    }

    private static NodoArbolAVL rotateWithRightChild( NodoArbolAVL k2 ) {
        NodoArbolAVL k1 = (NodoArbolAVL)k2.getRigth();
        k2.setRigth(k1.getLeft());
        k1.setLeft(k2);
        k2.setAltura(max( height((NodoArbolAVL)k2.getLeft()), height((NodoArbolAVL) k2.getRigth()) ) + 1);
        k1.setAltura(max( height((NodoArbolAVL)k1.getRigth()), k2.getAltura() ) + 1);
        return k1;
    }

    private static NodoArbolAVL doubleWithLeftChild( NodoArbolAVL k3 ) {
        k3.setLeft(rotateWithRightChild((NodoArbolAVL) k3.getLeft()));
        return rotateWithLeftChild( k3 );
    }

    private static NodoArbolAVL doubleWithRightChild( NodoArbolAVL k3 ) {
        k3.setRigth(rotateWithLeftChild((NodoArbolAVL) k3.getRigth()));
        return rotateWithRightChild( k3 );
    }

    private static int max( int lhs, int rhs ) {
        return lhs > rhs ? lhs : rhs;
    }
    private static int height(NodoArbolAVL t ){
        return t == null ? -1 : t.getAltura();
    }
}
