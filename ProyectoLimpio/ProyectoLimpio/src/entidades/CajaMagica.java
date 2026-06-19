package entidades;

import java.awt.Color;
import java.awt.Rectangle;
import entorno.Entorno;

public class CajaMagica extends Entidad {
    private boolean usada;

    public CajaMagica(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 50;
        this.alto = 50;
        this.usada = false;
    }

    public boolean estaUsada() { return usada; }
    public void usar() { usada = true; }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int) (x - desplazamientoMapa - ancho/2), (int) (y - alto/2), ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        if (!usada) {
            double xPantalla = x - desplazamientoMapa;
            // Caja de vida representada como un bloque Amarillo brillante
            entorno.dibujarRectangulo(xPantalla, y, ancho, alto, 0, Color.YELLOW);
        }
    }
}