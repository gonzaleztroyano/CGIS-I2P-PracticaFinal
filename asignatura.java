public class asignatura {
    public String codigo;
    public String nombre;
    public int total_horas_semana;
    public int max_horas_dia;
    public docente docente;
    private int horas_actual;


    public asignatura(String cod, String nom, int ths, int mhd) {
        // TODO: Add docente -- 1 solo
        this.codigo = cod;
        this.nombre = nom;
        this.total_horas_semana = ths;
        this.max_horas_dia = mhd;
        this.horas_actual = 0;
    }

    public void get_details(){
        System.out.println("CODigo:              " + this.codigo);
        System.out.println("NOMbre:              " + this.nombre);
        System.out.println("TOTal Horas Semana:  " + this.total_horas_semana);
        System.out.println("MAXimo Horas Dia:    " + this.max_horas_dia);
    }

    // Este metodo sirve para comprobar si puedo añadir mas horas a nivel semanal a esta asignatura. 
    // Devuelve true si puedo, porque el numero de horas actual es menor que el maximo
    // Devielve false si no puedo, porque ya he alcanzando el número máximo. 

    // TODO: Esto se refiere al limite maximo semanal o diario? Esta en semanal
    public boolean can_be_scheduled_more(){
        if (horas_actual < total_horas_semana) {
            return true;
        } else {
            return false;
        }
    }
}
