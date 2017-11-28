package adaits.cursoJava.aeroclub;

import adaits.cursoJava.Persona.Usuario;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.GregorianCalendar;

public class Aeronave {
    final private int OPERATIVO = 0;
    final private int MANTENIMIENTO = 1;
    final private int AVERIADO = 2;

    private String matricula;
    private double horas;
    private Modelo modelo;
    private boolean reservado;
    private int estado;
    private GregorianCalendar fhInicio;
    private GregorianCalendar fhFin;

    public Aeronave(String matricula, Modelo modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getHoras() {
        return horas;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public boolean isReservado() {
        return reservado;
    }

    public int getEstado() {
        return estado;
    }

    public GregorianCalendar getFhInicio() {
        return fhInicio;
    }

    public void setFhInicio(GregorianCalendar fhInicio) {
        this.fhInicio = fhInicio;
    }

    public GregorianCalendar getFhFin() {
        return fhFin;
    }

    public void setFhFin(GregorianCalendar fhFin) {
        this.fhFin = fhFin;
    }

    public void reserva(Usuario u,GregorianCalendar ini,GregorianCalendar fin){
        fhInicio = ini;
        fhFin = fin;
    }

    @Override
    public String toString() {
        return modelo.getMarca() + " " + modelo + " " + matricula;
    }
}
