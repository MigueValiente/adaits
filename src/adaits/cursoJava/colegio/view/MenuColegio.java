package adaits.cursoJava.colegio.view;

import adaits.cursoJava.mvc.menu.ItemMenu;
import adaits.cursoJava.mvc.menu.Menu;

import java.util.ArrayList;

public class MenuColegio extends Menu{
    public MenuColegio(String titulo, String[] labels,CodeColegio listener) {
        super(titulo, labels,listener);
    }

    public MenuColegio(String label,CodeColegio listener) {
        super(label,listener);
    }

    public MenuColegio(String label, ArrayList<ItemMenu> opciones,CodeColegio listener) {
        super(label, opciones,listener);
    }
}
