public class TarjetaCredito implements Pago {

    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private double monto;
    private Pedido pedido;

    public TarjetaCredito() {}

    public TarjetaCredito(String numeroTarjeta, String nombreTitular, String fechaExpiracion, Pedido pedido) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.pedido = pedido;
        // El monto total se calcula a partir del objeto pedido
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
               "Número de Tarjeta: XXXX-XXXX-XXXX-" + numeroTarjeta.substring(numeroTarjeta.length() - 4) + "\n" +
               "Titular de la Tarjeta: " + nombreTitular + "\n" +
               "Monto Total: $" + String.format("%.2f", monto) + "\n" +
               "Estado: Pagado";
    }
    //Getter and Getter
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}