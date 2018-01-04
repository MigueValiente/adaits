package adaits.cursoJava.colegio;

public class MatriculaAsignatura {
    private Alumno alumno;
    private int year;
    private Asignatura asignatura;
    private Curso curso;

    public MatriculaAsignatura(Alumno alumno, int year, Asignatura asignatura, Curso curso) {
        this.alumno = alumno;
        this.year = year;
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public MatriculaAsignatura(MatriculaAsignatura m) {
        this(m.alumno,m.year,m.asignatura,m.curso);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public int getYear() {
        return year;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Curso getCurso() {
        return curso;
    }

}
