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
        horario1.get_detalle_aula();
        horario1.get_docente_listado();
    }

    public static void muestra_menu() {
        // aqui menu. Ira llamando al resto de metodos definidos
    }

    public static void carga_inicial(horario hor) {
        hor.asignatura_auto("I2P", "Introduccion a la Programacion", 8, 2);
        hor.asignatura_auto("MCS", "Matematicas para la Computacion y Servicios", 9, 4);
        hor.asignatura_auto("HFS", "Historia y Fundamentos de los Servicios", 4, 1);
        hor.add_aula_auto("G107", 30);
        hor.add_aula_auto("G108", 20);
        hor.add_aula_auto("G109", 25);
        hor.add_docente_auto("123456789A","Manuel", "Sanchez", "Diaz");
        hor.add_docente_auto("234567890B","Cristina", "Gonzalez", "Pons");
        hor.add_docente_auto("345678901C","Rodrigo", "Hidalgo", "Esteban");
        hor.add_docente_auto("456789012D","Lucia", "Jimenez", "Diaz");

    };

}