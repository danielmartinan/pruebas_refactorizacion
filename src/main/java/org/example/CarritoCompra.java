package org.example;

public class CarritoCompra {
    private String[] prd; // nombres de productos
    private double[] prc;  // precios unitarios
    private int[] c; // cantidades
    private String tipoDescuento; // "Ninguno", "Cupon10", "BlackFriday"
    private String metodoPago; // "Tarjeta", "PayPal", "Transferencia"

    public CarritoCompra(String[] prd, double[] prc, int[] c, String tipoDescuento, String metodoPago) {
        this.prd = prd;
        this.prc = prc;
        this.c = c;
        this.tipoDescuento = tipoDescuento;
        this.metodoPago = metodoPago;
    }

    public void procesarCompra() {
        // Validar que los arrays tengan la misma longitud
        if (prd.length == prc.length && prd.length == c.length) {
            // Calcular el total
            double total = 0;
            for (int i = 0; i < prd.length; i++) {
                System.out.println("Producto: " + prd[i] + ", Cantidad: " + c[i] + ", Precio: " + prc[i]);
                total += prc[i] * c[i];
            }

            System.out.println("Total sin descuento: " + total);

            // Aplicar descuento
            if (tipoDescuento.equals("Cupon10")) {
                total = total - (total * 0.10);
            } else if (tipoDescuento.equals("BlackFriday")) {
                total = total - (total * 0.25);
            }

            System.out.println("Total con descuento: " + total);

            // Procesar pago
            if (metodoPago.equals("Tarjeta")) {
                System.out.println("Procesando pago con tarjeta de crédito...");
            } else if (metodoPago.equals("PayPal")) {
                System.out.println("Procesando pago con PayPal...");
            } else if (metodoPago.equals("Transferencia")) {
                System.out.println("Procesando pago mediante transferencia bancaria...");
            } else {
                System.out.println("Método de pago no soportado.");
            }

            System.out.println("Compra procesada con éxito.");

            //vaciar carrito
            prd = new String[0];
            prc = new double[0];
            c = new int[0];
            tipoDescuento = "Ninguno";
            metodoPago = "Ninguno";
        } else {
            System.out.println("Error: Los arrays de productos, precios y cantidades deben tener la misma longitud.");
            return;
        }
    }
}
