import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);

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

    }

}
