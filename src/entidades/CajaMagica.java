package entidades;

import java.awt.Graphics;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class CajaMagica extends Entidad {

    private Image imagen;
    private boolean usada;

    public CajaMagica(int x, int y) {

        this.x = x;
        this.y = y;

        this.ancho = 50;
        this.alto = 50;

        ImageIcon icono =
                new ImageIcon("img/cajaMagica.png");

        imagen = icono.getImage();

        usada = false;
    }

    public boolean estaUsada() {
        return usada;
    }

    public void usar() {
        usada = true;
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

    // Dibuja la caja en pantalla
    public void dibujar(
            Entorno entorno,
            int desplazamientoMapa
    ) {

        if (!usada) {

            entorno.dibujarImagen(
                    imagen,
                    (x - desplazamientoMapa) + ancho / 2,
                    y + alto / 2,
                    0,
                    0.2
                    0
            );
        }
    }
}
