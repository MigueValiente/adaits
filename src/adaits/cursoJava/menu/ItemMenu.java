package adaits.cursoJava.menu;

public class ItemMenu {
    String label;
    Menu subMenu;
    Menu parent;
    Codigo code;
    int itemMenuOption;


    public ItemMenu(String label,int option) {
        this.label = label;
        itemMenuOption = option;
        Codigo code = new Codigo();
        code.option = itemMenuOption;
        code.item = this;
        this.code = code;
    }

    public ItemMenu(String label, Menu subMenu, int option) {
        this.label = label;
        this.subMenu = subMenu;
        itemMenuOption = option;
        Codigo code = new Codigo();
        code.option = itemMenuOption;
        code.item = this;
        this.code = code;
    }

    public void goUp(){

    }


    @Override
    public String toString() {
        return label;
    }
}
