package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Princesa extends Entidad {

    private int vidas;
    private boolean saltando;
    private boolean cayendo;
    private Image imagen;

    public Princesa(int x, int y) {

        this.x = x;
        this.y = y;
        
        this.ancho = 65;
        this.alto = 85;
        
        this.velocidadX = 0;
        this.velocidadY = 0;
        
        this.vidas = 5;

        ImageIcon icono =
                new ImageIcon("img/princesa.png");
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

        // Solo puede saltar si no está en el aire
        if (!saltando && !cayendo) {

            // Velocidad negativa para subir
            velocidadY = -22;

            // Marcamos que está saltando
            saltando = true;
        }
    }

    // Devuelve el rectángulo de colisión del cuerpo
    public java.awt.Rectangle getBoundsCuerpo() {

        return new java.awt.Rectangle(
                x,
                y,
                ancho,
                alto - 12
        );
    }

    // Devuelve el rectángulo de colisión de los pies
    public java.awt.Rectangle getBoundsPies() {

        return new java.awt.Rectangle(
                x + 8,
                y + alto - 12,
                ancho - 16,
                12
        );
    }

    // Actualiza movimiento y colisiones
    public void actualizar(
            ArrayList<Plataforma> plataformas,
            int desplazamientoMapa
    ) {

        // =========================
        // MOVIMIENTO HORIZONTAL
        // =========================

        x += velocidadX;

        // Revisamos colisiones laterales
        for (Plataforma p : plataformas) {

            if (getBoundsCuerpo().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Colisión hacia la derecha
                if (velocidadX > 0) {

                    x =
                            (p.getX() - desplazamientoMapa)
                                    - ancho;
                }

                // Colisión hacia la izquierda
                else if (velocidadX < 0) {

                    x =
                            (p.getX() - desplazamientoMapa)
                                    + p.getAncho();
                }
            }
        }

        // =========================
        // GRAVEDAD Y MOVIMIENTO
        // =========================

        // Aplicamos gravedad
        velocidadY += 1;

        // Actualizamos posición vertical
        y += velocidadY;

        // Variable para saber si pisa una plataforma
        boolean tocandoAlgunSuelo = false;

        // Revisamos colisiones con plataformas
        for (Plataforma p : plataformas) {

            if (getBoundsPies().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Solo aplica si cae
                if (velocidadY >= 0) {

                    // Colocamos la princesa arriba
                    y = p.getY() - alto;

                    // Frenamos la caída
                    velocidadY = 0;

                    saltando = false;

                    cayendo = false;

                    tocandoAlgunSuelo = true;
                }
            }
        }

        if (!tocandoAlgunSuelo) {
            cayendo = true;
        }

        // =========================
        // COLISIÓN CON TECHO
        // =========================

        for (Plataforma p : plataformas) {

            if (getBounds().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Golpea desde abajo
                if (velocidadY < 0
                        && (y - velocidadY)
                        >= p.getY() + p.getAlto() - 10) {

                    // Posicionamos debajo
                    y = p.getY() + p.getAlto();

                    // Frenamos movimiento vertical
                    velocidadY = 0;
                }
            }
        }

        // =========================
        // CAÍDA FUERA DEL MAPA
        // =========================

        if (y > 700) {

            vidas--;

            x = 400;
            y = 200;

            velocidadY = 0;
        }
    }

    public void perderVida() {
        vidas--;
    }

    public void ganarVida() {

        if (vidas < 5) {
            vidas++;
        }
    }

    public int getVidas() {
        return vidas;
    }

    // Dibuja la princesa en pantalla
    public void dibujar(Graphics g) {

        g.drawImage(
                imagen,
                x,
                y,
                ancho,
                alto,
                null
        );
    }
}