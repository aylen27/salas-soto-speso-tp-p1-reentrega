package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Proyectil extends Entidad {

    private double dx;
    private double dy;

    private boolean activo;

    public Proyectil(int origenX, int origenY, int destinoX, int destinoY) {

        x = origenX;
        y = origenY;

        ancho = 15;
        alto = 15;

        double distancia = Math.sqrt(
                Math.pow(destinoX - origenX, 2)
              + Math.pow(destinoY - origenY, 2));

        dx = (destinoX - origenX) / distancia;
        dy = (destinoY - origenY) / distancia;

        activo = true;
    }

    public void actualizar() {

        x += dx * 10;
        y += dy * 10;
    }

    public boolean estaActivo() {
        return activo;
    }

    public void destruir() {
        activo = false;
    }

    public void dibujar(Graphics g) {

        g.setColor(Color.YELLOW);

        g.fillOval(x, y, ancho, alto);
    }
}