package adaits.cursoJava.aeroclub;


import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Clase que modela un aeroclub.<br>
 * Tiene como atributos:<br>
 * private final String name. Nombre del aeroclub<br>
 * private final ArrayList aeronaves. Lista de aeronaves del aeroclub<br>
 * private final ArrayList socios. Lista de Pilotos socios del aeroclub<br>
 * private final ArrayList reservas. Lista de reservas hechas en el aeroclub
 */
public class Aeroclub {
    private final String name;
    private final ArrayList<Aeronave> aeronaves = new ArrayList<>();
    private final ArrayList<Piloto> socios = new ArrayList<>();
    private final ArrayList<Reserva> reservas = new ArrayList<>();

    /**
     * Constructor parametrizado que recibe el nombre del aeroclub
     * @param n String (Cadena) con el nombre del aeroclub
     */
    public Aeroclub(String n) {
        name = n;
    }

    /**
     * Método para agregar un usuario (Piloto o socio) a la lista de pilotos del aeroclub
     * @param u Usuario de tipo Piloto
     */
    public void addUser(Piloto u){
        socios.add(u);
    }

    /**
     * Método que agrega una aeronave a la lista de aeronaves del aeroclub
     * @param a aeronave a agregar de la clase abstracta Aeronave
     */
    public void addAeronave(Aeronave a){
        aeronaves.add(a);
    }

    /**
     * Método que devuelve la lista de aeronaves del club
     * @return ArrayList de Aeronaves
     */
    public ArrayList<Aeronave> getAeronaves() {
        return aeronaves;
    }

    /**
     * Métod que permite reservar una aeronave por parte de un piloto. Comprueba que el piloto esté habilitado para volar
     * esa aeronave
     * @param u Piloto que pretende reservar
     * @param av Aeronave a reservar
     * @param ini Fecha-Hora de inicio de la reserva
     * @param fin Fecha-Hora de fin de la reserva
     */
    public void reservar(Piloto u, Aeronave av, GregorianCalendar ini, GregorianCalendar fin){
        if (ini.after(fin)){
            System.out.println("La fecha de fin de la reserva debe ser porterior a la de inicio");
            return;
        }
        if (av.isReservado(ini,fin) || !av.isOperativo()){
            System.out.println("Esta aeronave no está disponible para ser reservada");
            return;
        }
        if (u.isHabilitado(av.getModelo())) {
            reservas.add(new Reserva(u, av, ini, fin));
            av.setReserva(reservas.get(reservas.size()-1));
        }else{
            System.out.println(u + " no está habilitado para el modelo de aeronave " + av.getModelo().getMarca() + " " +
                    av.getModelo());
        }
    }

    /**
     * Método que lista los socios del aeroclub
     */
    public void listSocios(){
        for (Piloto p: socios) {
            if (p == null) break;
            System.out.println(p);
        }
    }

    /**
     * Método que lista las aeronaves del aeroclub
     */
    public void listAeronaves(){
        for (Aeronave a: aeronaves) {
            if (a == null) break;
            System.out.println(a);
        }
    }

    /**
     * Método que lista las reservas del aeroclub
     */
    public void listReservas(){
        for (Reserva r:reservas) {
            if (r == null) break;
            System.out.println(r);
        }
    }

    @Override
    public String toString() {
        return "Aeroclub " + name ;
    }
}
