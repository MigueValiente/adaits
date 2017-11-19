package adaits.cursoJava.mathematic;

public class Polinomio {
    private int polinomio[];

    /**
     * Constructor sin parámetros.
     * Crea un polinomio de grado 1 con un solo coeficiente 0x^0
     */
    public Polinomio(){
        polinomio = new int[1];
        polinomio[0] = 0;
    }

    /**
     * Constructor con parámetros.<br>
     *     Crea un org.adaits.mathematics.PolinomioF con un parámetro
     * @param p Array de enteros que contiene los coeficientes de los términos del org.adaits.mathematics.PolinomioF y cuyo índice corresponde a los
     *          exponentes de cada término
     */
    public Polinomio(int[] p) {
        polinomio = new int[p.length];
        for (int i=0;i<p.length;i++) {
            polinomio[i] = p[i];
        }
    }

    /**
     * Constructor con un parámetro de tipo entero que crea un org.adaits.mathematics.PolinomioF del tamaño del parámetro
     * @param c Entero
     */

    public Polinomio(int c){
        polinomio = new int[c];
    }

    /**
     * Método privado qu calcula el mayor de dos números enteros
     * @param a Entero
     * @param b Entero
     * @return El mayor de los dos enteros
     */
    private int max(int a, int b){
        return a>b?a:b;
    }

    /**
     * Método que suma dos polinomios
     * @param p org.adaits.mathematics.PolinomioF
     * @return org.adaits.mathematics.PolinomioF suma
     */
    public Polinomio sumar (Polinomio p){
        Polinomio newP = new Polinomio(max(this.polinomio.length,p.polinomio.length));
        for (int i=0;i<newP.polinomio.length;i++){
            int a = 0;
            int b = 0;
            if (this.polinomio.length > i) a = this.polinomio[i];
            if (p.polinomio.length > i) b = p.polinomio[i];
            newP.polinomio[i] = a + b;
        }
        return newP;
    }

    /**
     * Método que calcula el polinomio con todos sus coeficientes cambiados de signo
     * @return org.adaits.mathematics.PolinomioF
     */
    public Polinomio opuesto (){
        return this.producto(-1);
    }

    /**
     * Método que calcula la resta de dos polinomios
     * @param p org.adaits.mathematics.PolinomioF
     * @return org.adaits.mathematics.PolinomioF resta
     */
    public Polinomio restar(Polinomio p){
        return this.sumar(p.opuesto());
    }

    /**
     * Método que calcula el producto de dos polinomios
     * @param p org.adaits.mathematics.PolinomioF
     * @return org.adaits.mathematics.PolinomioF producto
     */
    public Polinomio producto(Polinomio p){
        Polinomio newP = new Polinomio(this.polinomio.length + p.polinomio.length -1);
        for (int i=0;i < this.polinomio.length;i++){
            for (int j=0;j < p.polinomio.length;j++){
                int r = this.polinomio[i]*p.polinomio[j];
                newP.polinomio[i+j] += r;
            }
        }
        return newP;
    }
    /**
     * Método que calcula el producto de un polinomio por un entero
     * @param e Entero
     * @return org.adaits.mathematics.PolinomioF producto
     */
    public Polinomio producto(int e){
        Polinomio p = new Polinomio();
        p.polinomio[0] = e;
        return this.producto(p);
    }

    @Override
    public String toString() {
        String salida ="";
        for (int i = polinomio.length-1;i>=0;i--){
            if (polinomio[i] != 0){
                salida += (i != polinomio.length-1)? (polinomio[i] > 0? " +":" ") : "";
                salida += polinomio[i] + ((i != 0)? i != 1?("x^" + i):"x":"");
            }
        }
        return salida;
    }
}