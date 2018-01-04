package adaits.cursoJava.colegio;

public class Salario {
    double salarioBase;
    double contingenciasComunesTrabajador;//4.7%
    double contingenciasComunesEmpresa;//23.6%
    double desempleoEmpresa;//5.5%
    double desempleoTrabajador;//1.55%
    double accidenteTrabajo;//3.5%
    double formacionEmpresa;//0.6%
    double formacionTrabajador;//0.1%
    double fogasa;//0.2%

    public Salario(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double calculaSalario(GrupoCotizacion grupoCotizacion){
        double salarioBaseCotizacion = salarioBase * 14; // Incluidas pagas extras
        if (salarioBaseCotizacion < grupoCotizacion.getBaseMinima()) salarioBaseCotizacion = grupoCotizacion.getBaseMinima();
        if (salarioBaseCotizacion > grupoCotizacion.getBaseMaxima()) salarioBaseCotizacion = grupoCotizacion.getBaseMaxima();
        double descuentos = salarioBaseCotizacion * (contingenciasComunesTrabajador + desempleoTrabajador +
                accidenteTrabajo + formacionTrabajador);

        return salarioBase - descuentos;
    }
}
