package adaits.cursoJava.mvc.menu;

import java.util.EventObject;

public class EventSelectOption extends EventObject {
    private int option;
    private ItemMenu itemMenu;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param option La opción elegida
     * @throws IllegalArgumentException if source is null.
     */
    public EventSelectOption(Object source, int option, ItemMenu itemMenu) {
        super(source);
        this.option = option;
        this.itemMenu = itemMenu;
    }

    public int getOption() {
        return option;
    }

    /**
     * Getter de
     *
     * @ return
     */
    public ItemMenu getItemMenu() {
        return itemMenu;
    }
}
