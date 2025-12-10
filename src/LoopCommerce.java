import java.util.Scanner;
public class LoopCommerce {
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                int opcionMenu;
                double subtotal = 0;

                String[] productos = {"Whiskey", "Ron", "Gin", "Vodka"};
                int[] precios = {10000, 7000, 10000, 15000};

                System.out.println("=== BIENVENIDO A LOOPCOMMERCE ===");

                do {
                    System.out.println("\n--- MENÚ PRINCIPAL ---");
                    System.out.println("1. Ver productos disponibles");
                    System.out.println("2. Agregar productos al carrito");
                    System.out.println("3. Ver subtotal actual");
                    System.out.println("4. Realizar checkout");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opción: ");


                    if (sc.hasNextInt()) {
                        opcionMenu = sc.nextInt();
                    } else {
                        opcionMenu = -1;
                    }

                    switch (opcionMenu) {
                        case 1:
                            System.out.println("\n--- LISTA DE PRODUCTOS ---");
                            int contador = 0;
                            for (String prod : productos) {
                                System.out.println((contador + 1) + ". " + prod + " - $" + precios[contador]);
                                contador++;
                            }
                            break;

                        case 2:
                            System.out.println("\n--- AGREGAR AL CARRITO ---");
                            int seleccion = -1;
                            System.out.println("Ingrese el número del producto (1-" + productos.length + ") para sumar.");
                            System.out.println("Ingrese 0 para terminar de agregar.");
                            System.out.print("Producto: ");
                            seleccion = sc.nextInt();

                            while (seleccion != 0) {
                                if (seleccion > 0 && seleccion <= productos.length) {
                                    int precioSeleccionado = precios[seleccion - 1];
                                    subtotal += precioSeleccionado;
                                    System.out.println(">> Agregado: " + productos[seleccion - 1] + " ($" + precioSeleccionado + ")");
                                } else {
                                    System.out.println("Producto no existe. Intente de nuevo.");
                                }

                                System.out.println("Subtotal parcial: $" + subtotal);
                                System.out.print("Ingrese otro producto (0 para salir): ");
                                seleccion = sc.nextInt();
                            }
                            break;

                        case 3:
                            System.out.println("\n--- ESTADO DEL CARRITO ---");
                            System.out.println("Subtotal: $" + subtotal);
                            break;

                        case 4:
                            System.out.println("\n--- INICIANDO CHECKOUT ---");
                            if (subtotal == 0) {
                                System.out.println("El carrito está vacío. Agregue productos primero.");
                            } else {
                                String[] pasos = {"Validación de stock", "Confirmación de datos", "Procesamiento de pago", "Generación de envío"};

                                for (int i = 0; i < 4; i++) {
                                    System.out.println("Procesando paso " + (i + 1) + ": " + pasos[i] + "...");
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("   -> [OK] " + pasos[i] + " completado.");
                                }

                                System.out.println("\n¡Compra realizada con éxito!");
                                System.out.println("Total pagado: $" + subtotal);
                                subtotal = 0;
                            }
                            break;

                        case 5:
                            System.out.println("Saliendo del sistema... ¡Gracias por su visita!");
                            break;

                        default:
                            System.out.println("Opción no válida. Por favor intente de nuevo.");
                    }

                } while (opcionMenu != 5);

                sc.close();
            }
        }

