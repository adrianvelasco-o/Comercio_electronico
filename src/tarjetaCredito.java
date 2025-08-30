public class TarjetaCredito implements Pago {
    
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;

    public TarjetaCredito(String numeroTarjeta, String nombreTitular, String fechaExpiracion){
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public boolean procesarPago(double monto){
        System.out.println("Procesando pago con tarjeta de crédito: " + numeroTarjeta);
        return true;
    }

    @Override
    public String generarRecibo(){
        
        return "Pago realizado con tarjeta a nombre de " + nombreTitular;
    }

}
