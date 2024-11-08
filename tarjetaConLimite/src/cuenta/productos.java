package cuenta;

import java.util.ArrayList;

public class productos {
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto = 0;

    private int indiceLista = 0;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getIndiceLista() {
        return indiceLista;
    }

    public void setIndiceLista(int indiceLista) {
        this.indiceLista = indiceLista;
    }



}




