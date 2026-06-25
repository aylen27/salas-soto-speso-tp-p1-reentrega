package entidades;

import java.awt.Image;
import javax.swing.ImageIcon;

import entorno.Entorno;

public class Moneda {

    private int x;
    private int y;
    private int ancho = 30;
    private int alto = 30;

    private Image imagen;

    public Moneda(int x, int y) {

        this.x = x;
        this.y = y;

        ImageIcon icono =
                new ImageIcon("img/moneda.png");

        imagen = icono.getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH);
    }

    public void dibujar(
            Entorno entorno,
            int desplazamientoMapa) {

        entorno.dibujarImagen(
                imagen,
                x - desplazamientoMapa + ancho / 2,
                y + alto / 2,
                0);
    }

    public java.awt.Rectangle getBounds(
            int desplazamientoMapa) {

        return new java.awt.Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto);
    }
}