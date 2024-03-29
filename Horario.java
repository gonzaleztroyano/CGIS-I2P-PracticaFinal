import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Horario {
    List<Asignatura> asignaturas = new ArrayList<Asignatura>();
    List<Aula> aulas = new ArrayList<Aula>();
    List<Docente> docentes = new ArrayList<Docente>();
    String nombre;
    int length_semana = 0;

    public Horario(String nomhorario) {
        nombre = nomhorario;
    }

    // Convierte dias de la semana, dow, desde strings hacia int
    public int dow_string_to_int(String p_string) {
        switch (p_string) {
            case "lunes":
                return 0;
            case "martes":
                return 1;
            case "miercoles":
                return 2;
            case "jueves":
                return 3;
            case "viernes":
                return 4;
            case "sabado":
                return 5;
            case "domingo":
                return 6;
            default:
                return 99;
        }
    }

    // Esto sirve unicamente para esperar hasta que el usuario pulse enter.
    // Como se utiliza en varias ocasiones, se crea como metodo y se llama a este
    // segun sea necesario
    public void waiter() {
        System.out.println("\n >>> Pulse enter para continuar... <<< \n");
        Scanner scanner_enter = new Scanner(System.in);
        String dummy_scanner_content = scanner_enter.nextLine(); // nexLine en lugar de 'next' para que admita el enter
                                                                 // sin letras ni espacios.
        return;
    }

    public boolean confirm_harmfull() {
        System.out.println("\n !!!   ATENCION   !!! \n La accion que va a realizar es potencialmente peligrosa.");
        System.out.println("Introduzca 'S' para confirmar, o cualquier otra tecla para continuar.");

        Scanner scanner_conf = new Scanner(System.in);
        String conf_edit_param = scanner_conf.next();
        if (conf_edit_param.equals("S") || conf_edit_param.equals("s")) { // mayusculas o minisculas para facilitar la
                                                                          // entrada de datos
            return true;
        } else {
            return false;
        }
    }

    public void ClearScreen() {
        System.out.print("");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // https://www.delftstack.com/es/howto/java/java-clear-console/

    /*
     * ***********************************************
     * ***********************************************
     *              Clases ASIGNATURA
     * ***********************************************
     * ***********************************************
     */

    public void nueva_asignatura() {
        System.out.println("Bienvenido al proceso de creacion de asignaturas");

        System.out.println("Por favor, introduzca los siguientes datos:\nCodigo:");
        Scanner scanner_add_asg_cod = new Scanner(System.in);
        String add_asg_cod = scanner_add_asg_cod.nextLine();

        System.out.println("Nombre de la asignatura");
        Scanner scanner_add_asg_nom = new Scanner(System.in);
        String add_asg_nom = scanner_add_asg_nom.nextLine();

        System.out.println("Total de horas a la semana:");
        Scanner scanner_add_asg_ths = new Scanner(System.in);
        int add_asg_ths = scanner_add_asg_ths.nextInt();

        System.out.println("Maximo horas al dia:");
        Scanner scanner_add_asg_mhd = new Scanner(System.in);
        int add_asg_mhd = scanner_add_asg_mhd.nextInt();

        System.out.println("Docente que impartira la nueva asignatura");
        System.out.println("  > Como referencia, se muestran a continuacion los DNIs de los docentes.");
        get_listado_docente_name_and_dni();
        Scanner scanner_add_asg_doc = new Scanner(System.in);
        String add_asg_doc = scanner_add_asg_doc.nextLine();

        asignaturas
                .add(new Asignatura(add_asg_cod, add_asg_nom, add_asg_ths, add_asg_mhd, docente_by_dni(add_asg_doc)));
        System.out.println("Se ha creado correctamente la asignatura.");
        waiter();
    }

    public void asignatura_auto(String cod, String nom, int ths, int mhd, String dni_doc) {
        asignaturas.add(new Asignatura(cod, nom, ths, mhd, docente_by_dni(dni_doc)));
    }

    public void listar_asignaturas() {
        int n = 0;
        System.out.println("\n Listando asignaturas...\n");
        for (Asignatura i : asignaturas) {
            i.show_id_and_name();
            n++;
        }
        System.out.println("  \nSe han encontrado " + n + " asignaturas.");
        waiter();
    }

    public void get_asg_codes() {
        System.out.println("Asignaturas registradas en este momento: ");
        for (Asignatura i : asignaturas) {
            System.out.println(i.codigo);
        }
    }

    public void detalle_asignatura() {
        get_asg_codes();
        Scanner scanner = new Scanner(System.in);
        String cod_a_buscar = scanner.next();
        System.out.println("\n");
        for (Asignatura i : asignaturas) {
            if (i.codigo.equals(cod_a_buscar)) {
                i.get_details();
            }
        }
        waiter();
    }

    public void editar_asignatura() {
        System.out.println("Mostrando lista de asignaturas: ");
        get_asg_codes();
        System.out.println("Introduzca el codigo de la asignatura que desea editar: ");
        Scanner scanner_editar = new Scanner(System.in);
        String cod_a_buscar = scanner_editar.next();
        for (Asignatura i : asignaturas) {
            if (i.codigo.equals(cod_a_buscar)) {
                System.out.println("Estos son los detalles de la asignatura solicitada:");
                i.get_details();
                System.out.println("Introduzca los tres primeros caracteres de la variable que desea cambiar: ");
                Scanner scanner_trescaracteres = new Scanner(System.in);
                String tres_primeros_caracteres = scanner_trescaracteres.next();
                System.out.println("Introduzca el nuevo valor de " + tres_primeros_caracteres);
                Scanner scannernuevo_valor = new Scanner(System.in);

                if (tres_primeros_caracteres.equals("COD") || tres_primeros_caracteres.equals("NOM")) {
                    String valor_a_cambiar = scannernuevo_valor.nextLine();
                    if (tres_primeros_caracteres.equals("COD")) {
                        i.codigo = valor_a_cambiar;
                    } else {
                        i.nombre = valor_a_cambiar;
                    }
                } else if (tres_primeros_caracteres.equals("MAX") || tres_primeros_caracteres.equals("TOT")) {
                    int valor_a_cambiar = scannernuevo_valor.nextInt();
                    if (tres_primeros_caracteres.equals("MAX")) {
                        i.max_horas_dia = valor_a_cambiar;
                    } else {
                        i.total_horas_semana = valor_a_cambiar;
                    }
                } else {
                    System.out.println("Error en la introduccion de datos.");
                    waiter();
                    break;
                }
            }
        }
    }

    public Asignatura asignatura_by_id(String p_id) {
        for (Asignatura a : asignaturas) {
            if (p_id.equals(a.codigo)) {
                return a;
            }
        }
        return null;
    }

    public void eliminar_asignatura() {
        System.out.println("Mostrando lista de asignaturas: ");
        get_asg_codes();
        System.out.println("Introduzca el codigo de la asignatura que desea eliminar: ");
        Scanner scanner = new Scanner(System.in);
        String cod_a_buscar = scanner.next();
        for (Asignatura i : asignaturas) {
            if (i.codigo.equals(cod_a_buscar)) {
                asignaturas.remove(i);
                waiter();
                break;
            }
        }
    }

    public void eliminar_asignaturas() {
        if (confirm_harmfull()) {
            asignaturas.clear();
            System.out.println("TODAS Las asignaturas se han eliminado correctamente.");
        } else {
            System.out.println("Se ha cancelado la operacion. Volviendo al menu.");
        }
        waiter();
    }

    /*
     * ***********************************************
     * ***********************************************
     * Clases HORAS / ENTRADAS HORARIO
     * ***********************************************
     * ***********************************************
     */

    // TODO: PENDING -- update value horas_actual at asignatura on ADD

    public void add_entrada_horario_auto(String p_dia, String id_aula, String id_asignatura, int p_hora) {
        int dia_deseado = 0;
        Aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "\n   ATENCION: El parametro introducido para el codigo de aula no es valido. Revise este valor, por favor.");
            return;
        }
        Asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
        if (asignatura_deseada == null) {
            System.out.println(
                    "El parametro introducido para el codigo de asignatura no es valido. Revise este valor, por favor");
            return;
        }

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println(
                    "\n   ATENCION:El parametro introducido para el dia de la semana no es valido. Revise este valor, por favor.");
            return;
        }
        // Si la asignatura no ha alcanzado su limite de 'ocupacion', permitira la
        // creacion de la hora. En caso contrario, else, dara mensaje de error y
        // retornara.
        if (asignatura_deseada.can_be_scheduled_more(dow_string_to_int(p_dia.toLowerCase()))) {
            aula_deseada.dia[dia_deseado].horas[p_hora] = new Hora(asignatura_deseada);
            asignatura_deseada.update_scheduled_by_day("+", dow_string_to_int(p_dia.toLowerCase()));
        } else {
            System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                    + " porque se ha alcanzado su limite (" + asignatura_deseada.max_horas_dia + ")");
            return; // return sirve para volver al menu, o a lo que ha llamado a la funcion
                    // inicialmente
        }
        aula_deseada.registros_anadidos++;
    }

    public void add_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de creacion de entradas en el horario!");
        int dia_deseado = 0;

        System.out.println(
                "    Introduzca el aula para el que desea agregar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();

        Aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "\n   ATENCION: El parametro introducido para el codigo de aula no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println(
                "    Introduzca la asignatura para la que desea agregar una entrada\n Asignaturas actualmente registradas: ");
        get_asg_codes();
        Scanner scanner_p_asg = new Scanner(System.in);
        String id_asignatura = scanner_p_asg.next();

        Asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
        if (asignatura_deseada == null) {
            System.out.println(
                    "El parametro introducido para el codigo de asignatura no es valido. Revise este valor, por favor");
            waiter();
            return;
        }

        System.out.println("    Introduzca el dia para el que desea agregar una entrada\n Valores validos: ");
        System.out.println("'lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'");
        Scanner scanner_p_dia = new Scanner(System.in);
        String p_dia = scanner_p_dia.next();

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println(
                    "\n   ATENCION:El parametro introducido para el dia de la semana no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println(
                "    Introduzca la hora para la que desea agregar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24) {
            System.out.println(
                    "\n  ATENCION: El parametro introducido para la hora del dia no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        // Hasta aqui no llegara si no alguno de los parametros introducidos
        // anteriormente han dado error.

        // Si la asignatura no ha alcanzado su limite de 'ocupacion', permitira la
        // creacion de la hora. En caso contrario, else, dara mensaje de error y
        // retornara.
        // System.out.println(" " + asignatura_deseada.can_be_scheduled_more(dow_string_to_int(p_dia.toLowerCase())));
        if (asignatura_deseada.can_be_scheduled_more(dow_string_to_int(p_dia.toLowerCase()))) {
            // Si es posibe annadir una nueva entradas, ahora llega el momento de comprobar
            // si en esa hora ya existe una entrada.
            // Una posible mejora seria permitir la eliminacion directamente aqui...

            // aula_deseada.dia[dia_deseado].horas[p_hora] = new Hora(asignatura_deseada);
            // asignatura_deseada.update_scheduled_by_day("+",
            // dow_string_to_int(p_dia.toLowerCase()));
            // aula_deseada.registros_anadidos++;

            // SOLVED: revisar esto. Puede que el problema no sea tanto porque .asignatura
            // sea null sino que algo en la ruta si lo sea. Por tanto, no llegara hasta ahi.
            // Queda pdte comprobarlo.
            // como info, el problema es que estabamos comprobando si la asignatura era
            // null. Y claro, lo null es la posicion del array de horas del dia.

            if (aula_deseada.dia[dia_deseado].horas[p_hora] == null) {
                aula_deseada.dia[dia_deseado].horas[p_hora] = new Hora(asignatura_deseada);
                asignatura_deseada.update_scheduled_by_day("+", dow_string_to_int(p_dia.toLowerCase()));
                aula_deseada.registros_anadidos++;
            } else {
                // Si NO es null, else, significa que en esa hora ya existe una entrada. Por
                // tanto, no la annadimos.
                System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                        + " porque ya existe una clase programada a esa misma hora.");
                waiter();
                return;
            }
            System.out.println("Se ha agregado correctamente la entrada al horario.");
        } else {
            System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                    + "porque se ha alcanzado su limite (" + asignatura_deseada.max_horas_dia + ")");
            waiter();
            return; // return sirve para volver al menu, o a lo que ha llamado a la funcion
                    // inicialmente
        }
        waiter();
    }

    public void edit_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de edicion de asignaturas!");
        int dia_deseado = 0;

        System.out.println(
                "    Introduzca el aula para el que desea editar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();

        Aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "\n   ATENCION: El parametro introducido para el codigo de aula no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println(
                "En el aula indicada anteriormente, " + id_aula + ", se encuentran agregadas las siguentes entradas:");
        aula_deseada.get_lessons();

        System.out.println("    Introduzca el dia para el cual desea editar una entrada\n Valores validos: ");
        System.out.println("      'lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'");

        Scanner scanner_p_dia = new Scanner(System.in);
        String p_dia = scanner_p_dia.next();

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println(
                    "\n   ATENCION:\n   ATENCION:El parametro introducido para el dia de la semana no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println(
                "    Introduzca la hora para la que desea editar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24) {
            System.out.println(
                    "El parametro introducido para la hora del dia no es valido. Revise este valor, por favor");
            waiter();
            return;
        }

        System.out.println("Se va a proceder a editar la asignatura "
                + aula_deseada.dia[dia_deseado].horas[p_hora].asignatura.nombre);
        System.out.println("   Es correcta la informacion? (S/N)");

        Scanner scanner_conf_edit = new Scanner(System.in);
        String conf_edit_param = scanner_conf_edit.next();
        if (conf_edit_param.equals("S") || conf_edit_param.equals("s")) { // mayusculas o minisculas para facilitar la
                                                                          // entrada de datos
            System.out.println("Introduzca la nueva asignatura por la que desea sustituir "
                    + aula_deseada.dia[dia_deseado].horas[p_hora].asignatura.nombre);
            Scanner scanner_nueva_asig = new Scanner(System.in);
            String id_asignatura = scanner_nueva_asig.next();
            Asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
            if (asignatura_deseada == null) {
                System.out.println(
                        "El parametro introducido para el codigo de asignatura no es valido. Revise este valor, por favor");
                waiter();
                return;
            }
            if (asignatura_deseada.can_be_scheduled_more(dow_string_to_int(p_dia.toLowerCase()))) {
                aula_deseada.dia[dia_deseado].horas[p_hora] = new Hora(asignatura_deseada);
                asignatura_deseada.update_scheduled_by_day("+", dow_string_to_int(p_dia.toLowerCase()));
                System.out.println("Se ha creado correctamente la entrada indicada. Regresando al menu...");
                waiter();
                return;
            } else {
                System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                        + " porque se ha alcanzado su limite (" + asignatura_deseada.max_horas_dia + ")");
                waiter();
                return; // return sirve para volver al menu, o a lo que ha llamado a la funcion
                        // inicialmente
            }
        } else {
            System.out.println("Ha cancelado el proceso o ha indicado una letra no admitida. Volviendo al menu");
            waiter();
            return;
        }
    }

    public void del_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de eliminacion de entradas en el hoario!");
        int dia_deseado = 0;

        System.out.println(
                "    Introduzca el aula para el que desea eliminar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();

        Aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "\n   ATENCION: El parametro introducido para el codigo de aula no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println("Mostrando planificacion de aula indicada");
        aula_deseada.get_lessons();

        System.out.println("    Introduzca el dia para el que desea eliminar una entrada\n Valores validos: ");
        System.out.println("'lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'");
        Scanner scanner_p_dia = new Scanner(System.in);
        String p_dia = scanner_p_dia.next();

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println(
                    "\n   ATENCION:El parametro introducido para el dia de la semana no es valido. Revise este valor, por favor.");
            waiter();
            return;
        }

        System.out.println(
                "    Introduzca la hora para la que desea eliminar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24) {
            System.out.println(
                    "El parametro introducido para la hora del dia no es valido. Revise este valor, por favor");
            waiter();
            return;
        }
        // AQUI se produce la eliminacion de la entrada
        Asignatura asignatura_deseada = aula_deseada.dia[dia_deseado].horas[p_hora].asignatura;
        asignatura_deseada.update_scheduled_by_day("-", dow_string_to_int(p_dia.toLowerCase()));
        aula_deseada.dia[dia_deseado].horas[p_hora] = null;
        System.out.println("Se ha eliminado correctamente la entrada indicada");
        waiter();
    }

    public void get_entradas() {
        for (Aula a : aulas) {
            System.out.println("Para el aula codigo " + a.id + ":");
            a.get_lessons();
            System.out.println("\n================\n");
        }
        waiter();
    }

    public void get_entradas_by_aula() {
        get_aula_codes();
        System.out.println("Introduzca el codigo del aula a listar:");
        Scanner scanner_aula_a_listar = new Scanner(System.in);
        String aula_a_listar = scanner_aula_a_listar.next();
        if (aula_by_id(aula_a_listar) == null) {
            // Si entra en null significa que no hay ningun aula con ese ID dada de alta.
            // Por tanto, no hay nada que listar.
            System.out.println("El ID introducido no se corresponde con ningun aula registrada. Volviendo al menu");
            waiter();
            return;
        } else {
            Aula au_a_listar = aula_by_id(aula_a_listar);
            for (Aula a : aulas) {
                if (a == au_a_listar) {
                    a.get_lessons();
                }
            }
        }
        waiter();
    }

    public void get_entradas_by_asg() {
        System.out.println("Mostrando asignaturas...");
        listar_asignaturas();
        System.out.println("Introduzca el codigo de la asignatura a listar:");
        Scanner scanner_asg_a_listar = new Scanner(System.in);
        String asg_a_listar = scanner_asg_a_listar.next();
        if (asignatura_by_id(asg_a_listar) == null) {
            // Si entra en null significa que no hay ninguna asignatura con ese ID dada de
            // alta. Por tanto, no hay nada que listar.
            System.out.println("El ID introducido no se corresponde con ninguna asignatura. Volviendo al menu");
            waiter();
            return;
        } else {
            int found = 0;
            Asignatura asignatura_para_listar = asignatura_by_id(asg_a_listar);
            // G109 miercoles 9:00 - 10:00
            System.out.println("    AULA |   DIA    |  HORA");
            for (Aula a : aulas) {
                for (Dia d : a.dia) {
                    int i = 0;
                    for (Hora h : d.horas) {
                        if (h != null) {
                            if (h.asignatura == asignatura_para_listar) {
                                System.out.println(
                                        "    " + a.id + "   " + d.nombre + "    " + i + ":00 - " + (i + 1) + ":00");
                                found++;
                            }
                        }
                        i++;
                    }
                }
            }
            if (found == 0) {
                System.out.println("\n  --- No se han encontrado resultados ---");
            } else {
                System.out.println("\n   Se han encontrado " + found + " resultados. ");
            }
            waiter();
        }
    }

    public void get_entradas_by_docente() {
        get_docente_listado();
        System.out.println("\nIntroduzca DNI del docente para el que desea ver las clases:");
        Scanner scanner_dni_docente_a_listar = new Scanner(System.in);
        String dni_docente_a_listar = scanner_dni_docente_a_listar.next();
        if (docente_by_dni(dni_docente_a_listar) == null) {
            // Si entra en null significa que no hay ningun docente con ese DNI dada de
            // alta. Por tanto, no hay nada que listar.
            System.out.println("El DNI introducido no se corresponde con ningun docente registrado. Volviendo al menu");
            return;
        } else {
            int found = 0;
            Docente docente_a_listar = docente_by_dni(dni_docente_a_listar);
            for (Aula a : aulas) {
                for (Dia d : a.dia) {
                    int i = 0;
                    for (Hora h : d.horas) {
                        if (h != null) {
                            if (h.asignatura.docente == docente_a_listar) {
                                // aula nombre_dia hora asignatura
                                System.out.println("    " + a.id + "   " + d.nombre + "    " + i + ":00 - " + (i + 1)
                                        + ":00    " + h.asignatura.codigo);
                                found++;
                            }
                        }
                        i++;
                    }
                }
            }
            if (found == 0) {
                System.out.println("\n  --- No se han encontrado resultados ---");
            } else {
                System.out.println("\n   Se han encontrado " + found + " resultados. ");
            }
        }
        waiter();
    }

    /*
     * ***********************************************
     * ***********************************************
     * Clases AULA
     * ***********************************************
     * ***********************************************
     */
    public void add_aula_auto(String p_id, int p_csp) {
        aulas.add(new Aula(p_id, p_csp));
    }

    public void get_aula_codes() {
        System.out.println("Aulas registradas en este momento: ");
        for (Aula i : aulas) {
            System.out.println(i.id);
        }
    }

    public void get_detalle_aula() {
        get_aula_codes();
        System.out.println("Introzca el codigo del aula para la que desea ver los detalles: ");
        // TODO: Check if requested exists. Maybe return an array?
        Scanner scanner = new Scanner(System.in);
        String cod_a_buscar = scanner.next();
        Aula aula_a_ver_detalles = aula_by_id(cod_a_buscar);
        if (aula_a_ver_detalles == null) {
            System.out.println("No se encuetra ningun aula con el ID indicado. Volviendo al menu...");
        } else {
            aula_a_ver_detalles.get_details();
        }
        waiter();
    }

    public void get_detalle_aulas() {
        System.out.println("Listado de aulas registradas en este momento: ");
        for (Aula i : aulas) {
            i.get_details();
            System.out.println("");
        }
        waiter();
    }

    public Aula aula_by_id(String p_id) {
        // System.out.println("Entro en method");
        for (Aula a : aulas) {
            // System.out.println("Recorriendo...");
            if (p_id.equals(a.id)) {
                // System.out.println("Encontrado");
                // a.get_details();
                return a;
            }
        }
        return null;
    }

    public void aula_delete() {
        System.out.println("Por favor, introduzca el identificador del aula que desea eliminar:");

        Scanner scanner = new Scanner(System.in);
        String id_aula_pasado_por_scanner = scanner.next();
        Aula aula_a_eliminar = aula_by_id(id_aula_pasado_por_scanner);
        aulas.remove(aula_a_eliminar);

        System.out.println("La aula ha sido eliminada correctamente.");
        waiter();
    }

    public void aula_add() {
        System.out.println("Bienvenido al asistente de adicion de aulas.");
        System.out.println("A continuacion se muestran las aulas ya existentes:");
        get_aula_codes();
        System.out.println("Introduzca el ID de la nueva aula a crear:");
        Scanner scannercreacionaula = new Scanner(System.in);
        String creacion_aula = scannercreacionaula.next();
        System.out.println("Indique la capacidad para aula " + creacion_aula + ":");
        Scanner scannercapacidad = new Scanner(System.in);
        int capacidad_aula_nueva = scannercapacidad.nextInt();
        aulas.add(new Aula(creacion_aula, capacidad_aula_nueva));
        System.out.println("Su aula ha sido creada con exito.");
        waiter();
    }

    public void eliminar_aulas() {
        if (confirm_harmfull()) {
            aulas.clear();
            System.out.println("TODAS los AULAS se han eliminado correctamente.");
        } else {
            System.out.println("Se ha cancelado la operacion. Volviendo al menu.");
        }
        waiter();
    }

    // EJEMPLO: este es un buen ejemplo de como modificar/acceder a private vs
    // public properties
    public void editar_aula() {
        get_aula_codes();
        System.out.println("\n Introduzca el ID del aula que desea editar:");
        Scanner scanner_id_aula_a_editar = new Scanner(System.in);
        String id_aula_a_editar = scanner_id_aula_a_editar.next();
        if (aula_by_id(id_aula_a_editar) == null) {
            System.out.println("El ID introducido no se corresponde con ninguno registrado en la base de datos");
        } else {
            Aula aula_a_editar = aula_by_id(id_aula_a_editar);
            aula_a_editar.get_details();
            System.out.println("Desea cambiar el ID o la capacidad? [ID/CAP]");
            Scanner scanner_cosa_a_cambiar = new Scanner(System.in);
            String cosa_a_cambiar = scanner_cosa_a_cambiar.next();
            switch (cosa_a_cambiar) {
                case "ID": // no se pone brak para que haga de "OR" __ +info
                           // https://logfetch.com/java-use-or-switch-case-statement/#use-or-operator-by-removing-break
                case "id":
                    System.out.println("Introduzca el nuevo ID que desea asignar al aula:");
                    Scanner scanner_valor_nuevo_id = new Scanner(System.in);
                    String nuevo_id = scanner_valor_nuevo_id.next();
                    aula_a_editar.id = nuevo_id;
                    break;
                case "CAP":
                case "cap":
                    System.out.println("Introduzca la nueva capacidad que desea asignar al aula:");
                    Scanner scanner_valor_nueva_cap = new Scanner(System.in);
                    int valor_nueva_cap = scanner_valor_nueva_cap.nextInt();
                    aula_a_editar.update_capacidad(valor_nueva_cap);
            }
            System.out.println("Se ha actualizado correctamente. ");
        }
        waiter();
    }

    /*
     * ***********************************************
     * ***********************************************
     * Clases DOCENTE
     * ***********************************************
     * ***********************************************
     */

    public void get_docente_dnis() {
        System.out.println("DNIs registrados en este momento: ");
        for (Docente i : docentes) {
            System.out.println(i.get_dni());
        }
        waiter();
    }

    public void get_docente_listado() {
        System.out.println("DNIs registrados en este momento: ");
        for (Docente i : docentes) {
            i.get_details();
            System.out.println("");
        }
        waiter();
    }

    public void get_listado_docente_name_and_dni() {
        for (Docente d : docentes) {
            System.out.println(d.get_fullname_and_dni());
        }
    }

    public void add_docente_auto(String dni, String nombre, String apellido1, String apellido2, Double p_sueldo,
            String p_tit) {
        docentes.add(new Docente(dni, nombre, apellido1, apellido2, p_sueldo, p_tit));
    }

    public void docente_delete() {
        System.out.println("Por favor, introduzca el DNI del docente que desee dar de baja:");
        Scanner scanner = new Scanner(System.in);
        String docente_de_baja = scanner.next();
        Docente docente_a_eliminar = docente_by_dni(docente_de_baja);
        if (docente_a_eliminar == null) {
            System.out.println("El docente que ha introducido no se encuentra. Volviendo al menu.");
            waiter();
        } else {
            docentes.remove(docente_a_eliminar);
            System.out.println("El docente se ha dado de baja correctamente.");
            waiter();
        }
    }

    public Docente docente_by_dni(String p_id) {
        for (Docente d : docentes) {
            // System.out.println("Recorriendo...");
            if (p_id.equals(d.dni)) {
                return d;
            }
        }
        return null;
    }

    public void add_docente() {
        System.out.println("\nTe damos la bienvenida al asistente de adicion del equipo docente!");
        System.out.println("Introduzca, por favor, el DNI del nuevo docente que desea dar de alta");
        Scanner scanner_add_doce_dni = new Scanner(System.in);
        String add_doce_dni = scanner_add_doce_dni.next();
        if (docente_by_dni(add_doce_dni) == null) {
            // Si entra en null significa que no hay ningun docente dado de alta. Por tanto,
            // podemos annadirlo.
            System.out.println("Introduzca, por favor, los datos que se le solicitan. \n   NOMBRE:");
            Scanner scanner_add_doce_nombre = new Scanner(System.in);
            String add_doce_nombre = scanner_add_doce_nombre.nextLine();

            System.out.println("   Primer Apellido: ");
            Scanner scanner_add_doce_ape1 = new Scanner(System.in);
            String add_doce_ape1 = scanner_add_doce_ape1.nextLine();

            System.out.println("   Segundo Apellido: ");
            Scanner scanner_add_doce_ape2 = new Scanner(System.in);
            String add_doce_ape2 = scanner_add_doce_ape2.nextLine();

            System.out.println("   Sueldo (formato 1000.0): ");
            Scanner scanner_add_doce_sueldo = new Scanner(System.in);
            Double add_doce_sueldo = scanner_add_doce_sueldo.nextDouble();

            System.out.println("   Titulo: ");
            Scanner scanner_add_doce_tit = new Scanner(System.in);

            String add_doce_tit = scanner_add_doce_tit.nextLine();

            // Seria interesante hacer aqui comprobaciones con hasNextXXXX en los Scanners
            // para evitar que java devuelva errores feos...

            docentes.add(new Docente(add_doce_dni, add_doce_nombre, add_doce_ape1, add_doce_ape2, add_doce_sueldo,
                    add_doce_tit));

            System.out.println("Se ha annadido correctamente el docente");
            waiter();

        } else {
            // si entra aqui significa que ya hay un/una docente con ese DNI. por tanto, no
            // podemos annadirlo.
            // Mostramos tambien el nombre del registro ya annadido para ayudar al usuario.
            System.out.println(
                    "ERROR: ya existe un registro para ese DNI: " + docente_by_dni(add_doce_dni).get_fullname());
            System.out.println(
                    "Puede, si asi lo desea, eliminar el registro o modificarlo desde las diferentes opciones del menu.");
            waiter();
        }

    }

    public void eliminar_docentes() {
        if (confirm_harmfull()) {
            docentes.clear();
            System.out.println("TODOS los DOCENTES se han eliminado correctamente.");
        } else {
            System.out.println("Se ha cancelado la operacion. Volviendo al menu.");
        }
        waiter();
    }

    public void editar_docente() {
        System.out.println("Mostrando lista de docentes: ");
        get_listado_docente_name_and_dni();
        System.out.println("Introduzca el DNI del docente que desea editar: ");
        Scanner scanner = new Scanner(System.in);
        String doce_a_buscar = scanner.next();
        if (docente_by_dni(doce_a_buscar) == null) {
            // Si es null el dni introducido no existe
            System.out.println("El DNI introducido no se corresponde con ninguno registrado en la base de datos");
        } else {
            Docente docente_a_modificar = docente_by_dni(doce_a_buscar);
            System.out.print("Los datos actuales del docente son:");
            docente_a_modificar.get_details();
            System.out.println(
                    "Introduzca la clave del campo a variar\nLa claves estan formadas por las 3-4 primeras letras mayusculas mostradas en el listado");
            Scanner scanner_codigo_a_cambiar = new Scanner(System.in);
            String codigo_a_cambiar = scanner_codigo_a_cambiar.next();
            System.out.println("\nIntroduzca el nuevo contenido que desea actualizar en el campo indicado: ");
            Scanner scanner_valor_a_cambiar = new Scanner(System.in);
            switch (codigo_a_cambiar) {
                case "DNI":
                    String valor_a_cambiar = scanner_valor_a_cambiar.next();
                    docente_a_modificar.dni = valor_a_cambiar;
                    break;
                case "NOM":
                    String valor_a_cambiar_n = scanner_valor_a_cambiar.next(); // Se cambia el nombre porque si no
                                                                               // chilla...
                    docente_a_modificar.update_nombre(valor_a_cambiar_n);
                    break;
                case "APE1":
                    String valor_a_cambiar_a1 = scanner_valor_a_cambiar.next();
                    docente_a_modificar.update_ape1(valor_a_cambiar_a1);
                    break;
                case "APE2":
                    String valor_a_cambiar_a2 = scanner_valor_a_cambiar.next();
                    docente_a_modificar.update_ape2(valor_a_cambiar_a2);
                    break;
                case "SUE":
                    Double valor_a_cambiar_s = scanner_valor_a_cambiar.nextDouble();
                    docente_a_modificar.update_sueldo(valor_a_cambiar_s);
                    break;
                case "TIT":
                    String valor_a_cambiar_t = scanner_valor_a_cambiar.next();
                    docente_a_modificar.update_titulo(valor_a_cambiar_t);
                    break;
                default:
                    System.out.println(
                            "El valor introducido no se corresponde con ninguno de los permitodos.\nVolviendo al menu.");
                    // Aqui no se llama a waiter porque esta al final.
            }
        }
        waiter();
    }
}
