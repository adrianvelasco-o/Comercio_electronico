import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List productos;

    public Carrito(){
        productos = new ArrayList<>();
    }

    public void agregarProductos(Producto producto){
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    public double calcularSubtotal(){
        return 32132;
    }

    public void obtenerProductos(){
        for(Producto producto : productos){
            System.out.print(producto.nombre);
        }
    }

}
