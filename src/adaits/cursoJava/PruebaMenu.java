package adaits.cursoJava;

import adaits.cursoJava.mvc.menu.*;

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

        ItemMenu op41 = new ItemMenu("Opción 41",41, new Code());
        ItemMenu op42 = new ItemMenu("Opción 42",42, new Code());
        ItemMenu op43 = new ItemMenu("Volver",43, new Code());
        ItemMenu a[] = {op41,op42,op43};
        ArrayList<ItemMenu> opciones4 = new ArrayList<>(Arrays.asList(a));

        Menu m4 = new Menu("Submenú M4",opciones4,new Code());

        ItemMenu op1 = new ItemMenu("Opción 1",OP1, new Code());
        ItemMenu op2 = new ItemMenu("Opción 2",OP2, new Code());
        ItemMenu op3 = new ItemMenu("Opción 3",OP3, new Code());
        ItemMenu op4 = new ItemMenu("SubMenu",m4,OP4, new Code());
        ItemMenu op5 = new ItemMenu("Salir",OP5, new Code());

        ItemMenu[] opciones = {op1,op2,op3,op4,op5};
        ArrayList<ItemMenu> opciones5 = new ArrayList<>(Arrays.asList(opciones));

        Menu m = new Menu("Principal",opciones5,new Code());

        m.exec();

    }


}
