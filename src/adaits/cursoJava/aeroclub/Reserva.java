package adaits.cursoJava.aeroclub;

import adaits.cursoJava.Persona.Usuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que modela una reserva de una aeronave hecha por un piloto.<br>
 * Tiene un contador de reservas para crear y almacenar el número de reserva.<br>
 * Guarda la fecha-hora de inicio y fin de la reserva<br>
 * Los datos del piloto<br>
 * Y los datos de la aeronave a alquilar
 */
class Reserva {
    private int nReserva;
    private  Calendar fhInicio;
    private  Calendar fhFin;
    private  Piloto socio;
    private  Aeronave aeronave;
    private static int counterReserva = 0;

    /**
     * Constructor parametrizado de la Clase Reserva
     * @param socio Piloto que hace la reserva
     * @param aeronave Aeronave sobre la que se hace la reserva
     * @param fhInicio Feha-Hora de inicio de la reserva
     * @param fhFin Fecha-Hora de Fin de la reserva
     */
    public Reserva(Piloto socio, Aeronave aeronave,GregorianCalendar fhInicio, GregorianCalendar fhFin) {
        this.fhInicio = fhInicio;
        this.fhFin = fhFin;
        this.socio = socio;
        this.aeronave = aeronave;
        nReserva = ++counterReserva;
    }

    /**
     * Getter del número de Reserva
     * @ return Entero
     */
    public int getnReserva() {
        return nReserva;
    }

    /**
     * Getter de la fecha-hora  de inicio de la reserva
      * @return devuelve una Fecha-Hora
     */
    Calendar getFhInicio() {
        return fhInicio;
    }

    /**
     * Getter de la fecha-hora  de fin de la reserva
     * @return devuelve una Fecha-Hora
     */
    Calendar getFhFin() {
        return fhFin;
    }

    /**
     * Getter del Piloto que hace la reserva
     * @return Piloto
     */
    public Usuario getSocio() {
        return socio;
    }

    /**
     * Getter de la aeronave de la reserva
     * @return devuelve una Aeronave
     */
    public Aeronave getAeronave() {
        return aeronave;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy --> HH:mm>");

        String fechaIni = formato.format(getFhInicio().getTime());
        String fechaFin = formato.format(getFhFin().getTime());

        return ("Nº Reserva: " + nReserva + " -- " + getSocio().getNombreYApellidos() + " "
                + getAeronave()+ " " + fechaIni + " " + fechaFin);
    }
}
