package entidades;

import entorno.Entorno;
import java.awt.Color;

public class ProyectilEnemigo extends Entidad {

    private double dx;
    private double dy;

    public ProyectilEnemigo(
            int origenX,
            int origenY,
            int destinoX,
            int destinoY
    ) {

        this.x = origenX;
        this.y = origenY;

        this.ancho = 15;
        this.alto = 15;

        double distancia = Math.sqrt(
                Math.pow(destinoX - origenX, 2)
              + Math.pow(destinoY - origenY, 2)
        );

        if (distancia > 0) {

            dx = (destinoX - origenX) / distancia;
            dy = (destinoY - origenY) / distancia;
        }
        else {

            dx = -1;
            dy = 0;
        }
    }

    public void actualizar() {

        x += dx * 7;
        y += dy * 7;
    }

    public void dibujar(Entorno entorno) {

        entorno.dibujarCirculo(
                x,
                y,
                8,
                Color.MAGENTA
        );
    }
}