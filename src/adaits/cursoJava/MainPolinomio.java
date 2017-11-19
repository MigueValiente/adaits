package adaits.cursoJava;


import adaits.cursoJava.mathematic.*;

public class MainPolinomio {
    public static void main(String[] args) {
        int [] enteros = {0,4,-3,2};
        int [] enteros2 = {-3,0,2};

        Fraccion f1 = new Fraccion(3,1);
        Fraccion f2 = new Fraccion(6,1);
        Fraccion f3 = new Fraccion(1,1);

        Fraccion fracciones1[] = {f3,f3,f2,f2,f2};
        Fraccion fracciones2[] = {f1,f1};
        PolinomioF p1 = new PolinomioF(fracciones1);
        PolinomioF p2 = new PolinomioF(fracciones2);
        PolinomioF d = new PolinomioF(p1.division(p2));
        PolinomioF r = new PolinomioF(p1.resto(p2));
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p1 + p2 = " + p1.sumar(p2));
        System.out.println("p1 - p2 = " + p1.restar(p2));
        System.out.println("p1 * p2 = " + p1.producto(p2));
        System.out.println("p1 * -2 = " + p1.producto(-2));
        System.out.println("p1 / p2 (cociente)= " + d);
        System.out.println("p1 / p2 (resto) = " + r);
        System.out.println("p1 = " + d.producto(p2).sumar(r));
    }
}
