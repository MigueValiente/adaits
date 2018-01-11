package adaits.cursoJava.miscelaneas.teatro;

import javax.swing.plaf.PanelUI;

import static adaits.cursoJava.miscelaneas.teatro.State.OCUPADA;

class Butaca {
//    final public static int LIBRE = 0;
//    final public static int OCUPADA = 1;
//    final public static int RESERVADA = 2;
//    final public static int ROTA = 3;
    //private int state = 0;
    private int numero;
    private double precio;
    private State state;

    public Butaca(int n) {
        numero = n;
        state = State.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private void ocupar(){
        if (state.equals(State.LIBRE))
            state = State.OCUPADA;
        else
            System.out.println("No es posible ocupar la butaca nº " + numero);
    }

    private void reservar(){
        if (state.equals(State.LIBRE))
            state = State.RESERVADA;
        else
            System.out.println("No es posible reservar la butaca nº " + numero);
    }
    private void romper(){
        state = State.ROTA;
    }
    private void liberar(){
        if (state.equals(State.LIBRE))
            state = State.LIBRE;
        else
            System.out.println("La butaca nº " + numero + " ya estaba libre");
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public State getState() {
        return state;
    }

    public void setState(State st){
        state = st;
    }


    @Override
    public String toString() {
        return state.state;
    }
}
