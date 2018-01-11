package adaits.cursoJava.colegio.view;

import java.util.Scanner;

public class LecturaPorConsola {
    Scanner input = new Scanner(System.in);
    String label;

    public LecturaPorConsola() {
    }
    public LecturaPorConsola(String label) {
        this.label = label;
    }

    public String getString(String label){
        System.out.println(label);
        return input.nextLine();
    }

    public int getInt(String label){
        System.out.println(label);
        return input.nextInt();
    }

    public double getDouble(String label){
        System.out.println(label);
        return input.nextDouble();
    }

}
