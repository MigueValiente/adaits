package adaits.cursoJava.miscelaneas.teatro;

import java.util.Arrays;

public class Teatro {
    private static Zona[] zonas;
    static int PASILLO;


    public Teatro(Zona[] z){
        zonas = new Zona[z.length];
        //zonas = Arrays.copyOf(z,z.length);
        for (int i = 0; i < z.length; i++) {
            z[i].setnZona(i);
            zonas[i] = z[i];
        }
        PASILLO = 2;
    }

    private int nZonas(){
        return zonas.length;
    }
    public void ocupar (Zona z,int f, int b){
        int nZ = z.getnZona();
        if (nZ < 0 || nZ >= zonas.length)
            System.out.println("La zona elegida no existe");
        else
            z.setState(f,b,State.OCUPADA);
    }

    public void ocupar(int butaca){
        Zona zona = zonas[butaca/1000];
        zona.setState(butaca%1000,State.OCUPADA);
    }

    public void reservar(int butaca){
        Zona zona = zonas[butaca/1000];
        zona.setState(butaca%1000,State.RESERVADA);
    }

    public void romper(int butaca){
        Zona zona = zonas[butaca/1000];
        zona.setState(butaca%1000,State.ROTA);
    }

    public void liberar(int butaca){
        Zona zona = zonas[butaca/1000];
        zona.setState(butaca%1000,State.LIBRE);
    }

    public void reservar (Zona z,int f, int b){
        int nZ = z.getnZona();
        if (nZ < 0 || nZ >= zonas.length)
            System.out.println("La zona elegida no existe");
        else
            z.setState(f,b,State.RESERVADA);
    }

    public void romper (Zona z,int f, int b){
        int nZ = z.getnZona();
        if (nZ < 0 || nZ >= zonas.length)
            System.out.println("La zona elegida no existe");
        else
            z.setState(f,b,State.ROTA);
    }

    public void liberar (Zona z,int f, int b){
        int nZ = z.getnZona();
        if (nZ < 0 || nZ >= zonas.length)
            System.out.println("La zona elegida no existe");
        else
            z.setState(f,b,State.LIBRE);
    }

    public double caja(){
        double c = 0;
        for (int i = 0; i < zonas.length; i++)
            c += zonas[i].caja();
        return c;
    }

    public void listarTeatro(){
        for (int i = 0; i < zonas.length; i++) {
            System.out.println("Zona " + i);
            zonas[i].listarZona();
            System.out.println();
        }
    }

    private int maxLongZona(){
        int max =0;
        for (int i = 0; i < Teatro.zonas.length; i++) {
            if (Teatro.zonas[i].getBUTACAS() > max)
                max = Teatro.zonas[i].getBUTACAS();
        }
        return max;
    }

    public void populateRandom(){
        int percent = 30;
        for (int i = 0; i < nZonas(); i++) {
            for (int j = 0; j < zonas[i].getFILAS()*zonas[i].getBUTACAS()*percent/100; j++) {
                int f = (int) (Math.random() * zonas[i].getFILAS());
                int b = (int) (Math.random() * zonas[i].getBUTACAS());
                ocupar(zonas[i],f,b);
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        int max = maxLongZona();
        for (int i = 0; i < zonas.length; i++) {
            zonas[i].setShift((max - zonas[i].getBUTACAS())/2);
            output += zonas[i] + "\n";
        }
        return output;
    }
}
