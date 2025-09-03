// PayPal.java
public class PayPal implements Pago {
    private String correoUsuario;
    private double monto;
    private Pedido pedido;
    
    public PayPal(String correoUsuario, Pedido pedido) {
        this.correoUsuario = correoUsuario;
        this.pedido = pedido;
        this.monto = pedido.calcularTotal();
    }

    @Override
    public boolean procesarPago() {
        System.out.println("Procesando pago con PayPal: " + correoUsuario);
        System.out.println("Monto a pagar: $" + monto);
        return true;
    }

    @Override
    public String generarRecibo() {
        return "Recibo de Pago\n" +
                "--------------------\n" +
                "Método de Pago: PayPal\n" +
                "Correo: " + correoUsuario + "\n" +
                "Monto Total: $" +monto + "\n" +
                "Estado: Pagado";
    }
}