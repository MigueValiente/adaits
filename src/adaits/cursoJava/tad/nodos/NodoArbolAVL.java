package adaits.cursoJava.tad.nodos;

public class NodoArbolAVL extends NodoArbol{

    int altura;

    public NodoArbolAVL(Comparable value) {
        this(value,null,null);
    }

    public NodoArbolAVL(Comparable value, NodoArbol left, NodoArbol rigth) {
        super(value, left, rigth);
        this.altura = 0;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
