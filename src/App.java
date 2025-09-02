
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
     Scanner entrada = new Scanner(System.in);
        Carrito carrito= new Carrito(1);
//+++++++++++++++++++++++++++++++++++++++++++
        Producto pc = new Producto(1, "Computador de mesa", 1000, 10, 0);
        Producto Portatil = new Producto(2, "Portatil", 500, 10, 0);
        Producto monitor = new Producto(3, "Monitor", 200, 10, 0);
        Producto teclado = new Producto(4, "Computador de mesa", 100, 10, 0);
        Producto mouse = new Producto(5, "Computador de mesa", 50, 10, 0);
        Producto mousePad = new Producto(6, "Computador de mesa", 20, 10, 0);
        Producto baseRefrigerante = new Producto(7, "Computador de mesa", 250, 10, 0);

        int opcion = 3;
        while (opcion != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver productos en el carrito");
             System.out.println("3. Procesar pago");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    //agregar productos
                    System.out.println("Seleccione el producto a agregar:");
                    System.out.println("1. Computador de mesa");
                    System.out.println("2. Portatil");
                    System.out.println("3. Monitor");
                    System.out.println("4. Teclado");
                    System.out.println("5. Mouse");
                    System.out.println("6. Mouse Pad");
                    System.out.println("7. Base Refrigerante");
                    int productoSeleccionado = entrada.nextInt();

                        switch (productoSeleccionado) {
                        case 1:
                            carrito.agregarProductos(pc);
                            break;
                        case 2:
                            carrito.agregarProductos(Portatil);
                            break;
                        case 3:
                            carrito.agregarProductos(monitor);
                            break;
                        case 4:
                            carrito.agregarProductos(teclado);
                            break;
                        case 5:
                            carrito.agregarProductos(mouse);
                            break;
                        case 6:
                            carrito.agregarProductos(mousePad);
                            break;
                        case 7:
                            carrito.agregarProductos(baseRefrigerante);
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    break;

                case 2:
                    // Ver productos
                    carrito.mostrarProductos();
                    break;
                case 3:
                    // Procesar pago
                     //++++++++++++++++++++++++++++++++++++++++++
                    // FORMA DE PAGO (PayPal O TARJETA DE CREDITO) 
                    //+++++++++++++++++++++++++++++++++++++++++++

                    System.out.println("Seleccione el método de pago:");
                    System.out.println("1. PayPal");
                    System.out.println("2. Tarjeta de crédito");
                    int metodoPago = entrada.nextInt();
                    entrada.nextLine(); 

                    switch (metodoPago) {
                        case 1:
                            System.out.println("Ingrese su correo de PayPal:");
                            String correo = entrada.nextLine();
                            PayPal pagoPayPal = new PayPal();
                            pagoPayPal.setCorreoUsuario(correo);
                            pagoPayPal.setMonto(carrito.calcularTotalConImpuestos(0.19));
                            pagoPayPal.procesarPago();
                            System.out.println(pagoPayPal.generarRecibo());
                            break;
                        case 2:
                            System.out.println("Ingrese el número de tarjeta:");
                            String numeroTarjeta = entrada.nextLine();
                            System.out.println("Ingrese el nombre del titular:");
                            String nombreTitular = entrada.nextLine();
                            System.out.println("Ingrese la fecha de expiración (MM/YY):");
                            String fechaExpiracion = entrada.nextLine();
                            TarjetaCredito pagoTarjeta = new TarjetaCredito();
                            pagoTarjeta.setNumeroTarjeta(numeroTarjeta);
                            pagoTarjeta.setNombreTitular(nombreTitular);
                            pagoTarjeta.setFechaExpiracion(fechaExpiracion);
                            pagoTarjeta.setMonto(carrito.calcularTotalConImpuestos(0.19));
                            pagoTarjeta.procesarPago();
                            System.out.println(pagoTarjeta.generarRecibo());
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    
                    break;    
                case 0:
                    // Salir
                    System.out.println("*****FINALIZADO******");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
