public class Aula {
    public String id;
    private int capacidad;
    public Dia[] dia = new Dia[] { new Dia("lunes"), new Dia("martes"), new Dia("miercoles"),
            new Dia("jueves"), new Dia("viernes"), new Dia("sabado"), new Dia("domingo") };
    public int registros_anadidos;

    public Aula(String p_id, int p_csp) {
        id = p_id;
        // Problema: se deben poder manejar tantos horarios como aulas tenga!
        // Solucion: El aula tiene los dias.
        capacidad = p_csp;
        registros_anadidos = 0;
    }

    public void get_details() {
        System.out.println("Codigo (id):         " + this.id);
        System.out.println("Capacidad:           " + this.capacidad);
        System.out.println("Registros anadidos:  " + this.registros_anadidos);
    }

    public void get_lessons() {
        int found = 0;
        for (Dia d : dia) {
            System.out.println("    Dia: " + d.nombre);
            int i = 0;
            for (Hora h : d.horas) {
                if (h != null) {
                    System.out.println("        Hora:          " + i + ":00 - " + (i + 1) + ":00");
                    System.out.println("        Asignatura:    " + h.asignatura.codigo + ": " + h.asignatura.nombre
                            + "\n          -");
                    found++;
                }
                i++;
            }
            System.out.println("    -----------------");
        }
        System.out.println("Se han encontrado " + found + " resultados para este aula.");
    }

    public void update_capacidad(int p_nueva_capacdad) {
        this.capacidad = p_nueva_capacdad;
    }
}
