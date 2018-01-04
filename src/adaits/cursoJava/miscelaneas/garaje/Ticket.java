package adaits.cursoJava.miscelaneas.garaje;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La Clase Ticket modela los tickets de entrada del garaje
 * Conoce la Hora y el minuto de entrada
 * Conoce la Planta, Calle y Plaza asignada
 * Cuando un vehículo quiere acceder al garaje, sacará un ticket que contendrá la hora de entrada al garaje
 * (la hora del sistema proporcionada por la clase GregorianCalendar. Ver la API de Java), la planta asignada,
 * la calle y la plaza. En caso de que no haya plaza emitirá un mensaje en consola informando de este hecho
 */
class Ticket {
    private final int hora;
    private final int min;
    private final Plaza plaza;
    private final Planta planta;
    private final Calle calle;

    /**
     * Constructor que recibe una Planta, una Calle y una Plaza.
     * Calcula la Hora y Minuto en el que se crea el Ticket
     * @param planta Planta
     * @param calle Calle
     * @param plaza Plaza
     */
    public Ticket(Planta planta, Calle calle, Plaza plaza) {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        this.plaza = plaza;
        this.planta = planta;
        this.calle = calle;
    }


    @Override
    public String toString() {
        String output = "";

        output += "Hora de Entrada: " + (hora<10?"0" + hora:hora) + ":" + (min<10?"0"+min:min) + "\n";
        output += "Planta: " + planta.getNumero() + "\n";
        output += "Calle: " + calle.getNumero() + "\n";
        output += "Plaza: " + plaza.getNumero() + "\n";
        return output;
    }
}
