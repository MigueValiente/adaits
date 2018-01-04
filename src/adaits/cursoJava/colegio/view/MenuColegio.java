package adaits.cursoJava.colegio.view;

import adaits.cursoJava.mvc.menu.ItemMenu;
import adaits.cursoJava.mvc.menu.Menu;

import java.util.ArrayList;

public class MenuColegio extends Menu{
    public MenuColegio(String titulo, String[] labels) {
        super(titulo, labels);
    }

    public MenuColegio(String label) {
        super(label);
    }

    public MenuColegio(String label, ArrayList<ItemMenu> opciones) {
        super(label, opciones);
    }
}
