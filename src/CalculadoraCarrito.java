import java.util.List;
public class CalculadoraCarrito {
    
    
    public double calcularSubtotal(List<Producto> productos) {
        double subtotal = 0.0;
        for(Producto p : productos) {
            subtotal += p.subtotal();
        }
        return subtotal;
    }
    
    public double calcularTotalConImpuestos(List<Producto> productos, double porcentajeImpuesto) {
        double subtotal = calcularSubtotal(productos);
        return subtotal + (subtotal * porcentajeImpuesto);
    }
    
    public double calcularDescuento(double subtotal, double porcentajeDescuento) {
        return subtotal * porcentajeDescuento;
    }
    
    public double calcularTotalConDescuento(double subtotal, double descuento) {
        return subtotal - descuento;
    }
}
