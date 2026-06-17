package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class ProyectilEnemigo extends Entidad {

    // Dirección horizontal del proyectil
    private double dx;

    // Dirección vertical del proyectil
    private double dy;

    // Constructor que recibe origen y destino
    public ProyectilEnemigo(
            int origenX,
            int origenY,
            int destinoX,
            int destinoY
    ) {

        // Posición inicial del proyectil
        this.x = origenX;
        this.y = origenY;

        // Tamaño del proyectil
        this.ancho = 15;
        this.alto = 15;

        // Calculamos la distancia entre origen y destino
        double distancia = Math.sqrt(
                Math.pow(destinoX - origenX, 2)
              + Math.pow(destinoY - origenY, 2)
        );

        // Si la distancia es válida calculamos dirección normalizada
        if (distancia > 0) {

            // Dirección horizontal
            this.dx =
                    (destinoX - origenX) / distancia;

            // Dirección vertical
            this.dy =
                    (destinoY - origenY) / distancia;
        }

        // Si la distancia es 0 usamos dirección por defecto
        else {

            // Movimiento hacia la izquierda
            this.dx = -1;

            // Sin movimiento vertical
            this.dy = 0;
        }
    }

    public void actualizar() {

        // Movimiento horizontal
        x += dx * 7;

        // Movimiento vertical
        y += dy * 7;
    }

    // Dibuja el proyectil enemigo en pantalla
    public void dibujar(Graphics g) {

        // Color del proyectil enemigo
        g.setColor(Color.MAGENTA);

        // Dibujamos el proyectil
        g.fillOval(
                x,
                y,
                ancho,
                alto
        );
    }
}