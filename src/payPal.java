public class payPal implements Pago {
    private String correoUsuario;
    private double monto;
    private pedido pedido;
    
    public payPal() {}
    public payPal(String correoUsuario, pedido pedido) {
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
        return "Pago realizado con PayPal desde: " + correoUsuario + 
               "\nValor: $" + monto;
    }
     //+++++++++++++++++++ Getter and Getter++++++++++++++
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public pedido getPedido() {
        return pedido;
    }

    public void setPedido(pedido pedido) {
        this.pedido = pedido;
    }
    
}