package adaits.cursoJava.colegio.view;
import adaits.cursoJava.colegio.Colegio;
import adaits.cursoJava.colegio.Titulacion;
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

    public static final int ABRIR_MATRICULA = 121;
    public static final int INCLUIR_ASIGNATURA= 122;

    public static final int CREAR_TITULACION = 21;
    public static final int ELIMINAR_TITULACION = 22;
    public static final int LISTAR_TITULACION = 23;

    Colegio colegio;


    public CodeColegio(){

    }
    public CodeColegio(Colegio colegio){
        this.colegio = colegio;
    }
    public CodeColegio(int option, ItemMenu item) {
        super(option, item);
        item.addSelectOptionListener(this);
    }

    public CodeColegio(ItemMenu item) {
        super(item);
        item.addSelectOptionListener(this);
    }

    @Override
    public void onSelectOption(EventSelectOption e) {
        switch (e.getOption()){
            case GESTION_DE_PERSONAL:
                ActionGestionDePersonal();
                break;
            case GESTION_EDUCATIVA:
                ActionGestionEducativa();
                break;
            case GESTION_DE_ADMINISTRACION:
                ActionGestionDeAdministracion();
                break;
            case SALIR:
                ActionSalir();
                break;
            case GESTION_DE_EMPLEADOS:
                ActionGestionDeEmpleados();
                break;
            case GESTION_DE_ALUMNOS:
                ActionGestionDeAlumnos();
                break;
            case VOLVER:
                ActionVolver();
                break;
            case CREAR_TITULACION:
                ActionCrearTitulacion();
                break;
            case ELIMINAR_TITULACION:
                ActionEliminarTitulacion();
                break;
            case LISTAR_TITULACION:
                ActionListarTitulaciones();
                break;
            case ABRIR_MATRICULA:
                ActionAbrirMatricula();
                break;
            case INCLUIR_ASIGNATURA:
                ActionIncluirAsignatura();
                break;
            default:
                ActionDeafault();
        }

    }



    private void ActionGestionDePersonal(){
        getItem().getSubMenu().exec();
    }
    private void ActionGestionEducativa(){
        getItem().getSubMenu().exec();
    }

    private void ActionGestionDeAdministracion(){
        System.out.println(getItem().getLabel());
    }

    private void ActionSalir(){
        System.exit(0);
    }

    private void ActionGestionDeEmpleados(){
      System.out.println(getItem().getLabel());
    }

    private void ActionGestionDeAlumnos(){
        getItem().getSubMenu().exec();
    }

    private void ActionVolver(){
        goUp();
    }

    private void ActionCrearTitulacion(){
        Titulacion t = new Titulacion(new LecturaPorConsola().getString("Nombre de la nueva Titulación"));
        colegio.addTitulacion(t);
    }

    private void ActionEliminarTitulacion(){
        System.out.println(getItem().getLabel());
    }

    private void ActionAbrirMatricula(){
        System.out.println(getItem().getLabel());
    }

    private void ActionIncluirAsignatura(){
        System.out.println(getItem().getLabel());
    }

    private void ActionListarTitulaciones(){
        System.out.println(new Print().list(colegio.getTitulaciones()));
    }

    private void ActionDeafault(){
        System.out.println("¡¡¡ERROR!!! Debe introducir una opción válida");
    }

    private void goUp(){
        getItem().getParent().getPadre().exec();
    }
}
