package juego;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    public boolean click;

    public int x;
    public int y;

    @Override
    public void mousePressed(MouseEvent e) {

        click = true;

        x = e.getX();
        y = e.getY();
    }
}