import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private List<Producto> productos = new ArrayList<>();

    public Carrito(int idCarrito){
        this.idCarrito = idCarrito;
        productos = new ArrayList<>();
    }

    public int obtenerIdCarrito(){
        return this.idCarrito;
    }

    public void agregarProductos(Producto producto){
        if (producto.obtenerStock() > 0) {
            productos.add(producto);
            producto.modificarStock(1);
        } else {
            System.out.println("No hay stock disponible para: " + producto.obtenerNombre());
        }
    }

    public void eliminarProducto(Producto producto){
        if (productos.contains(producto)) {
            productos.remove(producto);
            producto.modificarStock(-1);
        } else {
            System.out.println("El producto no está en el carrito");
        }
    }

    public List<Producto> obtenerProductos(){
        return new ArrayList<>(productos);
    }

    public double calcularSubtotal(){
        double subtotal = 0.0;
        for(Producto p : productos){
            subtotal += p.subtotal();
        }
        return subtotal;
    }

    public void mostrarProductos(){
        for(Producto p : productos){
            System.out.println(p.obtenerNombre() + " - Precio: $" + p.obtenerPrecio() + " - Subtotal: $" + p.subtotal());
        }
    }

    public int obtenerCantidadProductos(){
        return productos.size();
    }

    public void limpiarCarrito(){
        for(Producto p : productos){
            p.modificarStock(-1);
        }
        productos.clear();
    }
}
