package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Princesa extends Entidad {

    private int vidas;

    private boolean saltando;
    private boolean cayendo;

    private Image imagen;

    public Princesa(int x, int y) {

        this.x = x;
        this.y = y;

        ancho = 55;
        alto = 100;

        vidas = 5;

        ImageIcon icono = new ImageIcon("img/princesa.png");

        imagen = icono.getImage();
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

        // movimiento horizontal
        x += velocidadX;

        // gravedad
        velocidadY += 1;

        y += velocidadY;

        cayendo = true;

        for (Plataforma p : plataformas) {

            if (getBounds().intersects(p.getBounds())) {

                // colisión desde arriba
                if (velocidadY > 0
                        && y + alto - velocidadY <= p.getY()) {

                    y = p.getY() - alto;

                    velocidadY = 0;

                    saltando = false;

                    cayendo = false;
                }
            }
        }

        // caída al vacío
        if (y > 700) {

            vidas--;

            x = 200;

            y = 300;

            velocidadY = 0;
        }
    }

    public void perderVida() {

        vidas--;
    }

    public int getVidas() {

        return vidas;
    }

    public void dibujar(Graphics g) {

        // el -20 acomoda visualmente la imagen
    	g.drawImage(imagen, x, y, ancho, alto, null);
    }
}