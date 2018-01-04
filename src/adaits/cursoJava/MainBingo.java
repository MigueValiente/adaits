package adaits.cursoJava;

import adaits.cursoJava.miscelaneas.bingo.Bingo;
import adaits.cursoJava.miscelaneas.bingo.Binguero;

class MainBingo {
    public static void main(String[] args) {
        Bingo b = new Bingo(3);
        System.out.println(b);
        Binguero b1 = new Binguero("12345678A","PP","Aellido","OtroAp","qwerty", "asdfgh");
        Binguero b2 = new Binguero("12345675H","JJ","oiuy","MJNHBG","poiuyt", "mnbvcv");
        b.venderCartones(b1,12);
        b.venderCartones(b2,3);
        int [] ganadores = b.jugar();
        int i = 0;
        while (ganadores[i] != 0){
            System.out.println("Cartón ganador: " + ganadores[i]);
            System.out.println("Propietario: " + b.getTaquilla().getCartones()[i].getBinguero().getApellido1());
            System.out.println(b.getTaquilla().getCartones()[ganadores[i]-1]);
            i++;
        }
    }
}
