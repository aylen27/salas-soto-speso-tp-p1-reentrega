package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

// Importamos ImageIcon para cargar imágenes
import javax.swing.ImageIcon;

public class CajaMagica extends Entidad {

    private Image imagen;
    private boolean usada;

    public CajaMagica(int x, int y) {

        this.x = x;
        this.y = y;

        this.ancho = 50;
        this.alto = 50;
        
        ImageIcon icono = new ImageIcon("img/cajaMagica.png");

        imagen = icono.getImage();
        usada = false;
    }

    public boolean estaUsada() {
        return usada;
    }

    public void usar() {
        usada = true;
    }

    // Devuelve el rectángulo de colisión de la caja
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

    // Dibuja la caja en pantalla
    public void dibujar(Graphics g, int desplazamientoMapa) {

        if (!usada) {

            // Dibujamos la imagen de la caja
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
}