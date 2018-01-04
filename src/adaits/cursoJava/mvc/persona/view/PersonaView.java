package adaits.cursoJava.mvc.persona.view;

import adaits.cursoJava.Persona.Persona;
import adaits.cursoJava.interfaces.Printable;

public abstract class PersonaView implements Printable {
    Persona persona;

    public PersonaView(Persona persona){
        this.persona = persona;
    }
    @Override
    public String printConsola() {
        return persona.toString();
    }

    @Override
    public String printHTML() {
        return null;
    }

    @Override
    public String printJSON() {
        return null;
    }
//
//    public static void main(String[] args) {
//        Persona p = new Usuario("1254125V","Jose","Ape1","Ape2","espe","qwerty");
//        PersonaView vista = new PersonaView(p);
//        System.out.println(vista.printConsola());
//    }
}
