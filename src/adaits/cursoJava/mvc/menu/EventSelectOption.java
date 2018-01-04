package adaits.cursoJava.mvc.menu;

import java.util.EventObject;

public class EventSelectOption extends EventObject {
    private int option;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param option La opción elegida
     * @throws IllegalArgumentException if source is null.
     */
    public EventSelectOption(Object source, int option) {
        super(source);
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
