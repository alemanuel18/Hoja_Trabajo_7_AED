package com.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase ArbolProductos.
 */
public class AppTest 
{
    private ArbolProductos arbol;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        arbol = new ArbolProductos();
    }

    /**
     * Prueba para insertar y buscar productos en el árbol.
     */
    @Test
    void testInsertarYBuscar() {
        Producto producto1 = new Producto("12345", 100.0, 80.0, "Producto A", "Categoría A");
        Producto producto2 = new Producto("67890", 150.0, 120.0, "Producto B", "Categoría B");
        arbol.insertar(producto1);
        arbol.insertar(producto2);

        Producto encontrado1 = arbol.buscar("12345");
        Producto encontrado2 = arbol.buscar("67890");
        Producto noEncontrado = arbol.buscar("11111");

        assertEquals(producto1, encontrado1);
        assertEquals(producto2, encontrado2);
        assertNull(noEncontrado);
    }

    /**
     * Prueba para verificar que no se inserten productos duplicados.
     */
    @Test
    void testInsertarDuplicado() {
        Producto producto1 = new Producto("12345", 100.0, 80.0, "Producto A", "Categoría A");
        Producto productoDuplicado = new Producto("12345", 200.0, 180.0, "Producto Duplicado", "Categoría D");

        arbol.insertar(producto1);
        arbol.insertar(productoDuplicado);

        Producto encontrado = arbol.buscar("12345");

        // Verificar que el producto original se mantiene y el duplicado no se inserta
        assertEquals(producto1, encontrado);
        assertNotEquals(productoDuplicado, encontrado);
    }

    /**
     * Prueba para buscar un producto en un árbol vacío.
     */
    @Test
    void testBuscarEnArbolVacio() {
        Producto noEncontrado = arbol.buscar("12345");
        assertNull(noEncontrado);
    }
}
