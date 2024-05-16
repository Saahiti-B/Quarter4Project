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


   public Screen(){
       setLayout(null);
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
            drawDie(g,jl.diceRolled());
        }
        else if (startVar == false){
            startScreen(g);
        }
        /*
        number printed and number shown on screen are different
        */
    }


    public void drawDie(Graphics g, int num){
        //System.out.println("method called");
        //System.out.println("if statement called");
        dieValue = num;
        g.setColor(Color.GREEN);
        g.fillRect(20,0,50,50);
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN,20);
        g.setFont(font);
        g.drawString(Integer.toString(num), 20,20);
        //num is what the method diceRolled in JavaLand returns
    }


   public void startScreen(Graphics g){
       g.setColor(Color.CYAN);
       g.fillRect(0,0,1000,800);
   }
  
   //button methods
   public void actionPerformed(ActionEvent e){
       if(e.getSource() == die){
           System.out.println(dieValue);
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
