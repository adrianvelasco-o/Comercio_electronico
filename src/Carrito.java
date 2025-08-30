import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public Carrito(){
        productos = new ArrayList<>();
    }

    public void agregarProductos(Producto producto){
        productos.add(producto);
        producto.modificarStock(1);
    }

    public void eliminarProducto(Producto producto){
        productos.remove(producto);
        producto.modificarStock(-1);
    }

    public void obtenerProductos(){
        for(Producto p : productos){
            System.out.println(p.obtenerNombre());
        }
    }


}
