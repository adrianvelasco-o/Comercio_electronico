import java.util.List;
public class CalculadoraCarrito {
    public double calcularSubtotal(List<ArticuloCarrito> articulos) {
        double subtotal = 0.0;
        for (ArticuloCarrito articulo : articulos) {
            subtotal += articulo.getSubtotal();
        }
        return subtotal;
    }
    
    public double calcularTotalConImpuestos(List<ArticuloCarrito> articulos, double porcentajeImpuesto) {
        double subtotal = calcularSubtotal(articulos);
        return subtotal + (subtotal * porcentajeImpuesto);
    }
}