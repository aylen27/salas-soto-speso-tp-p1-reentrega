package entidades;

import java.awt.Image;
import java.awt.Rectangle;
import entorno.Entorno;
import javax.swing.ImageIcon;

public class EnemigoSaltarin {
    private double x;
    private double y;
    private int ancho;
    private int alto;
    private Image imagen;
    
    // Variables para la física del salto
    private double velY;
    private double gravedad;
    private boolean enElPiso;
    private int direccionX; // -1 izquierda, 1 derecha
    private double velocidadX;

    public EnemigoSaltarin(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho = 60;
        this.alto = 60;
        this.direccionX = -1; // Arranca caminando a la izquierda
        this.velocidadX = 1.5;
        
        this.velY = 0;
        this.gravedad = 0.4; // Qué tan rápido cae
        this.enElPiso = false;

        // Podés usar una imagen nueva (ej: bicho_salto.png) o reutilizar la que ya tenés
        ImageIcon icono = new ImageIcon("img/enemigo_saltarin.png");
        this.imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }

    public void actualizar(Plataforma piso) {
        // 1. Movimiento horizontal continuo
        x += direccionX * velocidadX;

        // 2. Aplicar gravedad en el eje Y
        velY += gravedad;
        y += velY;

        // 3. Lógica de colisión rústica con el piso para que rebote
        // Suponiendo que el piso está en Y = 540 (como tus plataformas principales)
        int limitePiso = 540 - this.alto; 
        
        if (y >= limitePiso) {
            y = limitePiso;
            velY = -10; // 🎯 ¡EL TRUCO!: Apenas toca el suelo, se impulsa hacia arriba automáticamente
            enElPiso = true;
        } else {
            enElPiso = false;
        }
        
        // 4. Si se sale mucho de la pantalla o querés que rebote en las paredes de tu mapa corto
        if (x < 0) {
            direccionX = 1;
        }
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        entorno.dibujarImagen(
            imagen,
            (x - desplazamientoMapa) + ancho / 2,
            y + alto / 2,
            0
        );
    }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int)x - desplazamientoMapa, (int)y, ancho, alto);
    }
    
    public double getX() { return x; }
}