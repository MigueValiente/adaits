package adaits.cursoJava.tad.nodos;

public class NodoDL extends NodoL {
    private NodoL anterior;

    public NodoDL(Object value) {
        super(value);
        this.anterior = null;
    }


    public NodoDL() {
        super();
        anterior = null;
    }

    public NodoDL(NodoDL n) {
        super(n);
        anterior = n.getAnterior();
    }

    public void setAnterior(NodoL anterior) {
        this.anterior =  anterior;
    }

    public void setSiguiente(NodoDL siguiente) {
        this.siguiente = siguiente;
    }

    public NodoL getSiguiente (){
        return  siguiente;
    }

    public NodoL prev(NodoDL n){
        return n.getAnterior();
    }

    public NodoL getAnterior() {
        return anterior;
    }
}
