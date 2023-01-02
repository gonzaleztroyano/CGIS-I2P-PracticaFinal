public class aula {
    public String id;
    private int capacidad;
    public dia[] dia = new dia[7];
    private String[] dias_a_crear = { "lunes", "martes", "miercoles", "jueves", "viernes" };
    public int registros_anadidos;
    public aula(String p_id, int p_csp){
        id = p_id;
        // Problema: se deben poder manejar tantos horarios como aulas tenga!
        // Solucion: El aula tiene los dias. 
        capacidad = p_csp;
        registros_anadidos = 0;
        dia[] dia = new dia[7];
        System.out.println("Creado array");
        for (int i = 0; i <= dias_a_crear.length-1; i++){
            dia[i] = new dia(dias_a_crear[i]);
            System.out.println("Creado dia:" + dias_a_crear[i]);
        }
    }

    public void get_details(){
        System.out.println("Codigo (id):         " + this.id);
        System.out.println("Capacidad:           " + this.capacidad);
        System.out.println("Registros anadidos:  " + this.registros_anadidos);
    }


}
