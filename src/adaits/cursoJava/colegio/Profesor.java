package adaits.cursoJava.colegio;

import adaits.cursoJava.Persona.Dni;

import java.util.ArrayList;

public class Profesor extends Empleado {
    ArrayList <Asignatura> asignaturas;
    public Profesor(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
        asignaturas = new ArrayList<>();
    }

    public void asignarAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
    }
}
