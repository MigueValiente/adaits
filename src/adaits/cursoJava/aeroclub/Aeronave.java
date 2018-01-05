package adaits.cursoJava.aeroclub;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase abstracta Aeronave que modela una aeronave. Controla si está operativa o no, según su estado. Mantiene los datos de la
 * matrícula, de las horas de vuelo, del Modelo (intrínsecamente de la Marca) y lleva un control de las reservas hechas a la aeronave
 */
public abstract class Aeronave {
    final private int OPERATIVO = 0;
    final private int MANTENIMIENTO = 1;
    final private int AVERIADO = 2;

    private final String matricula;
    private final Modelo modelo;
    private int estado = OPERATIVO;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Vuelo> diarioDeABordo;


    /**
     * Constructor parametrizado de la Clase Aeronave
     * @param matricula String Matrícula de la aeronave
     * @param modelo Modelo de la aeronave
     */
    public Aeronave(String matricula, Modelo modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    /**
     * Método que devuelve si la aeronave está operativa
     * @return Booleano
     */
    boolean isOperativo(){
        return estado == OPERATIVO;
    }

    /**
     * Método que cambia el estado de la aeronave
     * @param estado A establecer (OPERATIVO, MANTENIMIENTO, AVERIADO)
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Getter que devuelve la mátrícula de la aeronave
     * @return String Matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Getter que devuelve el modelo de la aeronave
     * @return Modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * Método que devuelve la marca de la aeronave
     * @return Marca
     */
    public Marca getMarca(){
        return modelo.getMarca();
    }

    /**
     * Método que comprueba si la aeronave está reservada en un intervalo de tiempo
     * @param fechaIni Momento de inicio del intervalo
     * @param fechaFin Momento de fin del intervalo
     * @return Booleano
     */
    boolean isReservado(Calendar fechaIni, Calendar fechaFin) {
        for (Reserva r: reservas){
            if (fechaIni.after(r.getFhInicio()) && fechaIni.before(r.getFhFin()))
                return true;
            if (fechaFin.after(r.getFhInicio()) && fechaFin.before(r.getFhFin()))
                return true;
            if (fechaIni.before(r.getFhInicio()) && fechaFin.after(r.getFhFin()))
                return true;
        }
        return false;
    }

    /**
     * Método que devuelve el estado de la aeronave
     * @return entero
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Setter de una Reserva. Agrega una reserva a la lista de reservas
     * @param reserva del tipo Reserva
     */
    void setReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    /**
     * Método que agrega un vuelo a la lista de vuelos de la aeronave (Diario de A Bordo)
     * @param vuelo del tipo Vuelo
     */
    public void setDiarioDeABordo(Vuelo vuelo) {
        this.diarioDeABordo.add(vuelo);
    }

    @Override
    public String toString() {
        return modelo.getMarca() + " " + modelo + " " + matricula;
    }
}
