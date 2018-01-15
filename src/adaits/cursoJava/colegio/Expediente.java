package adaits.cursoJava.colegio;

import java.util.ArrayList;

public class Expediente {
    private Alumno alumno;
    private Titulacion titulacion;
    private ArrayList<Matricula> matriculas;
    private ArrayList<AsignaturaAprobada> aprobadas;


    public Expediente(Alumno alumno, Titulacion titulacion) {
        this.alumno = alumno;
        this.titulacion = titulacion;
        this.alumno.setExpediente(this);
        this.matriculas = new ArrayList<>();
        this.aprobadas = new ArrayList<>();
    }

    public Matricula crearNuevaMatricula(Alumno alumno, int year){
        return new Matricula(alumno,year);
    }

    /**
     * Getter de titulacion
     *
     * @return titulacion
     */
    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void agregarNuevaMatricula(Matricula matricula){
        matriculas.add(matricula);
    }

    public boolean existeMatricula(int year, Alumno alumno){
        for (Matricula m:matriculas){
            if (m.getYear() == year && m.getAlumno().equals(alumno)) return true;
        }
        return false;
    }

    public Matricula getMatricula (int year, Alumno alumno){
        for (Matricula m:matriculas){
            if (m.getYear() == year && m.getAlumno().equals(alumno)) return m;
        }
        return null;
    }

    public void agregarAsignaturaAMatricula(Asignatura asignatura,Matricula matricula){
        if (matricula != null)
            getMatricula(matricula.getYear(),matricula.getAlumno()).matricularAsignatura(asignatura);
    }

    public void aprobarAsignatura(Matricula matricula, AsignaturaAprobada asignaturaAprobada){
        aprobadas.add(asignaturaAprobada);
        matricula.quitarAsignatura(asignaturaAprobada);
    }

    public void listarAsignaturasMatriculadas(int year){
        Matricula m = getMatricula(year,alumno);
        for (Asignatura a:m.getAsignaturas()){
            System.out.println(a);
        }
    }

    public void listarAsignaturasAprobadas(){
        for (AsignaturaAprobada a:aprobadas){
            System.out.println(a);
        }
    }
}
