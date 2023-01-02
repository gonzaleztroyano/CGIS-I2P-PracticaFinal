public class aula {
    public String id;
    private int capacidad;
    public dia[] dia = new dia[] { new dia("lunes"), new dia("martes"), new dia("miercoles"),
            new dia("jueves"), new dia("viernes"), new dia("sabado"), new dia("domingo")};
    public int registros_anadidos;

    public aula(String p_id, int p_csp){
        id = p_id;
        // Problema: se deben poder manejar tantos horarios como aulas tenga!
        // Solucion: El aula tiene los dias. 
        capacidad = p_csp;
        registros_anadidos = 0;
    }

    public void get_details(){
        System.out.println("Codigo (id):         " + this.id);
        System.out.println("Capacidad:           " + this.capacidad);
        System.out.println("Registros anadidos:  " + this.registros_anadidos);
    }

}
