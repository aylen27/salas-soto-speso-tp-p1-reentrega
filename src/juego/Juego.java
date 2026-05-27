package juego;

import javax.swing.JFrame;

public class Juego {

    private JFrame ventana;
    private PanelJuego panel;

    public Juego() {

        ventana = new JFrame("Super Elizabeth Sis");

        panel = new PanelJuego();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    public void iniciar() {
        panel.iniciarHilo();
    }
}