package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Castillo extends Entidad {

    public Castillo(int x, int y) {

        this.x = x;
        this.y = y;

        ancho = 120;
        alto = 180;
    }

    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.setColor(Color.RED);

        g.fillRect(x - desplazamientoMapa, y, ancho, alto);
    }
}