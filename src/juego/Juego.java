package juego;

<<<<<<< HEAD
=======

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import entidades.Princesa;
import entidades.Plataforma;
import entidades.Enemigo;
<<<<<<< HEAD
import entidades.EnemigoSaltarin; 
=======
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
import entidades.Proyectil;
import entidades.Castillo;
import entidades.CajaMagica;
import entidades.Jefe;
import entidades.ProyectilEnemigo;
import util.Constantes;
import entorno.Entorno;
import entorno.InterfaceJuego;
import javax.swing.ImageIcon;

<<<<<<< HEAD
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
=======


public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Princesa princesa;
	
	private int cooldownMuerte = 0;
	private Plataforma piso;
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

	private Enemigo enemigo1;
	private Enemigo enemigo2;
	private Enemigo enemigo3;
	private Enemigo enemigo4;
	private Enemigo enemigo5;
	
	private Proyectil proyectil;

	private ProyectilEnemigo disparoJefe1;
	private ProyectilEnemigo disparoJefe2;
	private ProyectilEnemigo disparoJefe3;
	
	private Castillo castillo;
	private CajaMagica cajaMagica;
	private Jefe jefe;
	// Variables de control
    private int desplazamientoMapa;

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
    private boolean ganado;
    private boolean perdido;
    private boolean batallaJefeIniciada;
    
