package sonidos;

import javax.sound.sampled.*;
import java.io.File;

public class Sonido {

    private static Clip musica;

    public static void reproducirMusica(String ruta) {
        try {

            if (musica != null && musica.isRunning()) {
                musica.stop();
                musica.close();
            }

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(new File(ruta));

            musica = AudioSystem.getClip();
            musica.open(audio);

            musica.loop(Clip.LOOP_CONTINUOUSLY);
            musica.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reproducirEfecto(String ruta) {
        try {
            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(new File(ruta));

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void detenerMusica() {
        if (musica != null) {
            musica.stop();
        }
    }
}