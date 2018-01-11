package adaits.cursoJava.mvc.menu;


public class ItemMenu{
    String label;
    Menu subMenu;
    Menu parent;
    private SelectOptionListener listener;

    private int itemMenuOption;

    public ItemMenu(String label,int option,SelectOptionListener listener) {
        this(label,listener);
        setItemMenuOption(option);
    }

    public ItemMenu(String label, Menu subMenu, int option,SelectOptionListener listener) {
        this(label,option,listener);
        this.subMenu = subMenu;
    }

    public ItemMenu(String label,SelectOptionListener listener) {
        this.label = label;
        addSelectOptionListener(listener);
    }

    public ItemMenu(String label, Menu subMenu, SelectOptionListener listener) {
        this(label,listener);
        this.subMenu = subMenu;
    }

    public void setItemMenuOption(int itemMenuOption) {
        this.itemMenuOption = itemMenuOption;
    }

    public int getItemMenuOption() {
        return itemMenuOption;
    }


    /**
     * Getter de
     *
     * @ return
     */
    public SelectOptionListener getListener() {
        return listener;
    }

    public void addSelectOptionListener(SelectOptionListener listener) {
        this.listener = listener;
        ((Codigo)listener).setItem(this);
    }

    public Menu getParent() {
        return parent;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void goUp(){

    }


    @Override
    public String toString() {
        return label;
    }

}
