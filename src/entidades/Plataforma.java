package entidades;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Plataforma extends Entidad {

    private Image imagen;

    public Plataforma(int x, int y, int ancho, int alto) {

        this.x = x;
        this.y = y;

        this.ancho = ancho;
        this.alto = alto;

        ImageIcon icono = new ImageIcon("img/ladrillos.png");

        imagen = icono.getImage();
    }

    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.drawImage(imagen,
                x - desplazamientoMapa,
                y,
                ancho,
                alto,
                null);
    }
}