public class hora {
    // public docente docente;
    public asignatura asignatura;
    public hora(){}

    public hora(asignatura asg){
        asignatura = asg;
        asg.total_horas_semana++;
    }
}