<<<<<<< HEAD
    private Image fondo;
    private Image gifVictoria;
    private Image gifDerrota;
    private Image iconoCorazon;
    
    public Juego() {
        this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
        inicializar();
        this.entorno.iniciar();
    }

    @Override
    public void tick() {
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
        
        // 🎯 Inicializamos la caja mágica en una posición visible del mapa
        cajaMagica = new CajaMagica(1200, 450); 

        jefe = new Jefe(3350, 250);

        batallaJefeIniciada = false;
        
        gifDerrota = new ImageIcon("img/gameover.gif").getImage();
        gifVictoria = new ImageIcon("img/ganaste.gif").getImage();
        iconoCorazon = new ImageIcon("img/vida.png").getImage(); 
    }
    
    private void reiniciarJuego() {
        desplazamientoMapa = 0;
        ganado = false;
        perdido = false;
        batallaJefeIniciada = false;
        
        princesa = new Princesa(400, 200);
        crearPlataformas();
        
        castillo = new Castillo(3500, 280);
        cajaMagica = new CajaMagica(1200, 450); // Se reinicia también la caja mágica
        jefe = new Jefe(3350, 250);
        
        enemigo1 = null; enemigo2 = null; enemigo3 = null; enemigo4 = null; enemigo5 = null;
        saltarin1 = null;
        proyectil = null;
        disparoJefe1 = null; disparoJefe2 = null; disparoJefe3 = null;
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
        if (enemigo1 != null) enemigo1.actualizar();
        if (enemigo2 != null) enemigo2.actualizar();
        if (enemigo3 != null) enemigo3.actualizar();
        if (enemigo4 != null) enemigo4.actualizar();
        if (enemigo5 != null) enemigo5.actualizar();
        
        if (saltarin1 != null) saltarin1.actualizar(piso1); 
    }
    
    public void actualizarProyectil() {
        if (proyectil != null) {
            proyectil.actualizar();
            if (proyectil.getX() < 0 || proyectil.getX() > Constantes.ANCHO || proyectil.getY() < 0 || proyectil.getY() > Constantes.ALTO) {
=======
    private boolean izquierda;
    private boolean derecha;
    private boolean salto;

    private boolean clickMouse;
    private int mouseX;
    private int mouseY;
    private Image fondo;
    private Image iconoCorazon;
    private Image gifVictoria;
    private Image gifDerrota;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
        
		inicializar();
		
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();

	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	@Override
	public void tick() {
		
		if (cooldownMuerte > 0) {
		    cooldownMuerte--;
		}

	    // Movimiento
	    manejarMovimiento();

	    // Actualizar princesa
	    princesa.actualizar(
	            piso1,  piso2, piso3,
	            piso4,  piso5,
	            piso6,  piso7, piso8,    
	            piso9, piso10, piso11, piso12,
	            piso13, piso14, piso15,
	            piso16, piso17, piso18, 
	            piso19, piso20, piso21,
	            plataforma1, plataforma2, plataforma3,
	            plataforma4, plataforma5, plataforma6,
	            plataforma7, plataforma8, plataforma9,
	            plataforma10, plataforma11, plataforma12,
	            plataforma13, plataforma14, plataforma15,
	            desplazamientoMapa
	        );

	    // Activar jefe al final del mapa
	    if (desplazamientoMapa >= Constantes.LARGO_MAPA
	            - Constantes.ANCHO - 100) {

	        batallaJefeIniciada = true;
	    }

	    // Lógica del jefe
	    if (batallaJefeIniciada && jefe != null) {

	        jefe.actualizar();

	        ProyectilEnemigo nuevoDisparo =
	                jefe.intentarAtacar(
	                        princesa.getX(),
	                        princesa.getY(),
	                        desplazamientoMapa);

	        if (nuevoDisparo != null) {

	        	if (disparoJefe1 == null) {
	        	    disparoJefe1 = nuevoDisparo;
	        	}
	        	else if (disparoJefe2 == null) {
	        	    disparoJefe2 = nuevoDisparo;
	        	}
	        	else if (disparoJefe3 == null) {
	        	    disparoJefe3 = nuevoDisparo;
	        	}
	        }

	    } else {

	        generarEnemigos();
	    }

	    // Actualizaciones generales
	    actualizarEnemigos();
	    actualizarProyectil();
	    actualizarProyectilesJefe();

	    // Colisiones
	    verificarColisiones();

	    // Caja mágica
	    verificarCajaMagica();

	    // Fin del juego
	    verificarVictoria();
	    verificarDerrota();
	    
	    dibujarJuego();
	}
	
	private void inicializar() {
		
		ImageIcon iconoFondo = new ImageIcon("img/fondo.jpg");
		fondo = iconoFondo.getImage();

		princesa = new Princesa(400, 200);

		crearPlataformas();

	    castillo = new Castillo(
	            Constantes.LARGO_MAPA - 300,
	            280);

	    jefe = new Jefe(
	            Constantes.LARGO_MAPA - 600,
	            250);

	    batallaJefeIniciada = false;
	    
	    gifDerrota = new ImageIcon("img/gameover.gif").getImage();
	    gifVictoria = new ImageIcon("img/ganaste.gif").getImage();
	}
	
	// Maneja controles de movimiento y disparo
	public void manejarMovimiento() {

	    princesa.detener();

	    // IZQUIERDA
	    if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)
	            && princesa.getX() > 0) {

	        princesa.moverIzquierda();
	    }

	    // DERECHA
	    if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {

	        if (princesa.getX() >= 500
	                && desplazamientoMapa < Constantes.LARGO_MAPA
	                - Constantes.ANCHO) {

	            desplazamientoMapa += 5;

	        } else {

	            princesa.moverDerecha();
	        }
	    }

	    // SALTO
	    if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {

	        princesa.saltar();
	    }

	    // DISPARO CON CLICK IZQUIERDO
	    if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)
	            && proyectil == null) {

	        proyectil = new Proyectil(
	                princesa.getX() + 25,
	                princesa.getY() + 25,
	                entorno.mouseX(),
	                entorno.mouseY());
	    }
	}
    
	public void crearPlataformas() {

	    Random random = new Random();
	    piso1 = new Plataforma(0, 540, 300, 40);
	    piso2 = new Plataforma(380, 540, 300, 40);
	    piso3 = new Plataforma(760, 540, 300, 40);
	    piso4 = new Plataforma(1140, 540, 300, 40);
	    piso5 = new Plataforma(1520, 540, 300, 40);
	    piso6 = new Plataforma(1900, 540, 300, 40);
	    piso7 = new Plataforma(2280, 540, 300, 40);
	    piso8 = new Plataforma(2660, 540, 300, 40);
	    piso9 = new Plataforma(4160, 540, 500, 40);
	    piso10 = new Plataforma(4680, 540, 500, 40);
	    piso11 = new Plataforma(4800, 540, 450, 40);
	    piso12 = new Plataforma(5280, 540, 450, 40);
	    piso13 = new Plataforma(5760, 540, 450, 40);
	    piso14 = new Plataforma(6240, 540, 450, 40);
	    piso15 = new Plataforma(6720, 540, 450, 40);
	    piso16 = new Plataforma(7200, 540, 450, 40);
	    piso17 = new Plataforma(7680, 540, 450, 40);
	    piso18 = new Plataforma(8160, 540, 450, 40);
	    piso19 = new Plataforma(7200, 540, 450, 40);
	    piso20 = new Plataforma(7680, 540, 450, 40);
	    piso21 = new Plataforma(8160, 540, 450, 40);
	    piso18 = new Plataforma(8160, 540, 450, 40);
	    piso19 = new Plataforma(7200, 540, 450, 40);
	    piso20 = new Plataforma(7680, 540, 450, 40);
	    piso21 = new Plataforma(8160, 540, 450, 40);
	    
	    plataforma1 = new Plataforma(
	            250 + random.nextInt(100),
	            450,
	            150 + random.nextInt(80),
	            30);

	    plataforma2 = new Plataforma(
	            550 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);

	    plataforma3 = new Plataforma(
	            850 + random.nextInt(100),
	            270,
	            150 + random.nextInt(80),
	            30);

	    plataforma4 = new Plataforma(
	            1150 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);

	    plataforma5 = new Plataforma(
	            1450 + random.nextInt(100),
	            450,
	            150 + random.nextInt(80),
	            30);

	    plataforma6 = new Plataforma(
	            1750 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);

	    plataforma7 = new Plataforma(
	            2050 + random.nextInt(100),
	            270,
	            150 + random.nextInt(80),
	            30);

	    plataforma8 = new Plataforma(
	            2350 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);

	    plataforma9 = new Plataforma(
	            2650 + random.nextInt(100),
	            450,
	            150 + random.nextInt(80),
	            30);

	    plataforma10 = new Plataforma(
	            2950 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);

	    plataforma11 = new Plataforma(
	            3250 + random.nextInt(100),
	            270,
	            150 + random.nextInt(80),
	            30);

	    plataforma12 = new Plataforma(
	            3550 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);
	    
	    plataforma13 = new Plataforma(
	            3850 + random.nextInt(100),
	            450,
	            150 + random.nextInt(80),
	            30);

	    plataforma14 = new Plataforma(
	            4150 + random.nextInt(100),
	            270,
	            150 + random.nextInt(80),
	            30);

	    plataforma15 = new Plataforma(
	            4450 + random.nextInt(100),
	            360,
	            150 + random.nextInt(80),
	            30);
	}

    // Genera enemigos aleatorios
	public void generarEnemigos() {

	    Random random = new Random();

	    if (enemigo1 == null) {
	        enemigo1 = new Enemigo(
	                desplazamientoMapa + 900,
	                300,
	                -1);
	    }

	    if (enemigo2 == null) {
	        enemigo2 = new Enemigo(
	                desplazamientoMapa + 1300,
	                250,
	                -1);
	    }

	    if (enemigo3 == null) {
	        enemigo3 = new Enemigo(
	                desplazamientoMapa + 1700,
	                350,
	                -1);
	    }

	    if (enemigo4 == null) {
	        enemigo4 = new Enemigo(
	                desplazamientoMapa + 2100,
	                300,
	                -1);
	    }

	    if (enemigo5 == null) {
	        enemigo5 = new Enemigo(
	                desplazamientoMapa + 2500,
	                250,
	                -1);
	    }
	}
    
	public void actualizarEnemigos() {

	    if (enemigo1 != null) enemigo1.actualizar();
	    if (enemigo2 != null) enemigo2.actualizar();
	    if (enemigo3 != null) enemigo3.actualizar();
	    if (enemigo4 != null) enemigo4.actualizar();
	    if (enemigo5 != null) enemigo5.actualizar();
	}
    
    // Actualiza el proyectil de la princesa
    public void actualizarProyectil() {

        if (proyectil != null) {

            proyectil.actualizar();

            // Eliminamos si sale de pantalla
            if (proyectil.getX() < 0
                    || proyectil.getX() > Constantes.ANCHO
                    || proyectil.getY() < 0
                    || proyectil.getY() > Constantes.ALTO) {

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
                proyectil = null;
            }
        }
    }

