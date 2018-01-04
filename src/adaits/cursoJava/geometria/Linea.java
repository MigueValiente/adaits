package adaits.cursoJava.geometria;

public class Linea {
    //Atributos
    private Punto p1,p2;

    //Constructores
    public Linea() {
        Punto pIni = new Punto(0,0);
        Punto pFin = new Punto(0,0);
        setP1(pIni);
        setP2(pFin);
    }

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Setters
    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    private void setP2(Punto p2) {
        this.p2 = p2;
    }

    // Getters
    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public double distancia (){
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(),2) + Math.pow(p2.getY()-p1.getY(),2));
    }

    @Override
    public String toString() {
        return "{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
