package test.java.com.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private ArbolProductos arbol;

    @BeforeEach
    void setUp() {
        arbol = new ArbolProductos();
    }

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
    @Test
    void testBuscarEnArbolVacio() {
        Producto noEncontrado = arbol.buscar("12345");
        assertNull(noEncontrado);
    }
}
