import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
//+++++++++++++++++++++++++++++++++++++++++++
        Producto pc = new Producto(1, "Computador de mesa", 1000, 10, 0);
        Producto Portatil = new Producto(2, "Portatil", 500, 10, 0);
        Producto monitor = new Producto(3, "Monitor", 200, 10, 0);
        Producto teclado = new Producto(4, "Computador de mesa", 100, 10, 0);
        Producto mouse = new Producto(5, "Computador de mesa", 50, 10, 0);
        Producto mousePad = new Producto(6, "Computador de mesa", 20, 10, 0);
        Producto baseRefrigerante = new Producto(7, "Computador de mesa", 250, 10, 0);

        int opcion = 20;
        while (opcion != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Ver productos");
            System.out.println("20. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    //agregar productos
                    break;
                case 2:
                    // Ver productos
                    break;
                case 3:
                    // Salir
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

//++++++++++++++++++++++++++++++++++++++++++
// FORMA DE PAGO (PAYPAL O TARJETA DE CREDITO)    
//+++++++++++++++++++++++++++++++++++++++++++

        payPal pagoPayPal= new payPal();
        tarjetaCredito pagoTarjeta= new tarjetaCredito();


        int opcionPago = 20;
        while (opcionPago != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Pago con payPal");
            System.out.println("2. Pago con tarjeta de crédito");
            System.out.println("3. Salir");
            opcionPago = entrada.nextInt();

            switch (opcionPago) {
                case 1:
                    
                    String correo=entrada.nextLine();
                    pagoPayPal.setCorreoUsuario(correo);
                    pagoPayPal.procesarPago();
                    pagoPayPal.generarRecibo();
                    
                    break;
                case 2:
                        String numeroTarjeta=entrada.nextLine();
                        String nombreTitular=entrada.nextLine();
                        String fechaExpiracion=entrada.nextLine();

                        pagoTarjeta.setNumeroTarjeta(numeroTarjeta);
                        pagoTarjeta.setNombreTitular(nombreTitular);
                        pagoTarjeta.setFechaExpiracion(fechaExpiracion);
                        pagoTarjeta.procesarPago();
                        pagoTarjeta.generarRecibo();

                    break;
                case 3:
                    System.out.println("HAS SALIDO DEL SISTEMA");
                    break;
                default:
                    System.out.println("Opción no válida");
                 
            }
        }
    }
}
