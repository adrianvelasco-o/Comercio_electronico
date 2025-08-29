public class payPal implements Pago {
    private String correoUsuario;

    public payPal(String correoUsuario){
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
