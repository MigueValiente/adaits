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
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Persona other = (Persona)obj;
        if (!name.equals(other.name)) return false;
        if (!apellido1.equals(other.apellido1)) return false;
        if (!apellido2.equals(other.apellido2)) return false;
        return dni.equals(other.dni);
    }

    @Override
    public String toString() {
        return "DNI = " + dni +
                "\nNombre = " + name +
                "\n1º Apellido = " + apellido1 +
                "\n2º Apellido = " + apellido2;
    }
}
