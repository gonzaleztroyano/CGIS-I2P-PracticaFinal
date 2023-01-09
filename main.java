/**
 * main class of Java Program
 * 
 * Practica Final
 * 
 */
import java.util.Scanner;
class Main {
    static Horario horario1 = new Horario("horario1");

    public static void main(String[] args) {
        // horario1.nueva_asignatura();
        carga_inicial(horario1);

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
        while (num != 6) { // Este valor solo tomara 6 si se selecciona la opcion 6 del menu. De no ser asi, volvera a ejecutarse la funcion de forma continua.
            horario1.ClearScreen();
            System.out.println("\n\n\n\n\n ================  MENU  ===============\n\n");
            System.out.println("Elija una de las siguientes opciones:");

            System.out.println("\n1. Gestion asignaturas:");

            System.out.println("    1.1. Agregar una asignatura");
            System.out.println("    1.2. Editar una asignatura");
            System.out.println("    1.3. Eliminar una asignatura");
            System.out.println("    1.4. Borrar TODAS las asiganturas");
            System.out.println("    1.5. Listar todas las asignaturas");
            System.out.println("    1.6. Ver los detalles de una asignatura");


            System.out.println("\n2. Definir horario:");
            System.out.println("    2.1. Agregar una entrada al horario");
            System.out.println("    2.2. Editar una entrada del horario");
            System.out.println("    2.3. Eliminar una entrada del horario");
            System.out.println("    2.4. Borrar todo el horario");
            System.out.println("    2.5. Restaurar horario/Cargar datos de muestra");

            System.out.println("\n3. Mostrar horario:");
            System.out.println("    3.1. Busqueda por asignatura");
            System.out.println("    3.2. Busqueda por aula");
            System.out.println("    3.3. Busqueda por profesor");
            System.out.println("    3.4. Mostrar todas las entradas");

            System.out.println("\n4. Gestion aulas:");
            System.out.println("    4.1. Agregar aula a la base de datos");
            System.out.println("    4.2. Editar aula ya creada");
            System.out.println("    4.3. Eliminar aula de la base de datos");
            System.out.println("    4.4. Eliminar TODAS las aulas.");
            System.out.println("    4.5. Listar aulas disponibles");

            System.out.println("\n5. Gestion docentes:");
            System.out.println("    5.1. Agregar docente a la base de datos");
            System.out.println("    5.2. Editar docente ya registrado");
            System.out.println("    5.3. Eliminar docente de la base de datos");
            System.out.println("    5.4. Eliminar TODOS los docentes.");
            System.out.println("    5.5. Listar docentes registrados disponibles");

            System.out.println("6. Salir");

            System.out.println("Introduzca el numero de la opcion que desea seleccionar.\n Sin espacios ni puntos. Ejemplo: '21' para agregar entrada al horario.");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();

            switch (num) {
                case 11:
                    horario1.ClearScreen();
                    horario1.nueva_asignatura();
                    break;
                case 12:
                    horario1.ClearScreen();
                    horario1.editar_asignatura();
                    break;
                case 13:
                    horario1.ClearScreen();
                    horario1.eliminar_asignatura();
                    break;
                case 14:
                    horario1.ClearScreen();
                    horario1.eliminar_asignaturas();
                    break;
                case 15:
                    horario1.ClearScreen();
                    horario1.listar_asignaturas();
                    break;
                case 16:
                    horario1.ClearScreen();
                    horario1.detalle_asignatura();
                    break;
                case 21:
                    horario1.ClearScreen();
                    horario1.add_entrada_horario();
                    break;
                case 22:
                    horario1.ClearScreen();
                    horario1.edit_entrada_horario();
                    break;
                case 23:
                    horario1.ClearScreen();
                    horario1.del_entrada_horario();
                    break;
                case 24:
                    horario1.ClearScreen();
                    // aqui puede ser interesante eliminar el objeto horario1 y volverlo a crear, directamente. Sin annadir datos quiza
                    horario1 = new Horario("horario1");
                    System.out.println("Se han borrado todos los datos de la base de datos."); // Evidentemente no hay base de datos, pero asi queda mas guay
                    horario1.waiter();
                    break;
                case 25:
                    horario1.ClearScreen();
                    horario1 = new Horario("horario1");
                    carga_inicial(horario1);
                    System.out.println("Se ha restaurado el horario a su estado inicial.");
                    horario1.waiter();
                    break;
                case 31:
                    horario1.ClearScreen();
                    horario1.get_entradas_by_asg();
                    break;
                case 32:
                    horario1.ClearScreen();
                    horario1.get_entradas_by_aula();
                    break;
                case 33:
                    horario1.ClearScreen();
                    horario1.get_entradas_by_docente();
                    break;
                case 34:
                    horario1.ClearScreen();
                    horario1.get_entradas();
                    break;
                case 41:
                    horario1.ClearScreen();
                    horario1.aula_add();
                    break;
                case 42:
                    horario1.ClearScreen();
                    horario1.editar_aula();
                    break;
                case 43:
                    horario1.ClearScreen();
                    horario1.aula_delete();
                    break;
                case 44:
                    horario1.ClearScreen();
                    horario1.eliminar_aulas();
                    break;
                case 45:
                    horario1.ClearScreen();
                    horario1.get_detalle_aulas();
                    break;
                case 51:
                    horario1.ClearScreen();
                    horario1.add_docente();
                    break;
                case 52:
                    horario1.ClearScreen();
                    horario1.editar_docente();
                    break;
                case 53:
                    horario1.ClearScreen();
                    horario1.docente_delete();
                    break;
                case 54:
                    horario1.ClearScreen();
                    horario1.eliminar_docentes();
                    break;
                case 55:
                    horario1.ClearScreen();
                    horario1.get_docente_listado();
                    break;
                case 6:
                    horario1.ClearScreen();
                    System.out.println("Gracias por usar esta apliacion\nSaliendo...\n");
                    break;
                default:
                        System.out.println("El numero que ha introducido no es valido. Por favor, intruzca uno de nuevo.");
                        break;
            }

        }
    }



