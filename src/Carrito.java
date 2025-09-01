import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private List<Producto> productos = new ArrayList<>();
    
    // Delegación de responsabilidades a clases especializadas
    private CalculadoraCarrito calculadora;
    private GestorInventario gestorInventario;
    private VisualizadorCarrito visualizador;

    public Carrito(int idCarrito){
        this.idCarrito = idCarrito;
        this.productos = new ArrayList<>();
        
        // Inicializar las clases especializadas
        this.calculadora = new CalculadoraCarrito();
        this.gestorInventario = new GestorInventario();
        this.visualizador = new VisualizadorCarrito();
    }

    //RESPONSABILIDAD ÚNICA GESTIÓN DEL CARRITO 
    
    public int obtenerIdCarrito(){
        return this.idCarrito;
    }

    public void agregarProductos(Producto producto){
        if (gestorInventario.hayStockDisponible(producto, 1)) {
            productos.add(producto);
            gestorInventario.reducirStock(producto, 1);
            visualizador.mostrarExito("Producto agregado al carrito: " + producto.obtenerNombre());
        } else {
            visualizador.mostrarError("No hay stock disponible para: " + producto.obtenerNombre());
        }
    }

    public void eliminarProducto(Producto producto){
        if (productos.contains(producto)) {
            productos.remove(producto);
            gestorInventario.restaurarStock(producto, 1);
            visualizador.mostrarExito("Producto eliminado del carrito: " + producto.obtenerNombre());
        } else {
            visualizador.mostrarError("El producto no está en el carrito");
        }
    }

    public List<Producto> obtenerProductos(){
        return new ArrayList<>(productos);
    }

    public int obtenerCantidadProductos(){
        return productos.size();
    }

    public void limpiarCarrito(){
        for(Producto p : productos){
            gestorInventario.restaurarStock(p, 1);
        }
        productos.clear();
        visualizador.mostrarExito("Carrito limpiado completamente");
    }
    
    public boolean estaVacio(){
        return productos.isEmpty();
    }
    
    public boolean contieneProducto(Producto producto){
        return productos.contains(producto);
    }
    
    // ASIGNACION DE RESPONSABILIDADES
    
    public double calcularSubtotal(){
        return calculadora.calcularSubtotal(productos);
    }
    
    public double calcularTotalConImpuestos(double porcentajeImpuesto){
        return calculadora.calcularTotalConImpuestos(productos, porcentajeImpuesto);
    }
    
    public void mostrarProductos(){
        visualizador.mostrarProductos(productos);
    }
    
    public void mostrarResumen(){
        double subtotal = calcularSubtotal();
        visualizador.mostrarResumen(productos, subtotal);
    }
    
    public String generarReporte(){
        double subtotal = calcularSubtotal();
        return visualizador.generarReporte(productos, subtotal);
    }
}
