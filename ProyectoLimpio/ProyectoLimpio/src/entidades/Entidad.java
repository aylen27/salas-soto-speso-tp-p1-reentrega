package entidades;

import java.awt.Rectangle;

public class Entidad {
    protected double x;
    protected double y;
    protected int ancho;
    protected int alto;
    protected double velocidadX;
    protected double velocidadY;

    // Nos sirve para detectar las colisiones entre los objetos
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, ancho, alto);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
    
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}