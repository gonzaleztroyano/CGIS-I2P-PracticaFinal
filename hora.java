public class hora {
    // public docente docente;
    public asignatura asignatura;

    public hora(docente doc, asignatura asig){
        // Creador null
        // TODO: Pending delete
    }
    public hora(){}

    public hora(asignatura asg){
        asignatura = asg;
        asg.total_horas_semana++;
    }
}
