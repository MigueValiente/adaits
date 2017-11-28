package adaits.cursoJava.aeroclub;

import adaits.cursoJava.Persona.Usuario;

import java.util.GregorianCalendar;

public class Reserva {
    private GregorianCalendar fhInicio;
    private GregorianCalendar fhFin;
    private Usuario socio;
    private Aeronave aeronave;

    public Reserva(Usuario socio, Aeronave aeronave,GregorianCalendar fhInicio, GregorianCalendar fhFin) {
        this.fhInicio = fhInicio;
        this.fhFin = fhFin;
        this.socio = socio;
        this.aeronave = aeronave;
    }

    public GregorianCalendar getFhInicio() {
        return fhInicio;
    }

    public GregorianCalendar getFhFin() {
        return fhFin;
    }

    public Usuario getSocio() {
        return socio;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }
}
