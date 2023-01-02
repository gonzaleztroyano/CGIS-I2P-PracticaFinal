public class docente {
    public String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double sueldo;
    private String titulo;
    
    
    // TODO:fixed annadir titulo docente 
    // TODO:fixed annadir sueldo

    public docente(String p_dni, String p_nom, String p_ape1, String p_ape2){
        dni = p_dni;
        nombre = p_nom;
        apellido1 = p_ape1;
        apellido2 = p_ape2;
    }

    public String get_fullname(){
        return (this.nombre + " "+ this.apellido1 + " " + this.apellido2);
    }

    public String get_dni(){
        return this.dni;
    }
}
