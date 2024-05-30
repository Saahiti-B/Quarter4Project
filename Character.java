import java.awt.Graphics;
public abstract class Character{
    /*
    this one is a generic character, has a move method that is used throughout
    import images for the characters
    */
    private int x;
	private int y;

    public Character(int x, int y){
		this.x = x;
		this.y = y;
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

    public void setY(int y){
		this.y = y;
	}

    public void moveUp(){
        y -= 60;
    }
    public void moveDown(){
        y += 60;
    }
    public void moveRight(){
        x += 60;
    }
    public void moveLeft(){
        x -= 60;
    }

    public abstract void drawMe(Graphics g);
}
