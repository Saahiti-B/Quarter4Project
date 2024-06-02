import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class FinishCup{
    private BufferedImage finishCup;
    
    public FinishCup(){
        try{
            finishCup = ImageIO.read(new File("finishCup.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void drawImage(Graphics g){
        g.drawImage(finishCup,305,347, null);
    }
}
