/**
 * main class of Java Program
 * 
 * Práctica Final
 * 
 */

class Main {
    static horario horario1 = new horario("horario1");

    public static void main(String[] args) {
        // horario1.nueva_asignatura();
        carga_inicial(horario1);
        horario1.listar_asignaturas();
        horario1.get_asg_codes();
        horario1.detalle_asignatura();
        crear_tiempo(horario1);
        horario1.lista_dias();
    }

    public static void muestra_menu() {
        // aqui menu. Ira llamando al resto de metodos definidos
    }

    public static void carga_inicial(horario hor) {
        hor.asignatura_auto("I2P", "Introduccion a la Programacion", 8, 2);
        hor.asignatura_auto("MCS", "Matematicas para la Computacion y Servicios", 9, 4);
        hor.asignatura_auto("HFS", "Historia y Fundamentos de los Servicios", 4, 1);
    };

    public static void crear_tiempo(horario hor) {
        String[] dias = { "lunes", "martes", "miercoles", "jueves", "viernes" };
        hor.crea_dias(dias);
    }
}