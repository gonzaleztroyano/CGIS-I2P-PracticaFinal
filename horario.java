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
        }

    /* ***********************************************
     * ***********************************************
     *      Clases HORAS / ENTRADAS HORARIO
     * ***********************************************
     * ***********************************************
     */

     public void add_entrada_horario(){
        // Aquí va el asistente
     }

     public void add_entrada_horario_auto(String p_dia, String id_aula, String id_asignatura, int p_hora){
        int dia_deseado = 0;
        aula aula_deseada = aula_by_id(id_aula);
        asignatura asignatura_deseada = asignatura_by_id(id_asignatura);

        p_dia.toLowerCase();
         switch (p_dia) {
             case "lunes" -> dia_deseado = 0;
             case "martes" -> dia_deseado = 1;
             case "miercoles" -> dia_deseado = 2;
             case "jueves" -> dia_deseado = 3;
             case "viernes" -> dia_deseado = 4;
             case "sadado" -> dia_deseado = 5;
             case "domingo" -> dia_deseado = 6;
         }
        //aula_deseada.dia.horas = new hora[] horas
        
        aula_deseada.dia[dia_deseado].horas[p_hora] = new hora(asignatura_deseada);

         System.out.println("asd");
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
