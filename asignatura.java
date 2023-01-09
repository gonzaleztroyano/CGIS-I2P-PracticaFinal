public class Asignatura {
    public String codigo;
    public String nombre;
    public int total_horas_semana;
    public int max_horas_dia;
    public Docente docente;
    private int horas_actual;
    private int[] asg_dia = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    // 0 --> +1 (lunes)
    // 1 --> +1 (martes)
    // 2 --> +3 (miercoles)

    public Asignatura(String cod, String nom, int ths, int mhd, Docente doc) {
        this.codigo = cod;
        this.nombre = nom;
        this.total_horas_semana = ths;
        this.max_horas_dia = mhd;
        this.horas_actual = 0;
        this.docente = doc;
        int[] asg_dia = new int[7];
    }

    public void update_scheduled_by_day(String operacion, int dow) {
        if (operacion.equals("+")) {
            asg_dia[dow]++;
        } else if (operacion.equals("-")) {
            asg_dia[dow]--;
        } else {
            System.out.println("Error en la modificacion.");
        }
    }

    public void get_details() {
        System.out.println("CODigo:              " + this.codigo);
        System.out.println("NOMbre:              " + this.nombre);
        System.out.println("TOTal Horas Semana:  " + this.total_horas_semana);
        System.out.println("MAXimo Horas Dia:    " + this.max_horas_dia);
    }

    // Este metodo sirve para comprobar si puedo annadir mas horas a nivel semanal a
    // esta asignatura.
    // Devuelve true si puedo, porque el numero de horas actual es menor que el
    // maximo
    // Devielve false si no puedo, porque ya he alcanzando el numero maximo.

    public boolean can_be_scheduled_more(int dow) {
        if (asg_dia[dow] < max_horas_dia) {
            return true;
        } else {
            return false;
        }

        // ANTES ESTABA ESTO, claramente habiamos entendido mal y estabamos mirando el
        // total de la semana.
        // if (horas_actual < total_horas_semana) {
        // return true;
        // } else {
        // return false;
        // }
    }

    public void show_id_and_name() {
        System.out.println(this.codigo + ": " + this.nombre);
    }
}
