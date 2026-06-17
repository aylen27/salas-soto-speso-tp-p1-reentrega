package entidades;

import java.awt.Color;
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
        
        this.ancho = 120;
        this.alto = 120;
        
        this.vidas = 10;
        this.velocidadX = 0;
        this.direccionY = 1;

        ImageIcon icono = new ImageIcon("img/bowser.png");
        imagen = icono.getImage();

        contadorAtaque = 0;
    }

    public void actualizar() {

        // Movimiento vertical flotante
        y += direccionY * 2;

        // Si llega arriba cambia de dirección
        if (y <= 150) {
            direccionY = 1;
        }

        // Si llega abajo cambia de dirección
        else if (y >= 400) {
            direccionY = -1;
        }

        contadorAtaque++;
    }

    // El jefe intenta atacar lanzando un proyectil
    public ProyectilEnemigo intentarAtacar(
            int princesaX,
            int princesaY,
            int desplazamientoMapa
    ) {

        // Ataca aproximadamente cada 2 segundos
        if (contadorAtaque >= 120) {

            contadorAtaque = 0;

            // Posición X desde donde sale el proyectil
            int origenX =
                    x - desplazamientoMapa + (ancho / 2);

            // Posición Y desde donde sale el proyectil
            int origenY =
                    y + (alto / 2);

            // Creamos y devolvemos el proyectil
            return new ProyectilEnemigo(
                    origenX,
                    origenY,
                    princesaX,
                    princesaY
            );
        }

        // Si no ataca devolvemos null
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
    public void dibujar(Graphics g, int desplazamientoMapa) {

        int xPantalla = x - desplazamientoMapa;

        // Si existe una imagen válida la dibujamos
        if (imagen != null && imagen.getWidth(null) > 0) {

            g.drawImage(
                    imagen,
                    xPantalla,
                    y,
                    ancho,
                    alto,
                    null
            );
        }

        // Si no hay imagen dibujamos un rectángulo naranja
        else {

            g.setColor(Color.ORANGE);

            g.fillRect(
                    xPantalla,
                    y,
                    ancho,
                    alto
            );
        }

        // Dibujamos el fondo rojo de la barra de vida
        g.setColor(Color.RED);

        g.fillRect(
                xPantalla,
                y - 20,
                ancho,
                8
        );

        // Dibujamos la vida restante en verde
        g.setColor(Color.GREEN);

        int anchoVida =
                (ancho * vidas) / 10;

        g.fillRect(
                xPantalla,
                y - 20,
                anchoVida,
                8
        );
    }
}