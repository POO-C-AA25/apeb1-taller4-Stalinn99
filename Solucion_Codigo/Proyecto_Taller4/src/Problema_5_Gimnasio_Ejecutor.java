import java.util.*;
public class Problema_5_Gimnasio_Ejecutor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Gimnasio gimnasiox = new Gimnasio();
            System.out.println("Registro de clientes: ");
            System.out.println("¿Cuantos clientes va a ingresar?");
            int clientes = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < clientes; i++){
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Tipo de entrenamiento: ");
                String tipo_entrenamiento = sc.nextLine();
                System.out.println("Duración: ");
                int duracion = sc.nextInt();
                System.out.println("¿Completo la rutina? (si/no)");
                String respuesta = sc.next().toLowerCase();
                boolean completado = respuesta.equals("si");
                sc.nextLine();
                Cliente clientex = new Cliente(nombre, tipo_entrenamiento, duracion, completado);
                gimnasiox.agregarCliente(clientex);
            }
            gimnasiox.calcularPromedioDuracion();
            gimnasiox.calcularClienteCompletado();
            System.out.println(gimnasiox.toString());
        }
    }
}
class Cliente{
    public String nombre;
    public String tipo_entrenamiento;
    public int duracion;
    public boolean completado;
    public Cliente(){}
    public Cliente(String nombre, String tipo_entrenamiento, int duracion, boolean completado){
        this.nombre = nombre;
        this.tipo_entrenamiento = tipo_entrenamiento;
        this.duracion = duracion;
        this.completado = completado;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo_entrenamiento(){
        return this.tipo_entrenamiento;
    }
    public int getDuracion(){
        return this.duracion;
    }
    public boolean getCompletado(){
        return this.completado;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTipo_entrenamiento(String tipo_entrenamiento){
        this.tipo_entrenamiento = tipo_entrenamiento;
    }
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    public void setCompletado(boolean completado){
        this.completado = completado;
    }
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + "\nTipo de entrenamiento: " + this.tipo_entrenamiento
                + "\nDuración de rutina: " + this.duracion + "\nCompletado: " + this.completado;
    }
}
class Gimnasio{
    public List<Cliente> clientes;
    public double promedio;
    public int clientes_completado;
    public Gimnasio (){
        this.clientes = new ArrayList<>();
        this.promedio = 0;
        this.clientes_completado = 0;
    }
    public void agregarCliente(Cliente cliente) {
        if(cliente != null){
            this.clientes.add(cliente);
        }
    }
    public void calcularPromedioDuracion(){
        if(this.clientes.isEmpty()){
            this.promedio = 0.0;
            return;
        }
        int totalduracion = 0;
        for(int i = 0; i < clientes.size(); i++){
            totalduracion += this.clientes.get(i).getDuracion();
        }
        this.promedio =  totalduracion / clientes.size();
    }
    public void calcularClienteCompletado(){
        this.clientes_completado = 0;
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getCompletado() == true){
                this.clientes_completado++;
            }
        }
    }
    @Override
    public String toString(){
        return "El tiempo promedio de todos los clientes es de: " + this.promedio + " minutos" +
                "\nClientes que completaron la rutina: " + this.clientes_completado;
    }
}