package adaits.cursoJava.colegio;

public enum GrupoCotizacion {
    INGENIEROS_Y_LICENCIADOS("Ingenieros y Licenciados",1152.90,3751.2,'M'),
    INGENIEROS_TECNICOS("Ingenieros Técnicos",956.1,3751.2,'M'),
    JEFES_ADMINISTRATIVOS_Y_DE_TALLER("Jefes Administrativos y de Taller",831.6,3751.2,'M'),
    AYUDANTES_NO_TITULADOS("Ayudantes No Titulados",825.6,3751.2,'M'),
    OFICIALES_ADMINISTRATIVOS("Oficiales Administrativos",825.6,3751.2,'M'),
    SUBALTERNOS("Subalternos",825.6,3751.2,'M'),
    AUXILIARES_ADMINISTRATIVOS("Auxiliares Administrativos",825.6,3751.2,'M'),
    OFICIALES_DE_1_Y_2("Oficiales de 1ª y 2ª",27.52,125.04,'D'),
    OFICIALES_DE_3_Y_ESPECIALISTAS("Oficiales de 3ª y Especialistas",27.52,125.04,'D'),
    PEONES("peones",27.52,125.04,'D'),
    MENORES_DE_18_ANNOS("Menores de 18 años",27.52,125.04,'D');

    private String nombreGrupo;
    private double baseMinima;
    private double baseMaxima;
    private char periodoCalculo;//M o D

    GrupoCotizacion(String nombreGrupo, double baseMinima, double baseMaxima,char periodo) {
        this.nombreGrupo = nombreGrupo;
        this.baseMinima = baseMinima;
        this.baseMaxima = baseMaxima;
        periodoCalculo = periodo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public double getBaseMinima() {
        return baseMinima;
    }

    public void setBaseMinima(double baseMinima) {
        this.baseMinima = baseMinima;
    }

    public double getBaseMaxima() {
        return baseMaxima;
    }

    public void setBaseMaxima(double baseMaxima) {
        this.baseMaxima = baseMaxima;
    }

    public char getPeriodoCalculo() {
        return periodoCalculo;
    }

    public void setPeriodoCalculo(char periodoCalculo) {
        this.periodoCalculo = periodoCalculo;
    }
}
