package adaits.cursoJava.algoritmos.otros;

import java.util.Scanner;

public class Billetes {
    public static void main(String[] args) {
        double cantidad;
        final double B50,B20,B10,B5,M2,M1,M05,M02,M01,M005,M002,M001;
        B50 = 50;
        B20 = 20;
        B10 = 10;
        B5 = 5;
        M2 = 2;
        M1 = 1;
        M05 = 0.5;
        M02 = 0.2;
        M01 = 0.1;
        M005 = 0.05;
        M002 = 0.02;
        M001 = 0.01;

        Scanner input = new Scanner(System.in);
        System.out.print("Introduzca cantidad a cambiar (separador coma \",\"): ");
        cantidad = input.nextDouble();
        System.out.println("\nCambio: ");

        System.out.println("Billetes de 50: " + (int)(cantidad / B50));
        cantidad %= B50;
        System.out.println("Billetes de 20: " + (int)(cantidad / B20));
        cantidad %= B20;
        System.out.println("Billetes de 10: " + (int)(cantidad / B10));
        cantidad %= B10;
        System.out.println("Billetes de 5: " + (int)(cantidad / B5));
        cantidad %= B5;
        System.out.println("Monedas de 2: " + (int)(cantidad / M2));
        cantidad %= M2;
        System.out.println("Monedas de 1: " + (int)(cantidad / M1));
        cantidad %= M1;
        System.out.println("Monedas de 0,5: " + (int)(cantidad / M05));
        cantidad %= M05;
        System.out.println("Monedas de 0,2: " + (int)(cantidad / M02));
        cantidad %= M02;
        System.out.println("Monedas de 0,1: " + (int)(cantidad / M01));
        cantidad %= M01;
        System.out.println("Monedas de 0,05: " + (int)(cantidad / M005));
        cantidad %= M005;
        System.out.println("Monedas de 0,02: " + (int)(cantidad / M002));
        cantidad %= M002;
        System.out.println("Monedas de 0,01: " + Math.round(cantidad / M001));
        cantidad %= M001;
    }
}
