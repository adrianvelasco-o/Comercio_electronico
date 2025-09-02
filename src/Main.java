import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto pc = new Producto(1, "Computador de mesa", 1000, 10, 1);
        Producto portatil = new Producto(2, "Portatil", 500, 10, 1);
        Producto monitor = new Producto(3, "Monitor", 200, 10, 1);
        Producto teclado = new Producto(4, "Teclado", 100, 10, 1);
        Producto mouse = new Producto(5, "Mouse", 50, 10, 1);
        Producto mousePad = new Producto(6, "Mouse Pad", 20, 10, 1);
        Producto baseRefrigerante = new Producto(7, "Base Refrigerante", 250, 10, 1);

        // Crear carrito
        Carrito carrito = new Carrito(1);

        // Agregar productos al carrito
        carrito.agregarProductos(pc);
        carrito.agregarProductos(portatil);
        carrito.agregarProductos(monitor);
        carrito.agregarProductos(teclado);
        carrito.agregarProductos(mouse);
        carrito.agregarProductos(mousePad);
        carrito.agregarProductos(baseRefrigerante);

        // Mostrar el contenido del carrito
        System.out.println("\n--- Carrito actual ---");
        carrito.mostrarProductos();

        // Calcular total con impuestos
        Pedido pedido = new Pedido(pc); // ⚠️ Aquí tu Pedido solo acepta 1 producto (lo podemos mejorar)
        double totalConImpuesto = pedido.calcularTotal();
        System.out.println("\nTotal del pedido con impuesto (solo PC): $" + totalConImpuesto);

        // Eliminar un producto
        System.out.println("\nEliminando el mouse del carrito...");
        carrito.eliminarProducto(mouse);

        // Mostrar carrito actualizado
        System.out.println("\n--- Carrito actualizado ---");
        carrito.mostrarProductos();

        // Simular pago con tarjeta
        Pago pagoTarjeta = new TarjetaCredito("1234567812345678", "Juan Perez", "12/27", pedido);
        if (pagoTarjeta.procesarPago()) {
            System.out.println("\n" + pagoTarjeta.generarRecibo());
        }

        // Simular pago con PayPal
        Pago pagoPayPal = new PayPal("cliente@correo.com", pedido);
        if (pagoPayPal.procesarPago()) {
            System.out.println("\n" + pagoPayPal.generarRecibo());
        }

        // Inventario actualizado
        System.out.println("\n--- Inventario actualizado ---");
        List<Producto> inventario = new ArrayList<>();
        inventario.add(pc);
        inventario.add(portatil);
        inventario.add(monitor);
        inventario.add(teclado);
        inventario.add(mouse);
        inventario.add(mousePad);
        inventario.add(baseRefrigerante);

        for (Producto p : inventario) {
            System.out.println(p.obtenerNombre() + " | Stock: " + p.obtenerStock());
        }
    }
}
