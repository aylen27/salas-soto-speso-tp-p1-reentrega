package juego;

import javax.swing.JFrame;

public class Juego {

    private JFrame ventana;

    private PanelJuego panel;

    public Juego() {

        ventana = new JFrame("Super Elizabeth Sis");

        panel = new PanelJuego();

        // Configuración para cerrar el programa
        ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        // Evita que la ventana cambie de tamaño
        ventana.setResizable(false);

        // Agregamos el panel a la ventana
        ventana.add(panel);

        // Ajustamos el tamaño automáticamente
        ventana.pack();

        // Centramos la ventana en pantalla
        ventana.setLocationRelativeTo(null);

        // Hacemos visible la ventana
        ventana.setVisible(true);
    }

    public void iniciar() {

        // Arranca el bucle principal
        panel.iniciarHilo();
    }
}