import java.util.Scanner;

public class App {

    public static void limpiarPantalla() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void esperarEnter() {
        System.out.println("\nPresiona ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Carrito carrito = new Carrito(1);

        Producto pc = new Producto(1, "Computador de mesa", 1000, 10);
        Producto Portatil = new Producto(2, "Portatil", 500, 10);
        Producto monitor = new Producto(3, "Monitor", 200, 10);
        Producto teclado = new Producto(4, "Teclado", 100, 10);
        Producto mouse = new Producto(5, "Mouse", 50, 10);
        Producto mousePad = new Producto(6, "Mouse Pad", 20, 10);
        Producto baseRefrigerante = new Producto(7, "Base Refrigerante", 250, 10);

        int opcion = 3;

        while (opcion != 0) {
            limpiarPantalla();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver productos en el carrito");
            System.out.println("3. Procesar pago");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("--- SELECCIONE PRODUCTO ---");
                    System.out.println("1. Computador de mesa");
                    System.out.println("2. Portatil");
                    System.out.println("3. Monitor");
                    System.out.println("4. Teclado");
                    System.out.println("5. Mouse");
                    System.out.println("6. Mouse Pad");
                    System.out.println("7. Base Refrigerante");
                    System.out.print("Ingrese el número del producto: ");
                    int productoSeleccionado = entrada.nextInt();
                    entrada.nextLine();
                    
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = entrada.nextInt();
                    entrada.nextLine();

                    switch (productoSeleccionado) {
                        case 1:
                            carrito.agregarProductos(pc, cantidad);
                            break;
                        case 2:
                            carrito.agregarProductos(Portatil, cantidad);
                            break;
                        case 3:
                            carrito.agregarProductos(monitor, cantidad);
                            break;
                        case 4:
                            carrito.agregarProductos(teclado, cantidad);
                            break;
                        case 5:
                            carrito.agregarProductos(mouse, cantidad);
                            break;
                        case 6:
                            carrito.agregarProductos(mousePad, cantidad);
                            break;
                        case 7:
                            carrito.agregarProductos(baseRefrigerante, cantidad);
                            break;
                        default:
                            System.out.println("\n¡Opción de producto no válida!");
                    }
                    esperarEnter();
                    break;

                case 2:
                    limpiarPantalla();
                    carrito.mostrarProductos();
                    System.out.println("\nSubtotal del carrito: $" + String.format("%.2f", carrito.calcularSubtotal()));
                    esperarEnter();
                    break;

                case 3:
                    limpiarPantalla();
                    System.out.println("--- PROCESAR PAGO ---");
                    if (carrito.obtenerArticulos().isEmpty()) {
                        System.out.println("El carrito está vacío. Agregue productos para procesar el pago.");
                        esperarEnter();
                        break;
                    }
                    
                    Pedido pedido = new Pedido(carrito);
                    double totalPagar = pedido.calcularTotal();
                    System.out.println("Total a pagar (incluye impuestos): $" + String.format("%.2f", totalPagar));
                    
                    System.out.println("Seleccione el método de pago:");
                    System.out.println("1. PayPal");
                    System.out.println("2. Tarjeta de crédito");
                    System.out.print("Ingrese su opción: ");
                    int metodoPago = entrada.nextInt();
                    entrada.nextLine();

                    switch (metodoPago) {
                        case 1:
                            System.out.print("Ingrese su correo de PayPal: ");
                            String correo = entrada.nextLine();
                            PayPal pagoPayPal = new PayPal(correo, pedido); 
                            if(pagoPayPal.procesarPago()){
                                System.out.println(pagoPayPal.generarRecibo());
                                carrito.limpiarCarrito();
                            }
                            break;
                        case 2:
                            System.out.print("Ingrese el número de tarjeta: ");
                            String numeroTarjeta = entrada.nextLine();
                            System.out.print("Ingrese el nombre del titular: ");
                            String nombreTitular = entrada.nextLine();
                            System.out.print("Ingrese la fecha de expiración (MM/YY): ");
                            String fechaExpiracion = entrada.nextLine();
                            TarjetaCredito pagoTarjeta = new TarjetaCredito(numeroTarjeta, nombreTitular, fechaExpiracion, pedido);
                            if(pagoTarjeta.procesarPago()){
                                System.out.println(pagoTarjeta.generarRecibo());
                                carrito.limpiarCarrito();
                            }
                            break;
                        default:
                            System.out.println("\n¡Opción de pago no válida!");
                    }
                    
                    esperarEnter();
                    break;

                case 0:
                    limpiarPantalla();
                    System.out.println("***** FINALIZADO, GRACIAS POR USAR NUESTRO SISTEMA ******");
                    break;
                default:
                    System.out.println("\n¡Opción no válida!");
                    esperarEnter();
            }
        }
        entrada.close();
    }
}