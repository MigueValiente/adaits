package adaits.cursoJava;


import adaits.cursoJava.mathematic.Complejo;

public class PruebaComplejos {
    public static void main(String[] args) {
        // declaración de números complejos
        Complejo c1 = new Complejo(0, 1);
        Complejo c2 = new Complejo(-2, 0);
        Complejo c3 = new Complejo(1, -1);
        Complejo c4 = new Complejo(0, -2);
        Complejo c5 = new Complejo(0, -1);
        Complejo c6 = new Complejo();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println("c5 = " + c5);
        System.out.println("c6 = " + c6);

        // operadores aritméticos
        System.out.println("c1 + c2 = " + c1.sumar(c2));
        System.out.println("c1 - c2 = " + c1.restar(c2));
        System.out.println("c1 / c2 = " + c1.dividir(c2));
        System.out.println("c1 * 3.5 = " + c1.multiplicar(3.5));
        System.out.println("c1 * c5 = " + c1.multiplicar(c5));

        if (c1.equals(c5.multiplicar(-1))) {
            System.out.println(c1 + " igual que " + c5 + " * -1");
        } else {
            System.out.println(c1 + " distinto que " + c5 + " * -2");
        }
    }
}
