package adaits.cursoJava.estructurasDeDatos;

import java.util.ArrayList;

public class Nodo {
    private String value;
    private ArrayList<Nodo> adyacentes;

    public Nodo(){
        value ="";
    }

    public Nodo(String value) {
        this.value = value;
    }

    public Nodo (Nodo n){
        value = n.value;
    }
}
