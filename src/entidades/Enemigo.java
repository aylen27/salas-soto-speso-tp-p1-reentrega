package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemigo extends Entidad {

    private boolean vivo;
    private Image imagen;
    
    public Enemigo(int x, int y, int direccion) {

    		this.x = x;
        this.y = y;
        
        this.ancho = 40;
        this.alto = 40;
        
        ImageIcon icono = new ImageIcon("img/enemigo.png");
        imagen = icono.getImage();

        // Definimos la velocidad horizontal
        // direccion = 1 derecha, -1 izquierda
        this.velocidadX = direccion * 3;

        // El enemigo comienza vivo
        this.vivo = true;
    }

    // Actualiza la posición del enemigo
    public void actualizar() {

        // Movimiento horizontal
        x += velocidadX;
    }

    // Devuelve true si el enemigo sigue vivo
    public boolean estaVivo() {
        return vivo;
    }

    // Marca al enemigo como muerto
    public void matar() {
        vivo = false;
    }

    // Devuelve el rectángulo de colisión del enemigo
    // desplazamientoMapa se usa para mover la cámara/mapa
    public Rectangle getBoundsReal(int desplazamientoMapa) {

        // Creamos y devolvemos el rectángulo de colisión
        return new Rectangle(
                x - desplazamientoMapa,
                y,
                ancho,
                alto
        );
    }

    // Dibuja el enemigo en pantalla
    public void dibujar(Graphics g, int desplazamientoMapa) {

        g.drawImage(
                imagen,
                x - desplazamientoMapa,
                y,
                ancho,
                alto,
                null
        );
    }
}