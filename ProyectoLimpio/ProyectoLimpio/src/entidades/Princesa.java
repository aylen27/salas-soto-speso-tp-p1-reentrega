package entidades;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import entorno.Entorno;

public class Princesa extends Entidad {
    private int vidas;
    private boolean saltando;
    private boolean cayendo;
    private Image imagen;

    public Princesa(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 30; 
        this.alto = 60;
        this.velocidadX = 0;
        this.velocidadY = 0;
        this.vidas = 5;
        
        // CARGA DIRECTA DESDE DISCO: Apunta a tu imagen chiquita del personaje princesa.png
        try {
            this.imagen = entorno.Herramientas.cargarImagen("img/princesa.jpg");
        } catch (Exception e) {
            this.imagen = null;
        }
    }

    public void moverIzquierda() { velocidadX = -5; }
    public void moverDerecha() { velocidadX = 5; }
    public void detener() { velocidadX = 0; }

    public void saltar() {
        if (!saltando && !cayendo) {
            velocidadY = -18;
            saltando = true;
        }
    }

    public java.awt.Rectangle getBoundsCuerpo() {
        return new java.awt.Rectangle((int) x - ancho/2, (int) y - alto/2, ancho, alto - 12);
    }

    public java.awt.Rectangle getBoundsPies() {
        return new java.awt.Rectangle((int) x - ancho/2 + 4, (int) y + alto/2 - 12, ancho - 8, 12);
    }

    @Override
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle((int) x - ancho/2, (int) y - alto/2, ancho, alto);
    }

    public void actualizarSinFiltro(Plataforma p1, Plataforma p2, Plataforma p3, Plataforma p4, int desplazamientoMapa) {
        x += velocidadX;

        verificarChoqueLateral(p1, desplazamientoMapa);
        verificarChoqueLateral(p2, desplazamientoMapa);
        verificarChoqueLateral(p3, desplazamientoMapa);
        verificarChoqueLateral(p4, desplazamientoMapa);

        velocidadY += 1; 
        y += velocidadY;

        boolean tocandoAlgunSuelo = false;
        
        if (getBoundsPies().intersects(p1.getBoundsReal(desplazamientoMapa))) { y = p1.getY() - p1.getAlto()/2 - alto/2; velocidadY = 0; saltando = false; cayendo = false; tocandoAlgunSuelo = true; }
        if (getBoundsPies().intersects(p2.getBoundsReal(desplazamientoMapa))) { y = p2.getY() - p2.getAlto()/2 - alto/2; velocidadY = 0; saltando = false; cayendo = false; tocandoAlgunSuelo = true; }
        if (getBoundsPies().intersects(p3.getBoundsReal(desplazamientoMapa))) { y = p3.getY() - p3.getAlto()/2 - alto/2; velocidadY = 0; saltando = false; cayendo = false; tocandoAlgunSuelo = true; }
        if (getBoundsPies().intersects(p4.getBoundsReal(desplazamientoMapa))) { y = p4.getY() - p4.getAlto()/2 - alto/2; velocidadY = 0; saltando = false; cayendo = false; tocandoAlgunSuelo = true; }

        if (!tocandoAlgunSuelo) {
            cayendo = true;
        }

        if (y > 600) {
            vidas--;
            x = 400;
            y = 200;
            velocidadY = 0;
        }
    }

    private void verificarChoqueLateral(Plataforma p, int desplazamientoMapa) {
        if (getBoundsCuerpo().intersects(p.getBoundsReal(desplazamientoMapa))) {
            if (velocidadX > 0) {
                x = (p.getX() - desplazamientoMapa) - ancho/2;
            } else if (velocidadX < 0) {
                x = (p.getX() - desplazamientoMapa) + p.getAncho() + ancho/2;
            }
        }
    }

    public void perderVida() { vidas--; }
    public void ganarVida() { if (vidas < 5) vidas++; }
    public int getVidas() { return vidas; }

    public void dibujar(Entorno entorno) {
        if (this.imagen != null) {
            entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
        } else {
            entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.PINK);
        }
    }
}