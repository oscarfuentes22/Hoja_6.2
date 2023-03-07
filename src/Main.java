package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        controller controlador = new controller();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la tienda de san lucas");
        System.out.println("que mapa quiere utilizar ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                controller.setInventario(files.leerFile("hashmap"));
                break;
            case "2":
                controller.setInventario(files.leerFile("treemap"));
                break;
            case "3":
                controller.setInventario(files.leerFile("linkedhashmap"));
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        while (true) {
            System.out.println("ELIJA UNA OCPION");
            System.out.println("1. AGREGAR PRODUCTO");
            System.out.println("2. MOSTRAR CATEGORIA DE UN PRODUCTO");
            System.out.println("3. MOSTRAS UNIDADES DE UN PRODUCTO");
            System.out.println("4. MOSTRAR DETALLES DE UN PRODUCTO");
            System.out.println("5. MOSTRAR INVENTARIO");
            System.out.println("6. Salir");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("IGRESE EL NOMBRE DEL PRODUCTO");
                    String nombre = scanner.nextLine();
                    System.out.println("INGRESE LA CATAGORIA DEL PRODUCTO");
                    String categoria = scanner.nextLine();
                    System.out.println("IGRESE LA CANTIDAD DE PRODUCTOS");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    controller.anadirProducto(nombre, categoria, cantidad);
                    break;
                case "2":
                    System.out.println("InGRESE EL NOMBRE DEL PRODUCTO");
                    String name = scanner.nextLine();
                    System.out.println(controller.ensenarProductoCategorias(name));
                    break;
                case "3":
                    System.out.println("InGRESE EL NOMBRE DEL PRODUCTO");
                    String names = scanner.nextLine();
                    System.out.println(controller.ensenarProductoUnidades(names));
                    break;
                case "4":
                    System.out.println("Ingrese el nombre del producto");
                    String Nombre = scanner.nextLine();
                    System.out.println(controller.ensenarDetalles(Nombre));
                    break;
                case "5":
                    for (String item : controller.mostrarInventario()) {
                        System.out.println(item);
                    }
                    break;
                case "6":
                    files.saveFile(controller.getInventario());
                    System.exit(0);
                default:
                    System.out.println("Opción inválida");
                    break;

            }
        }
    }
}