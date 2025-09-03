import java.util.List;

public class VisualizadorCarrito {
    public void mostrarProductos(List<ArticuloCarrito> articulos) {
        if (articulos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }
        System.out.println("PRODUCTOS EN EL CARRITO");
        for(int i = 0; i < articulos.size(); i++) {
            ArticuloCarrito articulo = articulos.get(i);
            System.out.println((i + 1) + ". " + articulo.getProducto().obtenerNombre() + 
                               " - Cantidad: " + articulo.getCantidad() +
                               " - Subtotal: $" + articulo.getSubtotal());
        }
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println("INFO: " + mensaje);
    }
    
    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
    
    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }
}