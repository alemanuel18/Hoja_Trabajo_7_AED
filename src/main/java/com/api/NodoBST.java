package main.java.com.api;

public class NodoBST {
    Producto producto;
    NodoBST izq;
    NodoBST der;

    public NodoBST(Producto producto) {
        this.producto = producto;
        this.izq = null;
        this.der = null;
    }
}