    public static void carga_inicial(Horario hor) {

        hor.add_docente_auto("12345678A","Manuel", "Sanchez", "Diaz", 2000.0, "Profesor Titular");
        hor.add_docente_auto("23456789J","Cristina", "Gonzalez", "Pons", 3000.0, "Doctora");
        hor.add_docente_auto("34567901C","Rodrigo", "Hidalgo", "Esteban", 1000.0, "Profesor asociado");
        hor.add_docente_auto("45678012D","Lucia", "Jimenez", "Llorente", 3000.0, "Doctora");
        hor.add_docente_auto("20458599E","Javier", "Airado", "Rodriguez", 2000.0, "Profesor Titular");
        hor.add_docente_auto("50369736Z","Pablo", "Aguado", "Gonzalez", 2000.0, "Profesor Titular");


        hor.asignatura_auto("I2P", "Introduccion a la Programacion", 8, 2, "50369736Z");
        hor.asignatura_auto("MCS", "Matematicas para la Computacion y Servicios", 9, 4, "23456789J");
        hor.asignatura_auto("HFS", "Historia y Fundamentos de los Servicios", 4, 1, "34567901C");
        hor.asignatura_auto("TDS", "Teoria de Sistemas", 10, 3, "45678012D");
        hor.asignatura_auto("ADQ", "Arquitectura de Computadores", 8, 3, "45678012D");
        hor.asignatura_auto("SDS", "Sociologia de los Servicios", 9, 2, "45678012D");

        hor.add_aula_auto("G107", 30);
        hor.add_aula_auto("G108", 20);
        hor.add_aula_auto("G109", 25);
        hor.add_aula_auto("G110", 40);
        hor.add_aula_auto("G111", 35);


        hor.add_entrada_horario_auto("lunes", "G107", "TDS", 10);
        hor.add_entrada_horario_auto("martes", "G108", "TDS", 9);
        hor.add_entrada_horario_auto("miercoles", "G109", "TDS", 8);
        hor.add_entrada_horario_auto("jueves", "G110", "TDS", 12);
        hor.add_entrada_horario_auto("viernes", "G111", "TDS", 13);
        hor.add_entrada_horario_auto("sabado", "G107", "TDS", 10);
        hor.add_entrada_horario_auto("domingo", "G107", "TDS", 9);

        hor.add_entrada_horario_auto("lunes", "G107", "MCS", 12);
        hor.add_entrada_horario_auto("martes", "G108", "MCS", 11);
        hor.add_entrada_horario_auto("miercoles", "G109", "MCS", 10);
        hor.add_entrada_horario_auto("jueves", "G110", "MCS", 10);
        hor.add_entrada_horario_auto("viernes", "G111", "MCS", 8);
        hor.add_entrada_horario_auto("sabado", "G108", "MCS", 10);
        hor.add_entrada_horario_auto("domingo", "G107", "MCS", 8);

        hor.add_entrada_horario_auto("lunes", "G107", "I2P", 14);
        hor.add_entrada_horario_auto("martes", "G108", "I2P", 13);
        hor.add_entrada_horario_auto("miercoles", "G109", "I2P",14);
        hor.add_entrada_horario_auto("jueves", "G110", "I2P", 8);
        hor.add_entrada_horario_auto("viernes", "G111", "I2P", 10);
        hor.add_entrada_horario_auto("sabado", "G109", "I2P", 10);
        hor.add_entrada_horario_auto("domingo", "G108", "I2P", 10);
        
        hor.add_entrada_horario_auto("lunes", "G111", "HFS", 10);
        hor.add_entrada_horario_auto("martes", "G110", "HFS", 8);
        hor.add_entrada_horario_auto("miercoles", "G109", "HFS", 9);
        hor.add_entrada_horario_auto("jueves", "G108", "HFS", 10);
        hor.add_entrada_horario_auto("viernes", "G107", "HFS", 14);
        hor.add_entrada_horario_auto("sabado", "G110", "HFS", 9);
        hor.add_entrada_horario_auto("domingo", "G108", "HFS", 8);

        hor.add_entrada_horario_auto("lunes", "G110", "ADQ", 10);
        hor.add_entrada_horario_auto("martes", "G111", "ADQ", 10);
        hor.add_entrada_horario_auto("miercoles", "G107", "ADQ", 11);
        hor.add_entrada_horario_auto("jueves", "G108", "ADQ", 8);
        hor.add_entrada_horario_auto("viernes", "G109", "ADQ", 9);
        hor.add_entrada_horario_auto("sabado", "G107", "ADQ", 14);
        hor.add_entrada_horario_auto("domingo", "G108", "ADQ", 13);

        hor.add_entrada_horario_auto("lunes", "G111", "SDS", 8);
        hor.add_entrada_horario_auto("martes", "G107", "SDS", 10);
        hor.add_entrada_horario_auto("miercoles", "G107", "SDS", 9);
        hor.add_entrada_horario_auto("jueves", "G108", "SDS", 14);
        hor.add_entrada_horario_auto("viernes", "G109", "SDS", 13);
        hor.add_entrada_horario_auto("sabado", "G110", "SDS", 8);
        hor.add_entrada_horario_auto("domingo", "G109", "SDS", 10);

        hor.asignatura_auto("TMH", "Test para comprobar el maximo de horas al dia", 2, 1, "50369736Z");
        hor.add_entrada_horario_auto("lunes", "G111", "TMH", 8);

    };

}