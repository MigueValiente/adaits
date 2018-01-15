package adaits.cursoJava.Persona;

public class Persona {
    Dni dni;
    String name;
    String apellido1;
    String apellido2;

    public Persona(Dni dni, String name, String apellido1, String apellido2) {
        this.dni = dni;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    public Dni getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = new Dni(dni);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String  getNombreYApellidos(){
        return name + " " + apellido1 + " " + apellido2;
    }


    @Override
    public boolean equals(Object obj) {
        //Reflexivo
        if ( this == obj ) return true;

        //No nulo
        if ( obj == null ) return false;

        //Simetrico
        //La máquina virtual mantiene una única instancia de cada clase, por lo que esta comparación es correcta
        //Usar instanceof no garantiza la simetría porque es true para una clase y sus hijos
        if ( this.getClass() != obj.getClass() ) return false;

        // una vez que sabemos que son del mismo tipo hacemos cast para que el compilador lo sepa también
        if ( this.getDni().equals(this.getClass().cast(obj).getDni()))
            return true;

        if ( this.getDni() != null )
            return this.getDni().equals( this.getClass().cast(obj).getDni());
        return false;
    }

    @Override
    public String toString() {
        return "DNI = " + dni +
                "\nNombre = " + name +
                "\n1º Apellido = " + apellido1 +
                "\n2º Apellido = " + apellido2;
    }
}
