package com.api;

import java.util.Scanner;

/**
 * Clase principal para ejecutar el programa de gestión de productos.
 */
public class Main {

    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        ArbolProductos arbol = new ArbolProductos();
        String rutaArchivo = "home_appliance_skus_lowes.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Iniciando carga de productos...");
        // Cargar productos desde archivo CSV
        CSVReader.cargarDesdeCSV(rutaArchivo, arbol);

        System.out.println("Carga de productos completada.\nLos datos no cargos estan incompletos.");

        // Interfaz de usuario
        while (true) {
            System.out.print("\nIngrese el SKU del producto que desea buscar (o 'salir' para terminar): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa. ¡Gracias por usar el sistema!");
                break;
            }

            Producto productoEncontrado = arbol.buscar(input);

            if (productoEncontrado != null) {
                System.out.println("Producto encontrado:\n" + productoEncontrado);
            } else {
                System.out.println("Producto con SKU " + input + " no encontrado.");
            }
        }

        scanner.close();
    }
}
