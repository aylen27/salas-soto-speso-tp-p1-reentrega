package entidades;

import java.awt.Color;
import java.awt.Rectangle;
import entorno.Entorno;

public class Plataforma extends Entidad {

    public Plataforma(double x, double y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        // El entorno dibuja rectángulos desde su CENTRO, ajustamos la colisión
        return new Rectangle((int) (x - desplazamientoMapa), (int) (y - alto/2), ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        double xPantalla = x - desplazamientoMapa + ancho/2;
        // Ladrillos representados de color Gris oscuro
        entorno.dibujarRectangulo(xPantalla, y, ancho, alto, 0, Color.DARK_GRAY);
    }
}