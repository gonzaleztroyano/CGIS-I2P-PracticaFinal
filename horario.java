import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class horario {
    List<asignatura> asignaturas = new ArrayList<asignatura>();
    dia[] dias = new dia[7];
    String nombre;
    int length_semana = 0;

    public horario(String nomhorario){
        nombre = nomhorario;
    }

    public void nueva_asignatura(){
        System.out.println("Bienvenido al proceso de creación de asignaturas");
        System.out.println("Introduzca, separados por espacios, los siguientes valores:\n 1. Codigo \n 2. Nombre \n 3. Total horas semana \n 4. Máximo horas día");
        Scanner datos_add = new Scanner(System.in);
        String cod = datos_add.next();
        String nom = datos_add.next();
        int ths = datos_add.nextInt();
        int mhd = datos_add.nextInt();
        // Pending Array docente
        asignaturas.add(new asignatura(cod, nom, ths, mhd));
    }
    public void asignatura_auto(String cod, String nom, int ths, int mhd){
        asignaturas.add(new asignatura(cod, nom, ths, mhd)); // Pending docente add
    }
    public void listar_asignaturas(){
        for (asignatura i : asignaturas) {
            System.out.println(i.codigo + ": " + i.nombre);
          }
    }
    public void get_asg_codes(){
        System.out.println("Asignaturas registradas en este momento:");
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
                i.getdetails();
            }
        }
    }
    public void crea_dias(String[] dias_pasados){
        for (int i = 0; i < dias_pasados.length; i++){
            System.out.println(dias_pasados[i]);
            dias[i] = new dia(dias_pasados[i]);
        }
        length_semana = dias_pasados.length;
    }
    public void lista_dias(){
        for (int i = 0; i<= length_semana-1; i++){
            System.out.println(dias[i] + " // " + dias[i].nombre);
        }
    }
}
