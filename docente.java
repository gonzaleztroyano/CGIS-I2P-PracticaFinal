public class Docente {
    public String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double sueldo;
    private String titulo;

    // TODO: usar sueldo y titulo. Actualizar acorde metodos
    

    public Docente(String p_dni, String p_nom, String p_ape1, String p_ape2, Double p_sueld, String p_tit){
        dni = p_dni;
        nombre = p_nom;
        apellido1 = p_ape1;
        apellido2 = p_ape2;
        sueldo = p_sueld;
        titulo = p_tit;
    }

    public String get_fullname(){
        return (this.nombre + " "+ this.apellido1 + " " + this.apellido2);
    }

    // Este metodo no tiene mucho sentido pero se ha utilizado durante la realizacion
    // del trabajo para la ilustracion de diferencias private/public en las propiedades de la clase.
    // Se mantiene por si fuera necesario usarlo posteriormente.
    public String get_dni(){
        return this.dni;
    }

    public String get_fullname_and_dni(){
        return(this.get_fullname() + ": " + this.dni);
    }

    public void get_details(){
        System.out.println("   DNI:          " + this.dni);
        System.out.println("      NOMbre:    " + this.nombre);
        System.out.println("      APE1:      " + this.apellido1);
        System.out.println("      APE2:      " + this.apellido2);
        System.out.println("      SUEldo:    " + this.sueldo);
        System.out.println("      TITulo:    " + this.titulo);
    }

    // Estos metodos sirven para ilustrar que son necesarios metodos para actualizar propiedades privadas. 
    public void update_nombre(String p_introducido){
        this.nombre = p_introducido;
        System.out.println("Se ha actualizado correctamente");
    }

    public void update_ape1(String p_introducido){
        this.apellido1 = p_introducido;
        System.out.println("Se ha actualizado correctamente");
    }

    public void update_ape2(String p_introducido){
        this.apellido2 = p_introducido;
        System.out.println("Se ha actualizado correctamente");
    }

    public void update_sueldo(Double p_introducido){
        this.sueldo = p_introducido;
        System.out.println("Se ha actualizado correctamente");
    }
    
    public void update_titulo(String p_introducido){
        this.titulo = p_introducido;
        System.out.println("Se ha actualizado correctamente");
    }
}
