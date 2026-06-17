package entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Proyectil extends Entidad {

    // Dirección horizontal del proyectil
    private double dx;

    // Dirección vertical del proyectil
    private double dy;

    private boolean activo;

    // Constructor que recibe origen y destino
    public Proyectil(
            int origenX,
            int origenY,
            int destinoX,
            int destinoY
    ) {

        // Posición inicial del proyectil
        x = origenX;
        y = origenY;

        // Tamaño del proyectil
        ancho = 15;
        alto = 15;

        // Calculamos la distancia entre origen y destino
        double distancia = Math.sqrt(
                Math.pow(destinoX - origenX, 2)
              + Math.pow(destinoY - origenY, 2)
        );

        // Calculamos dirección horizontal normalizada
        dx = (destinoX - origenX) / distancia;

        // Calculamos dirección vertical normalizada
        dy = (destinoY - origenY) / distancia;

        // El proyectil comienza activo
        activo = true;
    }

    // Actualiza la posición del proyectil
    public void actualizar() {

        // Movimiento horizontal
        x += dx * 10;

        // Movimiento vertical
        y += dy * 10;
    }

    // Devuelve true si el proyectil sigue activo
    public boolean estaActivo() {
        return activo;
    }

    // Destruye el proyectil
    public void destruir() {
        activo = false;
    }

    // Dibuja el proyectil en pantalla
    public void dibujar(Graphics g) {

        // Color del proyectil
        g.setColor(Color.YELLOW);

        // Dibujamos el proyectil
        g.fillOval(
                x,
                y,
                ancho,
                alto
        );
    }
}