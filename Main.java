
import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        List<Productos> products = new ArrayList<>();
        products.add(new Productos(1, "Camion", 100));
        products.add(new Productos(2, "Selec", 150.99));
        products.add(new Productos(3, "Armario", 1039.50));
        products.add(new Productos(4, "Ordenador", 521.10));


        int opcion, posicion_a_borrar, posicion_de_compra, id;
        String nombre;
        double precio;
        double newPrecio;
        LocalDate fechaActual = LocalDate.now();
        int dia = fechaActual.getDayOfMonth();
        LocalDate blackFriday = LocalDate.of(2023, 11, 24);
        int diaB = blackFriday.getDayOfMonth();
        LocalDate preblackFriday = LocalDate.of(2023, 11, 23);
        int diaP = preblackFriday.getDayOfMonth();

        JOptionPane.showMessageDialog(null,"BIENVENIDO A BENI BENITO\nHOY ESTAMOS A DIA " +dia);

        do {

            opcion = menu();

            switch (opcion) {

                case 1: {

                    opcion = password();

                    while (opcion > 0 && opcion != 4) {

                        opcion = menuAdmin();

                            switch (opcion) {

                                case 1: {
                                    Productos producto = new Productos();
                                    System.out.println("Escriba el ID del producto");
                                    id = entrada.nextInt();
                                    producto.setId(id);

                                    System.out.println("Escriba el nombre del producto");
                                    nombre = entrada.next();
                                    producto.setNombre(nombre);

                                    System.out.println("Escriba el precio del producto");
                                    precio = (entrada.nextDouble());
                                    producto.setPrecio(precio);
                                    products.add(producto);
                                    break;
                                }
                                case 2: {
                                    for (int i = 0; i < products.size(); i++) {
                                        System.out.println("Posicion: " + i);
                                        System.out.println("ID: " + products.get(i).getId());
                                        System.out.println("Nombre: " + products.get(i).getNombre());
                                        System.out.println("Precio: " + products.get(i).getPrecio());
                                        System.out.println("---------");
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.println("Dime la posicion del producto a borrar: ");
                                    posicion_a_borrar = entrada.nextInt();
                                    products.remove(posicion_a_borrar);
                                    break;
                                }
                                case 4: {
                                    break;
                                }
                            }
                    }
                    break;
                }
                case 2: {

                    do {

                        opcion = menuCliente();

                        switch (opcion) {

                            case 1: {
                                for (int i = 0; i < products.size(); i++) {
                                    System.out.println("Posicion: " + i);
                                    System.out.println("Nombre: " + products.get(i).getNombre());
                                    System.out.println("---------");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Dime la posicion del producto que quieres comprar");
                                posicion_de_compra = entrada.nextInt();
                                String pago;
                                String Vpago = "si";

                                if (posicion_de_compra <= products.size()) {
                                    System.out.println("Aplicacamos los descuentos");

                                    if (diaB == dia) {
                                        System.out.println("ES BLACK FRIDAY");
                                        newPrecio = products.get(posicion_de_compra).getPrecio();
                                        System.out.println(
                                                "El precio de su producto es: " + (newPrecio - (newPrecio * 0.4)) + " $");
                                        System.out.println("¿Desea comprar el producto?");
                                        pago = entrada.next();
                                        if (pago.equals(Vpago)) {
                                            System.out.println("Procesando pago...");
                                            products.remove(posicion_de_compra);
                                            System.out.println("Gracias por comprar en BENI BENITO");

                                        } else {
                                            System.out.println("Si necesita ayuda haganoslo saber");
                                        }
                                    }
                                    if (diaP == dia) {
                                        newPrecio = products.get(posicion_de_compra).getPrecio();
                                        System.out.println(
                                                "El precio de su producto es: " + (newPrecio + (newPrecio * 0.3)) + " $");
                                        System.out.println("¿Desea comprar el producto?");
                                        pago = entrada.next();
                                        if (pago.equals(Vpago)) {
                                            System.out.println("Procesando pago...");
                                            products.remove(posicion_de_compra);
                                            System.out.println("Gracias por comprar en BENI BENITO");
                                        } else {
                                            System.out.println("Si necesita ayuda haganoslo saber");
                                        }
                                    }
                                    if (dia != 23 && dia != 24) {
                                        newPrecio = products.get(posicion_de_compra).getPrecio();
                                        System.out.println("El precio de su producto es: " + newPrecio + " $");
                                        System.out.println("¿Desea comprar el producto?");
                                        pago = entrada.next();
                                        if (pago.equals(Vpago)) {
                                            System.out.println("Procesando pago...");
                                            products.remove(posicion_de_compra);
                                            System.out.println("Gracias por comprar en BENI BENITO");
                                        } else {
                                            System.out.println("Si necesita ayuda haganoslo saber");
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: {
                                break;
                            }
                        }
                    } while (opcion != 3);
                    break;
                }
                case 3: {
                    break;
                }
            }
        } while (opcion != 3);
    }

    public static int password(){
        final char[] password = {'1', '2', '3', '4'};
        int fallos = 0;
        Console console = System.console();

        if (console == null) {
            System.out.println("No se puede ejecutar si no estas en consola");
            System.exit(1);
        }

        while (fallos < 3){
            char[] passwordIn = console.readPassword("Ingrese la contraseña: ");

            if (Arrays.equals(passwordIn, password)) {
                return 1;
            }
            else {
                System.out.println("Contraseña incorrecta. Intentos restantes: " +(2-fallos));
                fallos++;
                if (fallos == 3){
                    System.out.println("Va a regresar al menu...");
                }
            }
        }
        return 0;
    }


    public static int menu() {
        Scanner in = new Scanner(System.in);
        String resp;

        System.out.println(ANSI_YELLOW + "-----BENI BENITO-----");
        System.out.println("---------------------" + ANSI_RESET);
        System.out.println(ANSI_GREEN+"\n    1.- Admin"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"    2.- Cliente"+ANSI_RESET);
        System.out.println(ANSI_RED+"    3.- Salir"+ANSI_RESET);


        do {
            System.out.print("\nSelecciona una opción (1-3): ");
            resp = in.nextLine();
        } while (!resp.matches("[1-3]"));

        return Integer.parseInt(resp);
    }


    public static int menuCliente() {
        Scanner in = new Scanner(System.in);
        String resp;

        System.out.println("\nHa accedido al menu cliente...");
        System.out.println(ANSI_BLUE + "-----BENI BENITO clientes-----");
        System.out.println("------------------------------" + ANSI_RESET);
        System.out.println("\n    1.- Ver catalogo");
        System.out.println("    2.- Comprar");
        System.out.println(ANSI_RED+"    3.- Salir"+ANSI_RESET);


        do {
            System.out.print("\nSelecciona una opción (1-3): ");
            resp = in.nextLine();
        } while (!resp.matches("[1-3]"));

        return Integer.parseInt(resp);
    }


    public static int menuAdmin() {
        Scanner in = new Scanner(System.in);
        String resp;

        System.out.println("\nHa accedido al menu admin...");
        System.out.println(ANSI_GREEN + "-----BENI BENITO admin-----");
        System.out.println("---------------------------" + ANSI_RESET);
        System.out.println("\n    1.- Ingresar producto");
        System.out.println("    2.- Ver catalogo");
        System.out.println("    3.- Dar de baja un producto");
        System.out.println(ANSI_RED+"    4.- Salir"+ANSI_RESET);

        do {
            System.out.print("\nSelecciona una opción (1-4): ");
            resp = in.nextLine();
        } while (!resp.matches("[1-4]"));

        return Integer.parseInt(resp);

    }


    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
}