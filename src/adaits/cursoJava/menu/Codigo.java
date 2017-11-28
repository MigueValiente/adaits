package adaits.cursoJava.menu;

/**
 * Clase que permite introducir el código a ejecutar según la opción del menú
 * @author José Espejo
 * @version 0.0.1
 */
public class Codigo {

    int option;
    ItemMenu item;

    public void run() {
        switch (option){
            case 1:
                op1Action();
                break;
            case 2:
                op2Action();
                break;
            case 3:
                op3Action();
                break;
            case 4:
                op4Action();
                break;
            case 5:
                op5Action();
                break;
            case 41:
                op41Action();
                break;
            case 42:
                op42Action();
                break;
            case 43:
                op43Action();
                break;
            default:
                opDefaultAction();
        }
    }

    private void op1Action(){
        System.out.println(item.label);
    }
    private void op2Action(){
        System.out.println(item.label);
    }

    private void op3Action(){
        System.out.println(item.label);
    }

    private void op4Action(){
        item.subMenu.exec();
    }


    private void op5Action(){
        System.exit(0);
    }

    private void op41Action(){
        System.out.println(item.label);
    }

    private void op42Action(){
        System.out.println(item.label);
    }

    private void op43Action(){
        item.parent.getParent().exec();
    }

    private void opDefaultAction(){
        System.out.println("¡¡¡ERROR!!! Debe introducir una opción válida");
    }
}