<<<<<<< HEAD
    public void actualizarProyectilesJefe() {
        if (disparoJefe1 != null) disparoJefe1.actualizar();
        if (disparoJefe2 != null) disparoJefe2.actualizar();
        if (disparoJefe3 != null) disparoJefe3.actualizar();
    }

    public void verificarColisiones() {
        if (enemigo1 != null) {
            if (princesa.getBounds().intersects(enemigo1.getBoundsReal(desplazamientoMapa))) { princesa.perderVida(); enemigo1 = null; }
            else if (proyectil != null && proyectil.getBounds().intersects(enemigo1.getBoundsReal(desplazamientoMapa))) { enemigo1 = null; proyectil = null; }
        }
        if (enemigo2 != null) {
            if (princesa.getBounds().intersects(enemigo2.getBoundsReal(desplazamientoMapa))) { princesa.perderVida(); enemigo2 = null; }
            else if (proyectil != null && proyectil.getBounds().intersects(enemigo2.getBoundsReal(desplazamientoMapa))) { enemigo2 = null; proyectil = null; }
        }
        if (enemigo3 != null) {
            if (princesa.getBounds().intersects(enemigo3.getBoundsReal(desplazamientoMapa))) { princesa.perderVida(); enemigo3 = null; }
            else if (proyectil != null && proyectil.getBounds().intersects(enemigo3.getBoundsReal(desplazamientoMapa))) { enemigo3 = null; proyectil = null; }
        }
        if (enemigo4 != null) {
            if (princesa.getBounds().intersects(enemigo4.getBoundsReal(desplazamientoMapa))) { princesa.perderVida(); enemigo4 = null; }
            else if (proyectil != null && proyectil.getBounds().intersects(enemigo4.getBoundsReal(desplazamientoMapa))) { enemigo4 = null; proyectil = null; }
        }
        if (enemigo5 != null) {
            if (princesa.getBounds().intersects(enemigo5.getBoundsReal(desplazamientoMapa))) { princesa.perderVida(); enemigo5 = null; }
            else if (proyectil != null && proyectil.getBounds().intersects(enemigo5.getBoundsReal(desplazamientoMapa))) { enemigo5 = null; proyectil = null; }
        }
        
        if (saltarin1 != null) {
            if (princesa.getBounds().intersects(saltarin1.getBoundsReal(desplazamientoMapa))) { 
                princesa.perderVida(); 
                saltarin1 = null; 
            }
            else if (proyectil != null && proyectil.getBounds().intersects(saltarin1.getBoundsReal(desplazamientoMapa))) { 
                saltarin1 = null; 
                proyectil = null; 
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
            Random random = new Random();
            int xCaja = 500 + random.nextInt(Constantes.LARGO_MAPA - 1000);
            int nivel = random.nextInt(3);
            int yCaja = (nivel == 0) ? 450 : (nivel == 1) ? 360 : 270;
=======
    // Actualiza disparos del jefe
    public void actualizarProyectilesJefe() {

        if (disparoJefe1 != null) {
            disparoJefe1.actualizar();
        }

        if (disparoJefe2 != null) {
            disparoJefe2.actualizar();
        }

        if (disparoJefe3 != null) {
            disparoJefe3.actualizar();
        }
    }

 // Verifica todas las colisiones
    public void verificarColisiones() {

        // ==========================
        // ENEMIGO 1
        // ==========================
        if (enemigo1 != null) {

            if (princesa.getBounds().intersects(
                    enemigo1.getBoundsReal(desplazamientoMapa))) {

                princesa.perderVida();
                enemigo1 = null;
            }

            else if (proyectil != null &&
                    proyectil.getBounds().intersects(
                            enemigo1.getBoundsReal(desplazamientoMapa))) {

                enemigo1 = null;
                proyectil = null;
            }
        }

        // ==========================
        // ENEMIGO 2
        // ==========================
        if (enemigo2 != null) {

            if (princesa.getBounds().intersects(
                    enemigo2.getBoundsReal(desplazamientoMapa))) {

                princesa.perderVida();
                enemigo2 = null;
            }

            else if (proyectil != null &&
                    proyectil.getBounds().intersects(
                            enemigo2.getBoundsReal(desplazamientoMapa))) {

                enemigo2 = null;
                proyectil = null;
            }
        }

        // ==========================
        // ENEMIGO 3
        // ==========================
        if (enemigo3 != null) {

            if (princesa.getBounds().intersects(
                    enemigo3.getBoundsReal(desplazamientoMapa))) {

                princesa.perderVida();
                enemigo3 = null;
            }

            else if (proyectil != null &&
                    proyectil.getBounds().intersects(
                            enemigo3.getBoundsReal(desplazamientoMapa))) {

                enemigo3 = null;
                proyectil = null;
            }
        }

        // ==========================
        // ENEMIGO 4
        // ==========================
        if (enemigo4 != null) {

            if (princesa.getBounds().intersects(
                    enemigo4.getBoundsReal(desplazamientoMapa))) {

                princesa.perderVida();
                enemigo4 = null;
            }

            else if (proyectil != null &&
                    proyectil.getBounds().intersects(
                            enemigo4.getBoundsReal(desplazamientoMapa))) {

                enemigo4 = null;
                proyectil = null;
            }
        }

        // ==========================
        // ENEMIGO 5
        // ==========================
        if (enemigo5 != null) {

            if (princesa.getBounds().intersects(
                    enemigo5.getBoundsReal(desplazamientoMapa))) {

                princesa.perderVida();
                enemigo5 = null;
            }

            else if (proyectil != null &&
                    proyectil.getBounds().intersects(
                            enemigo5.getBoundsReal(desplazamientoMapa))) {

                enemigo5 = null;
                proyectil = null;
            }
        }

        // ==========================
        // PROYECTIL CONTRA JEFE
        // ==========================
        if (jefe != null && proyectil != null) {

            if (proyectil.getBounds().intersects(
                    jefe.getBoundsReal(desplazamientoMapa))) {

                jefe.perderVida();

                proyectil = null;

                if (jefe.getVidas() <= 0) {
                    jefe = null;
                }
            }
        }

        // ==========================
        // DISPAROS DEL JEFE
        // ==========================
        if (disparoJefe1 != null &&
                princesa.getBounds().intersects(
                        disparoJefe1.getBounds())) {

            princesa.perderVida();
            disparoJefe1 = null;
        }

        if (disparoJefe2 != null &&
                princesa.getBounds().intersects(
                        disparoJefe2.getBounds())) {

            princesa.perderVida();
            disparoJefe2 = null;
        }

        if (disparoJefe3 != null &&
                princesa.getBounds().intersects(
                        disparoJefe3.getBounds())) {

            princesa.perderVida();
            disparoJefe3 = null;
        }
    }
    
    public void verificarCajaMagica() {

        if (cajaMagica != null
                && !cajaMagica.estaUsada()
                && princesa.getBounds().intersects(
                        cajaMagica.getBoundsReal(desplazamientoMapa))) {

            princesa.ganarVida();

            Random random = new Random();

            int xCaja = 500 + random.nextInt(Constantes.LARGO_MAPA - 1000);

            int nivel = random.nextInt(3);

            int yCaja;

            if (nivel == 0) {
                yCaja = 450;
            }
            else if (nivel == 1) {
                yCaja = 360;
            }
            else {
                yCaja = 270;
            }

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
            cajaMagica = new CajaMagica(xCaja, yCaja);
        }
    }
    
    public void verificarVictoria() {
<<<<<<< HEAD
        if (jefe == null && princesa.getBounds().intersects(castillo.getBoundsReal(desplazamientoMapa))) {
=======

        if (jefe == null
                && princesa.getBounds().intersects(
                        castillo.getBoundsReal(desplazamientoMapa))) {

>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
            ganado = true;
        }
    }

<<<<<<< HEAD
    public void verificarDerrota() {
        if (princesa.getY() > Constantes.ALTO) {
            princesa.perderVida(); princesa.setX(400); princesa.setY(200);
        }
        if (princesa.getVidas() <= 0) perdido = true;
    }
    
    public void dibujarJuego() {
        if (perdido) {
            entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.BLACK);
            entorno.dibujarImagen(gifDerrota, 400, 250, 0, 0.45);
            
            entorno.cambiarFont("Arial", 24, Color.WHITE);
            entorno.escribirTexto("Presioná 'R' para volver a jugar", 240, 480);
            
            if (entorno.estaPresionada('r')) {
                reiniciarJuego();
            }
            return;
        }
        
        if (ganado) {
            entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.BLACK);
            entorno.dibujarImagen(gifVictoria, 400, 250, 0, 0.45);
            
            entorno.cambiarFont("Arial", 24, Color.YELLOW);
            entorno.escribirTexto("¡Ganaste! Presioná 'R' para volver a jugar", 200, 480);
            
            if (entorno.estaPresionada('r')) {
                reiniciarJuego();
            }
            return;
        }

        // Fondo fijo centrado impecable sin cortes bruscos
        double escala = Math.max(800.0 / fondo.getWidth(null), 600.0 / fondo.getHeight(null));
        entorno.dibujarImagen(fondo, 400, 300, 0, escala);
=======
    // Verifica derrota
    public void verificarDerrota() {

        // Si cae fuera del mapa
        if (princesa.getY() > Constantes.ALTO) {

            princesa.perderVida();

            princesa.setX(400);
            princesa.setY(200);
        }

        // Si no tiene vidas
        if (princesa.getVidas() <= 0) {

            perdido = true;
        }
    }
    
    
    public void dibujarJuego() {
    	
    	    // 🔴 SI PERDIÓ: SOLO GAME OVER Y SALIR
    	if (perdido) {

    	    entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.BLACK);

    	    entorno.dibujarImagen(
    	            gifDerrota,
    	            400,
    	            300,
    	            0,
    	            0.45
    	    );

    	    return;
    	}
    	
    	// 🟢 SI GANÓ
        if (ganado) {
            entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.BLACK);

            entorno.dibujarImagen(
                    gifVictoria,
                    400,
                    300,
                    0,
                    0.45   
            );

            return;
        }


        // Fondo
    	double escala = Math.max(
    	        800.0 / fondo.getWidth(null),
    	        600.0 / fondo.getHeight(null)
    	);

    	int ancho = (int)(fondo.getWidth(null) * escala);

    	// movimiento lento
    	int offset = (int)(desplazamientoMapa * 0.2) % ancho;

    	// IMPORTANTE: solape de 2 a 5 px
    	int overlap = 5;

    	int x1 = 400 - offset;
    	int x2 = x1 + ancho - overlap;
    	int x3 = x2 + ancho - overlap;

    	entorno.dibujarImagen(fondo, x1, 300, 0, escala);
    	entorno.dibujarImagen(fondo, x2, 300, 0, escala);
    	entorno.dibujarImagen(fondo, x3, 300, 0, escala);
        
    	
    	// Plataformas
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
        
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
<<<<<<< HEAD
        piso22.dibujar(entorno, desplazamientoMapa);
        piso23.dibujar(entorno, desplazamientoMapa);
        piso24.dibujar(entorno, desplazamientoMapa);
=======
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
       
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
        
<<<<<<< HEAD
        if (castillo != null) castillo.dibujar(entorno, desplazamientoMapa);
        if (cajaMagica != null) cajaMagica.dibujar(entorno, desplazamientoMapa);

        if (enemigo1 != null) enemigo1.dibujar(entorno, desplazamientoMapa);
        if (enemigo2 != null) enemigo2.dibujar(entorno, desplazamientoMapa);
        if (enemigo3 != null) enemigo3.dibujar(entorno, desplazamientoMapa);
        if (enemigo4 != null) enemigo4.dibujar(entorno, desplazamientoMapa);
        if (enemigo5 != null) enemigo5.dibujar(entorno, desplazamientoMapa);
        
        if (saltarin1 != null) saltarin1.dibujar(entorno, desplazamientoMapa);
        
        if (jefe != null) jefe.dibujar(entorno, desplazamientoMapa);
        if (proyectil != null) proyectil.dibujar(entorno);
        if (disparoJefe1 != null) disparoJefe1.dibujar(entorno);
        if (disparoJefe2 != null) disparoJefe2.dibujar(entorno);
        if (disparoJefe3 != null) disparoJefe3.dibujar(entorno);

        princesa.dibujar(entorno);

        for (int i = 0; i < princesa.getVidas(); i++) {
            int posicionX = 25 + (i * 35); 
            entorno.dibujarImagen(iconoCorazon, posicionX, 30, 0, 0.01);
        }
    }

    public static void main(String[] args) {
        new Juego();
    }
}
=======

        // Castillo
        if (castillo != null) {
            castillo.dibujar(entorno, desplazamientoMapa);
        }

        // Caja mágica
        if (cajaMagica != null) {
            cajaMagica.dibujar(entorno, desplazamientoMapa);
        }

        // Enemigos
        if (enemigo1 != null)
            enemigo1.dibujar(entorno, desplazamientoMapa);

        if (enemigo2 != null)
            enemigo2.dibujar(entorno, desplazamientoMapa);

        if (enemigo3 != null)
            enemigo3.dibujar(entorno, desplazamientoMapa);

        if (enemigo4 != null)
            enemigo4.dibujar(entorno, desplazamientoMapa);

        if (enemigo5 != null)
            enemigo5.dibujar(entorno, desplazamientoMapa);

        // Jefe
        if (jefe != null) {
            jefe.dibujar(entorno, desplazamientoMapa);
        }

        // Proyectil
        if (proyectil != null) {
            proyectil.dibujar(entorno);
        }

        // Disparos del jefe
        if (disparoJefe1 != null)
            disparoJefe1.dibujar(entorno);

        if (disparoJefe2 != null)
            disparoJefe2.dibujar(entorno);

        if (disparoJefe3 != null)
            disparoJefe3.dibujar(entorno);

        // Princesa
        princesa.dibujar(entorno);

        // Texto
        entorno.cambiarFont("Arial", 20, Color.WHITE);

        entorno.escribirTexto(
                "Vidas: " + princesa.getVidas(),
                20,
                30);
        
    }

	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
>>>>>>> b48b458faa6379a7731ca1982bcce60cbfa11aa6
