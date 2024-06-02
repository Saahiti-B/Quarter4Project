import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
//textprompts https://github.com/tips4java/tips4java/blob/main/source/TextPromptDemo.java
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ActionMove extends ActionCard{
    //card that is randomly drawn, interspaced with the trivia questions
    private Color color;
    private int x;
    private int y;


    public ActionMove(Color color, int x, int y){
        super(color,x,y);
    }

    public void drawCard(Graphics g){
        g.setColor(super.getCardColor());
        g.fillRect(55,85,50,50);
        g.fillRect(595,85,50,50);
        g.fillRect(595,625,50,50);

        g.setColor(Color.BLACK);
        Font font = new Font("Courier", Font.PLAIN, 7);
        g.drawString("MOVE", 57, 115);
        g.drawString("MOVE", 597, 115);
        g.drawString("MOVE", 597, 655);
    }
}

