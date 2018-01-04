package adaits.cursoJava.algoritmos.busqueda;

import java.util.Scanner;

class BusquedaBinaria {
    public static void main(String[] args) {
        final int TAM;
        int min;
        final int rango = 20;
        Scanner input = new Scanner(System.in);
        System.out.print("Introduzca un número entero: ");
        TAM = input.nextInt();
        // Creamos un array de yamaño TAM
        int [] enteros = new int[TAM];
        // Llenamos un array de números enteros crecientes
        enteros[0]=(int) (Math.random()+1);
        min = enteros[0];
        for (int i = 1;i<TAM;i++){
            enteros[i] = (int) (Math.random() * rango + min+1);
            min = enteros[i];
        }
        for (int i =0; i< enteros.length;i++) {
            System.out.println("[" + i + "] -> " + enteros[i]);
        }

        // Buscamos un número cualquiera del array
        int n = enteros[27];
        int inferior,superior,centro;
        superior = TAM-1;
        inferior =0;
        System.out.println("Número a buscar: " + n);

        // Inicio búsqueda binaria
        while (inferior <= superior){
            centro = (superior + inferior)/2;
            if (enteros[centro] == n){  // Eureka!
                System.out.println("El número " + n + " se encuentra en la posición " + centro);
                break;
            }else if (n < enteros[centro]){
                superior = centro - 1;
            }else{
                inferior = centro + 1;
            }
        }

    }
}
