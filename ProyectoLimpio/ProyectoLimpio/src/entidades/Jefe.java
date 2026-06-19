package entidades;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;
import entorno.Entorno;

public class Jefe extends Entidad {
    private int vidas;
    private Image imagen;
    private int contadorAtaque;
    private int direccionY;

    public Jefe(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 120;
        this.alto = 120;
        this.vidas = 10;
        this.direccionY = 1;
        this.contadorAtaque = 0;
        
        
            try {
                this.imagen = ImageIO.read(new File("img/bowser.png"));
            } catch (Exception ex) {
                this.imagen = null;
            }
        }
    

    public void actualizar() {
        y += direccionY * 2;
        if (y <= 150) direccionY = 1;
        else if (y >= 400) direccionY = -1;
        contadorAtaque++;
    }

    public ProyectilEnemigo intentarAtacar(double princesaX, double princesaY, int desplazamientoMapa) {
        if (contadorAtaque >= 120) {
            contadorAtaque = 0;
            int origenX = (int) (x - desplazamientoMapa);
            int origenY = (int) (y);
            return new ProyectilEnemigo(origenX, origenY, (int) princesaX, (int) princesaY);
        }
        return null;
    }

    public void perderVida() { vidas--; }
    public int getVidas() { return vidas; }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int) (x - desplazamientoMapa - ancho/2), (int) (y - alto/2), ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        double xPantalla = x - desplazamientoMapa;
        if (this.imagen != null) {
            entorno.dibujarImagen(this.imagen, xPantalla, y, 0);
        } else {
            entorno.dibujarRectangulo(xPantalla, y, ancho, alto, 0, Color.ORANGE);
        }

        entorno.dibujarRectangulo(xPantalla, y - 70, ancho, 8, 0, Color.RED);
        double anchoVida = (ancho * vidas) / 10.0;
        entorno.dibujarRectangulo(xPantalla - (ancho - anchoVida)/2, y - 70, anchoVida, 8, 0, Color.GREEN);
    }
}