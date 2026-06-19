package entidades;

import java.awt.Color;
import entorno.Entorno;

// El "extends Entidad" es CLAVE para que herede x, y, getX() y getY()
public class ProyectilEnemigo extends Entidad {
    private double dx;
    private double dy;

    public ProyectilEnemigo(int origenX, int origenY, int destinoX, int destinoY) {
        this.x = origenX;
        this.y = origenY;
        this.ancho = 15;
        this.alto = 15;

        double distancia = Math.sqrt(Math.pow(destinoX - origenX, 2) + Math.pow(destinoY - origenY, 2));

        if (distancia > 0) {
            this.dx = (destinoX - origenX) / distancia;
            this.dy = (destinoY - origenY) / distancia;
        } else {
            this.dx = -1;
            this.dy = 0;
        }
    }

    public void actualizar() {
        // El proyectil viaja a velocidad 7
        x += dx * 7;
        y += dy * 7;
    }

    // Corregido para que reciba el Entorno del profesor tal como pide el error
    public void dibujar(Entorno entorno) {
        // Dibuja las balas del jefe como círculos color Magenta nativos
        entorno.dibujarCirculo(this.x, this.y, this.ancho, Color.MAGENTA);
    }
}