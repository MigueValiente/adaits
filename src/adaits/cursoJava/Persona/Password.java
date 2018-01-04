package adaits.cursoJava.Persona;

public class Password {
    private String psw="";

    public Password() {
        creaPassword();
    }

    public Password(String psw) {
        this.psw = psw;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        if (isPswStrong(psw))
            this.psw = psw;
        else
            System.out.println("El password introducido no es seguro");
    }

    private void creaPassword(){
        String newPsw = "";
        char newChar;
        int n;
        final int MAX = 125;
        final int MIN = 35;
        final int RANGO = MAX-MIN+1;

        int i=0;
        do{
            n = (int) (Math.random() * RANGO + MIN);
            newChar = (char)n;
            newPsw += newChar;
        }while (!isPswStrong(newPsw));
//        for(int i = 0;i<8;i++){
//            n = (int) (Math.random() * RANGO + MIN);
//            newChar = (char)n;
//            newPsw += newChar;
//        }
        psw = newPsw;
    }

    private boolean isPswStrong(String psw){
        // Debe tener al menos 8 caracteres, dos numeros, dos mayúsculas y dos símbolos
        int carac=0;
        int num=0;
        int may=0;
        int sim=0;
        for (int i = 0;i<psw.length();i++){
            carac++;
            int c = (int)psw.charAt(i);
            if ((c >= 35 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 125)) sim++;
            if (c >= 48 && c <= 57) num++;
            if (c >= 65 && c <= 90) may++;
        }
        return carac >= 8 && num >= 2 && may >= 2 && sim >= 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Password))
            return false;
        Password newPsw = (Password) obj;
        return psw.equals(newPsw.psw);
    }

    @Override
    public String toString() {
        return psw;
    }
}
