import java.util.*; 
public class Problea_2_Empleado_Ejecutor {
    public static void main(String[] args) {
        NominaEmpleados nominax = new NominaEmpleados();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Cúantos empleados desea agregar?");
            int empleados = sc.nextInt();
            sc.nextLine();
            double porcentaje;
            for (int i = 0; i < empleados; i++) {
                System.out.println("\n--- Información del empleado " + (i + 1) + " ---"); 
                System.out.print("Nombre: ");   
                String nombre = sc.nextLine();
                System.out.print("Salario: "); 
                double salario = sc.nextDouble();
                System.out.print("Edad: "); 
                byte edad = sc.nextByte();
                sc.nextLine();
                Empleado empleadox = new Empleado(nombre, salario, edad);
                nominax.agregarEmpleado(empleadox);
            }
            nominax.mostrarempleados();
            double promedioSalarios = nominax.promedio();
            System.out.println("\nPromedio de salarios: " + String.format("%.2f", promedioSalarios));
            do {
                System.out.print("\nIngrese el porcentaje de aumento salarial a aplicar: ");
                porcentaje = sc.nextDouble();
            } while (porcentaje <= 0);
            nominax.calcularaumentos(porcentaje);
            nominax.mostrarempleados();
        }
    }
}
class Empleado {
    private String nombre;
    private double salario;
    private byte edad;
    public Empleado(){}
    public Empleado(String nombre, double salario, byte edad){
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getSalario(){
        return this.salario;
    }
    public byte getEdad(){
        return this.edad;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setEdad(byte edad){
        this.edad = edad;
    }
    @Override
    public String toString(){
        return "Nombre del empleado: " + this.nombre + "\nSalario: " + this.salario
                + "\n Edad: " + this.edad;
    }
}
class NominaEmpleados {
    private List<Empleado> empleados;
    public NominaEmpleados() {
        this.empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            this.empleados.add(empleado);
            System.out.println("Empleado agregado con éxito.");
        } else {
            System.out.println("Error: No se puede agregar un empleado nulo.");
        }
    }
    public double promedio() {
        if (empleados.isEmpty()) {
            return 0.0;
        }
        double sumaSalarios = 0;
        for (int i = 0; i < empleados.size(); i++) {
            sumaSalarios += empleados.get(i).getSalario();
        }
        return sumaSalarios / empleados.size();
    }
    public void mostrarempleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la nómina.");
            return;
        }
        System.out.println("Lista de Empleados: ");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println("Empleado " + (i + 1) + ": " + empleados.get(i).toString());
        }
    }
    public void calcularaumentos(double porcentaje) {
        System.out.println("Aplicando aumento del " + porcentaje + "% a los salarios.");
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            double salarioActual = empleado.getSalario();
            double aumento = salarioActual * (porcentaje / 100.0);
            empleado.setSalario(salarioActual + aumento);
        }
        System.out.println("Aumentos aplicados.");
    }
}