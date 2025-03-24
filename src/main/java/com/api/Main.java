package main.java.com.api;

public class Main {
    public static void main(String[] args) {
        ArbolProductos arbol = new ArbolProductos();
        String rutaArchivo = "home_appliance_skus_lowes.csv";

        // Cargar productos desde archivo CSV
        CSVReader.cargarDesdeCSV(rutaArchivo, arbol);

        // Simulación de búsqueda
        String skuBuscado = "5001252387"; // SKU de prueba
        Producto productoEncontrado = arbol.buscar(skuBuscado);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:\n" + productoEncontrado);
        } else {
            System.out.println("Producto con SKU " + skuBuscado + " no encontrado.");
        }
    }
}