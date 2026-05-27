package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import util.Constantes;

public class Princesa extends Entidad {

    private int vidas;

    private boolean saltando;
    private boolean cayendo;

    public Princesa(int x, int y) {

        this.x = x;
        this.y = y;

        ancho = 50;
        alto = 70;

        vidas = 5;
    }
    
    public void moverIzquierda() {
        velocidadX = -5;
    }

    public void moverDerecha() {
        velocidadX = 5;
    }

    public void detener() {
        velocidadX = 0;
    }

    public void saltar() {

        if (!saltando && !cayendo) {

            velocidadY = -18;
            saltando = true;
        }
    }
    
    public void actualizar(ArrayList<Plataforma> plataformas) {

        x += velocidadX;

        velocidadY += Constantes.GRAVEDAD;

        y += velocidadY;

        cayendo = true;

        for (Plataforma p : plataformas) {

            Rectangle princesa = getBounds();
            Rectangle plataforma = p.getBounds();

            if (princesa.intersects(plataforma)) {

                if (velocidadY > 0) {

                    y = p.getY() - alto;

                    velocidadY = 0;
                    saltando = false;
                    cayendo = false;
                }
            }
        }
    }
    
    public void perderVida() {
        vidas--;
    }

    public int getVidas() {
        return vidas;
    }

    public void dibujar(Graphics g) {

        g.setColor(Color.PINK);

        g.fillRect(x, y, ancho, alto);
    }
}