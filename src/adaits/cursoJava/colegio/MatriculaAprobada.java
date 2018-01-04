package adaits.cursoJava.colegio;

public class MatriculaAprobada extends MatriculaAsignatura {
    Integer nota;
    public MatriculaAprobada(MatriculaAsignatura m) {
        super(m);
    }

    public void aprobar(int nota){
        this.nota = nota;
    }
}
