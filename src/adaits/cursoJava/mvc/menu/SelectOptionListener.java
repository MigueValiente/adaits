package adaits.cursoJava.mvc.menu;

import java.util.EventListener;

public interface SelectOptionListener extends EventListener {
    public abstract void onSelectOption(EventSelectOption e);
}
