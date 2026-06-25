package entidades;

import java.awt.Color;
import entorno.Entorno;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Jefe extends Entidad {

    private int vidas;
    private Image imagen;
    private int contadorAtaque;
    private int direccionY;

    public Jefe(int x, int y) {
        this.x = x;
        this.y = y;

        this.ancho = 100;
        this.alto = 120;

        this.vidas = 10;

        ImageIcon icono = new ImageIcon("img/bowser.png");

        imagen = icono.getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH);

        contadorAtaque = 0;
     
        this.direccionY = 1; 
    }

    public void actualizar() {
    
        y += direccionY * 2;

        if (y <= 150) {
            direccionY = 1;
        }
      
        else if (y >= 400) {
            direccionY = -1;
        }

        contadorAtaque++;
    }


    public ProyectilEnemigo intentarAtacar(int princesaX, int princesaY, int desplazamientoMapa) {
        
        if (contadorAtaque >= 120) {

            contadorAtaque = 0;

            int origenX = x - desplazamientoMapa + (ancho / 2);

            int origenY = y + (alto / 2);

            return new ProyectilEnemigo(
                    origenX,
                    origenY,
                    princesaX,
                    princesaY
            );
        }

  
        return null;
    }

    // Le resta una vida al jefe
    public void perderVida() {
        this.vidas--;
    }

    // Devuelve la cantidad de vidas actuales
    public int getVidas() {
        return vidas;
    }

    // Devuelve el rectángulo de colisión del jefe
    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    // Dibuja el jefe en pantalla
    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        // 1. Dibujamos la imagen del jefe
        entorno.dibujarImagen(
                imagen,
                (x - desplazamientoMapa) + ancho / 2,
                y + alto / 2,
                0
        );

        // 2. Dibujamos la barra de vida arriba del jefe
        int barraAncho = 100; // Mismo ancho que el jefe
        int barraAlto = 10;
        int barraX = (x - desplazamientoMapa);
        int barraY = y - 20; // 20 píxeles arriba del jefe

        // Fondo de la barra (Gris)
        entorno.dibujarRectangulo(barraX + ancho/2, barraY, barraAncho, barraAlto, 0, Color.GRAY);

        // Vida actual (Roja)
        // Calculamos el ancho proporcional a las vidas restantes (vidas/10 * 100)
        double vidaProporcional = (vidas / 10.0) * barraAncho;
        entorno.dibujarRectangulo(barraX + (int)vidaProporcional/2, barraY, (int)vidaProporcional, barraAlto, 0, Color.RED);
    }
}