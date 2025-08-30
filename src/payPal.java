public class PayPal implements Pago {
    private String correoUsuario;

    public PayPal(String correoUsuario){
        this.correoUsuario = correoUsuario;
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
