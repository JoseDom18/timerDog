import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Temporizador {
  private String[] perros = { "Condesa", "Duquesa", "Titan" };
  private int turno = 0;

  public void temporizador() {

    System.out.println("DogTimer iniciado!");
    mostrarTurno();

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        turno = (turno + 1) % perros.length;
        mostrarTurno();
        reproducirSonido();
      }
    }, 30 * 60 * 1000, 30 * 60 * 1000);

  }
  
  public void mostrarTurno() {

    System.out.printf("Es hora de sacar a la %s.%n", perros[turno]);

    System.out.println("Los demás perros tienen que estar encerrados: ");
    for (int i = 0; i < perros.length; i++) {
      if (i != turno) {
        System.out.printf("- %s.%n", perros[i]);
      }
    }
  }
  
  public void reproducirSonido() {
    try {
        AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource("sonido.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
