import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound{

    public void playSound(){
        try {
            URL url = this.getClass().getClassLoader().getResource("diceRolling2.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playEndSound(){
        try{
            URL url = this.getClass().getClassLoader().getResource("yay.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc){
            exc.printStackTrace(System.out);
        }
    }
}
