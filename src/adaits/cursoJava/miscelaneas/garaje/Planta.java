package adaits.cursoJava.miscelaneas.garaje;

public class Planta {
    private int numero;
    private Fila[]filas;

    public Planta(int n,int f,int ub) {
        numero = n;
        filas = new Fila[f];
        for (int i = 0; i < f; i++) {
            filas[i] = new Fila(i,ub);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Fila[] getFilas() {
        return filas;
    }

    public boolean isFullPlanta(){
        for (int i = 0; i < filas.length; i++) {
            if (!filas[i].isFullRow())
                return false;
        }
        return true;
    }

    public Fila buscaFilaLibre(){
        Ubicacion ub;
        for (int i = 0; i < filas.length; i++) {
            if (filas[i].buscaUbicacion() != null){
                return filas[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < filas.length; i++) {
            output += filas[i] + "\n";
            if (i%2 == 0)
                output += "\n";
        }
        return output;
    }
}
