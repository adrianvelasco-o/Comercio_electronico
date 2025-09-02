import java.util.List;

public class VisualizadorCarrito {
    
   
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }
        
        System.out.println("PRODUCTOS EN EL CARRITO");
        for(int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
                System.out.println((i + 1) + ". " + p.obtenerNombre() + " - Precio: $" + p.obtenerPrecio() + " - Subtotal: $" + p.subtotal());
        }
        
    }
    
    
    public void mostrarResumen(List<Producto> productos, double subtotal) {
        System.out.println("RESUMEN DEL CARRITO ");
        System.out.println("Total de productos: " + productos.size());
        System.out.println("Subtotal: $" + subtotal);
        
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
    
   
    public String generarReporte(List<Producto> productos, double subtotal) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("REPORTE DEL CARRITO\n");
        reporte.append("Total de productos: ").append(productos.size()).append("\n");
        reporte.append("Subtotal: $" + subtotal + "\n");
        
        
        for(int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            reporte.append((i + 1) + ". " + p.obtenerNombre() + " - " + p.obtenerPrecio() + "\n");
        }
        
        return reporte.toString();
    }
}
