//GUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.util.ArrayList;


public class Screen extends JPanel implements MouseListener, ActionListener{
   //arraylist of cards, (one for discard, one for to be used (polymorphism))
   ArrayList<ActionCard> actionCard = new ArrayList<ActionCard>();
   private JButton die;
   private JButton start;
   private int dieValue;
   private JavaLand jl = new JavaLand();
   boolean startVar; // to see if the start button has been pressed and the game has begun

    // colors
    private Color backgroundTaupe;
    private Color boardCamel;
    private Color boardBeige;
    private Color boardChocolate;
    private Color boardCinnamon;

   public Screen(){
       setLayout(null);

       //Colors
       backgroundTaupe = new Color(204, 160, 116);
       boardCamel = new Color(201, 138, 75);
       boardBeige = new Color(227, 180, 134);
       boardChocolate = new Color(110, 68, 26);
       boardCinnamon = new Color(138, 86, 36);
	
       //buttons
       die = new JButton("Roll Die");
       die.setBounds(50,50,100,30);
       die.addActionListener(this);
       this.add(die);
       die.setVisible(false);

       start = new JButton("Start");
       start.setBounds(400,370,100,30);
       start.addActionListener(this);
       this.add(start);

       startVar = false;
   }
   public Dimension getPreferredSize() {
       //Sets the size of the panel
       return new Dimension(1000,800);
   }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(startVar){
            drawDie(g,dieValue);
        }
        else if (startVar == false){
            startScreen(g);
        }
    }

    public void drawBoard(Graphics g){
        //uses rectangles, some will have symbols
    }
    public void drawDie(Graphics g, int num){
        g.setColor(new Color(111, 78, 55));
        g.fillRect(10,0,50,50);
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN,20);
        g.setFont(font);
        g.drawString(Integer.toString(num), 20,20);
        //num is what the method diceRolled in JavaLand returns
    }


   public void startScreen(Graphics g){
       g.setColor(backgroundTaupe);
       g.fillRect(0,0,1000,800);
   }
  
   //button methods
   public void actionPerformed(ActionEvent e){
       if(e.getSource() == die){
            dieValue = jl.diceRolled();
        }
        else if(e.getSource() == start){
            startVar = true;
            start.setVisible(false);
            die.setVisible(true);
        }
        repaint();
   }


   //mouselistener methods
   public void mouseClicked(MouseEvent e){}
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mousePressed(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}
   //create an animate method
}
