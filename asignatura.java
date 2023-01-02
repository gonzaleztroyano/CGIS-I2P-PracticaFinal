public class asignatura {
    public String codigo;
    public String nombre;
    public int total_horas_semana;
    public int max_horas_dia;
    public String[] docente;

    public asignatura(String cod, String nom, int ths, int mhd) {
        // Check if all passed
        this.codigo = cod;
        this.nombre = nom;
        this.total_horas_semana = ths;
        this.max_horas_dia = mhd;
    }

    public void get_details(){
        System.out.println("Codigo:              " + this.codigo);
        System.out.println("Nombre:              " + this.nombre);
        System.out.println("Total Horas Semana:  " + this.total_horas_semana);
        System.out.println("Maximo Horas Dia:    " + this.max_horas_dia);
    }
}
