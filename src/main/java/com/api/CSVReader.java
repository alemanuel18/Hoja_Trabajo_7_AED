package main.java.com.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class CSVReader {
        public static void cargarDesdeCSV(String rutaArchivo, ArbolProductos arbol) {
        File file = new File(rutaArchivo);
        System.out.println("Intentando cargar archivo desde: " + file.getAbsolutePath());
        
        if (!file.exists()) {
            System.out.println("ERROR: No se encontró el archivo " + file.getAbsolutePath());
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea = br.readLine(); // Leer encabezado
            if (linea == null) {
                System.out.println("El archivo está vacío.");
                return;
            }
            
            int lineasLeidas = 0;
            int productosCargados = 0;
            
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;
                String[] datos = linea.split(",", -1);
                if (datos.length < 20)
                    continue; // Validación de columnas
                try {
                    String sku = datos[6].trim();
                    double priceRetail = Double.parseDouble(datos[9].trim());
                    double priceCurrent = Double.parseDouble(datos[10].trim());
                    String productName = datos[18].trim();
                    String category = datos[0].trim();

                    Producto producto = new Producto(sku, priceRetail, priceCurrent, productName, category);
                    arbol.insertar(producto);
                    productosCargados++;
                } catch (NumberFormatException e) {
                    System.err.println("Error en línea " + lineasLeidas + ": " + e.getMessage() + " - Datos: " + linea);
                }
            }
            
            System.out.println("Lectura completa. Líneas leídas: " + lineasLeidas + ", Productos cargados: " + productosCargados);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
