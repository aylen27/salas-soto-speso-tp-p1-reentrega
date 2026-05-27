package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Enemigo extends Entidad {

    private boolean vivo;

    public Enemigo(int x, int y, int direccion) {

        this.x = x;
        this.y = y;

        ancho = 40;
        alto = 40;

        velocidadX = direccion * 3;

        vivo = true;
    }

    public void actualizar() {
        x += velocidadX;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void matar() {
        vivo = false;
    }

    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.setColor(Color.BLACK);

        g.fillOval(x - desplazamientoMapa, y, ancho, alto);
    }
}