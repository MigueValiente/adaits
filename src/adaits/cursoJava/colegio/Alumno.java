package adaits.cursoJava.colegio;

import adaits.cursoJava.Persona.Dni;
import adaits.cursoJava.Persona.Persona;

public class Alumno extends Persona {
    private Expediente expediente;

    public Alumno(Dni dni, String name, String apellido1, String apellido2,Titulacion titulacion) {
        super(dni, name, apellido1, apellido2);
        crearExpediente(titulacion);
    }

    /**
     * Setter de expediente
     * @param expediente del tipo adaits.cursoJava.colegio.Expediente
     */
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public void crearExpediente(Titulacion titulacion){
        expediente = new Expediente(this,titulacion);
    }

    public void agregarMatriculaAlExpediente(Matricula matricula){
        expediente.agregarNuevaMatricula(matricula);
    }

    public Matricula getMatriculaDelYear(int year){
        return expediente.getMatricula(year,this);
    }

    /**
     * Getter de expediente
     *
     * @return expediente
     */
    public Expediente getExpediente() {
        return expediente;
    }

    public boolean tieneExpediente(){
        return expediente != null;
    }

    public void matricularAsignatura(Asignatura asignatura, int year){
        Matricula m = getMatriculaDelYear(year);
        if (m == null)
            m = crearNuevaMatricula(year);
        expediente.agregarAsignaturaAMatricula(asignatura,m);
    }

    public Matricula crearNuevaMatricula(int year){
        return new Matricula(this,year);
    }

    public Titulacion getTitulacion(){
        return expediente.getTitulacion();
    }

    public void anularasignaturaDeMatricula(Asignatura asignatura,int year){
        Matricula m = getMatriculaDelYear(year);
        if (estaMatriculado(asignatura,year)) {
            m.quitarAsignatura(asignatura);
        }
    }

    public boolean estaMatriculado(Asignatura asignatura,int year){
        Matricula m = getMatriculaDelYear(year);
        return m.estaMatriculado(asignatura);
    }

    public void aprobarAsignatura(Asignatura asignatura, int nota,int year){
        if (estaMatriculado(asignatura,year)) {
            AsignaturaAprobada ap = new AsignaturaAprobada(asignatura);
            ap.aprobar(nota,year);
            Matricula m = getMatriculaDelYear(year);
            expediente.aprobarAsignatura(m,ap);
        }
    }


}
