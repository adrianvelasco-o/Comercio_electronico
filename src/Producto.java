public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int idProducto, String nombre, double precio, int stock){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void modificarStock(int cantidad){
        this.stock -= cantidad;
    }
}
