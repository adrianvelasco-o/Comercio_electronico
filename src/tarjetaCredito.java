public class TarjetaCredito implements Pago {
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private double monto;
    private Pedido pedido;

    public TarjetaCredito(String numeroTarjeta, String nombreTitular, String fechaExpiracion, Pedido pedido) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.pedido = pedido;
        this.monto = pedido.calcularTotal();
    }

    @Override
    public boolean procesarPago() {
        System.out.println("Procesando pago con tarjeta de crédito: " + numeroTarjeta);
        return true;
    }

    @Override
    public String generarRecibo() {
        return "Recibo de Pago\n" +
                "--------------------\n" +
                "Método de Pago: Tarjeta de Crédito\n" +
                "Número de Tarjeta: XXXX-XXXX-XXXX-" + (numeroTarjeta.length() - 4) + "\n" +
                "Titular de la Tarjeta: " + nombreTitular + "\n" +
                "Monto Total: $" +  monto + "\n" +
                "Estado: Pagado";
    }
}