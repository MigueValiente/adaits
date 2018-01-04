package adaits.cursoJava.algoritmos.otros.numerosAleatorios;

public class Random {
    private final int[] numeros;
    private int max;

    public Random(int n) {
        numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = i + 1;
        }
        max = n - 1;
    }

    public int getNumeroSinRepeticion() {
        if (max >= 0){
            int n = (int) (Math.random() * max);
            int m = numeros[n];
            numeros[n] = numeros[max];
            numeros[max] = m;
            max--;
            return m;
        }
        return -1;
    }
}
