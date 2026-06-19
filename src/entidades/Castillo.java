package entidades;

import java.awt.Graphics;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Castillo extends Entidad {

    private Image imagen;

    public Castillo(int x, int y) {

        this.x = x;
        this.y = y;

        this.ancho = 200;
        this.alto = 260;

        ImageIcon icono =
                new ImageIcon("img/castillo.png");

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

    // Dibuja el castillo en pantalla
    public void dibujar(
            Entorno entorno,
            int desplazamientoMapa
    ) {

        entorno.dibujarImagen(
                imagen,
                (x - desplazamientoMapa) + ancho / 2,
                y + alto / 2,
                0
        );
    }
}