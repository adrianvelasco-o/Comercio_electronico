public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private int cantidad;

    public Producto(int idProducto, String nombre, double precio, int stock, int cantidad){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantidad = cantidad;
    }
    public int obtenerId(){
        return this.idProducto;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }

    public double obtenerPrecio(){
        return this.precio;
    }

    public int obtenerStock(){
        return this.stock;
    }

    public double subtotal(){
        return this.precio * this.cantidad;
    }
    
    public void modificarStock(int cantidad){
        this.stock -= cantidad;
    }
}