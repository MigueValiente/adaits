package adaits.cursoJava.miscelaneas.bingo;

import adaits.cursoJava.algoritmos.otros.numerosAleatorios.Random;

public class Carton {
    private final int [][] numeros;
    private int aciertos = 0;
    private final double precio = 10;
    private Binguero binguero;

    public Carton() {
        numeros = new int[3][9];
        populate();
    }
    private void populate(){
        Random r = new Random(90);
        for (int i = 0; i < 3; i++) {
            int numerosEnFila = 0;
            while (numerosEnFila < 5) {
                int n = r.getNumeroSinRepeticion();
                int decena = n / 10;
                if (decena == 9)
                    decena = 8;  // El 90
                if (numeros[i][decena] == 0) {
                    numeros[i][decena] = n;
                    numerosEnFila++;
                }
            }
        }
    }

    public Binguero getBinguero() {
        return binguero;
    }

    public void setBinguero(Binguero binguero) {
        this.binguero = binguero;
    }

    public double getPrecio() {
        return precio;
    }

    private void tacharNumero(int fila, int columna){

        numeros[fila][columna] = -1;
        aciertos++;
    }

    public void comprobar(int n){
        int pos;
        if ((pos = estaElNumero(n)) != -1){
            tacharNumero(pos/9,pos%9);
        }
    }

    private int estaElNumero(int n){
        int decena = n/10;
        if (n == 90) decena = 8;
        for (int i = 0; i < 3; i++) {
            if (numeros[i][decena] == n)
                return i*9 + decena;
        }
        return -1;
    }

    public boolean ganador(){
//        for (int i = 0; i < numeros.length; i++) {
//            for (int j = 0; j < numeros[i].length; j++) {
//                if (numeros[i][j] != 0 && numeros[i][j] != -1) return false;
//            }
//        }
        return aciertos == 15;
    }

    @Override
    public String toString() {
        String output="";
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                switch (numeros[i][j]) {
                    case 0:
                        output += "░\t";
                        break;
                    case -1:
                        output += "X\t";
                        break;
                    default:
                        output += numeros[i][j] + "\t";
                }
            }
            output += "\n";
        }
        return output;
    }
}
