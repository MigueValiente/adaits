package adaits.cursoJava.miscelaneas.bingo;

import adaits.cursoJava.algoritmos.otros.numerosAleatorios.Random;

class Bombo {
    private final int bolas = 90;
    private final Random r = new Random(bolas);

    public int sacarBola(){
        return r.getNumeroSinRepeticion();
    }
}
