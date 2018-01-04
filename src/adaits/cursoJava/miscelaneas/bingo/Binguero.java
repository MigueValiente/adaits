package adaits.cursoJava.miscelaneas.bingo;

import adaits.cursoJava.Persona.Usuario;

public class Binguero extends Usuario {
    private final Carton[] cartones = new Carton[10]; // Máximo 10 cartones por persona
    private int cartonesComprados = 0;

    public Binguero(String dni, String name, String apellido1, String apellido2, String user, String psw){
        super(dni, name, apellido1, apellido2, user, psw);
    }

    public boolean comprarCarton(Carton c){
        if (cartonesComprados < cartones.length) {
            cartones[cartonesComprados] = c;
            cartonesComprados++;
            return true;
        }
        else {
            System.out.println("Ya no puede comprar más cartones");
            return false;
        }
    }
}
