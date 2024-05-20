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
            drawBoard(g);
        }
        else if (startVar == false){
            startScreen(g);
        }
    }

    public void drawBoard(Graphics g){
        /*
        private Color backgroundTaupe;
        private Color boardCamel;
        private Color boardBeige;
        private Color boardChocolate;
        private Color boardCinnamon;
        */
       //outlines the squares
        g.setColor(boardChocolate);
        g.drawRect(100,100,60,60);
        g.drawRect(160,100,60,60);
        g.drawRect(160,160,60,60);
        g.drawRect(220,160,60,60);
        g.drawRect(280,160,60,60);
        g.drawRect(280,220,60,60);
        //straight
        g.drawRect(280,280,60,60);
        g.drawRect(220,280,60,60);
        g.drawRect(160,280,60,60);
        g.drawRect(100,280,60,60);
        //turn
        g.drawRect(100,340,60,60);
        //straight
        g.drawRect(100,400,60,60);
        g.drawRect(160,400,60,60);
        g.drawRect(220,400,60,60);
        g.drawRect(280,400,60,60);
        g.drawRect(340,400,60,60);
        g.drawRect(400,400,60,60);
        //up 4 squares
        g.drawRect(400,340,60,60);
        g.drawRect(400,280,60,60);
        g.drawRect(400,220,60,60);
        g.drawRect(400,160,60,60);
        //over 2
        g.drawRect(460,160,60,60);
        g.drawRect(520,160,60,60);
        //down 6
        g.drawRect(520,220,60,60);
        g.drawRect(520,280,60,60);
        g.drawRect(520,340,60,60);
        g.drawRect(520,400,60,60);
        g.drawRect(520,460,60,60);
        g.drawRect(520,520,60,60);
        //left 7
        g.drawRect(460,520,60,60);
        g.drawRect(400,520,60,60);
        g.drawRect(340,520,60,60);
        g.drawRect(280,520,60,60);
        g.drawRect(220,520,60,60);
        g.drawRect(160,520,60,60);
        g.drawRect(100,520,60,60);
        //beginning of board
        g.setColor(boardBeige);
        g.fillRect(100,100,60,60);
        g.setColor(boardCamel);
        g.fillRect(160,100,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(160,160,60,60);
        g.setColor(boardBeige);
        g.fillRect(220,160,60,60);
        //change colors
        g.setColor(boardCamel);
        g.fillRect(280,160,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(280,220,60,60);
        //straight
        g.setColor(boardBeige);
        g.fillRect(280,280,60,60);
        g.setColor(boardCamel);
        g.fillRect(220,280,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(160,280,60,60);
        g.setColor(boardBeige);
        g.fillRect(100,280,60,60);
        //turn
        g.setColor(boardCamel);
        g.fillRect(100,340,60,60);
        //straight
        g.setColor(boardCinnamon);
        g.fillRect(100,400,60,60);
        g.setColor(boardBeige);
        g.fillRect(160,400,60,60);
        g.setColor(boardCamel);
        g.fillRect(220,400,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(280,400,60,60);
        g.setColor(boardBeige);
        g.fillRect(340,400,60,60);
        g.setColor(boardCamel);
        g.fillRect(400,400,60,60);
        //up 4 squares
        g.setColor(boardCinnamon);
        g.fillRect(400,340,60,60);
        g.setColor(boardBeige);
        g.fillRect(400,280,60,60);
        g.setColor(boardCamel);
        g.fillRect(400,220,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(400,160,60,60);
        //over 2
        g.setColor(boardBeige);
        g.fillRect(460,160,60,60);
        g.setColor(boardCamel);
        g.fillRect(520,160,60,60);
        //down 6
        g.setColor(boardCinnamon);
        g.fillRect(520,220,60,60);
        g.setColor(boardBeige);
        g.fillRect(520,280,60,60);
        g.setColor(boardCamel);
        g.fillRect(520,340,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(520,400,60,60);
        g.setColor(boardBeige);
        g.fillRect(520,460,60,60);
        g.setColor(boardCamel);
        g.fillRect(520,520,60,60);
        //left 7
        g.setColor(boardCinnamon);
        g.fillRect(460,520,60,60);
        g.setColor(boardBeige);
        g.fillRect(400,520,60,60);
        g.setColor(boardCamel);
        g.fillRect(340,520,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(280,520,60,60);
        g.setColor(boardBeige);
        g.fillRect(220,520,60,60);
        g.setColor(boardCamel);
        g.fillRect(160,520,60,60);
        g.setColor(boardCinnamon);
        g.fillRect(100,520,60,60);
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
