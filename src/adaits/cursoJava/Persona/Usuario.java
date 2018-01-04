package adaits.cursoJava.Persona;

public class Usuario extends Persona{
    // Atributos
    private String user;
    private Password psw;

    // Métodos
    public Usuario(Usuario user){
        super(user.dni,user.name,user.apellido1,user.apellido2);
        this.user = user.user;
        psw = user.psw;
    }

    public Usuario(String dni, String name, String apellido1, String apellido2, String user, String psw) {
        super(new Dni(dni),name,apellido1,apellido2);
        this.user = user;
        if (psw.equals(""))
            this.psw = new Password();
        else
            this.psw = new Password(psw);
    }

    // Setters y Getters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Password getPsw() {
        return psw;
    }

    public void setPsw(Password psw) {
        this.psw = psw;
    }

    // toString

    @Override
    public String toString() {
        return super.toString() +
                "\nUsuario = " + user +
                "\nPassword = " + psw ;
    }
}