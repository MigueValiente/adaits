package adaits.cursoJava;

import adaits.cursoJava.colegio.Asignatura;
import adaits.cursoJava.colegio.Colegio;
import adaits.cursoJava.colegio.Curso;
import adaits.cursoJava.colegio.Titulacion;
import adaits.cursoJava.colegio.view.CodeColegio;
import adaits.cursoJava.colegio.view.LecturaPorConsola;
import adaits.cursoJava.colegio.view.MenuColegio;
import adaits.cursoJava.mvc.menu.ItemMenu;
import adaits.cursoJava.mvc.menu.Menu;

public class MainColegio {
    public static void main(String[] args) {
        LecturaPorConsola input = new LecturaPorConsola();

        Colegio colegio = new Colegio("ADA-ITS");

        Titulacion tsmaAv = new Titulacion("Técnico Superior de Mantenimiento Aeronáutico. Aviónica");
        Titulacion tsmaAe = new Titulacion("Técnico Superior de Mantenimiento Aeronáutico. Aeromecánica");
        colegio.addTitulacion(tsmaAv);
        colegio.addTitulacion(tsmaAe);

        Curso tsmaAv1 = new Curso(1,tsmaAv);
        Curso tsmaAe1 = new Curso(1,tsmaAe);
        Curso tsmaAv2 = new Curso(2,tsmaAv);

        tsmaAv.agregarCurso(tsmaAv1);
        tsmaAe.agregarCurso(tsmaAe1);
        tsmaAv.agregarCurso(tsmaAv2);

        Asignatura teb = new Asignatura("Técnicas electromagnéticas Básicas",Asignatura.TRONCAL);
        Asignatura ca = new Asignatura("Computadores de aeronaves, teoría de operación y su mantenimiento",Asignatura.TRONCAL);
        Asignatura cna = new Asignatura("Constitución y navegación de las aeronaves",Asignatura.TRONCAL);
        Asignatura fct = new Asignatura("Formación en centros de trabajo",Asignatura.TRONCAL);
        Asignatura fol = new Asignatura("Formación y orientación laboral",Asignatura.TRONCAL);
        Asignatura lom = new Asignatura("Legislación y organización del mantenimiento",Asignatura.TRONCAL);
        Asignatura pp = new Asignatura("Planta de potencia y sistemas mecánicos de aeronaves",Asignatura.TRONCAL);
        Asignatura rat = new Asignatura("Relaciones en el ámbito de trabajo",Asignatura.TRONCAL);
        Asignatura sma = new Asignatura("Seguridad en el mantenimiento de aeronaves",Asignatura.TRONCAL);
        Asignatura sca = new Asignatura("Sistemas de comunicación del aeronave y componentes asociados",Asignatura.TRONCAL);
        Asignatura sirv = new Asignatura("Sistemas de instrumentalización, de registro de datos de vuelo y mantenimiento",Asignatura.TRONCAL);
        Asignatura sva = new Asignatura("Sistemas de vuelo automático. Piloto automático, gestión de vuelo",Asignatura.TRONCAL);
        Asignatura sea = new Asignatura("Sistemas eléctricos del aeronave y componentes asociados",Asignatura.TRONCAL);

        Asignatura temb = new Asignatura("Técnicas electromecánicas Básicas",Asignatura.TRONCAL);
        Asignatura hn = new Asignatura("Hidráulica y neumática",Asignatura.TRONCAL);
        Asignatura mea = new Asignatura("Materiales y estructuras de las aeronaves",Asignatura.TRONCAL);
        Asignatura mphs = new Asignatura("Motor de pistón, hélices y sus sistemas",Asignatura.TRONCAL);
        Asignatura mrsa  = new Asignatura("Motor de reacción, sus sistemas y la unidad de potencia auxiliar (APU)",Asignatura.TRONCAL);
        Asignatura sa1 = new Asignatura("Sistemas de la aeronave I",Asignatura.TRONCAL);
        Asignatura sa2 = new Asignatura("Sistemas de la aeronave II",Asignatura.TRONCAL);
        Asignatura seea = new Asignatura("Sistemas eléctricos/electrónicos de las aeronaves",Asignatura.TRONCAL);


        tsmaAv1.addAsignatura(temb);
        tsmaAv1.addAsignatura(ca);
        tsmaAv1.addAsignatura(cna);
        tsmaAv1.addAsignatura(fct);
        tsmaAv1.addAsignatura(fol);
        tsmaAv1.addAsignatura(lom);
        tsmaAv1.addAsignatura(pp);
        tsmaAv1.addAsignatura(rat);
        tsmaAv1.addAsignatura(sma);
        tsmaAv1.addAsignatura(sca);
        tsmaAv1.addAsignatura(sirv);
        tsmaAv1.addAsignatura(sva);
        tsmaAv1.addAsignatura(sea);

        tsmaAe1.addAsignatura(hn);
        tsmaAe1.addAsignatura(mea);
        tsmaAe1.addAsignatura(mphs);
        tsmaAe1.addAsignatura(mrsa);
        tsmaAe1.addAsignatura(sa1);
        tsmaAe1.addAsignatura(sa2);
        tsmaAe1.addAsignatura(seea);
        tsmaAe1.addAsignatura(fct);
        tsmaAe1.addAsignatura(fol);
        tsmaAe1.addAsignatura(lom);
        tsmaAe1.addAsignatura(rat);
        tsmaAe1.addAsignatura(sma);
        tsmaAe1.addAsignatura(teb);

//        Print pr = new Print();
//        Titulacion daw = new Titulacion(input.getString("Introduzca una Titulación: "));
//        colegio.addTitulacion(daw);
//
//        System.out.println(pr.list(tsmaAv.getCursos()));
//        System.out.println(pr.list(tsmaAe.getCursos().get(0).getAsignaturas()));
//        System.out.println(pr.list(colegio.getTitulaciones()));
//        System.out.println(pr.list(colegio.getTitulaciones().get(0)));


        MenuColegio menuPrincipal = new MenuColegio("Colegio ADA-ITS");


        ItemMenu gestionEmpleados = new ItemMenu("Gestión de Empleados", CodeColegio.GESTION_DE_EMPLEADOS);
        ItemMenu gestionAlumnos = new ItemMenu("Gestión de Alumnos",CodeColegio.GESTION_DE_ALUMNOS);
        ItemMenu volver = new ItemMenu("Volver",CodeColegio.VOLVER);

        Menu menuPersonal = new MenuColegio("Gestión de Personal");
        menuPersonal.add(gestionEmpleados);
        menuPersonal.add(gestionAlumnos);
        menuPersonal.add(volver);

        ItemMenu crearTitulacion = new ItemMenu("Crear una Titulación",CodeColegio.CREAR_TITULACION);
        ItemMenu eliminarTitulacion = new ItemMenu("Eliminar una Titulación",CodeColegio.ELIMINAR_TITULACION);

        Menu menuGestionEdu = new MenuColegio("Gestión Educativa");
        menuGestionEdu.add(crearTitulacion);
        menuGestionEdu.add(eliminarTitulacion);
        menuGestionEdu.add(volver);

        ItemMenu gestioPersonal = new ItemMenu("Gestión de Personal",menuPersonal,CodeColegio.GESTION_DE_PERSONAL);
        ItemMenu gestioEducativa = new ItemMenu("Gestión de Educativa",menuGestionEdu,CodeColegio.GESTION_EDUCATIVA);
        ItemMenu gestioAdministracion = new ItemMenu("Gestión de Administración",CodeColegio.GESTION_DE_ADMINISTRACION);
        ItemMenu salir = new ItemMenu("Salir",CodeColegio.SALIR);

        menuPrincipal.add(gestioPersonal);
        menuPrincipal.add(gestioEducativa);
        menuPrincipal.add(gestioAdministracion);
        menuPrincipal.add(salir);

        menuPrincipal.exec();
    }

}
