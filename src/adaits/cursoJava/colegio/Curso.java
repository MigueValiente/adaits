package adaits.cursoJava.colegio;

import java.util.ArrayList;

public class Curso {
    private int curso;
    private ArrayList<Asignatura> asignaturas;
    private Titulacion titulacion;

    public Curso(int curso, Titulacion titulacion) {
        this.curso = curso;
        this.titulacion = titulacion;
        asignaturas = new ArrayList<>();
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void addAsignatura(Asignatura asignatura) {
        asignatura.setCurso(this);
        this.asignaturas.add(asignatura);
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return curso + "º" + " de " + titulacion;
    }
}
