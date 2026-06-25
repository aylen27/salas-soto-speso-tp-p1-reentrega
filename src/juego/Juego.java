package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import entidades.Princesa;
import entidades.Plataforma;
import entidades.Enemigo;
import entidades.EnemigoSaltarin; 
import entidades.Proyectil;
import entidades.Castillo;
import entidades.CajaMagica;
import entidades.Jefe;
import entidades.ProyectilEnemigo;
import entidades.Moneda;
import util.Constantes;
import entorno.Entorno;
import entorno.InterfaceJuego;
import javax.swing.ImageIcon;

public class Juego extends InterfaceJuego {
    private Entorno entorno;
    private Princesa princesa;
    private int cooldownMuerte = 0;
    
    // Bloques de piso
    private Plataforma piso1;
    private Plataforma piso2;
    private Plataforma piso3;
    private Plataforma piso4;
    private Plataforma piso5;
    private Plataforma piso6;
    private Plataforma piso7;
    private Plataforma piso8;
    private Plataforma piso9;
    private Plataforma piso10;
    private Plataforma piso11;
    private Plataforma piso12;
    private Plataforma piso13;
    private Plataforma piso14;
    private Plataforma piso15;
    private Plataforma piso16;
    private Plataforma piso17;
    private Plataforma piso18;
    private Plataforma piso19;
    private Plataforma piso20;
    private Plataforma piso21;
    private Plataforma piso22;
    private Plataforma piso23;
    private Plataforma piso24;

    // Plataformas flotantes
    private Plataforma plataforma1;
    private Plataforma plataforma2;
    private Plataforma plataforma3;
    private Plataforma plataforma4;
    private Plataforma plataforma5;
    private Plataforma plataforma6;
    private Plataforma plataforma7;
    private Plataforma plataforma8;
    private Plataforma plataforma9;
    private Plataforma plataforma10;
    private Plataforma plataforma11;
    private Plataforma plataforma12;
    private Plataforma plataforma13;
    private Plataforma plataforma14;
    private Plataforma plataforma15;

    // Enemigos comunes
    private Enemigo enemigo1;
    private Enemigo enemigo2;
    private Enemigo enemigo3;
    private Enemigo enemigo4;
    private Enemigo enemigo5;
    
    private int spawnEnemigo1 = 900;
    private int spawnEnemigo2 = 1300;
    private int spawnEnemigo3 = 1700;
    private int spawnEnemigo4 = 2100;
    private int spawnEnemigo5 = 2500;
    
    // Enemigo dinámico saltarín
    private EnemigoSaltarin saltarin1;
    
    private Proyectil proyectil;

    private ProyectilEnemigo disparoJefe1;
    private ProyectilEnemigo disparoJefe2;
    private ProyectilEnemigo disparoJefe3;
    
    private Castillo castillo;
    private CajaMagica cajaMagica;
    private Jefe jefe;
    
    // Variables de control
    private int desplazamientoMapa;
    private boolean ganado;
    private boolean perdido;
    private boolean batallaJefeIniciada;
    
    private Image fondo;
    private Image gifVictoria;
    private boolean victoriaIniciada = false;
    private Image gifDerrota;
    private boolean mostrandoAnimacionVictoria = false;
    private long inicioAnimacionVictoria;
    private Image gifPrincesaCastillo;
    private Image iconoCorazon;
    
    private Moneda moneda1;
    private Moneda moneda2;
    private Moneda moneda3;
    private Image iconoMonedaInterfaz;

    private int puntaje;
    
    private boolean menu = true;
    
    private int cicloMonedas = 0;
    private int cicloEnemigos = 0;
    
    public Juego() {
        this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
        inicializar();
        this.entorno.iniciar();
    }

