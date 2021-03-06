package adaits.cursoJava.mvc.agenda.view;

import adaits.cursoJava.mvc.menu.ItemMenu;
import adaits.cursoJava.mvc.menu.Menu;

import java.util.ArrayList;

public class viewAgenda {
    private Menu menuPrincipal,menuEditar;
    private ArrayList<ItemMenu> opcionesPrincipales= new ArrayList<>();
    private Menu opcionesEditar;

    public viewAgenda() {
        String []arrayOpcionesEditar = {"Agregar tarea","Editar Tarea","Salir"};
        menuEditar = new Menu("Editar",arrayOpcionesEditar,new CodeAgenda());
        ItemMenu imEditar = new ItemMenu("Editar",menuEditar,0,new CodeAgenda());
        ItemMenu imVer = new ItemMenu("Ver tareas",1,new CodeAgenda());
        ItemMenu imSalir = new ItemMenu("Salir",2,new CodeAgenda());
        opcionesPrincipales.add(imEditar);
        opcionesPrincipales.add(imVer);
        opcionesPrincipales.add(imSalir);
        this.menuPrincipal = new Menu("Menú Principal",opcionesPrincipales,new CodeAgenda());
    }
}
