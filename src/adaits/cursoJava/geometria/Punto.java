package adaits.cursoJava.geometria;

public class Punto {
    //Atributos
    private double x,y;

    //Constructores
    public Punto(){
        x=0;
        y=0;
    }

    public Punto(Punto p){
        x = p.x;
        y = p.y;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
