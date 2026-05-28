package entidades;

import java.awt.Rectangle;

public class Entidad {

    protected int x;
    protected int y;

    protected int ancho;
    protected int alto;

    protected int velocidadX;
    protected int velocidadY;

    public Rectangle getBounds() {

        return new Rectangle(x, y, ancho, alto);
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getAncho() {

        return ancho;
    }

    public int getAlto() {

        return alto;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }
}