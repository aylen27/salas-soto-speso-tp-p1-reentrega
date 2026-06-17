package util;

// Clase que almacena todas las constantes del juego.
// Las constantes son valores fijos que no cambian
// durante la ejecución del programa.
public class Constantes {

    // Ancho de la ventana del juego
    public static final int ANCHO = 1000;

    // Alto de la ventana del juego
    public static final int ALTO = 600;

    // Cantidad de cuadros por segundo (FPS)
    // Controla la velocidad de actualización del juego
    public static final int FPS = 60;

    // Valor de gravedad aplicado a los personajes
    // mientras caen
    public static final int GRAVEDAD = 1;

    // Cantidad máxima de enemigos permitidos
    // al mismo tiempo en pantalla
    public static final int MAX_ENEMIGOS = 5;

    // Largo total del mapa del juego
    // Se usa para el desplazamiento lateral
    public static final int LARGO_MAPA = 5000;
}