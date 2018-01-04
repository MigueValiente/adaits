package adaits.cursoJava;

import adaits.cursoJava.mvc.menu.ItemMenu;
import adaits.cursoJava.mvc.menu.Menu;
import adaits.cursoJava.mvc.menu.EventSelectOption;
import adaits.cursoJava.mvc.menu.SelectOptionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class PruebaMenu {

    public static void main(String[] args) throws NoSuchMethodException {
        final int OP1 = 1;
        final int OP2 = 2;
        final int OP3 = 3;
        final int OP4 = 4;
        final int OP5 = 5;

        ItemMenu op41 = new ItemMenu("Opción 41",41);
        ItemMenu op42 = new ItemMenu("Opción 42",42);
        ItemMenu op43 = new ItemMenu("Volver",43);
        ItemMenu a[] = {op41,op42,op43};
        ArrayList<ItemMenu> opciones4 = new ArrayList<>(Arrays.asList(a));

        Menu m4 = new Menu("Submenú M4",opciones4);

        ItemMenu op1 = new ItemMenu("Opción 1",OP1);
        ItemMenu op2 = new ItemMenu("Opción 2",OP2);
        ItemMenu op3 = new ItemMenu("Opción 3",OP3);
        ItemMenu op4 = new ItemMenu("SubMenu",m4,OP4);
        ItemMenu op5 = new ItemMenu("Salir",OP5);

        ItemMenu[] opciones = {op1,op2,op3,op4,op5};
        ArrayList<ItemMenu> opciones5 = new ArrayList<>(Arrays.asList(opciones));

        Menu m = new Menu("Principal",opciones5);

        m.exec();

    }


}
