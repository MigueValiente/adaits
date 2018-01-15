package adaits.cursoJava.colegio;

public class MatriculaAprobada extends Matricula {
    Integer nota;
    public MatriculaAprobada(Matricula m) {
        super(m);
    }

    public void aprobar(int nota){
        this.nota = nota;
    }
}
