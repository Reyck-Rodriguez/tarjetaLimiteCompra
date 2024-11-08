package cuenta;

public class tarjetaUsuario {

    public static String nombre;
    public static double saldo;

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        tarjetaUsuario.nombre = nombre;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        tarjetaUsuario.saldo = saldo;
    }
}
