public class PayPal implements Pago {
    private String correoUsuario;

    public PayPal(String correoUsuario){
        this.correoUsuario = correoUsuario;
    }

    @Override
    public boolean procesarPago(double monto){
        System.out.println("Procesando pago con PayPal: " + correoUsuario);
        return true;
    }

    @Override
    public String generarRecibo(){
        return "Pago realizado con PayPal desde " + correoUsuario;
    }
}
