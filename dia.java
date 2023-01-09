public class Dia {
    public String nombre;
    public Hora[] horas  = new Hora[24];
    
    // Constructor
    public Dia(String nom){
        nombre = nom;
        Hora[] horas = new Hora[24];
    }

    public Dia(){
        
    }
    public Hora get_entrada(int num){
        return this.horas[num];
    }
}
