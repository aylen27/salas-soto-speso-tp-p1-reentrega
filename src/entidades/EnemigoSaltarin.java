package entidades;

<<<<<<< HEAD
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
=======
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemigoSaltarin extends Entidad {

	// Variable que guarda la imagen del enemigo
    private Image imagen;

    // Variable que controla la velocidad vertical
    // Se usa para gravedad y saltos
    private int velocidadY;

    // Constructor del enemigo saltarín
    // Recibe:
    // x -> posición horizontal
    // y -> posición vertical
    // direccion -> hacia dónde se mueve
    public EnemigoSaltarin(int x, int y, int direccion) {

        // Guardamos la posición inicial
        this.x = x;
        this.y = y;

        // Definimos el tamaño del enemigo
        this.ancho = 50;
        this.alto = 50;

        // Velocidad horizontal
        // direccion puede ser:
        // 1  -> derecha
        // -1 -> izquierda
        this.velocidadX = direccion * 2;

        // El enemigo empieza sin movimiento vertical
        this.velocidadY = 0;

        // Cargamos la imagen del enemigo
        ImageIcon icono = new ImageIcon("img/enemigo_saltarin.png");

        // Guardamos la imagen cargada
        imagen = icono.getImage();
    }

    // Método que actualiza la posición y movimiento del enemigo
    public void actualizar() {

        // Movimiento horizontal
        x += velocidadX;

        // Simulación de gravedad
        // Aumenta la velocidad vertical hacia abajo
        velocidadY += 1;

        // Aplicamos el movimiento vertical
        y += velocidadY;

        // Verificamos si el enemigo llegó al piso
        if (y >= 450) {

            // Lo mantenemos apoyado en el suelo
            y = 450;

            // Probabilidad de saltar
            // Math.random() genera un número entre 0 y 1
            // 0.03 = 3% de probabilidad
            if (Math.random() < 0.03) {

                // Salto hacia arriba
                // Valor negativo porque sube
                velocidadY = -18;

            } else {

                // Si no salta, queda quieto en el piso
                velocidadY = 0;
            }
        }
    }

    // Método que devuelve el rectángulo real de colisión
    // desplazamientoMapa sirve para mover el mapa/cámara
    public Rectangle getBoundsReal(int desplazamientoMapa) {

        // Creamos y devolvemos el rectángulo
        return new Rectangle(
                x - desplazamientoMapa, // posición X en pantalla
                y,                      // posición Y
                ancho,                  // ancho
                alto                    // alto
        );
    }

    // Método encargado de dibujar el enemigo en pantalla
    public void dibujar(Graphics g, int desplazamientoMapa) {

        // Dibujamos la imagen del enemigo
        g.drawImage(
                imagen,                  // imagen a dibujar
                x - desplazamientoMapa, // posición X
                y,                      // posición Y
                ancho,                  // ancho
                alto,                   // alto
                null
        );
    }
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
}