    @Override
    public void tick() {
    	
    	if(menu){

    	    entorno.dibujarRectangulo(
    	            400,300,
    	            800,600,
    	            0,
    	            Color.BLACK);

    	    entorno.cambiarFont(
    	            "Arial",
    	            50,
    	            Color.YELLOW);

    	    entorno.escribirTexto(
    	            "PRINCESS QUEST",
    	            220,
    	            200);

    	    entorno.cambiarFont(
    	            "Arial",
    	            30,
    	            Color.WHITE);

    	    entorno.escribirTexto(
    	            "Presiona ENTER para jugar",
    	            220,
    	            350);

    	    if(entorno.sePresiono(
    	            entorno.TECLA_ENTER))
    	        menu = false;

    	    return;
    	}
    	
        if (cooldownMuerte > 0) {
            cooldownMuerte--;
        }

        manejarMovimiento();

        princesa.actualizar(
            piso1,  piso2, piso3, piso4,  piso5, piso6,  piso7, piso8,    
            piso9, piso10, piso11, piso12, piso13, piso14, piso15,
            piso16, piso17, piso18, piso19, piso20, piso21,
            plataforma1, plataforma2, plataforma3, plataforma4, plataforma5, plataforma6,
            plataforma7, plataforma8, plataforma9, plataforma10, plataforma11, plataforma12,
            plataforma13, plataforma14, plataforma15, desplazamientoMapa
        );

        if (desplazamientoMapa >= 2900) {
            batallaJefeIniciada = true;
        }

        // Actualizar jefe si la batalla empezó
        if (batallaJefeIniciada && jefe != null) {
            jefe.actualizar();
            ProyectilEnemigo nuevoDisparo = jefe.intentarAtacar(princesa.getX(), princesa.getY(), desplazamientoMapa);
            if (nuevoDisparo != null) {
                if (disparoJefe1 == null) disparoJefe1 = nuevoDisparo;
                else if (disparoJefe2 == null) disparoJefe2 = nuevoDisparo;
                else if (disparoJefe3 == null) disparoJefe3 = nuevoDisparo;
            }
        } else {
            generarEnemigos();
        }

        actualizarEnemigos();
        actualizarProyectil();
        actualizarProyectilesJefe();
        verificarColisiones();
        verificarCajaMagica();
        verificarMonedas();
        if (moneda1 != null && moneda1.getBounds(desplazamientoMapa).x < -50) {
            moneda1 = new Moneda(desplazamientoMapa + 900 + (cicloMonedas * 120), 150 + ((cicloMonedas % 3) * 100));
        }

        if (moneda2 != null && moneda2.getBounds(desplazamientoMapa).x < -50) {
            moneda2 = new Moneda(desplazamientoMapa + 1200 + (cicloMonedas * 150), 150 + (((cicloMonedas + 1) % 3) * 100));
        }

        if (moneda3 != null && moneda3.getBounds(desplazamientoMapa).x < -50) {
            moneda3 = new Moneda(desplazamientoMapa + 1500 + (cicloMonedas * 180), 150 + (((cicloMonedas + 2) % 3) * 100));
        }

        cicloMonedas++;
        
        verificarVictoria();
        verificarDerrota();
        
        dibujarJuego();
    }
    
    private void inicializar() {
        ImageIcon iconoFondo = new ImageIcon("img/fondo.jpg");
        fondo = iconoFondo.getImage();

        princesa = new Princesa(400, 200);

        crearPlataformas();

        castillo = new Castillo(3500, 280);
        
        cajaMagica = new CajaMagica(1200, 450); 
        
        enemigo1 = new Enemigo(900, 200, -1);   // Altura 200 (Aire)
        enemigo2 = new Enemigo(1400, 300, -1);  // Altura 300 (Aire medio)
        enemigo3 = new Enemigo(1900, 150, -1);  // Altura 150 (Alto)
        enemigo4 = new Enemigo(2400, 250, -1);  // Altura 250 (Aire medio)
        enemigo5 = new Enemigo(2900, 320, -1);
        saltarin1 = new EnemigoSaltarin(1500, 500); // Este sí va en el suelo
        jefe = new Jefe(3350, 250);
        
        jefe = new Jefe(3350, 250);

        batallaJefeIniciada = false;
        
        gifDerrota = new ImageIcon("img/gameover.gif").getImage();
        gifPrincesaCastillo =new ImageIcon("img/princesaCastillo2.gif").getImage();
        gifVictoria = new ImageIcon("img/ganaste.gif").getImage();
        iconoCorazon = new ImageIcon("img/vida.png").getImage(); 
    
        //Monedas para que la princesa agarre
        moneda1 = new Moneda(800,250);
        moneda2 = new Moneda(1500,200);
        moneda3 = new Moneda(2300,150);

        puntaje = 0;
        iconoMonedaInterfaz = new ImageIcon("img/moneda.png").getImage();
    
    }
    
