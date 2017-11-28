package adaits.cursoJava.miscelaneas.teatro;

import javax.swing.plaf.PanelUI;

public class Butaca {
    final public static int LIBRE = 0;
    final public static int OCUPADA = 1;
    final public static int RESERVADA = 2;
    final public static int ROTA = 3;
    private int state = 0;
    private int numero;
    private double precio;

    public Butaca(int n) {
        numero = n;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private void ocupar(){
        if (state == LIBRE)
            state = OCUPADA;
        else
            System.out.println("No es posible ocupar la butaca nº " + numero);
    }

    private void reservar(){
        if (state == LIBRE)
            state = RESERVADA;
        else
            System.out.println("No es posible reservar la butaca nº " + numero);
    }
    private void romper(){
        state = ROTA;
    }
    private void liberar(){
        if (state != LIBRE)
            state = LIBRE;
        else
            System.out.println("La butaca nº " + numero + " ya estaba libre");
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getState() {
        return state;
    }

    public void setState(int st){
        switch (st){
            case LIBRE:
                liberar();
                break;
            case OCUPADA:
                ocupar();
                break;
            case RESERVADA:
                reservar();
                break;
            case ROTA:
                romper();
        }
    }


    @Override
    public String toString() {
        switch (state){
            case LIBRE:
                return "-";
            case OCUPADA:
                return "O";
            case RESERVADA:
                return "R";
            case ROTA:
                return "X";
            default:
                return "?";
        }
    }
}
