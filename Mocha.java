import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Mocha extends Character{
    private BufferedImage mocha;
    
    public Mocha(){
        try{
            mocha = ImageIO.read(new File("mocha.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
