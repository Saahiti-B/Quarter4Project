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

    public void drawSquare(Graphics g){
        g.setColor(super.getCardColor());
        g.fillRect(60,95,40,40);
        g.fillRect(600,95,40,40);
        g.fillRect(600,630,40,40);
    }

    public void drawCard(Graphics g){
        //g.drawString
    }
    public void drawType(Graphics g){
        //g.drawString
    }
}

