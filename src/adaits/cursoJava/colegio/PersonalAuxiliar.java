package adaits.cursoJava.colegio;

import adaits.cursoJava.Persona.Dni;

public abstract class PersonalAuxiliar extends Empleado {

    public PersonalAuxiliar(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }
}
