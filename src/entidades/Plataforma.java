package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Plataforma extends Entidad {

    public Plataforma(int x, int y, int ancho, int alto) {

        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.setColor(Color.GRAY);

        g.fillRect(x - desplazamientoMapa, y, ancho, alto);
    }
}