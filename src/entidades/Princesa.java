package entidades;


import entorno.Entorno;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Princesa extends Entidad {

    private int vidas;
    private boolean saltando;
    private boolean cayendo;
    private Image imagen;
    private int invulnerable = 0;

    public Princesa(int x, int y) {

        this.x = x;
        this.y = y;
        
        this.ancho = 65;
        this.alto = 85;
        
        this.velocidadX = 0;
        this.velocidadY = 0;
        
        this.vidas = 5;

        ImageIcon icono =
                new ImageIcon("img/princesa.png");

        imagen = icono.getImage().getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH);
    }

    public void moverIzquierda() {
        velocidadX = -5;
    }

    public void moverDerecha() {
        velocidadX = 5;
    }

    public void detener() {
        velocidadX = 0;
    }
    
    public java.awt.Rectangle getBounds() {

        return new java.awt.Rectangle(
                x,
                y,
                ancho,
                alto);
    }

    public void saltar() {

        // Solo puede saltar si no está en el aire
        if (!saltando && !cayendo) {

            // Velocidad negativa para subir
            velocidadY = -22;

            // Marcamos que está saltando
            saltando = true;
        }
    }

    // Devuelve el rectángulo de colisión del cuerpo
    public java.awt.Rectangle getBoundsCuerpo() {

        return new java.awt.Rectangle(
                x,
                y,
                ancho,
                alto - 12
        );
    }

    // Devuelve el rectángulo de colisión de los pies
    public java.awt.Rectangle getBoundsPies() {

        return new java.awt.Rectangle(
                x + 8,
                y + alto - 12,
                ancho - 16,
                12
        );
    }

    // Actualiza movimiento y colisiones
    public void actualizar(
            Plataforma piso1,
            Plataforma piso2,
            Plataforma piso3,
            Plataforma piso4,
            Plataforma piso5,
            Plataforma piso6,
            Plataforma piso7,
            Plataforma piso8,
            Plataforma piso9,
            Plataforma piso10,
            Plataforma piso11,
            Plataforma piso12,
            Plataforma piso13,
            Plataforma piso14,
            Plataforma piso15,
            Plataforma piso16,
            Plataforma piso17,
            Plataforma piso18,
            Plataforma piso19,
            Plataforma piso20,
            Plataforma piso21,
            Plataforma plataforma1,
            Plataforma plataforma2,
            Plataforma plataforma3,
            Plataforma plataforma4,
            Plataforma plataforma5,
            Plataforma plataforma6,
            Plataforma plataforma7,
            Plataforma plataforma8,
            Plataforma plataforma9,
            Plataforma plataforma10,
            Plataforma plataforma11,
            Plataforma plataforma12,
            Plataforma plataforma13,
            Plataforma plataforma14,
            Plataforma plataforma15,
            int desplazamientoMapa){
    	
    	if (invulnerable > 0) {
    	    invulnerable--;
    	}
    	
    	Plataforma[] plataformas = {
    			
    		    piso1,
    		    piso2,
    		    piso3,
    		    piso4,
    		    piso5,
    		    piso6,
    		    piso7,
    		    piso8,
    		    piso9,
    		    piso10,
    		    piso11,
    		    piso12,
    		    piso13,
    		    piso14,
    		    piso15,
    		    piso16, piso17, piso18,
    		    piso19, piso20, piso21,
    		    plataforma1,
    		    plataforma2,
    		    plataforma3,
    		    plataforma4,
    		    plataforma5,
    		    plataforma6,
    		    plataforma7,
    		    plataforma8,
    		    plataforma9,
    		    plataforma10,
    		    plataforma11,
    		    plataforma12,
    		    plataforma13,
    		    plataforma14,
    		    plataforma15
    		};

        // =========================
        // MOVIMIENTO HORIZONTAL
        // =========================

        x += velocidadX;

        // Revisamos colisiones laterales
        for (Plataforma p : plataformas) {
        	
        	 if (p == null) {
        	        continue;
        	   }

            if (getBoundsCuerpo().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Colisión hacia la derecha
                if (velocidadX > 0) {

                    x =
                            (p.getX() - desplazamientoMapa)
                                    - ancho;
                }

                // Colisión hacia la izquierda
                else if (velocidadX < 0) {

                    x =
                            (p.getX() - desplazamientoMapa)
                                    + p.getAncho();
                }
            }
        }

        // =========================
        // GRAVEDAD Y MOVIMIENTO
        // =========================

        // Aplicamos gravedad
        velocidadY += 1;

        // Actualizamos posición vertical
        y += velocidadY;

        // Variable para saber si pisa una plataforma
        boolean tocandoAlgunSuelo = false;

        // Revisamos colisiones con plataformas
        for (Plataforma p : plataformas) {

            if (getBoundsPies().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Solo aplica si cae
                if (velocidadY >= 0) {

                    // Colocamos la princesa arriba
                    y = p.getY() - alto;

                    // Frenamos la caída
                    velocidadY = 0;

                    saltando = false;

                    cayendo = false;

                    tocandoAlgunSuelo = true;
                }
            }
        }

        if (!tocandoAlgunSuelo) {
            cayendo = true;
        }

        // =========================
        // COLISIÓN CON TECHO
        // =========================

        for (Plataforma p : plataformas) {

            if (getBounds().intersects(
                    p.getBoundsReal(desplazamientoMapa))) {

                // Golpea desde abajo
                if (velocidadY < 0
                        && (y - velocidadY)
                        >= p.getY() + p.getAlto() - 10) {

                    // Posicionamos debajo
                    y = p.getY() + p.getAlto();

                    // Frenamos movimiento vertical
                    velocidadY = 0;
                }
            }
        }

        // =========================
        // CAÍDA FUERA DEL MAPA
        // =========================

        if (y > 700) {

            vidas--;

            x = 400;
            y = 200;

            velocidadY = 0;
        }
    }

    public void perderVida() {
    		if(invulnerable == 0){
    			vidas--;
    			invulnerable = 60;
    		}
    }

    public void ganarVida() {

        if (vidas < 5) {
            vidas++;
        }
    }

    public int getVidas() {
        return vidas;
    }

    // Dibuja la princesa en pantalla
    public void dibujar(Entorno entorno) {

        // Mientras es invulnerable parpadea
        if (invulnerable > 0 && invulnerable % 10 < 5) {
            return;
        }

        entorno.dibujarImagen(
                imagen,
                x + ancho / 2,
                y + alto / 2,
                0
        );
    }
}