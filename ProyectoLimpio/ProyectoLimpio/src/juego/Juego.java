package juego;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import entorno.Entorno;
import entorno.InterfaceJuego;

import entidades.CajaMagica;
import entidades.Castillo;
import entidades.Enemigo;
import entidades.Plataforma;
import entidades.Princesa;
import entidades.Proyectil;
import entidades.Jefe;
import entidades.ProyectilEnemigo;
import util.Constantes;

public class Juego extends InterfaceJuego {
    private Entorno entorno;

    private Princesa princesa;
    private Proyectil proyectil;
    private Castillo castillo;
    private CajaMagica cajaMagica;
    private int desplazamientoMapa;
    private boolean ganado;
    private boolean perdido;

    // Imagen de fondo con carga directa
    private Image imagenFondo;

    // Plataformas individuales fijas (Sin Arrays ni ArrayLists)
    private Plataforma pisoBase1;
    private Plataforma pisoBase2;
    private Plataforma plataformaFlotante1;
    private Plataforma plataformaFlotante2;

    // Enemigos individuales
    private Enemigo enemigo1;
    private Enemigo enemigo2;

    // Variables del Jefe Final
    private Jefe jefe;
    private ProyectilEnemigo proyectilJefe;
    private boolean batallaJefeIniciada;

    public Juego() {
        this.entorno = new Entorno(this, "Super Elizabeth Sis - UNGS", 1000, 600);
        inicializar();
        this.entorno.iniciar();
    }

    public void inicializar() {
        // CARGA DIRECTA DESDE DISCO: Cambiá 'fondonuevo.png' por el archivo que sea tu paisaje de fondo
        try {
            this.imagenFondo = ImageIO.read(new File("C:/eclipse-workspace/ProyectoLimpio/img/fondonuevo.png"));
        } catch (Exception e) {
            try {
                this.imagenFondo = ImageIO.read(new File("img/fondonuevo.png"));
            } catch (Exception ex) {
                this.imagenFondo = null;
            }
        }

        princesa = new Princesa(400, 200);
        
        pisoBase1 = new Plataforma(0, 540, 1500, 40);
        pisoBase2 = new Plataforma(1800, 540, 2200, 40);
        
        plataformaFlotante1 = new Plataforma(600, 380, 250, 30);
        plataformaFlotante2 = new Plataforma(1200, 280, 200, 30);
        
        enemigo1 = new Enemigo(800, 500, -1);
        enemigo2 = new Enemigo(1400, 500, -1);
        
        castillo = new Castillo(Constantes.LARGO_MAPA - 300, 410);
        jefe = new Jefe(Constantes.LARGO_MAPA - 600, 250);
        proyectilJefe = null;
        batallaJefeIniciada = false;
        desplazamientoMapa = 0;
        ganado = false;
        perdido = false;

        cajaMagica = new CajaMagica(900, 515);
    }

    @Override
    public void tick() {
        if (ganado) {
            entorno.cambiarFont("Arial", 50, Color.WHITE);
            entorno.escribirTexto("GANASTE", 350, 250);
            return;
        }

        if (perdido) {
            entorno.cambiarFont("Arial", 50, Color.WHITE);
            entorno.escribirTexto("GAME OVER", 300, 250);
            return;
        }

        // 1. CONTROLES
        princesa.detener();
        
        if (entorno.estaPresionada('a') || entorno.estaPresionada('A') || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
            if (princesa.getX() > 0) princesa.moverIzquierda();
        }
        
        if (entorno.estaPresionada('d') || entorno.estaPresionada('D') || entorno.estaPresionada(entorno.TECLA_DERECHA)) {
            if (princesa.getX() >= 500 && desplazamientoMapa < Constantes.LARGO_MAPA - Constantes.ANCHO) {
                desplazamientoMapa += 5;
            } else {
                princesa.moverDerecha();
            }
        }
        
        if (entorno.estaPresionada('w') || entorno.estaPresionada('W') || entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
            princesa.saltar();
        }
        
        if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && proyectil == null) {
            proyectil = new Proyectil((int)princesa.getX(), (int)princesa.getY(), entorno.mouseX(), entorno.mouseY());
        }

        // 2. ACTUALIZACIÓN DE LÓGICA
        princesa.actualizarSinFiltro(pisoBase1, pisoBase2, plataformaFlotante1, plataformaFlotante2, desplazamientoMapa);

        if (desplazamientoMapa >= Constantes.LARGO_MAPA - Constantes.ANCHO - 100) {
            batallaJefeIniciada = true;
        }

        if (batallaJefeIniciada && jefe != null) {
            jefe.actualizar();
            if (proyectilJefe == null) {
                proyectilJefe = jefe.intentarAtacar(princesa.getX(), princesa.getY(), desplazamientoMapa);
            }
        } else {
            reincorporarEnemigosFueraDePantalla();
        }

