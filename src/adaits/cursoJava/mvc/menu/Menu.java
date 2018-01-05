package adaits.cursoJava.mvc.menu;

import adaits.cursoJava.colegio.view.CodeColegio;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que modela un menú de opciones
 */
public class Menu {
    private ArrayList<ItemMenu> opciones = new ArrayList<>();
    private final String label;
    private Menu parent = null;
    private static int nMenus = 0;
//    SelectOptionListener listener;
//    CodeColegio code;


    public Menu(String titulo, String[] labels) {
        nMenus++;
        label = titulo;
        for (int i = 0; i < labels.length; i++) {
            ItemMenu im = new ItemMenu(labels[i], nMenus);
            opciones.add(im);
            opciones.get(i).parent = this;
//            code = new CodeColegio(nMenus,im);
        }

    }

    public Menu(String label) {
        this.label = label;
    }

    /**
     * Constructor de un Menú
     *
     * @param label    Etiqueta que aparece en el título del menú
     * @param opciones Opciones del menú
     */
    public Menu(String label, ArrayList<ItemMenu> opciones) {
        nMenus++;
        this.opciones = opciones;
        for (int i = 0; i < opciones.size(); i++) {
            //this.opciones[i] = opciones[i];
            opciones.get(i).parent = this;
            //addSelectOptionListener(code);
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
        System.out.println(this);
        do {
            op = getOption();
            triggerSelectOption(op);
        } while (op != -1);
    }


    private void triggerSelectOption(int option) {
        ItemMenu im = getItemMenu(option);
        if (im != null){
            int selection = im.getItemMenuOption();
            //////// CORREGIR ESTO
            ItemMenu.listener.get(0).onSelectOption(new EventSelectOption(this, selection));
            //////// CORREGIR ^
        }
    }

//
//    public void addSelectOptionListener(SelectOptionListener l) {
//        listener = l;
//    }

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
           