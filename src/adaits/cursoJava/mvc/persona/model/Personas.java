package adaits.cursoJava.mvc.persona.model;

import adaits.cursoJava.Persona.Dni;
import adaits.cursoJava.Persona.Persona;
import adaits.cursoJava.mvc.CRUDable;

import java.lang.reflect.Field;
import java.util.ArrayList;



public class Personas implements CRUDable {
    private final ArrayList<Persona> personas;

    private Personas() {
        personas = new ArrayList<>();
    }

    public void add(Object persona) {
        personas.add((Persona) persona);
    }

    public int getIndex(Object persona) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).equals(persona)) return i;
        }
        return -1;
    }

    public Persona seek (Object dni){
        for (Persona persona:personas) {
            if (persona.getDni().equals(dni))
                return persona;
        }
        return null;
    }

    /**
     *
     * @param persona
     * @return
     */
    public int delete(Object persona) {
        int i = getIndex(persona);
        if (i != -1) {
            personas.remove(i);
        }
        return i;
    }

    public void set(Object dni,String campo, String valor){
        Persona persona = this.seek(dni);
        try {
            Class c = persona.getClass();
            Field f = c.getDeclaredField(campo);
            f.setAccessible(true);
            f.set(persona,valor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        return 0;
    }

    public static void main(String[] args) {
        Personas personas= new Personas();
        Dni dni = new Dni("27271949K");
        Persona p1 = new Persona(dni,"José","Espejo","Roig");
        Persona p2 = new Persona(new Dni("27262860V"),"Encarna","Espejo","Roig");
        personas.add(p1);
        personas.add(p2);
        int i = personas.getIndex(p2);

        System.out.println(personas.personas.get(personas.getIndex(p1)).getNombreYApellidos());
        System.out.println(personas.personas.get(personas.getIndex(p2)).getNombreYApellidos());
        Persona p = personas.seek(dni);
        System.out.println(p.getNombreYApellidos());
        System.out.println(i);

        System.out.println(personas.personas.get(personas.delete(p1)).getNombreYApellidos());
        personas.set(new Dni("27262860V"),"apellido1","Fernández");
        Persona p4 = personas.seek(new Dni("27262860V"));
        System.out.println(p4.getNombreYApellidos());

    }
}
