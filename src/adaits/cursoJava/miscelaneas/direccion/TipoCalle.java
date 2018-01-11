package adaits.cursoJava.miscelaneas.direccion;

public enum TipoCalle {
    AVENIDA("Avenida","Av. "),
    CALLE("Calle","C/ "),
    PLAZA("Plaza","Pza."),
    RONDA("Ronda","Rnd."),
    CARRETERA("Carretera","Crrt.");

    private final String tipo;
    private final String tipoShort;

    private TipoCalle(String tipo,String tipoShort) {
        this.tipo = tipo;
        this.tipoShort = tipoShort;
    }

    public String getTipoShort() {
        return tipoShort;
    }
    private Boolean isTipo(String tipoCalle) {
        return tipoCalle.toUpperCase().equals(this.tipo.toUpperCase());
    }

    public static TipoCalle whatTipe(String tipoCalle){
        for (TipoCalle t:TipoCalle.values()) {
            if (t.isTipo(tipoCalle)) return t;
        }
        return null;
    }




    @Override
    public String toString() {
        return tipo;
    }

}
