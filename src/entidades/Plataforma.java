package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Plataforma extends Entidad {

    private Image imagen;

    public Plataforma(int x, int y, int ancho, int alto) {

        this.x = x;
        this.y = y;
        
        this.ancho = ancho;
        this.alto = alto;

        ImageIcon icono =
                new ImageIcon("img/ladrillos.png");
        imagen = icono.getImage();
    }

    // Devuelve el rectángulo de colisión
    // desplazamientoMapa se usa para mover la cámara/mapa
    public Rectangle getBoundsReal(int desplazamientoMapa) {

        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    // Dibuja la plataforma en pantalla
    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.drawImage(
                imagen,
                x - desplazamientoMapa,
                y,
                ancho,
                alto,
                null
        );
    }
}