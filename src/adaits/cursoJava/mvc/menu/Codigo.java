package adaits.cursoJava.mvc.menu;

/**
 * Clase que permite introducir el código a ejecutar según la opción del menú
 * @author José Espejo
 * @version 0.0.1
 */
public abstract class Codigo implements SelectOptionListener{

    int option;
    ItemMenu item;


    public Codigo() {
    }

    public Codigo(int option, ItemMenu item) {
        this.option = option;
        this.item = item;
        item.addSelectOptionListener(this);
    }

    /**
     * @param item del tipo adaits.cursoJava.mvc.menu.ItemMenu
     */
    public void setItem(ItemMenu item) {
        this.item = item;
    }

    public Codigo(ItemMenu item) {
        this.item = item;
        item.addSelectOptionListener(this);
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public ItemMenu getItem() {
        return item;
    }

    @Override
    public abstract void onSelectOption(EventSelectOption e);

}
