import java.util.Scanner;
public class Problema_1_Producto_Ejecutor {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el precio del producto: ");
            double precio = sc.nextDouble();
            System.out.println("Ingrese la cantidad del producto: ");
            int cantidadP = sc.nextInt();
            Producto productox = new Producto(precio, cantidadP);
            System.out.println("\n--- Detalles del Producto ---");
            productox.calculardescuento(precio, cantidadP);
            productox.calcularPrecioFinal();
            System.out.println(productox.toString());
        }
    }
}
class Producto{
    public double precio;
    public int cantidadP;
    public double descuento;
    public double preciofinal;
    public Producto() {}
    public Producto(double precio, int cantidadP){
        this.precio = precio;
        this.cantidadP = cantidadP;
    }
    public double calculardescuento(double precio, int cantidadP){
        if (precio >= 1000 && cantidadP >=10) {
            this.descuento = 0.1;
        } else if (precio < 1000 ){
            this.descuento = 0.05;
        }
        return this.descuento;
    }
    public double calcularPrecioFinal(){
        this.preciofinal = (this.cantidadP * this.precio) -((this.cantidadP * this.precio) * this.descuento) ;
        return this.preciofinal;
    }
    @Override
    public String toString(){
        return String.format("Precio: %.2f\nCantidad: %3d\nDescuento: %.2f %s\nPrecio final: %.2f"
        ,this.precio,this.cantidadP,this.descuento,"%",this.preciofinal);
    }
}