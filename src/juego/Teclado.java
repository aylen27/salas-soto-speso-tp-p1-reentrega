package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    public boolean izquierda;
    public boolean derecha;
    public boolean salto;

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_LEFT) {
            izquierda = true;
        }

        if (tecla == KeyEvent.VK_RIGHT) {
            derecha = true;
        }

        if (tecla == KeyEvent.VK_UP) {
            salto = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_LEFT) {
            izquierda = false;
        }

        if (tecla == KeyEvent.VK_RIGHT) {
            derecha = false;
        }

        if (tecla == KeyEvent.VK_UP) {
            salto = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}