    private void reiniciarJuego() {
        desplazamientoMapa = 0;
        perdido = false;
        batallaJefeIniciada = false;
        
        princesa = new Princesa(400, 200);
        crearPlataformas();
        
        castillo = new Castillo(3500, 280);
        cajaMagica = new CajaMagica(1200, 450); // Se reinicia también la caja mágica
        jefe = new Jefe(3350, 250);
        
     // Reiniciar enemigos flotantes
        enemigo1 = new Enemigo(900, 200, -1);
        enemigo2 = new Enemigo(1400, 300, -1);
        enemigo3 = new Enemigo(1900, 150, -1);
        enemigo4 = new Enemigo(2400, 250, -1);
        enemigo5 = new Enemigo(2900, 320, -1);
        
        saltarin1 = new EnemigoSaltarin(1500, 500);
        proyectil = null;
        disparoJefe1 = null; disparoJefe2 = null; disparoJefe3 = null;
    
        moneda1 = new Moneda(800,250);
        moneda2 = new Moneda(1500,200);
        moneda3 = new Moneda(2300,150);

        puntaje = 0;
    }
    
    public void crearPlataformas() {
        Random random = new Random();
        
        piso1 = new Plataforma(0, 540, 300, 40);
        piso2 = new Plataforma(290, 540, 300, 40);
        piso3 = new Plataforma(580, 540, 300, 40);
        
        piso4 = new Plataforma(1000, 540, 300, 40);
        piso5 = new Plataforma(1290, 540, 300, 40);
        
        piso6 = new Plataforma(1720, 540, 300, 40);
        piso7 = new Plataforma(2010, 540, 300, 40);
        
        piso8 = new Plataforma(2440, 540, 300, 40);
        piso9 = new Plataforma(2730, 540, 300, 40);
        
        piso10 = new Plataforma(3020, 540, 300, 40);
        piso11 = new Plataforma(3310, 540, 300, 40);
        piso12 = new Plataforma(3600, 540, 300, 40);
        piso13 = new Plataforma(3890, 540, 300, 40);
        piso14 = new Plataforma(4180, 540, 300, 40);
        piso15 = new Plataforma(4470, 540, 300, 40);
        
        piso16 = new Plataforma(99000, 540, 10, 10);
        piso17 = new Plataforma(99000, 540, 10, 10);
        piso18 = new Plataforma(99000, 540, 10, 10);
        piso19 = new Plataforma(99000, 540, 10, 10);
        piso20 = new Plataforma(99000, 540, 10, 10);
        piso21 = new Plataforma(99000, 540, 10, 10);
        piso22 = new Plataforma(99000, 540, 10, 10);
        piso23 = new Plataforma(99000, 540, 10, 10);
        piso24 = new Plataforma(99000, 540, 10, 10);
        
        plataforma1 = new Plataforma(250 + random.nextInt(100), 450, 150 + random.nextInt(80), 30);
        plataforma2 = new Plataforma(550 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma3 = new Plataforma(850 + random.nextInt(100), 270, 150 + random.nextInt(80), 30);
        plataforma4 = new Plataforma(1150 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma5 = new Plataforma(1450 + random.nextInt(100), 450, 150 + random.nextInt(80), 30);
        plataforma6 = new Plataforma(1750 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma7 = new Plataforma(2050 + random.nextInt(100), 270, 150 + random.nextInt(80), 30);
        plataforma8 = new Plataforma(2350 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma9 = new Plataforma(2650 + random.nextInt(100), 450, 150 + random.nextInt(80), 30);
        plataforma10 = new Plataforma(2950 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma11 = new Plataforma(3250 + random.nextInt(100), 270, 150 + random.nextInt(80), 30);
        plataforma12 = new Plataforma(3550 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
        plataforma13 = new Plataforma(3850 + random.nextInt(100), 450, 150 + random.nextInt(80), 30);
        plataforma14 = new Plataforma(4150 + random.nextInt(100), 270, 150 + random.nextInt(80), 30);
        plataforma15 = new Plataforma(4450 + random.nextInt(100), 360, 150 + random.nextInt(80), 30);
    }

    public void manejarMovimiento() {
        princesa.detener();

        if ((entorno.estaPresionada(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada('a')) 
                && princesa.getX() > 0) {
            princesa.moverIzquierda();
        }

        if (entorno.estaPresionada(entorno.TECLA_DERECHA) || entorno.estaPresionada('d')) {
            if (princesa.getX() >= 400 && desplazamientoMapa < 2900) {
                desplazamientoMapa += 5;
            } else {
                if (princesa.getX() < 760) {
                    princesa.moverDerecha();
                }
            }
        }

        if (entorno.sePresiono(entorno.TECLA_ESPACIO) 
                || entorno.sePresiono('w') 
                || entorno.sePresiono(entorno.TECLA_ARRIBA)) {
            princesa.saltar();
        }

        if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && proyectil == null) {
            proyectil = new Proyectil(
                    princesa.getX() + 25,
                    princesa.getY() + 25,
                    entorno.mouseX(),
                    entorno.mouseY());
        }
    }

    public void generarEnemigos() {
        if (enemigo1 == null) enemigo1 = new Enemigo(desplazamientoMapa + 900, 300, -1);
        if (enemigo2 == null) enemigo2 = new Enemigo(desplazamientoMapa + 1300, 250, -1);
        if (enemigo3 == null) enemigo3 = new Enemigo(desplazamientoMapa + 1700, 350, -1);
        if (enemigo4 == null) enemigo4 = new Enemigo(desplazamientoMapa + 2100, 300, -1);
        if (enemigo5 == null) enemigo5 = new Enemigo(desplazamientoMapa + 2500, 250, -1);
        
        if (saltarin1 == null && desplazamientoMapa < 2000) {
            saltarin1 = new EnemigoSaltarin(1500, 300);
        }
    }
    
    public void actualizarEnemigos() {

        cicloEnemigos++;

        // ENEMIGO 1
        if (enemigo1 != null) {
            enemigo1.actualizar();
            if (enemigo1.getBoundsReal(desplazamientoMapa).x < -50) {
                enemigo1 = new Enemigo(desplazamientoMapa + 900, 200, -1);
            }
        }

        // ENEMIGO 2
        if (enemigo2 != null) {
            enemigo2.actualizar();
            if (enemigo2.getBoundsReal(desplazamientoMapa).x < -50) {
                enemigo2 = new Enemigo(desplazamientoMapa + 1100, 300, -1);
            }
        }

        // ENEMIGO 3
        if (enemigo3 != null) {
            enemigo3.actualizar();
            if (enemigo3.getBoundsReal(desplazamientoMapa).x < -50) {
                enemigo3 = new Enemigo(desplazamientoMapa + 1300, 150, -1);
            }
        }

        // ENEMIGO 4
        if (enemigo4 != null) {
            enemigo4.actualizar();
            if (enemigo4.getBoundsReal(desplazamientoMapa).x < -50) {
                enemigo4 = new Enemigo(desplazamientoMapa + 1500, 250, -1);
            }
        }

        // ENEMIGO 5
        if (enemigo5 != null) {
            enemigo5.actualizar();
            if (enemigo5.getBoundsReal(desplazamientoMapa).x < -50) {
                enemigo5 = new Enemigo(desplazamientoMapa + 1700, 320, -1);
            }
        }

        // SALTARÍN
        if (saltarin1 != null) {
            saltarin1.actualizar(piso1);

            if (saltarin1.getBoundsReal(desplazamientoMapa).x < -50) {
                int nuevaX = desplazamientoMapa + 800 + (cicloEnemigos * 200 % 600);
                saltarin1 = new EnemigoSaltarin(nuevaX, 100);
            }
        }
    }
    
    public void actualizarProyectil() {
        if (proyectil != null) {
            proyectil.actualizar();
            if (proyectil.getX() < 0 || proyectil.getX() > Constantes.ANCHO || proyectil.getY() < 0 || proyectil.getY() > Constantes.ALTO) {
                proyectil = null;
            }
        }
    }

    public void actualizarProyectilesJefe() {
        if (disparoJefe1 != null) disparoJefe1.actualizar();
        if (disparoJefe2 != null) disparoJefe2.actualizar();
        if (disparoJefe3 != null) disparoJefe3.actualizar();
    }

    public void verificarColisiones() {

    		int baseY = 150;

    		if (enemigo1 != null) {
    			if (princesa.getBounds().intersects(enemigo1.getBoundsReal(desplazamientoMapa))) {
    				princesa.perderVida();
    				enemigo1 = new Enemigo(desplazamientoMapa + 900, baseY, -1);
    			}
    		}
        

    		if (enemigo2 != null) {
    		    if (princesa.getBounds().intersects(enemigo2.getBoundsReal(desplazamientoMapa))) {
    		        princesa.perderVida();
    		        enemigo2 = new Enemigo(desplazamientoMapa + 1100, baseY + 100, -1);
    		    }
    		}

    		if (enemigo3 != null) {
    		    if (princesa.getBounds().intersects(enemigo3.getBoundsReal(desplazamientoMapa))) {
    		        princesa.perderVida();
    		        enemigo3 = new Enemigo(desplazamientoMapa + 1300, baseY + 200, -1);
    		    }
    		}


    		if (enemigo4 != null) {
    		    if (princesa.getBounds().intersects(enemigo4.getBoundsReal(desplazamientoMapa))) {
    		        princesa.perderVida();
    		        enemigo4 = new Enemigo(desplazamientoMapa + 1500, baseY + 100, -1);
    		    }
    		}

    		if (enemigo5 != null) {
    		    if (princesa.getBounds().intersects(enemigo5.getBoundsReal(desplazamientoMapa))) {
    		        princesa.perderVida();
    		        enemigo5 = new Enemigo(desplazamientoMapa + 1700, baseY + 200, -1);
    		    }
    		}
        
        if (saltarin1 != null) {
            if (princesa.getBounds().intersects(saltarin1.getBoundsReal(desplazamientoMapa))) { 
                princesa.perderVida(); 
                
                // Re-spawn inmediato adelante
                int nuevaX = desplazamientoMapa + 800 + (cicloEnemigos * 200 % 600);
                saltarin1 = new EnemigoSaltarin(nuevaX, 100); 
            }
            else if (proyectil != null && proyectil.getBounds().intersects(saltarin1.getBoundsReal(desplazamientoMapa))) { 
                puntaje += 150; // El saltarín da más puntos por ser más difícil
                proyectil = null; 
                
                // Re-spawn inmediato adelante
                int nuevaX = desplazamientoMapa + 800 + (cicloEnemigos * 200 % 600);
                saltarin1 = new EnemigoSaltarin(nuevaX, 100); 
            }
        }

        if (jefe != null && proyectil != null) {
            if (proyectil.getBounds().intersects(jefe.getBoundsReal(desplazamientoMapa))) {
                jefe.perderVida(); proyectil = null;
                if (jefe.getVidas() <= 0) jefe = null;
            }
        }
        if (disparoJefe1 != null && princesa.getBounds().intersects(disparoJefe1.getBounds())) { princesa.perderVida(); disparoJefe1 = null; }
        if (disparoJefe2 != null && princesa.getBounds().intersects(disparoJefe2.getBounds())) { princesa.perderVida(); disparoJefe2 = null; }
        if (disparoJefe3 != null && princesa.getBounds().intersects(disparoJefe3.getBounds())) { princesa.perderVida(); disparoJefe3 = null; }
    }
    
    public void verificarCajaMagica() {
        if (cajaMagica != null && !cajaMagica.estaUsada() && princesa.getBounds().intersects(cajaMagica.getBoundsReal(desplazamientoMapa))) {
            princesa.ganarVida();
            int xCaja = 500 + (cicloEnemigos * 300 % (Constantes.LARGO_MAPA - 1000));
            int nivel = cicloEnemigos % 3;
            int yCaja = (nivel == 0) ? 450 : (nivel == 1) ? 360 : 270;
            cajaMagica = new CajaMagica(xCaja, yCaja);
        }
    }
    
    public void verificarMonedas() {
    		if (moneda1 != null && princesa.getBounds().intersects(moneda1.getBounds(desplazamientoMapa))) {
    			puntaje += 100;
    			moneda1 = new Moneda(desplazamientoMapa + 800 + (cicloMonedas * 120), 150);
    		}

    		if (moneda2 != null && princesa.getBounds().intersects(moneda2.getBounds(desplazamientoMapa))) {
    	    		puntaje += 100;
    	    		moneda2 = new Moneda(desplazamientoMapa + 1100 + (cicloMonedas * 150), 250);
    		}

    		if (moneda3 != null && princesa.getBounds().intersects(moneda3.getBounds(desplazamientoMapa))) {
    			puntaje += 100;
    			moneda3 = new Moneda(desplazamientoMapa + 1400 + (cicloMonedas * 180), 350);
    		}
    }
    
    public void verificarVictoria() {

        if (!victoriaIniciada &&
            jefe == null &&
            princesa.getBounds().intersects(
                castillo.getBoundsReal(desplazamientoMapa))) {

            victoriaIniciada = true;
            mostrandoAnimacionVictoria = true;
            inicioAnimacionVictoria = System.currentTimeMillis();
        }
    }

    public void verificarDerrota() {
        if (princesa.getY() > Constantes.ALTO) {
            princesa.perderVida(); princesa.setX(400); princesa.setY(200);
        }
        if (princesa.getVidas() <= 0) perdido = true;
    }
    

    
    public void dibujarJuego() {
    	
    	if (mostrandoAnimacionVictoria) {

    	    long tiempo =
    	            System.currentTimeMillis() - inicioAnimacionVictoria;

    	    entorno.dibujarRectangulo(
	                400, 300,
	                800, 600,
	                0,
	                Color.BLACK);
    	    
    	    // Primeros 4 segundos: princesa entra al castillo
    	    if (tiempo < 10900) {

    	        entorno.dibujarImagen(
    	                gifPrincesaCastillo,
    	                400,
    	                300,
    	                0,
    	                0.6);

    	    } else {

    	        entorno.dibujarImagen(
    	                gifVictoria,
    	                400,
    	                300,
    	                0,
    	                0.4); // más chico porque el gif original es enorme

    	        entorno.cambiarFont("Arial", 24, Color.YELLOW);
    	        entorno.escribirTexto(
    	                "¡Ganaste! Presioná 'R' para volver a jugar",
    	                180,
    	                550);

    	        if (entorno.estaPresionada('r')) {
    	            reiniciarJuego();
    	        }
    	    }

    	    return;
    	}
    	
        if (perdido) {
            entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.BLACK);
            entorno.dibujarImagen(gifDerrota, 400, 300, 0, 0.4);
            
            entorno.cambiarFont("Arial", 24, Color.WHITE);
            entorno.escribirTexto("Presioná 'R' para volver a jugar", 240, 480);
            
            if (entorno.estaPresionada('r')) {
                reiniciarJuego();
            }
            return;
        }
        

        // Fondo fijo centrado impecable sin cortes bruscos
        double escala = Math.max(800.0 / fondo.getWidth(null), 600.0 / fondo.getHeight(null));
        entorno.dibujarImagen(fondo, 400, 300, 0, escala);
        
        piso1.dibujar(entorno, desplazamientoMapa);
        piso2.dibujar(entorno, desplazamientoMapa);
        piso3.dibujar(entorno, desplazamientoMapa);
        piso4.dibujar(entorno, desplazamientoMapa);
        piso5.dibujar(entorno, desplazamientoMapa);
        piso6.dibujar(entorno, desplazamientoMapa);
        piso7.dibujar(entorno, desplazamientoMapa);
        piso8.dibujar(entorno, desplazamientoMapa);
        piso9.dibujar(entorno, desplazamientoMapa);
        piso10.dibujar(entorno, desplazamientoMapa);
        piso11.dibujar(entorno, desplazamientoMapa);
        piso12.dibujar(entorno, desplazamientoMapa);
        piso13.dibujar(entorno, desplazamientoMapa); 
        piso14.dibujar(entorno, desplazamientoMapa);
        piso15.dibujar(entorno, desplazamientoMapa);
        piso16.dibujar(entorno, desplazamientoMapa);
        piso17.dibujar(entorno, desplazamientoMapa);
        piso18.dibujar(entorno, desplazamientoMapa);
        piso19.dibujar(entorno, desplazamientoMapa);
        piso20.dibujar(entorno, desplazamientoMapa);
        piso21.dibujar(entorno, desplazamientoMapa);
        piso22.dibujar(entorno, desplazamientoMapa);
        piso23.dibujar(entorno, desplazamientoMapa);
        piso24.dibujar(entorno, desplazamientoMapa);
       
        plataforma1.dibujar(entorno, desplazamientoMapa);
        plataforma2.dibujar(entorno, desplazamientoMapa);
        plataforma3.dibujar(entorno, desplazamientoMapa);
        plataforma4.dibujar(entorno, desplazamientoMapa);
        plataforma5.dibujar(entorno, desplazamientoMapa);
        plataforma6.dibujar(entorno, desplazamientoMapa);
        plataforma7.dibujar(entorno, desplazamientoMapa);
        plataforma8.dibujar(entorno, desplazamientoMapa);
        plataforma9.dibujar(entorno, desplazamientoMapa);
        plataforma10.dibujar(entorno, desplazamientoMapa);
        plataforma11.dibujar(entorno, desplazamientoMapa);
        plataforma12.dibujar(entorno, desplazamientoMapa);
        plataforma13.dibujar(entorno, desplazamientoMapa);
        plataforma14.dibujar(entorno, desplazamientoMapa);
        plataforma15.dibujar(entorno, desplazamientoMapa);
        
        if (castillo != null) castillo.dibujar(entorno, desplazamientoMapa);
        if (cajaMagica != null) cajaMagica.dibujar(entorno, desplazamientoMapa);

        if (moneda1 != null) moneda1.dibujar(entorno, desplazamientoMapa);
        if (moneda2 != null) moneda2.dibujar(entorno, desplazamientoMapa);
        if (moneda3 != null) moneda3.dibujar(entorno, desplazamientoMapa);
        
        if (enemigo1 != null) enemigo1.dibujar(entorno, desplazamientoMapa);
        if (enemigo2 != null) enemigo2.dibujar(entorno, desplazamientoMapa);
        if (enemigo3 != null) enemigo3.dibujar(entorno, desplazamientoMapa);
        if (enemigo4 != null) enemigo4.dibujar(entorno, desplazamientoMapa);
        if (enemigo5 != null) enemigo5.dibujar(entorno, desplazamientoMapa);
        
        if (saltarin1 != null) saltarin1.dibujar(entorno, desplazamientoMapa);
        
        if (jefe != null) {
            jefe.dibujar(entorno, desplazamientoMapa);
        }
        
        if (proyectil != null) proyectil.dibujar(entorno);
        if (disparoJefe1 != null) disparoJefe1.dibujar(entorno);
        if (disparoJefe2 != null) disparoJefe2.dibujar(entorno);
        if (disparoJefe3 != null) disparoJefe3.dibujar(entorno);

        princesa.dibujar(entorno);

        for (int i = 0; i < princesa.getVidas(); i++) {
            int posicionX = 25 + (i * 35); 
            entorno.dibujarImagen(iconoCorazon, posicionX, 30, 0, 0.01);
        }
        
        entorno.dibujarImagen(iconoMonedaInterfaz, 630, 30, 0, 0.01); 
        
        // Dibujamos el número del puntaje justo al lado de la moneda (X = 660)
        entorno.cambiarFont("Arial", 24, Color.YELLOW); 
        entorno.escribirTexto("" + puntaje, 660, 40);
    }

    public static void main(String[] args) {
        new Juego();
    }
}