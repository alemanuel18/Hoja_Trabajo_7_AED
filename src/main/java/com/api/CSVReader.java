package com.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Clase para leer y cargar productos desde un archivo CSV.
 */
class CSVReader {

    /**
     * Carga productos desde un archivo CSV y los inserta en un árbol de productos.
     *
     * @param rutaArchivo Ruta del archivo CSV dentro de los recursos.
     * @param arbol       Árbol donde se insertarán los productos cargados.
     */
    public static void cargarDesdeCSV(String rutaArchivo, ArbolProductos arbol) {
        ClassLoader classLoader = CSVReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(rutaArchivo);

        if (inputStream == null) {
            System.out.println("ERROR: No se encontró el archivo en resources: " + rutaArchivo);
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
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
                    String priceRetailStr = datos[9].trim();
                    String priceCurrentStr = datos[10].trim();
                    String productName = datos[18].trim();
                    String category = datos[0].trim();

                    // Validación de campos no vacíos
                    if (sku.isEmpty() || priceRetailStr.isEmpty() || priceCurrentStr.isEmpty()) {
                        continue;
                    }

                    double priceRetail = Double.parseDouble(priceRetailStr);
                    double priceCurrent = Double.parseDouble(priceCurrentStr);

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