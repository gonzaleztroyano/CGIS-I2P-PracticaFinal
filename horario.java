import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class horario {
    List<asignatura> asignaturas = new ArrayList<asignatura>();
    List<aula> aulas = new ArrayList<aula>();
    List<docente> docentes = new ArrayList<docente>();
    String nombre;
    int length_semana = 0;

    public horario(String nomhorario){
        nombre = nomhorario;
    }

    // Convierte dias de la semana, dow, desde strings hacia int
    public int dow_string_to_int(String p_string){
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
            case "sadado":
                return 5;
            case "domingo":
                return 6;
            default:
               return 99;
       }
    }

    // Esto sirve unicamente para esperar hasta que el usuario pulse enter. 
    // Como se utiliza en varias ocasiones, se crea como metodo y se llama a este segun sea necesario
    public void waiter(){
        System.out.println("Pulse enter para continuar...");
        Scanner scanner_enter = new Scanner(System.in);
        String dummy_scanner_content = scanner_enter.nextLine(); // nexLine en lugar de 'next' para que admita el enter sin letras ni espacios. 
        return;
    }

    /* ***********************************************
     * ***********************************************
     *               Clases ASIGNATURA
     * ***********************************************
     * ***********************************************
     */

        public void nueva_asignatura(){
            System.out.println("Bienvenido al proceso de creacion de asignaturas");
            System.out.println("Introduzca, separados por espacios, los siguientes valores:\n 1. Codigo \n 2. Nombre \n 3. Total horas semana \n 4. Maximo horas dia");
            Scanner datos_add = new Scanner(System.in);
            String cod = datos_add.next();
            String nom = datos_add.next();
            int ths = datos_add.nextInt();
            int mhd = datos_add.nextInt();
            asignaturas.add(new asignatura(cod, nom, ths, mhd));
        }
        public void asignatura_auto(String cod, String nom, int ths, int mhd){
            asignaturas.add(new asignatura(cod, nom, ths, mhd)); // TODO: Pending docente add
        }
        public void listar_asignaturas(){
            for (asignatura i : asignaturas) {
                System.out.println(i.codigo + ": " + i.nombre); // TODO: get via method? See docente getfullname
            }
        }
        public void get_asg_codes(){
            System.out.println("Asignaturas registradas en este momento: ");
            for (asignatura i : asignaturas) {
                System.out.println(i.codigo);
            }
        }
        public void detalle_asignatura(){
            get_asg_codes();
            Scanner scanner = new Scanner(System.in);
            String cod_a_buscar = scanner.next();
            for (asignatura i: asignaturas) {
                if (i.codigo.equals(cod_a_buscar)) {
                    i.get_details();
                }
            }
        }


        public void editar_asignatura(){
            System.out.println("Mostrando lista de asignaturas: ");
            get_asg_codes();
            System.out.println("Introduzca el codigo de la asignatura que desea editar: ");
            Scanner scanner_editar = new Scanner(System.in);
            String cod_a_buscar = scanner_editar.next();
            for (asignatura i: asignaturas) {
                if (i.codigo.equals(cod_a_buscar)) {
                    System.out.println("Estos son los detalles de la asignatura solicitada:");
                    i.get_details();
                    System.out.println("Introduzca los tres primeros caracteres de la variable que desea cambiar: ");
                    Scanner scanner_trescaracteres = new Scanner(System.in);
                    String tres_primeros_caracteres = scanner_trescaracteres.next();
                    System.out.println("Introduzca el nuevo valor de " + tres_primeros_caracteres);
                    Scanner scannernuevo_valor = new Scanner(System.in);
                    
                    if (tres_primeros_caracteres.equals("COD") || tres_primeros_caracteres.equals("NOM")){
                        String valor_a_cambiar = scannernuevo_valor.next();
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
                    }
                }
            }
        }

        public asignatura asignatura_by_id(String p_id){
            for (asignatura as: asignaturas) {
                if (p_id.equals(as.codigo)){
                    return as;
                }
            }
            return null;
        }


        public void eliminar_asignatura(){
            System.out.println("Mostrando lista de asignaturas: ");
            get_asg_codes();
            System.out.println("Introduzca el codigo de la asignatura que desea eliminar: ");
            Scanner scanner = new Scanner(System.in);
            String cod_a_buscar = scanner.next();
            for (asignatura i: asignaturas) {
                if (i.codigo.equals(cod_a_buscar)) {
                    asignaturas.remove(i);
                    break;
                }
            }
        }

        public void eliminar_asignaturas(){
            asignaturas.clear();
            System.out.println("TODAS Las asignaturas se han eliminado correctamente.");

        }

    /* ***********************************************
     * ***********************************************
     *      Clases HORAS / ENTRADAS HORARIO
     * ***********************************************
     * ***********************************************
     */

    public void add_entrada_horario_auto(String p_dia, String id_aula, String id_asignatura, int p_hora) {
        int dia_deseado = 0;
        aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "El parámetro introducido para el código de aula no es valido. Revise este valor, por favor");
            return;
        }
        asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
        if (asignatura_deseada == null) {
            System.out.println("El parámetro introducido para el código de asignatura no es valido. Revise este valor, por favor");
            return;
        }

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println("El parámetro introducido para el día de la semana no es valido. Revise este valor, por favor");
            return;
        }
        // Si la asignatura no ha alcanzado su limite de 'ocupacion', permitira la
        // creacion de la hora. En caso contrario, else, dara mensaje de error y
        // retornara.
        if (asignatura_deseada.can_be_scheduled_more()) {
            aula_deseada.dia[dia_deseado].horas[p_hora] = new hora(asignatura_deseada);
        } else {
            System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                    + "porque se ha alcanzado su límite (" + asignatura_deseada.max_horas_dia + ")");
            return; // return sirve para volver al menu, o a lo que ha llamado a la funcion inicialmente
        }
    }

    public void add_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de creacion de entradas en el horario!");
        int dia_deseado = 0;

        System.out.println("    Introduzca el aula para el que desea agregar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();
        
        aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println("El parámetro introducido para el código de aula no es valido. Revise este valor, por favor");
            waiter();
            return;
        }
        
        System.out.println("    Introduzca la asignatura para la que desea agregar una entrada\n Asignaturas actualmente registradas: ");
        get_asg_codes();
        Scanner scanner_p_asg = new Scanner(System.in);
        String id_asignatura = scanner_p_asg.next();

        asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
        if (asignatura_deseada == null) {
            System.out.println("El parámetro introducido para el código de asignatura no es valido. Revise este valor, por favor");
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
            System.out.println("El parámetro introducido para el día de la semana no es valido. Revise este valor, por favor");
            waiter();
            return;
        }

        System.out.println("    Introduzca la hora para la que desea agregar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24){
            System.out.println("El parámetro introducido para la hora del dia no es valido. Revise este valor, por favor");
            waiter();
            return;
        }

        // Hasta aqui no llegara si no alguno de los parametros introducidos anteriormente han dado error.

        // Si la asignatura no ha alcanzado su limite de 'ocupacion', permitira la
        // creacion de la hora. En caso contrario, else, dara mensaje de error y
        // retornara.

        if (asignatura_deseada.can_be_scheduled_more()) {
            // Si es posibe añadir una nueva entradas, ahora llega el momento de comprobar si en esa hora ya existe una entrada. 
            // Una posible mejora seria permitir la eliminacion directamente aqui...
            if (aula_deseada.dia[dia_deseado].horas[p_hora].asignatura == null){
                aula_deseada.dia[dia_deseado].horas[p_hora] = new hora(asignatura_deseada);
            } else {
                // Si NO es null, else, significa que en esa hora ya existe una entrada. Por tanto, no la annadimos.
                System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                    + " porque ya existe una clase programada a esa misma hora.");
                waiter();
                return;
            }
        } else {
            System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                    + "porque se ha alcanzado su límite (" + asignatura_deseada.max_horas_dia + ")");
                    waiter();
            return; // return sirve para volver al menu, o a lo que ha llamado a la funcion inicialmente
        }
        waiter();
    }

    public void edit_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de edicion de asignaturas!");
        int dia_deseado = 0;

        System.out.println("    Introduzca el aula para el que desea editar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();
        
        aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println(
                    "El parámetro introducido para el código de aula no es valido. Revise este valor, por favor");
            return;
        }
        
        System.out.println("En el aula indicada anteriormente, " + id_aula + " se encuentran agregadas las siguentes entradas:");
        aula_deseada.get_lessons();

        System.out.println("    Introduzca el dia para el cual desea editar una entrada\n Valores validos: ");
        System.out.println("      'lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'");

        Scanner scanner_p_dia = new Scanner(System.in);
        String p_dia = scanner_p_dia.next();

        dia_deseado = dow_string_to_int(p_dia.toLowerCase());
        // Si la funcion devuelve 99 significa que el parametro introducido no es
        // valido.
        if (dia_deseado == 99) {
            System.out.println("El parámetro introducido para el día de la semana no es valido. Revise este valor, por favor");
            return;
        }

        
        System.out.println("    Introduzca la hora para la que desea editar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24){
            System.out.println("El parámetro introducido para la hora del dia no es valido. Revise este valor, por favor");
            return;
        }

        System.out.println("Se va a proceder a editar la asignatura " + aula_deseada.dia[dia_deseado].horas[p_hora].asignatura.nombre);
        System.out.println("   Es correcta la informacion? (S/N)");

        Scanner scanner_conf_edit = new Scanner(System.in);
        String conf_edit_param = scanner_conf_edit.next();
        if (conf_edit_param.equals("S") || conf_edit_param.equals("s")) { // mayusculas o minisculas para facilitar la entrada de datos
            System.out.println("Introduzca la nueva asignatura por la que desea sustituir" + aula_deseada.dia[dia_deseado].horas[p_hora].asignatura.nombre);
            Scanner scanner_nueva_asig = new Scanner(System.in);
            String id_asignatura = scanner_nueva_asig.next();
            asignatura asignatura_deseada = asignatura_by_id(id_asignatura);
            if (asignatura_deseada == null) {
                System.out.println("El parámetro introducido para el código de asignatura no es valido. Revise este valor, por favor");
                return;
            }
            if (asignatura_deseada.can_be_scheduled_more()) {
                aula_deseada.dia[dia_deseado].horas[p_hora] = new hora(asignatura_deseada);
                System.out.println("Se ha creado correctamente la entrada indicada. Regresando al menu...");
            } else {
                System.out.println("No es posible crear una nueva entrada para " + id_asignatura
                        + " porque se ha alcanzado su límite (" + asignatura_deseada.max_horas_dia + ")");
                return; // return sirve para volver al menu, o a lo que ha llamado a la funcion inicialmente
            }
        } else {
            System.out.println("Ha cancelado el proceso o ha indicado una letra no admitida. Volviendo al menu");
            return;
        }
    }

    public void del_entrada_horario() {
        System.out.println("Te damos la bienvenida al asistente de eliminacion de entradas en el hoario!");
        int dia_deseado = 0;

        System.out.println("    Introduzca el aula para el que desea eliminar una entrada\n Aulas actualmente registradas: ");
        get_aula_codes();
        Scanner scanner_p_aula = new Scanner(System.in);
        String id_aula = scanner_p_aula.next();
        
        aula aula_deseada = aula_by_id(id_aula);
        if (aula_deseada == null) {
            System.out.println("El parámetro introducido para el código de aula no es valido. Revise este valor, por favor");
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
            System.out.println("El parámetro introducido para el día de la semana no es valido. Revise este valor, por favor");
            waiter();
            return;
        }

        System.out.println("    Introduzca la hora para la que desea eliminar una entrada\n En formato 0 - 24. Horas enteras unicamente. ");
        Scanner scanner_p_hora = new Scanner(System.in);
        int p_hora = scanner_p_hora.nextInt();
        if (p_hora < 0 || p_hora > 24){
            System.out.println("El parámetro introducido para la hora del dia no es valido. Revise este valor, por favor");
            waiter();
            return;
        }
        // AQUI se produce la eliminacion de la entrada
        aula_deseada.dia[dia_deseado].horas[p_hora] =null;
        System.out.println("Se ha eliminado correctamente la entrada indicada");
        waiter();

        waiter();
    }


    public void get_entradas(){
        for (aula a: aulas){
            System.out.println("Para el aula código " + a.id + ":");
            a.get_lessons();
        }
    }



    // TODO: listar entradas del un dia
    // TODO: listar todas las entradas de todos los dias

    /* ***********************************************
     * ***********************************************
     *               Clases AULA
     * ***********************************************
     * ***********************************************
     */
        public void add_aula_auto(String p_id, int p_csp){
            aulas.add(new aula(p_id, p_csp));
        }

        public void get_aula_codes(){
            System.out.println("Aulas registradas en este momento: ");
            for (aula i: aulas) {
                System.out.println(i.id);
            }
        }

        public void get_detalle_aula(){
            get_aula_codes();
            System.out.println("Introzca el codigo del aula para la que desea ver los detalles: ");
            // TODO: Check if requested exists. Maybe return an array?
            Scanner scanner = new Scanner(System.in);
            String cod_a_buscar = scanner.next();
            for (aula i: aulas) {
                    if (i.id.equals(cod_a_buscar)) {
                        i.get_details();
                    }
                }
        }

        public void get_detalle_aulas(){
            for (aula i: aulas) {
                    i.get_details();
                }
            }
        }

        public aula aula_by_id(String p_id){
            // System.out.println("Entro en method");
            for (aula a: aulas) {
                // System.out.println("Recorriendo...");
                if (p_id.equals(a.id)){
                    // System.out.println("Encontrado");
                    // a.get_details();
                    return a;
                }
            }
            return null;
        }

        public void aula_delete(){
            System.out.println("Por favor, introduzca el identificador del aula que desea eliminar:");
            
            Scanner scanner = new Scanner(System.in);
            String id_aula_pasado_por_scanner = scanner.next();
            aula aula_a_eliminar = aula_by_id(id_aula_pasado_por_scanner);
            aulas.remove(aula_a_eliminar);
            
            System.out.println("La aula ha sido eliminada correctamente.");
        }
        
        public void aula_add(){
            System.out.println("Bienvenido al asistente de adicion de aulas.");
            System.out.println("A continuacion se muestran las aulas ya existentes:");
            get_aula_codes();
            System.out.println("Introduzca el ID de la nueva aula a crear:");
            Scanner scannercreacionaula = new Scanner(System.in);
            String creacion_aula = scannercreacionaula.next();
            System.out.println("Indique la capacidad para aula " + creacion_aula + ":");
            Scanner scannercapacidad = new Scanner(System.in);
            int capacidad_aula_nueva = scannercapacidad.nextInt();
            aulas.add(new aula(creacion_aula, capacidad_aula_nueva));
            System.out.println("Su aula ha sido creada con exito.");
        }
        

        // TODO: asistente edicion aula

    /* ***********************************************
     * ***********************************************
     *               Clases DOCENTE
     * ***********************************************
     * ***********************************************
     */

        public void get_docente_dnis(){
            System.out.println("DNIs registrados en este momento: ");
            for (docente i: docentes) {
                System.out.println(i.get_dni());
            }
        }

        public void get_docente_listado(){
            System.out.println("DNIs registrados en este momento: ");
            for (docente i: docentes) {
                System.out.println(i.get_dni() + ": " + i.get_fullname());
            }
        }

        public void add_docente_auto(String dni, String nombre, String apellido1, String apellido2){
            docentes.add(new docente(dni, nombre, apellido1, apellido2));
        }

        public void docente_delete(){
            System.out.println("Por favor, introduzca el DNI del docente que desee dar de baja:");
            
            Scanner scanner = new Scanner(System.in);
            String docente_de_baja = scanner.next();
            docente docente_a_eliminar = docente_by_dni(docente_de_baja);
            docentes.remove(docente_a_eliminar);
            System.out.println("El docente se ha dado de baja correctamente.");

        }

        public docente docente_by_dni(String p_id){
            for (docente d: docentes) {
                // System.out.println("Recorriendo...");
                if (p_id.equals(d.dni)){
                    return d;
                }
            }
            return null;
        }

        // TODO: asistente adicion docente
        // TODO: asistente edicion docente
        
}
