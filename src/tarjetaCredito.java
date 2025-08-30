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
        return false;
    }

    @Override
    public String generarRecibo(){
        return "";
    }

}
