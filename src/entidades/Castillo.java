package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

// Importamos ImageIcon para cargar imágenes
import javax.swing.ImageIcon;

public class Castillo extends Entidad {

    private Image imagen;

    public Castillo(int x, int y) {

        this.x = x;
        this.y = y;
        
        this.ancho = 200;
        this.alto = 260;

        ImageIcon icono = new ImageIcon("img/castillo.png");

        imagen = icono.getImage();
    }

    // Devuelve el rectángulo de colisión del castillo
    // desplazamientoMapa se usa para mover la cámara/mapa
    public Rectangle getBoundsReal(int desplazamientoMapa) {

        // Creamos y devolvemos el rectángulo de colisión
        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    public void dibujar(Graphics g, int desplazamientoMapa) {

        // Calculamos la posición X del castillo en pantalla
        int xPantalla = x - desplazamientoMapa;

        // Dibujamos la imagen del castillo
        g.drawImage(
                imagen,
                xPantalla,
                y,
                ancho,
                alto,
                null
        );
    }
}