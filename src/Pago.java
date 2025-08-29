public interface Pago {
    public boolean procesarPago(double monto);
    public String generarRecibo();
}
