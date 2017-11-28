package adaits.cursoJava;

import adaits.cursoJava.menu.ItemMenu;
import adaits.cursoJava.menu.Menu;

public class PruebaMenu {
    public static void main(String[] args) {
        final int OP1 = 1;
        final int OP2 = 2;
        final int OP3 = 3;
        final int OP4 = 4;
        final int OP5 = 5;

        ItemMenu op41 = new ItemMenu("Opción 41",41);
        ItemMenu op42 = new ItemMenu("Opción 42",42);
        ItemMenu op43 = new ItemMenu("Volver",43);
        ItemMenu[] opciones4 = {op41,op42,op43};

        Menu m4 = new Menu("Submenú M4",opciones4);

        ItemMenu op1 = new ItemMenu("Opción 1",OP1);
        ItemMenu op2 = new ItemMenu("Opción 2",OP2);
        ItemMenu op3 = new ItemMenu("Opción 3",OP3);
        ItemMenu op4 = new ItemMenu("SubMenu",m4,OP4);
        ItemMenu op5 = new ItemMenu("Salir",OP5);

        ItemMenu[] opciones = {op1,op2,op3,op4,op5};
        Menu m = new Menu("Principal",opciones);

        m.exec();
    }
}
