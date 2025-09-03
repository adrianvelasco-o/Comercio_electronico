import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private List<ArticuloCarrito> articulos = new ArrayList<>();
    private CalculadoraCarrito calculadora;
    private GestorInventario gestorInventario;
    private VisualizadorCarrito visualizador;

    public Carrito(int idCarrito) {
        this.idCarrito = idCarrito;
        this.calculadora = new CalculadoraCarrito();
        this.gestorInventario = new GestorInventario();
        this.visualizador = new VisualizadorCarrito();
    }

    public int obtenerIdCarrito() {
        return this.idCarrito;
    }

    public void agregarProductos(Producto producto, int cantidad) {
        if (gestorInventario.hayStockDisponible(producto, cantidad)) {
            boolean articuloEncontrado = false;
            for (ArticuloCarrito articuloExistente : articulos) {
                if (articuloExistente.getProducto().obtenerId() == producto.obtenerId()) {
                    articuloExistente.setCantidad(articuloExistente.getCantidad() + cantidad);
                    articuloEncontrado = true;
                    break;
                }
            }
            if (!articuloEncontrado) {
                articulos.add(new ArticuloCarrito(producto, cantidad));
            }
            gestorInventario.reducirStock(producto, cantidad);
            visualizador.mostrarExito("Producto agregado al carrito: " + producto.obtenerNombre());
        } else {
            visualizador.mostrarError("No hay stock disponible para: " + producto.obtenerNombre());
        }
    }

    public void eliminarProducto(Producto producto) {
        for (ArticuloCarrito articulo : articulos) {
            if (articulo.getProducto().equals(producto)) {
                articulos.remove(articulo);
                gestorInventario.restaurarStock(producto, articulo.getCantidad());
                visualizador.mostrarExito("Producto eliminado del carrito: " + producto.obtenerNombre());
                return;
            }
        }
        visualizador.mostrarError("El producto no está en el carrito");
    }

    public List<ArticuloCarrito> obtenerArticulos() {
        return new ArrayList<>(articulos);
    }

    public int obtenerCantidadProductos() {
        return articulos.size();
    }

    public void limpiarCarrito() {
        for (ArticuloCarrito articulo : articulos) {
            gestorInventario.restaurarStock(articulo.getProducto(), articulo.getCantidad());
        }
        articulos.clear();
        visualizador.mostrarExito("Carrito limpiado completamente");
    }

    public boolean estaVacio() {
        return articulos.isEmpty();
    }

    public double calcularSubtotal() {
        return calculadora.calcularSubtotal(articulos);
    }
    
    public void mostrarProductos() {
        visualizador.mostrarProductos(articulos);
    }
}