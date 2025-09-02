public class Pedido {

    private Producto producto;
    private double impuesto;
    public Pedido(Producto producto){
        this.producto = producto;
        this.impuesto = 0.19;
    }

    public double calcularTotal(){
        return producto.subtotal() + (producto.subtotal() * impuesto);
    }
}
