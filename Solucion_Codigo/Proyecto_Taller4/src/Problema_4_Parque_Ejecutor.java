import java.util.*;
public class Problema_4_Parque_Ejecutor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Parque parquex = new Parque();
            System.out.println("¿Cúantos visitantes van a ingresar?");
            int visitantes = sc.nextInt();
            for(int i = 0; i < visitantes; i++){
                sc.nextLine();
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Edad: ");
                byte edad = sc.nextByte();
                System.out.println("Estatura: ");
                double estatura = sc.nextDouble();
                Visitante visitante = new Visitante(nombre, edad, estatura);
                parquex.registrovisitantes(visitante);
            }
            System.out.println("Lista de visitantes");
            parquex.mostrarInfo();
            System.out.println("Simulacion de ingreso");
            parquex.simularIngreso();
            System.out.println("Aceptados y Rechazados");
            System.out.println(parquex.toString());
        }
    }
}
class Visitante{
    public String nombre;
    public byte edad;
    public double estatura;

    public Visitante() {
    }
    public Visitante(String nombre, byte edad, double estatura){
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }
    public String getNombre(){
        return this.nombre;
    }
    public byte getEdad(){
        return this.edad;
    }
    public double getEstatura(){
        return this.estatura;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(byte edad){
        this.edad = edad;
    }
    public void setEstatura(double estatura){
        this.estatura = estatura;
    }
    @Override
    public String toString() {
        return "Nombre: "+this.nombre+"\nEdad: "+this.edad+"\nEstatura: "+this.estatura;
    }
}
class Parque{
    public List<Visitante> visitantes;
    public int aceptados;
    public int rechazados;
    public Parque(){
        this.visitantes = new ArrayList<>();
        this.aceptados = 0;
        this.rechazados = 0;
    }
    public void registrovisitantes(Visitante visitante){
        visitantes.add(visitante);
    }
    public void simularIngreso(){
        this.aceptados = 0;
        this.rechazados = 0;
        for(int i = 0; i < visitantes.size(); i++){
            boolean juego1 = false;
            boolean juego2 = false;
            boolean juego3 = false;
            Visitante visitante= visitantes.get(i);
            if(visitante.getEdad() >= 12 && visitante.getEstatura() >= 1.4){
                System.out.println(visitante.getNombre() + " puede ingresar al juego 1");
                juego1 = true;
            } else{
                System.out.println(visitante.getNombre() + " no puede ingresar al juego 1");
            }
            if(visitante.getEdad() >= 10 && visitante.getEstatura() >= 1){
                juego2 = true;
                System.out.println(visitante.getNombre() + " puede ingresar al juego 2");
            } else{
                System.out.println(visitante.getNombre() + " no puede ingresar al juego 2");
            }
            if(visitante.getEdad() >= 15 && visitante.getEstatura() >= 1.5){
                juego3 = true;
                System.out.println(visitante.getNombre() + " puede ingresar al juego 3");
            } else{
                System.out.println(visitante.getNombre() + " no puede ingresar al juego 3");
            }
            if ((juego1 && juego2) && (juego2 && juego3)){
                this.aceptados++;
            } else {
                this.rechazados++;
            }
        }
    }
    public void mostrarInfo(){
        for(int i = 0; i < visitantes.size(); i++){
            System.out.println(visitantes.get(i));
        }
    }
    @Override
    public String toString(){
        return "Aceptados en todos los juegos: " + this.aceptados + "\nRechazados: " + this.rechazados;
    }
}