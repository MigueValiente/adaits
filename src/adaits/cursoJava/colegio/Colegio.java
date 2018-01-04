package adaits.cursoJava.colegio;

import java.util.ArrayList;

public class Colegio {
    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Titulacion> titulaciones;

    public Colegio(String nombre) {
        this.nombre = nombre;
        titulaciones = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public void addTitulacion (Titulacion titulacion){
        titulaciones.add(titulacion);
    }

    public ArrayList<Titulacion> getTitulaciones() {
        return titulaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
