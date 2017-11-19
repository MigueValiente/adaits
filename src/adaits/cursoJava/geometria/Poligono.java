package adaits.cursoJava.geometria;

public class Poligono {
    // Atributos
    private int lados;
    private Punto[] puntos;

    // Constructores
    public Poligono() {
        lados = 3;
        puntos = new Punto[lados];
        for (int i=0; i < lados; i++){
            puntos[i] = new Punto();
        }
    }

    public Poligono(int lados, Punto[] puntos) {
        this.lados = lados;
        this.puntos = puntos;
    }

    public Poligono(Punto[] puntos) {
        lados = puntos.length;
        this.puntos = puntos;
    }

    //Setters
    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }

    //Getters
    public Punto[] getPuntos() {
        return puntos;
    }

    // Métodos
    public void movePoint(int orden, Punto destino){
        if (orden < lados)
            puntos[orden] = destino;
    }

    public double dimTrack(){
        double longitud=0;
        Punto last = new Punto(puntos[0]);
        for (int i = 1; i < this.lados; i++){
            Linea l = new Linea(puntos[i-1],puntos[i]);
            longitud += l.distancia();
        }
        return longitud;
    }

    @Override
    public String toString() {
        String salida = "[";
        for (int i = 0; i < lados; i++){
            salida += puntos[i] + ((i < lados-1)?", ":"");
        }
        salida += "]";
        return  salida;
    }
}
