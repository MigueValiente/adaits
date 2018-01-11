package adaits.cursoJava.mvc.menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que modela un menú de opciones
 */
public class Menu extends ItemMenu{
    private ArrayList<ItemMenu> opciones = new ArrayList<>();
    private static int nMenus = 0;


    public Menu(String label, String[] labels, SelectOptionListener listener) {
        super(label,listener);
        nMenus++;
        for (int i = 0; i < labels.length; i++) {
            ItemMenu im = new ItemMenu(labels[i], nMenus,listener);
            opciones.add(im);
            opciones.get(i).parent = this;
        }

    }

    public Menu(String label, SelectOptionListener listener) {
        super(label,listener);
    }

    /**
     * Constructor de un Menú
     *
     * @param label    Etiqueta que aparece en el título del menú
     * @param opciones Opciones del menú
     */
    public Menu(String label, ArrayList<ItemMenu> opciones, SelectOptionListener listener) {
        super(label,listener);
        nMenus++;
        this.opciones = opciones;
        for (int i = 0; i < opciones.size(); i++) {
            opciones.get(i).parent = this;
            if (opciones.get(i).subMenu != null) {
                opciones.get(i).subMenu.parent = this;
            }
        }
        this.label = label;
    }

    public Menu getPadre() {
        return parent;
    }

    public void add(ItemMenu im) {
        if (im.getItemMenuOption() == 0)
            im.setItemMenuOption(++nMenus);
        im.parent = this;
        if (im.subMenu != null)
            im.subMenu.parent = this;
        opciones.add(im);
    }


    private int getOption() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void exec() {
        int op;
        do {
            System.out.println(this);
            op = getOption();
            triggerSelectOption(op);
        } while (op != -1);
    }


    private void triggerSelectOption(int option) {
        ItemMenu im = getItemMenu(option);
        if (im != null){
            int selection = im.getItemMenuOption();
            im.getListener().onSelectOption(new EventSelectOption(im, selection,im));
        }
    }


    private ItemMenu getItemMenu(int option){
        for (int i = 0;i < opciones.size();i++) {
            if (opciones.get(i).getItemMenuOption() == option)
                return opciones.get(i);
        }
        return null;
    }

    private String separator(int l) {
        String output = "";
        for (int i = 0; i < l; i++) {
            output += "-";
        }
        return output;
    }


    @Override
    public String toString() {
        String output = "";
        output += label + "\n";
        output += separator(label.length()) + "\n";
        for (int i = 0; i < opciones.size(); i++) {
            output += "(" + (opciones.get(i).getItemMenuOption()) + ")";
            if (opciones.get(i).subMenu != null)
                output += "»";
            else
                output += " ";
            output += opciones.get(i) + "\n";
        }
        return output;
    }
}
           