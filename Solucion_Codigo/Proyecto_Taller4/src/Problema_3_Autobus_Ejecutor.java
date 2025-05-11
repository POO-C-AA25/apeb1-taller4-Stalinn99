import java.util.*;
public class Problema_3_Autobus_Ejecutor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Autobus autobusx = new Autobus();
            System.out.println("¿Cúantos estudiantes desea ingresar?");
            int estudiante = sc.nextInt();
            sc.nextLine();
            for (int i  = 0; i < estudiante; i++){
                boolean permiso;
                int n;
                System.out.println("Estudiante " + (i+1) + ": ");
                System.out.println("Nombre del estudiante: ");
                String nombre = sc.nextLine();
                System.out.println("Grado del estudiante: ");
                int grado = sc.nextInt();
                do {
                    System.out.println("Tiene permiso? (1 = true, 2=false): ");
                    n = sc.nextInt();
                } while(n != 1 && n != 2);
                if (n == 1){
                    permiso = true;
                } else {
                    permiso = false;
                }
                Estudiante estudiantes = new Estudiante(nombre, grado, permiso);
                autobusx.registrarEstudiante(estudiantes);
                sc.nextLine();
            }
            System.out.println("Estudiantes registrados");
            autobusx.mostrarEstudiantes();
            System.out.println("Simulacro  de ingreso");
            autobusx.simularIngreso();
            System.out.println(autobusx.toString());
        }
    }
}
class Autobus {
    private List<Estudiante> estudiantes;
    private int aceptados;
    private int rechazados;
    public Autobus() {
        this.estudiantes = new ArrayList<>();
        this.aceptados = 0;
        this.rechazados = 0;
    }
    public Autobus(int aceptados, int rechazados) {
        this();
        this.aceptados = aceptados;
        this.rechazados = rechazados;
    }
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public void simularIngreso() {
        this.aceptados = 0;
        this.rechazados = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            if (estudiante.getPermiso()) {
                this.aceptados++;
                System.out.println(estudiante.getNombre() + " puede ingresar.");
            } else {
                this.rechazados++;
                System.out.println(estudiante.getNombre() + " no puede ingresar.");
            }
        }
    }
    public void mostrarEstudiantes() {
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println(e);
        }
    }
    @Override
    public String toString() {
        return "Total aceptados: " + aceptados + ", Total rechazados: " + rechazados;
    }
}
class Estudiante{
    private String nombre;
    private int grado;
    private boolean permiso;
    public Estudiante() {}
    public Estudiante(String nombre, int grado, boolean permiso){
        this.nombre = nombre;
        this.grado = grado;
        this.permiso = permiso;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getGrado(){
        return this.grado;
    }
    public boolean getPermiso(){
        return this.permiso;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setGrado(int grado){
        this.grado = grado;
    }
    public void setPermiso(boolean permiso){
        this.permiso = permiso;
    }
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + "\nGrado: " + this.grado + "\nPermiso: " + this.permiso;
    }
}