package adaits.cursoJava.menu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que modela un menú de opciones
 */
public class Menu {
    private ItemMenu opciones[];
    private String label;
    private Menu parent;


    /**
     * Constructor de un Menú
     * @param label Etiqueta que aparece en el título del menú
     * @param opciones Opciones del menú
     */
    public Menu(String label, ItemMenu[] opciones) {
        this.opciones = new ItemMenu [opciones.length];
        for (int i = 0; i < opciones.length; i++) {
            this.opciones[i] = opciones[i];
            opciones[i].parent = this;
            if (opciones[i].subMenu != null) {
                opciones[i].subMenu.parent = this;
            }
        }
        this.label = label;
    }

    public Menu getParent() {
        return parent;
    }

    public void add (ItemMenu im){
        // Creamos un nuevo array de tamaño uno más
        //ItemMenu[] newArray;
        opciones = Arrays.copyOf(opciones,opciones.length+1);
    }

    int getOption(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void exec(){
        int op;
        System.out.println(this);
        do{
            op = getOption();
            if (op > 0 && op <= opciones.length)
                opciones[op-1].code.run();
        }while (op != -1);
    }

    private String separator(int l){
        String output = "";
        for (int i = 0; i < l; i++) {
            output += "-";
        }
        return output;
    }


    @Override
    public String toString() {
        String output ="";
        output += label + "\n";
        output += separator(label.length()) + "\n";
        for (int i = 0; i < opciones.length; i++) {
            output += "(" + (i+1) + ")";
            if (opciones[i].subMenu != null)
                output += "»";
            else
                output += " ";
            output += opciones[i] + "\n";
        }
        return output;
    }
}
