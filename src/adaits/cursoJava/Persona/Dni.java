package adaits.cursoJava.Persona;

/**
 *Clase que modela el DNI español
 * @author  JER
 * @version 18/11/2017
 */
public class Dni {

    private int numero;
    private char letra;

    final private static char letras[]={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

    /**
     * Constructor con parámetro. Admite un entero y calcula la letra asignada al número.
     * Actualiza el atributo <b>letra</b>
     * @param n Número del DNI
     */
    public Dni(int n){
        numero = n;
        letra = letras[n%23];
    }
    public Dni (String dni){
        if (isDniOk(dni)){
            dni = dni.toUpperCase();
            numero = Integer.parseInt(dni.substring(0,dni.length()-1));
            letra = dni.charAt(dni.length()-1);
        }else
            System.out.println("El formato del DNI no es correcto");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    private static  boolean isDniOk(int dni,char letra){
        return letras[dni % 23] == letra;
    }

    private static boolean isDniOk(String dni){
        dni = dni.toUpperCase();
        int n = Integer.parseInt(dni.substring(0,dni.length()-1));
        char c = dni.charAt(dni.length()-1);
        return isDniOk(n,c);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dni))
            return false;
        Dni newDni = (Dni) obj;
        return numero == newDni.numero && letra == newDni.letra;
    }

    @Override
    public String toString() {
        return "" + numero + letra;
    }
}
