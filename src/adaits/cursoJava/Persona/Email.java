package adaits.cursoJava.Persona;

public class Email {
    private String email;


    public Email(String txt){
        if (isEmailOk(txt))
            email = txt;
        else
            System.out.println("El email no está bien formado");
    }

    public boolean isEmailOk(String txt){
        int state = 0;
        int c = 0;
        for (int i = 0; i < txt.length(); i++) {
            char letra = txt.charAt(i);
            switch (state){
                case 0:
                    switch (letra){
                        case '.':
                            if (c > 1){
                                state = 1;
                                c = 0;
                            }else return false;
                            break;
                        case '@':
                            if (c > 1){
                                state = 2;
                                c = 0;
                            }else return false;
                            break;
                        default:
                            c++;
                    }
                    break;
                case 1:
                    switch (letra){
                        case '.':
                            if (c > 1){
                                c = 0;
                            }else return false;
                            break;
                        case '@':
                            if (c > 1){
                                state = 2;
                                c = 0;
                            }else return false;
                            break;
                        default:
                            c++;
                    }
                    break;
                case 2:
                    if (letra == '.')
                        if (c > 1) {
                            c = 0;
                            state = 3;
                        }
                        else
                            return false;
                    else if (letra == '@')
                        return false;
                    else
                        c++;
                    break;
                case 3:
                    if (letra == '.')
                        if (c > 1) {
                            c = 0;
                        }
                        else
                            return false;
                    else if (letra == '@')
                        return false;
                    else
                        c++;
                    break;
            }
        }
        if (c > 1 && state == 3) return true;
        else return false;
    }

    public void setEmail(String txt) {
        if (isEmailOk(txt))
            email = txt;
        else
            System.out.println("El email no está bien formado");
    }

    public String getEmail() {
        return email;
    }

}
