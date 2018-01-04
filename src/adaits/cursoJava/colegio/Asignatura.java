package adaits.cursoJava.colegio;

import java.util.ArrayList;

public class Asignatura {
    public static final int TRONCAL = 0;
    public static final int OPTATIVA = 1;
    public static final int LIBRE_CONFIGURACION = 2;

    private String nombre;
    private int tipo;
    private int horas;
    private ArrayList<Curso> cursos;
    private ArrayList<Alumno> alumnosMatriculados;
    private ArrayList<Alumno> antiguosAlumnos;

    public Asignatura(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        cursos = new ArrayList();
        alumnosMatriculados = new ArrayList<>();
        antiguosAlumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public ArrayList<Alumno> getAlumnosMatriculados() {
        return alumnosMatriculados;
    }

    public void setAlumnoMatriculado(Alumno alumno) {
        this.alumnosMatriculados.add(alumno);
    }

    public ArrayList<Alumno> getAntiguosAlumnos() {
        return antiguosAlumnos;
    }

    public void setAntiguoAlumno(Alumno alumno) {
        this.antiguosAlumnos.add(alumno);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        //Reflexivo
        if ( this == obj ) return true;

        //No nulo
        if ( obj == null ) return false;

        //Simetrico
        //La máquina virtual mantiene una única instancia de cada clase, por lo que esta comparación es correcta
        //Usar instanceof no garantiza la simetría porque es true para una clase y sus hijos
        if ( this.getClass() != obj.getClass() ) return false;

        // una vez que sabemos que son del mismo tipo hacemos cast para que el compilador lo sepa también
        if ( this.nombre == this.getClass().cast(obj).getNombre() ) return true;

        if ( this.nombre != null )
            return this.nombre.equals( this.getClass().cast(obj).getNombre());
        return false;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
