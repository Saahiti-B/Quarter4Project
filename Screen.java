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
   private boolean[][] board;
   private String row0;
   private String row1;
   private String row2;
   private String row3;
   private String row4;
   private String row5;
   private String row6;
   private String row7;
   private String row8;
   private String row9;

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

       //rows 
       row0 = "1111111111";
       row1 = "1000000001";
       row2 = "1011111101";
       row3 = "1010000101";
       row4 = "1010110101";
       row5 = "1010110101";
       row6 = "1010100101";
       row7 = "1010111101";
       row8 = "1010000001";
       row9 = "1011111111";
	
       //buttons
       die = new JButton("Roll Die");
       die.setBounds(50,50,100,30);
       die.addActionListener(this);
       this.add(die);
       die.setVisible(false);

       start = new JButton("Start"); //as about start vs restart
       start.setBounds(400,370,100,30);
       start.addActionListener(this);
       this.add(start);

       board = new boolean[10][10];

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
        //for setting values to true or false
        /*
        for(int c = 0; c < board[0].length; c++){
            for(int r = board.length - 1; r <= 0; r--){
                if(c == 0){
                    board[r][c] = true;
                }
                else if(c == 1){
                    if(r == 0){
                        board[r][c] = true;
                    }
                }
                
                else if(c == 2){

                }
                
            }
        }
        //drawing the actual values
        g.setColor(boardBeige);
        int x = 20;
        int y = 600;
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == true){
                    g.fillRect(x,y,60,60);
                    y -= 60;
                }
                y = 600;
                x += 60;
            }
        }
        */
        int x = 100;
        int y = 80;
        g.setColor(boardBeige);
        for(int i = 0; i < row0.length(); i++){
            if(row0.charAt(i) == '1'){
                board[0][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        g.setColor(boardCamel);
        for(int i = 0; i < row1.length(); i++){
            if(row1.charAt(i) == '1'){
                board[1][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        g.setColor(boardCinnamon);
        for(int i = 0; i < row2.length(); i++){
            if(row2.charAt(i) == '1'){
                board[2][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        g.setColor(boardChocolate);
        for(int i = 0; i < row3.length(); i++){
            if(row3.charAt(i) == '1'){
                board[3][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        g.setColor(boardCinnamon);
        for(int i = 0; i < row4.length(); i++){
            if(row4.charAt(i) == '1'){
                board[4][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        for(int i = 0; i < row5.length(); i++){
            if(row5.charAt(i) == '1'){
                board[5][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        for(int i = 0; i < row6.length(); i++){
            if(row6.charAt(i) == '1'){
                board[6][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        for(int i = 0; i < row7.length(); i++){
            if(row7.charAt(i) == '1'){
                board[7][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y += 60;
        for(int i = 0; i < row8.length(); i++){
            if(row8.charAt(i) == '1'){
                board[8][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        x = 100;
        y +=60;
        for(int i = 0; i < row9.length(); i++){
            if(row9.charAt(i) == '1'){
                board[9][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
        }
        //x = 100;
        //y += 60;
        /*
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
        */
    }

    public void drawDie(Graphics g, int num){
        //add animation
        g.setColor(new Color(111, 78, 55));
        g.fillRect(10,0,50,50);
        g.setColor(Color.WHITE);
        Font font = new Font("Courier", Font.PLAIN,20);
        g.setFont(font);
        g.drawString(Integer.toString(num), 27,30);
        //num is what the method diceRolled in JavaLand returns
    }


    public void startScreen(Graphics g){
        g.setColor(backgroundTaupe);
        g.fillRect(0,0,1000,800);
    }

    public void endGameScreen(Graphics g){
        g.setColor(new Color(53, 30, 16));
        g.fillRect(0,0,1000,800);
        Font font = new Font("Courier", Font.PLAIN, 30);
        g.drawString("Game Over", 300,400);
    }
    
    public void howToPlay(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Courier", Font.PLAIN, 20);
        //g.drawString("")
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
