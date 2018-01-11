package adaits.cursoJava.miscelaneas.teatro;

import java.util.SplittableRandom;

public class Zona {
    final private int FILAS;
    final private int BUTACAS;
    private int nZona;
    private int extremos;
    private double precio;
    private final double descuento;

    private int shift;

    final private Butaca[][] distribucion;

    public Zona(int FILAS, int BUTACAS) {
        extremos = 20;  // 20 % de butacas tienen menor precio
        descuento = 20;
        this.FILAS = FILAS;
        this.BUTACAS = BUTACAS;
        distribucion = new Butaca[FILAS][BUTACAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < BUTACAS; j++) {
                distribucion[i][j] = new Butaca((i* BUTACAS) + j);
            }
        }
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void setState (int fila,int butaca,State state){
        if (fila < 0 || fila >= FILAS)
            System.out.println("Esta zona no tiene esa fila");
        else if (butaca < 0 || butaca >= BUTACAS)
            System.out.println("Esta zona no tiene esa butaca");
        else
            distribucion[fila][butaca].setState(state);
    }

    public void setState (int numero,State state){
        int fila = numero/BUTACAS;
        int butaca = numero%BUTACAS;
        setState(fila,butaca,state);
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getBUTACAS() {
        return BUTACAS;
    }

    public double caja (){
        double recaudacion = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < BUTACAS; j++) {
                if (distribucion[i][j].getState()== State.OCUPADA)
                    recaudacion += distribucion[i][j].getPrecio();
            }
        }
        return recaudacion;
    }

    public void setPrecio(double precio){
        this.precio = precio;
        int limite = BUTACAS *extremos/100;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < BUTACAS; j++) {
                if (j < limite || j > BUTACAS - limite)
                    distribucion[i][j].setPrecio(precio*(100-descuento)/100);
                else
                    distribucion[i][j].setPrecio(precio);
            }
        }

    }
    public  int getExtremos() {
        return extremos;
    }

    public void setExtremos(int extremos) {
        this.extremos = extremos;
    }

    public double getPrecio() {
        return precio;
    }


    public void setnZona(int nZona) {
        this.nZona = nZona;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < BUTACAS; j++) {
                distribucion[i][j].setNumero(nZona*1000 + distribucion[i][j].getNumero());
            }
        }
    }

    public int getnZona() {
        return nZona;
    }


    private String printFila(int i){
        String output = "";
        for (int j = 0; j < shift; j++) {
            output += "\t";
        }
        for (int j = 0; j < BUTACAS; j+=2) {
            output += distribucion[i][j] + "\t";
        }
        for (int j = 0; j < Teatro.PASILLO; j++) {
            output += "\t";
        }
        for (int j = 1; j < BUTACAS; j+=2) {
            output += distribucion[i][j] + "\t";
        }
        output += " " + i;

        output += "\n";
        return output;
    }

    private String printNumeros(){
        String output = "";
        for (int j = 0; j < shift; j++) {
            output += "\t";
        }
        for (int j = 0; j < BUTACAS; j+=2) {
            output += j + "\t";
        }
        for (int j = 0; j < Teatro.PASILLO; j++) {
            output += "\t";
        }
        for (int j = 1; j < BUTACAS; j+=2) {
            output += j + "\t";
        }

        output += "\n";
        return output;
    }


    public void listarZona(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < BUTACAS; j++) {
                System.out.print(distribucion[i][j].getNumero() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String output="";
        output += printNumeros();
        for (int i = 0; i < FILAS; i++) {
            output += printFila(i);
        }
        return output;
    }
}
