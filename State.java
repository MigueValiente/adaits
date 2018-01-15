package adaits.cursoJava.miscelaneas.teatro;

public enum State {
    LIBRE("-"),
    OCUPADA("O"),
    RESERVADA("R"),
    ROTA("X");

    final String state;

    private State (String state){
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }
}
