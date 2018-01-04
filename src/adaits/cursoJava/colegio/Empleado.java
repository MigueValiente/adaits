package adaits.cursoJava.colegio;

import adaits.cursoJava.Persona.Dni;
import adaits.cursoJava.Persona.Persona;

public class Empleado extends Persona {
    GrupoCotizacion grupoCotizacion;
    GrupoProfesional grupoProfesional;
    Salario salario;
    int claveContrato;
    public Empleado(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public double getSalario(){
        return calculaSalario();
    }

    private double calculaSalario(){
        return salario.calculaSalario(grupoCotizacion);
    }
}
