package cuenta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class compra extends tarjetaUsuario {
    int cantidad;
    private List<productos> carrito = new ArrayList<>();
    private double totalCompra;


    public double getTotalCompra() {
        return totalCompra;
    }

    public void calcularTotalCompra() {
        productos producto = new productos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.next();
        System.out.println("Ingrese el precio del producto: $$");
        double precioProducto = Double.parseDouble(scanner.next());

        while (precioProducto <= 0) {
            if (precioProducto < 0) {
                System.out.println("Precio no puede ser negativo. Intente de nuevo. \n" +
                        "Por favor ingrese un precio positivo. \n" + tarjetaUsuario.getNombre() + " tu saldo es: $" + tarjetaUsuario.getSaldo());
                precioProducto = Double.parseDouble(scanner.next());
            }
        }
        System.out.println("ingrese la cantidad que desea comprar.");
        cantidad = scanner.nextInt();

        while (cantidad < 0) {
            if (cantidad < 0) {
                System.out.println("ingresa una cantidad valida. " + tarjetaUsuario.getNombre());
                cantidad = scanner.nextInt();
            }
        }
        totalCompra = precioProducto * cantidad;

        if (totalCompra <= saldo) {

            System.out.println("la compra ha sido exitosa.\n");
            producto.setNombreProducto(nombreProducto);
            producto.setPrecioProducto(precioProducto);
            producto.setCantidadProducto(cantidad);


            descontarSaldo(totalCompra);
            carrito.add(producto);

            System.out.println("el nuevo saldo de su tarjeta " + tarjetaUsuario.getNombre() + " es: $ " + saldo);


        } else {
            System.out.println("compra fallida!!!!\n" +
                    "No tiene saldo suficiente para realizar la compra.\n" +
                    "tu saldo es " + tarjetaUsuario.getSaldo());
        }

    }


    public void descontarSaldo(double totalCompra) {
        saldo = saldo - totalCompra;
        System.out.println("Compra exitosa wiii!\n");

    }


    public void mostrarProductos() {

        double sumatotal = 0;
        System.out.println("__________________________________________________________");
        reordenarlista();
        for (int i = 0; i < carrito.size(); i++) {

            System.out.println("Producto: " + carrito.get(i).getNombreProducto() +
                    ", Precio: $" + carrito.get(i).getPrecioProducto() +
                    ", Cantidad: " + carrito.get(i).getCantidadProducto() +
                    ", Total: $" + carrito.get(i).getPrecioProducto() * carrito.get(i).getCantidadProducto());
            sumatotal = sumatotal + (carrito.get(i).getPrecioProducto() * carrito.get(i).getCantidadProducto());

        }

        System.out.println("__________________________________________________________");
        System.out.println("Total a pagar: $" + sumatotal);
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("__________________________________________________________");
    }

    public void reordenarlista() {
        carrito.sort(new Comparator<productos>() {
            @Override
            public int compare(productos o1, productos o2) {
                return Double.compare(o1.getPrecioProducto(), o2.getPrecioProducto());
            }
        });
        System.out.println("La lista de productos ha sido reordenada.");
        System.out.println("__________________________________________________________");

    }

}