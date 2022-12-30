public class dia {
    public String nombre;
    public hora[] horas  = new hora[24];
    // Constructor
    public dia(String nom){
        nombre = nom;
        hora[] horas = new hora[24];
    }

    public hora get_entrada(int num){
        return this.horas[num];
    }
}
