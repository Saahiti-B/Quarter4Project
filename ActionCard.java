import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.*;

public abstract class ActionCard{
    private Color cardColor;
	private int x;
	private int y;

    //trivia card or move back/forward
    public ActionCard(Color cardColor, int x, int y){
		this.cardColor = cardColor;
		this.x = x;
		this.y = y;

	}

    public void drawMe(Graphics g){
		drawCard(g);
		drawType(g);
	}


	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public Color getCardColor(){
		return cardColor;
	}

	public void setColor(Color color){
		cardColor = color;
	}

	public abstract void drawCard(Graphics g);
	
	public abstract void drawType(Graphics g);
}
