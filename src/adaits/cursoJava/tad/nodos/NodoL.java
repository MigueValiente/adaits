package adaits.cursoJava.tad.nodos;

public class NodoL extends Nodo {
    NodoL siguiente;

    public NodoL(Object value) {
        super(value);
        this.siguiente = null;
    }

    public NodoL(){
        super();
        siguiente = null;
    }
    NodoL(NodoL n){
        super(n);
        siguiente = n.getSiguiente();
    }

    public NodoL getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoL siguiente) {
        this.siguiente = siguiente;
    }

    public NodoL next(NodoL n){
        return n.getSiguiente();
    }
}
