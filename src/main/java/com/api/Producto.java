package com.api;

/**
 * Representa un producto con información básica como SKU, precios, nombre y categoría.
 */
class Producto {
    String sku;
    double priceRetail;
    double priceCurrent;
    String productName;
    String category;

    /**
     * Constructor para inicializar un producto.
     *
     * @param sku          Código único del producto.
     * @param priceRetail  Precio de venta al público.
     * @param priceCurrent Precio actual del producto.
     * @param productName  Nombre del producto.
     * @param category     Categoría del producto.
     */
    public Producto(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Información del producto en formato legible.
     */
    @Override
    public String toString() {
        return "SKU: " + sku + 
               "\nNombre: " + productName + 
               "\nCategoría: " + category + 
               "\nPrecio Retail: $" + priceRetail + 
               "\nPrecio Actual: $" + priceCurrent;
    }
}