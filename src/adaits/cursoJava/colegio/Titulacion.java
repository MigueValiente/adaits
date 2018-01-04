package adaits.cursoJava.colegio;

import adaits.cursoJava.interfaces.Printable;

import java.util.ArrayList;

public class Titulacion{
    private String nombre;
    private ArrayList<Curso> cursos;

    public Titulacion(String nombre){
        this.nombre = nombre;
        cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCurso(Curso curso){
        curso.setTitulacion(this);
        cursos.add(curso);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
