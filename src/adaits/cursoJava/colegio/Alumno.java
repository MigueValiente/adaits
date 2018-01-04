package adaits.cursoJava.colegio;

import adaits.cursoJava.Persona.Dni;
import adaits.cursoJava.Persona.Persona;

import java.util.ArrayList;

public class Alumno extends Persona {
    //private Curso curso;
    private ArrayList<MatriculaAsignatura> asignaturasMatriculado;
    private ArrayList<MatriculaAprobada> aprobadas;

    public Alumno(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public void matricular(Asignatura asignatura,Curso curso,int year){
        if (!matriculaViva(asignatura)) {
            MatriculaAsignatura ma = new MatriculaAsignatura(this, year, asignatura, curso);
            asignaturasMatriculado.add(ma);
        }
    }

    public void anularMatricula(Asignatura asignatura){
        if (matriculaViva(asignatura)) {
            int i = estaMatriculado(asignatura);
            asignaturasMatriculado.remove(i);
        }
    }

    public boolean matriculaViva(Asignatura asignatura){
        return (estaMatriculado(asignatura) != -1);
    }

    public int estaMatriculado(Asignatura asignatura){
        for (int i = 0; i < asignaturasMatriculado.size(); i++) {
            if (asignaturasMatriculado.get(i).getAsignatura().equals(asignatura))
                return i;
        }
        return -1;
    }

    public void aprobarAsignatura(Asignatura asignatura, int nota){
        if (matriculaViva(asignatura)) {
            int i = estaMatriculado(asignatura);
            MatriculaAprobada ma = new MatriculaAprobada(asignaturasMatriculado.get(i));
            ma.aprobar(nota);
            aprobadas.add(ma);
            asignaturasMatriculado.remove(i);
        }
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
        if ( this.getDni().equals(this.getClass().cast(obj).getDni()))
            return true;

        if ( this.getDni() != null )
            return this.getDni().equals( this.getClass().cast(obj).getDni());
        return false;
    }
}