        if (proyectil != null) {
            proyectil.actualizar();
            if (proyectil.getX() < 0 || proyectil.getX() > Constantes.ANCHO || proyectil.getY() < 0 || proyectil.getY() > Constantes.ALTO) {
                proyectil = null;
            }
        }

        if (proyectilJefe != null) {
            proyectilJefe.actualizar();
            if (proyectilJefe.getX() < 0 || proyectilJefe.getX() > Constantes.ANCHO || proyectilJefe.getY() < 0 || proyectilJefe.getY() > Constantes.ALTO) {
                proyectilJefe = null;
            }
        }

        if (enemigo1 != null) enemigo1.actualizar();
        if (enemigo2 != null) enemigo2.actualizar();

        verificarColisionesIndividuales();
        verificarCajaMagica();
        
        if (princesa.getVidas() <= 0) perdido = true;
        if (jefe == null && princesa.getBounds().intersects(castillo.getBoundsReal(desplazamientoMapa))) ganado = true;

        // 3. RENDERIZADO
        if (this.imagenFondo != null) {
            entorno.dibujarImagen(this.imagenFondo, 500, 300, 0);
        } else {
            entorno.dibujarRectangulo(500, 300, 1000, 600, 0, Color.CYAN); 
        }

        pisoBase1.dibujar(entorno, desplazamientoMapa);
        pisoBase2.dibujar(entorno, desplazamientoMapa);
        plataformaFlotante1.dibujar(entorno, desplazamientoMapa);
        plataformaFlotante2.dibujar(entorno, desplazamientoMapa);
        
        castillo.dibujar(entorno, desplazamientoMapa);
        if (cajaMagica != null) cajaMagica.dibujar(entorno, desplazamientoMapa);
        
        princesa.dibujar(entorno);

        if (enemigo1 != null) enemigo1.dibujar(entorno, desplazamientoMapa);
        if (enemigo2 != null) enemigo2.dibujar(entorno, desplazamientoMapa);
        
        if (proyectil != null) proyectil.dibujar(entorno);
        if (jefe != null && batallaJefeIniciada) jefe.dibujar(entorno, desplazamientoMapa);
        if (proyectilJefe != null) proyectilJefe.dibujar(entorno);

        int xCorazon = 40;
        for (int i = 0; i < princesa.getVidas(); i++) {
            entorno.dibujarCirculo(xCorazon, 35, 30, Color.RED);
            xCorazon += 45;
        }
    }

    private void reincorporarEnemigosFueraDePantalla() {
        if (enemigo1 != null && (enemigo1.getX() < desplazamientoMapa - 100 || enemigo1.getX() > desplazamientoMapa + 1100)) {
            enemigo1.setX(desplazamientoMapa + 1000);
        }
        if (enemigo2 != null && (enemigo2.getX() < desplazamientoMapa - 100 || enemigo2.getX() > desplazamientoMapa + 1100)) {
            enemigo2.setX(desplazamientoMapa + 1200);
        }
    }

    private void verificarColisionesIndividuales() {
        if (enemigo1 != null) {
            if (princesa.getBounds().intersects(enemigo1.getBoundsReal(desplazamientoMapa))) {
                princesa.perderVida();
                enemigo1.setX(desplazamientoMapa + 1000);
            }
            if (proyectil != null && proyectil.getBounds().intersects(enemigo1.getBoundsReal(desplazamientoMapa))) {
                enemigo1.setX(desplazamientoMapa + 1100);
                proyectil = null;
            }
        }

        if (enemigo2 != null) {
            if (princesa.getBounds().intersects(enemigo2.getBoundsReal(desplazamientoMapa))) {
                princesa.perderVida();
                enemigo2.setX(desplazamientoMapa + 1000);
            }
            if (proyectil != null && proyectil.getBounds().intersects(enemigo2.getBoundsReal(desplazamientoMapa))) {
                enemigo2.setX(desplazamientoMapa + 1300);
                proyectil = null;
            }
        }

        if (jefe != null && proyectil != null && proyectil.getBounds().intersects(jefe.getBoundsReal(desplazamientoMapa))) {
            jefe.perderVida();
            proyectil = null; 
            if (jefe.getVidas() <= 0) jefe = null;
        }

        if (proyectilJefe != null && princesa.getBounds().intersects(proyectilJefe.getBounds())) {
            princesa.perderVida();
            proyectilJefe = null;
        }
    }

    private void verificarCajaMagica() {
        if (cajaMagica != null && !cajaMagica.estaUsada() && princesa.getBounds().intersects(cajaMagica.getBoundsReal(desplazamientoMapa))) {
            princesa.ganarVida();
            cajaMagica.usar();
        }
    }

    public static void main(String[] args) {
        new Juego();
    }
}