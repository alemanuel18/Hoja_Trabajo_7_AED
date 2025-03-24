package main.java.com.api;

public class Main {
    public static void main(String[] args) {
        ArbolProductos arbol = new ArbolProductos();
        String rutaArchivo = "home appliance skus lowes.csv"; // Ruta del archivo CSV

        // Cargar productos en el BST
        CSVReader.cargarDesdeCSV(rutaArchivo, arbol);

        // Simulación de búsqueda
        String skuBuscado = "12345"; // SKU de prueba
        Producto productoEncontrado = arbol.buscar(skuBuscado);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:\n" + productoEncontrado);
        } else {
            System.out.println("Producto con SKU " + skuBuscado + " no encontrado.");
        }
    }
}