package menu;

import cuenta.compra;
import cuenta.tarjetaUsuario;
import cuenta.productos;

import java.math.BigInteger;
import java.util.Scanner;

public class menu extends tarjetaUsuario {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("indiqueme su primer nombre : ");
        tarjetaUsuario.nombre = scanner.next();
        if (tarjetaUsuario.nombre == null || tarjetaUsuario.nombre.trim().isEmpty()) {
            System.out.println("Por favor ingrese un nombre valido");
        } else if (!tarjetaUsuario.nombre.matches("[a-zA-Z]+")) {
            System.out.println("Por favor ingrese un nombre válido (solo caracteres alfabéticos)");
        } else {
            System.out.println("Ingrese su limite de la tarjeta : $$");
            tarjetaUsuario.saldo = Double.parseDouble(scanner.next());
            System.out.println("el saldo para " + tarjetaUsuario.nombre + ": $" + String.format("%.2f", tarjetaUsuario.saldo));
            compra compra = new cuenta.compra();
            boolean salir = false;
            while (!salir) {
                if (saldo > 0) {
                    System.out.println("desea realizar alguna compra? (si/no)");
                    String opcion = scanner.next();
                    if (opcion.equalsIgnoreCase("no")) {


                        compra.mostrarProductos();
                        System.out.println("fin de las compras su saldo en la tarjeta es $" + String.format("%.2f", tarjetaUsuario.getSaldo()) + "\n" +
                                "que tenga un buen dia " + tarjetaUsuario.getNombre() + "!");

                        salir = true;
                        break;

                    } else if (opcion.equalsIgnoreCase("si")) {
                        compra.calcularTotalCompra();


                    } else {
                        System.out.println("Por favor ingrese una opción válida (si/no)");
                    }

                } else if (saldo < 0) {
                    System.out.println(tarjetaUsuario.getNombre() + " no tiene saldo suficiente para realizar compras\n" +
                            "" + tarjetaUsuario.getNombre() + " debe de pagar su saldo $ " + String.format("%.2f", compra.getSaldo()) + "\n" +
                            "y recargar su tarjeta para poder comprar nuevamente \n" +
                            "que tenga un buen dia " + tarjetaUsuario.getNombre() + "!");
                    break;
                } else {
                    System.out.println("Alerta "+tarjetaUsuario.getNombre() + " su saldo en la tarjeta es $ " + String.format("%.2f", compra.getSaldo()) + "\n" +
                            "no puede realizar compras, recuerde recargar su tarjeta para poder comprar\n " +
                            "que tenga un buen dia " + tarjetaUsuario.getNombre() + "!");
                    compra.mostrarProductos();

                    break;
                }
            }
        }

    }


}

