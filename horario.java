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

    // TODO: definir nomenclatura 

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
            // TODO: Pending Array docente
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

            // TODO: asistente edicion asignatura
        public void editar_asignatura(){
            System.out.println("Mostrando lista de asignaturas: ");
            get_asg_codes();
            System.out.println("Introduzca el codigo de la asignatura que desea editar: ");
            Scanner scanner = new Scanner(System.in);
            String cod_a_buscar = scanner.next();
            for (asignatura i: asignaturas) {
                if (i.codigo.equals(cod_a_buscar)) {
                    System.out.println("Estos son los detalles de la asignatura solicitada:");
                    i.get_details();
                    System.out.println("Introduzca los tres primeros caracteres de la variable que desea cambiar: ");
                    Scanner scanner = new Scanner(System.in);
                    String tres_primeros_caracteres = scanner.next();
                    // TODO: comprobar
                    System.out.println("Introduzca el nuevo valor de " + tres_primeros_caracteres);
                    Scanner scanner = new Scanner(System.in);
                    String nuevo_valor = scanner.next();
                }
                else{
                    (scanner = )
                }
            }

        }
 
                //  --> public docente.XXX = YYY
                //  --> private method update_hours_max(14) 
                    // editar propiedad 
                // OKI 
            // TODO: asistente eliminacion asignatura

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
     *               Clases DIAS
     * ***********************************************
     * ***********************************************
     */



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

        // TODO: asistente adicion aula
        // TODO: asistente edicion aula
        // TODO: asistente eliminado aula

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

        // TODO: asistente adicion docente
        // TODO: asistente edicion docente
        // TODO: asistente eliminado docente
}
