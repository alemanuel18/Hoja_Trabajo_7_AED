package main.java.com.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CSVReader {
    public static void cargarDesdeCSV(String rutaArchivo, ArbolProductos arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltar la primera línea (encabezados)

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 5) continue; // Evita líneas mal formateadas

                String sku = datos[0].trim();
                double priceRetail = Double.parseDouble(datos[1].trim());
                double priceCurrent = Double.parseDouble(datos[2].trim());
                String productName = datos[3].trim();
                String category = datos[4].trim();

                Producto producto = new Producto(sku, priceRetail, priceCurrent, productName, category);
                arbol.insertar(producto);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}