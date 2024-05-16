import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Latte extends Character{
    private BufferedImage latte;
    
    public Latte(){
        try{
            latte = ImageIO.read(new File("latte.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
