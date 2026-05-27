package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import entidades.Castillo;
import entidades.Enemigo;
import entidades.Plataforma;
import entidades.Princesa;
import entidades.Proyectil;
import util.Constantes;

public class PanelJuego extends JPanel implements Runnable {

    private Thread hilo;

    private Princesa princesa;

    private ArrayList<Plataforma> plataformas;

    private Enemigo[] enemigos;

    private Proyectil proyectil;

    private Castillo castillo;

    private Teclado teclado;
    private Mouse mouse;

    private int desplazamientoMapa;

    private boolean ganado;
    private boolean perdido;

    public PanelJuego() {

        setPreferredSize(new Dimension(Constantes.ANCHO, Constantes.ALTO));

        setBackground(Color.CYAN);

        teclado = new Teclado();
        mouse = new Mouse();

        addKeyListener(teclado);
        addMouseListener(mouse);

        setFocusable(true);

        inicializar();
    }

    public void inicializar() {

        princesa = new Princesa(400, 200);

        plataformas = new ArrayList<>();

        crearPlataformas();

        enemigos = new Enemigo[Constantes.MAX_ENEMIGOS];

        castillo = new Castillo(Constantes.LARGO_MAPA - 300, 320);
    }

    public void crearPlataformas() {

        int x = 0;

        while (x < Constantes.LARGO_MAPA) {

            plataformas.add(new Plataforma(x, 500, 200, 40));

            x += 280;
        }

        Random random = new Random();

        for (int i = 0; i < 20; i++) {

            int px = 300 + random.nextInt(Constantes.LARGO_MAPA - 500);

            int py = 200 + random.nextInt(200);

            plataformas.add(new Plataforma(px, py, 150, 30));
        }
    }

    public void iniciarHilo() {

        hilo = new Thread(this);

        hilo.start();
    }

    @Override
    public void run() {

        while (true) {

            actualizar();

            repaint();

            try {

                Thread.sleep(1000 / Constantes.FPS);
            }
            catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public void actualizar() {

        if (ganado || perdido) {

            return;
        }

        manejarMovimiento();

        princesa.actualizar(plataformas);

        generarEnemigos();

        actualizarEnemigos();

        actualizarProyectil();

        verificarColisiones();

        verificarVictoria();

        verificarDerrota();
    }

    public void manejarMovimiento() {

        princesa.detener();

        if (teclado.izquierda) {

            princesa.moverIzquierda();
        }

        if (teclado.derecha) {

            princesa.moverDerecha();

            desplazamientoMapa += 5;
        }

        if (teclado.salto) {

            princesa.saltar();
        }

        if (mouse.click && proyectil == null) {

            proyectil = new Proyectil(
                    princesa.getX() + 25,
                    princesa.getY() + 25,
                    mouse.x,
                    mouse.y);

            mouse.click = false;
        }
    }

    public void generarEnemigos() {

        Random random = new Random();

        for (int i = 0; i < enemigos.length; i++) {

            if (enemigos[i] == null) {

                int lado = random.nextInt(2);

                int x;
                int direccion;

                if (lado == 0) {

                    x = desplazamientoMapa - 100;

                    direccion = 1;
                }
                else {

                    x = desplazamientoMapa + Constantes.ANCHO + 100;

                    direccion = -1;
                }

                int y = 100 + random.nextInt(300);

                enemigos[i] = new Enemigo(x, y, direccion);

                break;
            }
        }
    }

    public void actualizarEnemigos() {

        for (int i = 0; i < enemigos.length; i++) {

            if (enemigos[i] != null) {

                enemigos[i].actualizar();

                if (enemigos[i].getX() < desplazamientoMapa - 300
                        || enemigos[i].getX() > desplazamientoMapa + 1400) {

                    enemigos[i] = null;
                }
            }
        }
    }

    public void actualizarProyectil() {

        if (proyectil != null) {

            proyectil.actualizar();

            if (proyectil.getX() < 0
                    || proyectil.getX() > Constantes.ANCHO
                    || proyectil.getY() < 0
                    || proyectil.getY() > Constantes.ALTO) {

                proyectil = null;
            }
        }
    }

    public void verificarColisiones() {

        for (int i = 0; i < enemigos.length; i++) {

            if (enemigos[i] != null) {

                if (princesa.getBounds().intersects(enemigos[i].getBounds())) {

                    princesa.perderVida();

                    enemigos[i] = null;
                }

                if (proyectil != null
                        && proyectil.getBounds().intersects(enemigos[i].getBounds())) {

                    enemigos[i] = null;

                    proyectil = null;
                }
            }
        }
    }

    public void verificarVictoria() {

        if (princesa.getBounds().intersects(castillo.getBounds())) {

            ganado = true;
        }
    }

    public void verificarDerrota() {

        if (princesa.getY() > Constantes.ALTO) {

            princesa.perderVida();
        }

        if (princesa.getVidas() <= 0) {

            perdido = true;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        dibujar(g);
    }

    public void dibujar(Graphics g) {

        for (Plataforma p : plataformas) {

            p.dibujar(g, desplazamientoMapa);
        }

        castillo.dibujar(g, desplazamientoMapa);

        princesa.dibujar(g);

        for (Enemigo e : enemigos) {

            if (e != null) {

                e.dibujar(g, desplazamientoMapa);
            }
        }

        if (proyectil != null) {

            proyectil.dibujar(g);
        }

        g.setColor(Color.WHITE);

        g.setFont(new Font("Arial", Font.BOLD, 24));

        g.drawString("Vidas: " + princesa.getVidas(), 20, 40);

        if (ganado) {

            g.setFont(new Font("Arial", Font.BOLD, 50));

            g.drawString("GANASTE", 350, 250);
        }

        if (perdido) {

            g.setFont(new Font("Arial", Font.BOLD, 50));

            g.drawString("GAME OVER", 300, 250);
        }
    }
}