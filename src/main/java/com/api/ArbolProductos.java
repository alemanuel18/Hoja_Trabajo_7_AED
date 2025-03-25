package com.api;

class ArbolProductos {
    private NodoBST raiz;

    // Método para insertar un producto en el BST
    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    private NodoBST insertarRec(NodoBST nodo, Producto producto) {
        if (nodo == null) {
            return new NodoBST(producto);
        }
        if (producto.sku.compareTo(nodo.producto.sku) < 0) {
            nodo.izq = insertarRec(nodo.izq, producto);
        } else if (producto.sku.compareTo(nodo.producto.sku) > 0) {
            nodo.der = insertarRec(nodo.der, producto);
        }
        return nodo;
    }

    // Método para buscar un producto por SKU
    public Producto buscar(String sku) {
        return buscarRec(raiz, sku);
    }

    private Producto buscarRec(NodoBST nodo, String sku) {
        if (nodo == null) {
            return null; // No encontrado
        }
        if (sku.equals(nodo.producto.sku)) {
            return nodo.producto;
        }
        if (sku.compareTo(nodo.producto.sku) < 0) {
            return buscarRec(nodo.izq, sku);
        } else {
            return buscarRec(nodo.der, sku);
        }
    }
}