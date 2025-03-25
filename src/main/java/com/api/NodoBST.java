package com.api;

/**
 * Nodo de un árbol binario de búsqueda (BST) que almacena un producto.
 */
public class NodoBST {
    Producto producto;
    NodoBST izq;
    NodoBST der;

    /**
     * Constructor para inicializar un nodo con un producto.
     *
     * @param producto Producto que se almacenará en el nodo.
     */
    public NodoBST(Producto producto) {
        this.producto = producto;
        this.izq = null;
        this.der = null;
    }
}
