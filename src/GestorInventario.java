public class GestorInventario {
    public boolean hayStockDisponible(Producto producto, int cantidad) {
        return producto.obtenerStock() >= cantidad;
    }
    
    public boolean reducirStock(Producto producto, int cantidad) {
        if (hayStockDisponible(producto, cantidad)) {
            producto.modificarStock(cantidad);
            return true;
        }
        return false;
    }
    
    public void restaurarStock(Producto producto, int cantidad) {
        producto.modificarStock(-cantidad);
    }
}