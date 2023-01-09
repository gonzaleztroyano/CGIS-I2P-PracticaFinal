public class Hora {
    // public docente docente;
    public Asignatura asignatura;
    public Hora(){}

    public Hora(Asignatura asg){
        asignatura = asg;
        asg.total_horas_semana++;
    }
}
