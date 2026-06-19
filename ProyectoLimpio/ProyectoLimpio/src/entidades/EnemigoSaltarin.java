package entidades;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import entorno.Entorno;
import entorno.Herramientas;

public class EnemigoSaltarin extends Entidad {
    private Image imagen;

    public EnemigoSaltarin(double x, double y, int direccion) {
        this.x = x;
        this.y = y;
        this.ancho = 50;
        this.alto = 50;
        this.velocidadX = direccion * 2;
        this.velocidadY = 0;

        this.imagen = Herramientas.cargarImagen("img/enemigo_saltarin.png");
    }

    public void actualizar() {
        x += velocidadX;
        velocidadY += 1; // Gravedad
        y += velocidadY;

        if (y >= 450) {
            y = 450;
            if (Math.random() < 0.03) {
                velocidadY = -18; // Salto aleatorio
            } else {
                velocidadY = 0;
            }
        }
    }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int) (x - desplazamientoMapa), (int) y, ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        double xPantalla = x - desplazamientoMapa;
        entorno.dibujarImagen(imagen, xPantalla, y, 0);
    }
}