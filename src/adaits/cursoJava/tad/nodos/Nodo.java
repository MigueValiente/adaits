package adaits.cursoJava.tad.nodos;


public class Nodo {
    private final Object value;
    //private LinkedList adyacentes;

    Nodo(){
        value =null;
//        adyacentes = new LinkedList();
    }

    Nodo(Object value) {
        this.value = value;
        //adyacentes = new LinkedList();
    }

    public Nodo (Nodo n){
        value = n.value;
        //adyacentes = new LinkedList();
    }

    public Object getValue() {
        return value;
    }
//
//    public LinkedList getAdyacentes() {
//        return adyacentes;
//    }

    @Override
    public String toString() {
        return "(" + value.toString() + ")";
    }
}


