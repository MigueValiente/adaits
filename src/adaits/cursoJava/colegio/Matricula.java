package adaits.cursoJava.colegio;

import java.util.ArrayList;

public class Matricula {
    private Alumno alumno;
    private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
    private int year;

    public Matricula(Alumno alumno, int year) {
        this.alumno = alumno;
        this.year = year;
        alumno.agregarMatriculaAlExpediente(this);
    }

    public Matricula(Matricula matricula) {
        this(matricula.alumno,matricula.year);
        this.asignaturas = matricula.asignaturas;
    }

    /**
     * Getter de year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter de alumno
     * @return alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    public  void matricularAsignatura(Asignatura asignatura){
        Titulacion t = alumno.getTitulacion();
        if (t.tieneEstaAsignatura(asignatura))
            asignaturas.add(asignatura);
        else
            System.out.println("La asignatura " + asignatura + " no pertenece a la titulación " + t);
    }

    public void quitarAsignatura(Asignatura asignatura){
        for (Asignatura a:asignaturas){
            if (a.getNombre().equals(asignatura.getNombre())) {
                asignaturas.remove(a);
                return;
            }
        }
    }

    public boolean estaMatriculado(Asignatura asignatura){
        for (Asignatura a:asignaturas){
            if (a.equals(asignatura))
                return true;
        }
        return false;
    }

    /**
     * Getter de asignaturas
     *
     * @return asignaturas
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
