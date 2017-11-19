package adaits.cursoJava.mathematic;

public class Complejo {
    private double real;
    private double imag;

    //Constructor por defecto de la clase
    public Complejo() {
        this.real = 0;
        this.imag = 0;
    }
    //Constructor con parámetros
    public Complejo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    //métodos setters y getters
    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    //sumar dos números complejos
    //(a, b) + (c, d) = (a + c, b + d);
    public Complejo sumar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real + c.real;
        aux.imag = imag + c.imag;
        return aux;
    }

    //restar dos números complejos
    //(a, b) - (c, d) = (a - c, b - d);
    public Complejo restar(Complejo c){
/*        Complejo aux = new Complejo();
        aux.real = real - c.real;
        aux.imag = imag - c.imag;
        return aux;*/
        return this.sumar(c.multiplicar(-1));
    }

    //multiplicar dos números complejos
    //(a, b) * (c, d) = (a*c – b*d, a*d + b*c)
    public Complejo multiplicar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real * c.real - imag * c.imag;
        aux.imag = real * c.imag + imag * c.real;
        return aux;
    }

    //multiplicar un número complejo por un número de tipo double
    //(a, b) * n = (a * n, b * n)
    public Complejo multiplicar(double n){
        Complejo aux = new Complejo();
        aux.real = real * n;
        aux.imag = imag * n;
        return aux;
    }

    // 1/(a,b)
    public Complejo inverso(){
        Complejo c = new Complejo();
        c.real = real / (real * real + imag * imag);
        c.imag = - imag / (real * real + imag * imag);
        return c;
    }

    //dividir dos números complejos
    //(a, b) / (c, d) = ((a*c + b*d) / (c^2 + d^2) , (b*c – a*d) / (c^2 + d^2))
    public Complejo dividir(Complejo c){
/*        Complejo aux = new Complejo();
        aux.real = (real * c.real + imag * c.imag)/(c.real * c.real + c.imag * c.imag);
        aux.imag = (imag * c.real - real * c.imag)/(c.real * c.real + c.imag * c.imag);
        return aux;*/
        return this.multiplicar(c.inverso());
    }

    //método toString
    @Override
    public String toString() {
        String imagToString = "";
        String realToString = "";

        if (real != 0) {
            realToString += real;
            if (imag > 0)
                realToString += "+";
        }
        if (imag != 0) {
            if (imag > 0) {
                if (imag != 1) {
                    imagToString += imag;
                }
            }else{
                if (imag != -1)
                    imagToString += imag;
                else
                    imagToString += "-";
            }
            imagToString += "i";
        }
        if (real == 0 && imag == 0)
            return "0";

        return realToString + imagToString;
    }

    //método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complejo other = (Complejo) obj;
        if (this.real != other.real) {
            return false;
        }
        if (this.imag != other.imag) {
            return false;
        }
        return true;
    }
} //Fin de la Clase org.adaits.mathematics.Complejo Java
