package entidades;

import java.awt.Color;
import java.awt.Rectangle;
import entorno.Entorno;

public class Castillo extends Entidad {

    public Castillo(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 200;
        this.alto = 260;
    }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int) (x - desplazamientoMapa - ancho/2), (int) (y - alto/2), ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        double xPantalla = x - desplazamientoMapa;
        // El castillo final representado como un gran bloque Blanco/Grisáceo
        entorno.dibujarRectangulo(xPantalla, y, ancho, alto, 0, Color.LIGHT_GRAY);
    }
}