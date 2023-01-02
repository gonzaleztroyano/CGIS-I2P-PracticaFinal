/**
 * main class of Java Program
 * 
 * Practica Final
 * 
 */
import java.util.Scanner;
class Main {
    static horario horario1 = new horario("horario1");

    public static void main(String[] args) {
        // horario1.nueva_asignatura();
        carga_inicial(horario1);

        horario1.add_entrada_horario_auto("viernes", "G107", "TDS", 10);

        /*horario1.listar_asignaturas();
        horario1.get_asg_codes();
        horario1.detalle_asignatura();
        horario1.get_detalle_aula();
        horario1.get_docente_listado();
        horario1.editar_asignatura();*/
        muestra_menu();
    }

    public static void muestra_menu() {

        int num = 0;
        while (num != 4) {
            System.out.println("Elija una de las siguientes opciones:");

            System.out.println("    1.1. Agregar una asignatura");
            System.out.println("    1.2. Editar una asignatura");
            System.out.println("    1.3. Eliminar una asignatura");
            System.out.println("    1.4. Borrar TODAS las asiganturas");

            System.out.println("2. Definir horario");
            System.out.println("    2.1. Agregar una entrada al horario");
            System.out.println("    2.2. Editar una entrada del horario");
            System.out.println("    2.3. Eliminar una entrada del horario");
            System.out.println("    2.4. Borrar todo el horario");

            System.out.println("3. Mostrar horario");
            System.out.println("    3.1. Búsqueda por asignatura");
            System.out.println("    3.2. Búsqueda por aula");
            System.out.println("    3.3. Búsqueda por profesor");
            System.out.println("    3.4. Mostrar todas las entradas");

            System.out.println("4. Salir");

            System.out.println("Introduzca el numero de la opcion que desea seleccionar.\n Sin espacios ni puntos. Ejemplo: '21' para agregar entrada al horario.");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();


            switch (num) {
                case 11:
                    horario1.nueva_asignatura();
                    break;
                case 12:
                    horario1.editar_asignatura();
                    break;
                case 13:
                    horario1.eliminar_asignatura();
                    break;
                case 14:
                    horario1.eliminar_asignaturas();
                    break;
                case 21:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 22:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 23:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 24:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 31:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 32:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 33:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 34:
                    System.out.println("hola");
                    // TODO: asignar el metodo
                    break;
                case 4:
                    System.out.println("Adios");

                default:
                        System.out.println("El numero que ha introducido no es valido. Por favor, intruzca uno de nuevo.");
                        break;
            }

        }
    }



    public static void carga_inicial(horario hor) {
        hor.asignatura_auto("I2P", "Introduccion a la Programacion", 8, 2);
        hor.asignatura_auto("MCS", "Matematicas para la Computacion y Servicios", 9, 4);
        hor.asignatura_auto("HFS", "Historia y Fundamentos de los Servicios", 4, 1);
        hor.asignatura_auto("TDS", "Teoria de Sistemas", 10, 3);
        hor.asignatura_auto("ADQ", "Arquitectura de Computadores", 8, 3);
        hor.asignatura_auto("SDS", "Sociologia de los Servicios", 9, 2);

        hor.add_aula_auto("G107", 30);
        hor.add_aula_auto("G108", 20);
        hor.add_aula_auto("G109", 25);
        hor.add_aula_auto("G110", 40);
        hor.add_aula_auto("G111", 35);

        hor.add_docente_auto("12345678A","Manuel", "Sanchez", "Diaz");
        hor.add_docente_auto("23456789J","Cristina", "Gonzalez", "Pons");
        hor.add_docente_auto("34567901C","Rodrigo", "Hidalgo", "Esteban");
        hor.add_docente_auto("45678012D","Lucia", "Jimenez", "Llorente");
        hor.add_docente_auto("20458599E","Javier", "Airado", "Rodriguez");
        hor.add_docente_auto("50369736Z","Pablo", "Aguado", "Gonzalez");

        hor.add_entrada_horario_auto("lunes", "G107", "TDS", 10);
        hor.add_entrada_horario_auto("martes", "G107", "MCS", 11);
        hor.add_entrada_horario_auto("miercoles", "G109", "I2P", 9);
        hor.add_entrada_horario_auto("muercoles", "G107", "TDS", 10);

    };

}