package entidades;

import java.awt.Color;
import entorno.Entorno;

public class Proyectil extends Entidad {
    private double dx;
    private double dy;
    private boolean activo;

    public Proyectil(int origenX, int origenY, int destinoX, int destinoY) {
        this.x = origenX;
        this.y = origenY;
        this.ancho = 15;
        this.alto = 15;

        double distancia = Math.sqrt(Math.pow(destinoX - origenX, 2) + Math.pow(destinoY - origenY, 2));

        if (distancia > 0) {
            this.dx = (destinoX - origenX) / distancia;
            this.dy = (destinoY - origenY) / distancia;
        }
        this.activo = true;
    }

    public void actualizar() {
        x += dx * 10;
        y += dy * 10;
    }

    public boolean estaActivo() { return activo; }
    public void destruir() { activo = false; }

    public void dibujar(Entorno entorno) {
        // Mantiene el círculo de poder nativo de color amarillo
        entorno.dibujarCirculo(this.x, this.y, this.ancho, Color.YELLOW);
    }
}