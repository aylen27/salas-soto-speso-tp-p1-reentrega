package entidades;

<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
import java.awt.Color;
import entorno.Entorno;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
import javax.swing.ImageIcon;

public class Jefe extends Entidad {

    private int vidas;
    private Image imagen;
    private int contadorAtaque;
    private int direccionY;

    public Jefe(int x, int y) {
<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
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
<<<<<<< HEAD
        
        // 🎯 IMPULSO INICIAL: Arranca en 1 para que el movimiento vertical funcione de una
        this.direccionY = 1; 
    }

    public void actualizar() {
=======
    }

    public void actualizar() {

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        // Movimiento vertical flotante
        y += direccionY * 2;

        // Si llega arriba cambia de dirección
        if (y <= 150) {
            direccionY = 1;
        }
<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        // Si llega abajo cambia de dirección
        else if (y >= 400) {
            direccionY = -1;
        }

        contadorAtaque++;
    }

    // El jefe intenta atacar lanzando un proyectil
<<<<<<< HEAD
    public ProyectilEnemigo intentarAtacar(int princesaX, int princesaY, int desplazamientoMapa) {
        // Ataca aproximadamente cada 2 segundos (60 frames = 1 segundo)
=======
    public ProyectilEnemigo intentarAtacar(
            int princesaX,
            int princesaY,
            int desplazamientoMapa
    ) {

        // Ataca aproximadamente cada 2 segundos
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        if (contadorAtaque >= 120) {

            contadorAtaque = 0;

            // Posición X desde donde sale el proyectil
<<<<<<< HEAD
            int origenX = x - desplazamientoMapa + (ancho / 2);

            // Posición Y desde donde sale el proyectil
            int origenY = y + (alto / 2);

            // Creamos y devolvemos el proyectil apuntando a la princesa
=======
            int origenX =
                    x - desplazamientoMapa + (ancho / 2);

            // Posición Y desde donde sale el proyectil
            int origenY =
                    y + (alto / 2);

            // Creamos y devolvemos el proyectil
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
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

<<<<<<< HEAD
    // Le resta una vida al jefe cuando le pegamos
=======
   // Le resta una vida al jefe
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
    public void perderVida() {
        this.vidas--;
    }

    // Devuelve la cantidad de vidas actuales
    public int getVidas() {
        return vidas;
    }

    // Devuelve el rectángulo de colisión del jefe
    public Rectangle getBoundsReal(int desplazamientoMapa) {
<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    // Dibuja el jefe en pantalla
<<<<<<< HEAD
    public void dibujar(Entorno entorno, int desplazamientoMapa) {
=======
    public void dibujar(
            Entorno entorno,
            int desplazamientoMapa
    ) {

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        entorno.dibujarImagen(
                imagen,
                (x - desplazamientoMapa) + ancho / 2,
                y + alto / 2,
                0
        );
    }
}