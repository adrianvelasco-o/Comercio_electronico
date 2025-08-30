import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    // public Carrito(){
    //     productos = new ArrayList<>();
    // }

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
        for(Producto p : productos){
            System.out.print(p);
        }
    }

}
