public class Pedido {
    private Carrito carrito;
    private double impuesto;
    
    public Pedido(Carrito carrito) {
        this.carrito = carrito;
        this.impuesto = 0.19;
    }

    public double calcularTotal() {
        double subtotal = carrito.calcularSubtotal();
        return subtotal + (subtotal * impuesto);
    }
}