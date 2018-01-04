package adaits.cursoJava;

import adaits.cursoJava.algoritmos.otros.numerosAleatorios.Random;

class MainRandom {
    public static void main(String[] args) {
        Random r = new Random(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(r.getNumeroSinRepeticion());
        }
    }
}
