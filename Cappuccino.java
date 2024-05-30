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
    private int x;
    private int y;

    public Cappuccino(int x, int y){
        super(x, y);

        try{
            cap = ImageIO.read(new File("cappuccino.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void drawMe(Graphics g){
        g.drawImage(cap,super.getX(),super.getY(), null);
    }
}
