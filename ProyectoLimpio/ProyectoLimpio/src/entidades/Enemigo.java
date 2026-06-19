package entidades;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;
import entorno.Entorno;

public class Enemigo extends Entidad {
    private Image imagen;

    public Enemigo(double x, double y, int direccion) {
        this.x = x;
        this.y = y;
        this.ancho = 40;
        this.alto = 40;
        this.velocidadX = direccion * 3;
        
        try {
            this.imagen = ImageIO.read(new File("C:/eclipse-workspace/ProyectoLimpio/img/enemigo.png"));
        } catch (Exception e) {
            try {
                this.imagen = ImageIO.read(new File("img/enemigo.png"));
            } catch (Exception ex) {
                this.imagen = null;
            }
        }
    }

    public void actualizar() {
        x += velocidadX;
    }

    public Rectangle getBoundsReal(int desplazamientoMapa) {
        return new Rectangle((int) (x - desplazamientoMapa - ancho/2), (int) (y - alto/2), ancho, alto);
    }

    public void dibujar(Entorno entorno, int desplazamientoMapa) {
        double xPantalla = x - desplazamientoMapa;
        if (this.imagen != null) {
            entorno.dibujarImagen(this.imagen, xPantalla, y, 0);
        } else {
            entorno.dibujarRectangulo(xPantalla, y, ancho, alto, 0, Color.RED);
        }
    }
}