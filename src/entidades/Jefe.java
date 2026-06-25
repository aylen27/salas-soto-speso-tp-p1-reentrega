package entidades;

import java.awt.Color;
import entorno.Entorno;
<<<<<<< HEAD
import java.awt.Graphics;
=======
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
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
<<<<<<< HEAD

        this.ancho = 100;
        this.alto = 120;

        this.vidas = 10;

        ImageIcon icono = new ImageIcon("img/bowser.png");

        imagen = icono.getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH);

        contadorAtaque = 0;
     
=======
        this.ancho = 100;
        this.alto = 120;
        this.vidas = 10;

        ImageIcon icono = new ImageIcon("img/bowser.png");
        imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        contadorAtaque = 0;
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
        this.direccionY = 1; 
    }

    public void actualizar() {
<<<<<<< HEAD
    
        y += direccionY * 2;

        if (y <= 150) {
            direccionY = 1;
        }
      
        else if (y >= 400) {
=======
        // Movimiento vertical
        y += direccionY * 2;

        // Rebote en los límites
        if (y <= 150) {
            direccionY = 1;
        } else if (y >= 400) {
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
            direccionY = -1;
        }

        contadorAtaque++;
    }

<<<<<<< HEAD

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
=======
    public ProyectilEnemigo intentarAtacar(int princesaX, int princesaY, int desplazamientoMapa) {
        if (contadorAtaque >= 120) {
            contadorAtaque = 0;

            int origenX = x - desplazamientoMapa + (ancho / 2);
            int origenY = y + (alto / 2);

            return new ProyectilEnemigo(origenX, origenY, princesaX, princesaY);
        }
        return null;
    }

>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
    public void perderVida() {
        this.vidas--;
    }

<<<<<<< HEAD
    // Devuelve la cantidad de vidas actuales
=======
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
    public int getVidas() {
        return vidas;
    }

<<<<<<< HEAD
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
=======
    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle(x - desplazamientoMapa, y, ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
        entorno.dibujarImagen(
                imagen,
                (x - desplazamientoMapa) + ancho / 2,
                y + alto / 2,
                0
        );

<<<<<<< HEAD
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
=======
        int barraAncho = 100;e
        int barraAlto = 10;
        int barraX = (x - desplazamientoMapa);
        int barraY = y - 20;

        entorno.dibujarRectangulo(barraX + ancho/2, barraY, barraAncho, barraAlto, 0, Color.GRAY);

        double vidaProporcional = (vidas / 10.0) * barraAncho;
        entorno.dibujarRectangulo(barraX + (int)vidaProporcional/2, barraY, (int)vidaProporcional, barraAlto, 0, Color.RED);
        entorno.dibujarImagen(imagen, (x - desplazamientoMapa) + ancho / 2, y + alto / 2, 0);
    }
}
>>>>>>> d1dc0f3d9255f25ef01fa95ea0986c22c51b4a5f
