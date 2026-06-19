package entidades;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import entorno.Entorno;
import javax.swing.ImageIcon;

public class Plataforma extends Entidad {

    private Image imagen;

    public Plataforma(
            int x,
            int y,
            int ancho,
            int alto
    ) {

        this.x = x;
        this.y = y;

        this.ancho = ancho;
        this.alto = alto;

        ImageIcon icono = new ImageIcon("img/ladrillos.png");

        imagen = icono.getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH);
    }

    // Devuelve el rectángulo de colisión
    public Rectangle getBoundsReal(int desplazamientoMapa) {

        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    // Dibuja la plataforma en pantalla
    public void dibujar(Entorno entorno, int desplazamientoMapa) {

        entorno.dibujarImagen(
                imagen,
                (x - desplazamientoMapa) + ancho / 2,
                y + alto / 2,
                0);
    }
}