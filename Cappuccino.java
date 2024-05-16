import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Cappuccino extends Character{
    private BufferedImage cap;

    public Cappuccino(){
        try{
            cap = ImageIO.read(new File("cappuccino.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
