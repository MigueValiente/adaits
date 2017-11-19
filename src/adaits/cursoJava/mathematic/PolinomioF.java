package adaits.cursoJava.mathematic;

public class PolinomioF {
    private Fraccion polinomio[];

    /**
     * Constructor sin parámetros.
     * Crea un polinomio de grado 1 con un solo coeficiente 0x^0
     */
    public PolinomioF(){
        polinomio = new Fraccion[1];
        polinomio[0] = new Fraccion(0);
    }

    /**
     * Constructor con parámetros.<br>
     *     Crea un org.adaits.mathematics.PolinomioF con un parámetro
     * @param p Array de enteros que contiene los coeficientes de los términos del org.adaits.mathematics.PolinomioF y cuyo índice corresponde a los
     *          exponentes de cada término
     */
    public PolinomioF(Fraccion[] p) {
        this(p,0,p.length - 1);
//        for (int i=0;i<p.length;i++) {
//            polinomio[i] = p[i];
//        }
    }

    /**
     * Constructor que crea un org.adaits.mathematics.Polinomio a partir de otro que se le pasa como parámetro
     * @param p org.adaits.mathematics.Polinomio
     */

    public PolinomioF(PolinomioF p){
        this(p.polinomio);
    }

    /**
     * Constructor con un parámetro de tipo entero que crea un org.adaits.mathematics.PolinomioF del tamaño del parámetro
     * @param c Entero
     */

    public PolinomioF(int c){
        polinomio = new Fraccion[c];
        for (int i = 0;i < polinomio.length;i++) {
            polinomio[i] = new Fraccion(0);
        }
    }

    /**
     * Constructor que crea un org.adaits.mathematics.Polinomio a partie de un subarray
     * @param p Array de Fracciones
     * @param inicio índice de inicio del subarray
     * @param fin índice de fin del subarray
     */
    public PolinomioF (Fraccion[] p,int inicio,int fin){
        polinomio = new Fraccion[fin - inicio + 1];
        for (int i = inicio,j=0;i<= fin;i++,j++) {
            polinomio[j] = p[i];
        }
    }

    /**
     * Calcula el grado de un polinomio
     * @return entero. grado del polinomio
     */
    public int grado(){
        return this.polinomio.length - 1;
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
    public PolinomioF sumar (PolinomioF p){
        PolinomioF newP = new PolinomioF(max(this.polinomio.length,p.polinomio.length));
        int ceros = 0;
        for (int i=0;i<newP.polinomio.length;i++){
            Fraccion a = new Fraccion(0);
            Fraccion b = new Fraccion(0);
            if (this.polinomio.length > i) a = this.polinomio[i];
            if (p.polinomio.length > i) b = p.polinomio[i];
            newP.polinomio[i] = a.sumar(b);
            if (newP.polinomio[i].esCero())
                ceros++;
            else
                ceros=0;
        }
        // eliminamos los términos con coeficiente 0 en los elementos de mayor exponente

        PolinomioF salida = new PolinomioF(newP.polinomio,0,newP.grado()  - ceros);
        return salida;
    }

    /**
     * Método que calcula el polinomio con todos sus coeficientes cambiados de signo
     * @return org.adaits.mathematics.PolinomioF
     */
    public PolinomioF opuesto (){
        return this.producto(-1);
    }

    /**
     * Método que calcula la resta de dos polinomios
     * @param p org.adaits.mathematics.PolinomioF
     * @return org.adaits.mathematics.PolinomioF resta
     */
    public PolinomioF restar(PolinomioF p){
        return this.sumar(p.opuesto());
    }


    /**
     * Método que calcula el producto de dos polinomios
     * @param p org.adaits.mathematics.PolinomioF
     * @return org.adaits.mathematics.PolinomioF producto
     */
    public PolinomioF producto(PolinomioF p){
        PolinomioF newP = new PolinomioF(this.polinomio.length + p.polinomio.length -1);
        for (int i=0;i < newP.polinomio.length;i++){
            newP.polinomio[i] = new Fraccion(0);
        }
        for (int i=0;i < this.polinomio.length;i++){
            for (int j=0;j < p.polinomio.length;j++){
                Fraccion r = this.polinomio[i].multiplicar(p.polinomio[j]);
                newP.polinomio[i+j] = newP.polinomio[i+j].sumar(r);
            }
        }
        return newP;
    }

    /**
     * Método que calcula el producto de un polinomio por una Fracción
     * @param e Fracción
     * @return org.adaits.mathematics.PolinomioF producto
     */

    public PolinomioF producto(Fraccion e){
        PolinomioF p = new PolinomioF();
        p.polinomio[0] = e;
        return this.producto(p);
    }
    /**
     * Método que calcula el producto de un polinomio por un entero
     * @param e Entero
     * @return org.adaits.mathematics.PolinomioF producto
     */
    public PolinomioF producto(int e){
        return this.producto(new Fraccion(e));
    }

    public PolinomioF division (PolinomioF divisor){
        PolinomioF dividendo = new PolinomioF(this);
        PolinomioF cociente = new PolinomioF(dividendo.grado() - divisor.grado() + 1);
        // Mientras el grado del dividendo sea mayor o igual que el del divisor...
        int c;
        int D;
        int d = divisor.grado();
        while ((D=dividendo.grado()) >= divisor.grado()){
            c = dividendo.grado() - divisor.grado();
            PolinomioF cocienteParcial = new PolinomioF(c + 1);
            cociente.polinomio[c] = dividendo.polinomio[D].dividir(divisor.polinomio[d]);
            cocienteParcial.polinomio[c] = cociente.polinomio[c];
            PolinomioF producto = new PolinomioF(divisor.producto(cocienteParcial));
            dividendo = new PolinomioF(dividendo.restar(producto));
        }
        return cociente;
    }

    public PolinomioF resto (PolinomioF divisor){
        PolinomioF dividendo = new PolinomioF(this);
        PolinomioF cociente = new PolinomioF(dividendo.grado() - divisor.grado() + 1);
        // Mientras el grado del dividendo sea mayor o igual que el del divisor...
        int c;
        int D;
        int d = divisor.grado();
        while ((D=dividendo.grado()) >= divisor.grado()){
            c = dividendo.grado() - divisor.grado();
            PolinomioF cocienteParcial = new PolinomioF(c + 1);
            cociente.polinomio[c] = dividendo.polinomio[D].dividir(divisor.polinomio[d]);
            cocienteParcial.polinomio[c] = cociente.polinomio[c];
            PolinomioF producto = new PolinomioF(divisor.producto(cocienteParcial));
            dividendo = new PolinomioF(dividendo.restar(producto));
        }
        return dividendo;
    }

    @Override
    public String toString() {
        String salida ="";
        for (int i = polinomio.length-1;i>=0;i--){
            if (!polinomio[i].esCero()){
                salida += (i != polinomio.length-1)? (polinomio[i].positiva()? " +":" ") : "";
                salida += polinomio[i] + ((i != 0)? i != 1?("x^" + i):"x":"");
            }
        }
        return salida;
    }
}
