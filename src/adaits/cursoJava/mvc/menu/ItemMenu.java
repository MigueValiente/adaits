package adaits.cursoJava.mvc.menu;

import adaits.cursoJava.colegio.view.CodeColegio;

import java.util.ArrayList;
import java.util.EventObject;

public class ItemMenu{
    private String label;
    Menu subMenu;
    Menu parent;
    public static ArrayList<SelectOptionListener> listener;
    CodeColegio code;

    //final Codigo code;
    private int itemMenuOption;
    //EventSelectOption event;

    public ItemMenu(String label,int option) {
        this(label);
        setItemMenuOption(option);
        //code = new Codigo(itemMenuOption,this);
        //event = new EventSelectOption(this,option);
    }

    public ItemMenu(String label, Menu subMenu, int option) {
        this(label,option);
        this.subMenu = subMenu;
    }

    public ItemMenu(String label) {
        this.label = label;
        code = new CodeColegio(this);
        addSelectOptionListener(code);
    }

    public ItemMenu(String label, Menu subMenu) {
        this(label);
        this.subMenu = subMenu;
    }

    public void setItemMenuOption(int itemMenuOption) {
        this.itemMenuOption = itemMenuOption;
        code.setOption(itemMenuOption);
    }

    public int getItemMenuOption() {
        return itemMenuOption;
    }

    public ItemMenu(SelectOptionListener listener) {
        this.listener.add(listener);
    }

    public void addSelectOptionListener(SelectOptionListener listener) {
        this.listener.add(listener);
    }

//    public SelectOptionListener getListener() {
//        return listener;
//    }

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
