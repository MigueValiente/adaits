package adaits.cursoJava.miscelaneas.bingo;

public class Bingo {

    private final Bombo bombo = new Bombo();
    private final int AFORO = 100;
    private final Taquilla taquilla = new Taquilla(AFORO);

    public Bingo(int n) {

//        for (int i = 0; i < n; i++) {
//            cartones[i] = new Carton();
//        }
    }

    public Bingo() {
        this(10);
    }

    public Taquilla getTaquilla() {
        return taquilla;
    }

    public int getAFORO() {
        return AFORO;
    }

    public void venderCartones(Binguero b,int cantidad){
        for (int i = 0; i < cantidad; i++) {
            taquilla.venderCarton(b);
        }
    }

    public double hacerCaja (){
        return taquilla.getCaja();
    }

    public int[] jugar(){
        int [] ganadores = new int[9];
        int g = 0;
        boolean hayGanador = false;
        while (!hayGanador){
            int b = bombo.sacarBola();
            System.out.println("EL " + b);
            for (int i = 0; i < taquilla.getCartones().length; i++) {
                if (taquilla.getCartones()[i] != null) {
                    taquilla.getCartones()[i].comprobar(b);
                    if (taquilla.getCartones()[i].ganador()) {
                        ganadores[g++] = i + 1;
                        hayGanador = true;
                    }
                }else
                    break;

            }
            System.out.println(this);

        }
        return ganadores;
    }



    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < taquilla.getCartones().length; i++) {
            if (taquilla.getCartones()[i] != null)
                output += "Cartón nº " + (i+1) + "\n" + taquilla.getCartones()[i] + "\n";
            else
                break;
        }
        return output;
    }
}
