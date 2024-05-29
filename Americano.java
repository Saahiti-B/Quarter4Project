import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Americano extends Character{
    private BufferedImage americano;

    public Americano(int x, int y){
        super(x, y);

        try{
            americano = ImageIO.read(new File("americano.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void drawMe(Graphics g){
        g.drawImage(americano, getX() ,getY(), null);
    }

    public void moveUp(int y){
        y--;
    }
    public void moveDown(int y){
        y++;
    }
    public void moveRight(int x){
        x++;
    }
    public void moveLeft(int x){
        x--;
    }
}
