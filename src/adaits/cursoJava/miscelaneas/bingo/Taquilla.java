package adaits.cursoJava.miscelaneas.bingo;

import adaits.cursoJava.Persona.Usuario;

public class Taquilla {
    private final Binguero [] bingueros;
    private static int clientes = 0;
    private final Carton [] cartones;
    private final int TOTALCARTONES = 1000;
    private int cartonesVendidos = 0;
    private double caja =0;

    Taquilla(int aforo){
        bingueros = new Binguero[aforo];
        cartones = new Carton[TOTALCARTONES];
    }

    public void registrar (Binguero u){
        int aforo = bingueros.length;
        if (clientes < aforo) {
            bingueros[clientes] = u;
            clientes++;
        }else{
            System.out.println("Aforo Completo");
        }
    }

    public double getCaja() {
        return caja;
    }

    public Carton[] getCartones() {
        return cartones;
    }

    public void venderCarton(Binguero b){
        Carton c = new Carton();
        if (b.comprarCarton(c)) {
            c.setBinguero(b);
            cartones[cartonesVendidos] = c;
            cartonesVendidos++;
            caja += c.getPrecio();
        }
    }
}
