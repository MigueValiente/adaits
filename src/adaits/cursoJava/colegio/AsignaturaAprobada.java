package adaits.cursoJava.colegio;

public class AsignaturaAprobada extends Asignatura {
    int nota;
    int year;

    public AsignaturaAprobada(String nombre, int tipo) {
        super(nombre, tipo);
    }

    public AsignaturaAprobada(Asignatura asignatura){
        this(asignatura.getNombre(),asignatura.getTipo());
    }


    public void aprobar(int nota, int year){
        this.nota = nota;
        this.year = year;
    }
}
