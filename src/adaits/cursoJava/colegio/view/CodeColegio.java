package adaits.cursoJava.colegio.view;
import adaits.cursoJava.mvc.menu.Codigo;
import adaits.cursoJava.mvc.menu.EventSelectOption;
import adaits.cursoJava.mvc.menu.ItemMenu;

public class CodeColegio extends Codigo {
    public static final int GESTION_DE_PERSONAL = 1;
    public static final int GESTION_EDUCATIVA = 2;
    public static final int GESTION_DE_ADMINISTRACION = 3;
    public static final int SALIR = 4;

    public static final int GESTION_DE_EMPLEADOS = 11;
    public static final int GESTION_DE_ALUMNOS = 12;
    public static final int VOLVER = 13;

    public static final int CREAR_TITULACION = 21;
    public static final int ELIMINAR_TITULACION = 22;


    public CodeColegio(int option, ItemMenu item) {
        super(option, item);
    }

    public CodeColegio(ItemMenu item) {
        super(item);
    }

    @Override
    public void onSelectOption(EventSelectOption e) {
        switch (e.getOption()){
            case GESTION_DE_PERSONAL:
                op1Action();
                break;
            case GESTION_EDUCATIVA:
                op2Action();
                break;
            case GESTION_DE_ADMINISTRACION:
                op3Action();
                break;
            case SALIR:
                op4Action();
                break;
            case GESTION_DE_EMPLEADOS:
                op5Action();
                break;
            case GESTION_DE_ALUMNOS:
                op6Action();
                break;
            case VOLVER:
                op7Action();
                break;
            case CREAR_TITULACION:
                op8Action();
                break;
            case ELIMINAR_TITULACION:
                op9Action();
                break;
            default:
                opDefaultAction();
        }

    }
    private void op1Action(){
        getItem().getSubMenu().exec();
    }
    private void op2Action(){
        getItem().getSubMenu().exec();
    }

    private void op3Action(){
        System.out.println(getItem().getLabel());
    }

    private void op4Action(){
        System.exit(0);
    }


    private void op5Action(){
      System.out.println(getItem().getLabel());
    }

    private void op6Action(){
        System.out.println(getItem().getLabel());
    }

    private void op7Action(){
        goUp();
    }

    private void op8Action(){
        System.out.println(getItem().getLabel());
    }
    private void op9Action(){
        System.out.println(getItem().getLabel());
    }

    private void opDefaultAction(){
        System.out.println("¡¡¡ERROR!!! Debe introducir una opción válida");
    }
    private void goUp(){
        getItem().getParent().getPadre().exec();
    }
}
