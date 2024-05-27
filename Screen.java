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
    ArrayList<ActionCard> actionCard;

    //players
    ArrayList<Character> players;
    Cappuccino cap;
    Americano ame;
    Mocha moc;
    Latte lat;

    //buttons
    private JButton die;
    private JButton start;
    private int dieValue;
    private JavaLand jl;
    boolean startVar; // to see if the start button has been pressed and the game has begun
    private boolean[][] board;

    //rows
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
       die.setBounds(670,230,100,30);
       die.addActionListener(this);
       this.add(die);
       die.setVisible(false);

       start = new JButton("Start"); //as about start vs restart
       start.setBounds(400,370,100,30);
       start.addActionListener(this);
       this.add(start);

        board = new boolean[10][10];
        actionCard = new ArrayList<ActionCard>();
        
        jl = new JavaLand();

        players = new ArrayList<Character>();
        cap = new Cappuccino(700,400);
        players.add(cap);
        
       startVar = false;
   }
   public Dimension getPreferredSize() {
       //Sets the size of the panel
       return new Dimension(1500,800);
   }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(startVar){
            drawDie(g,dieValue);
            drawBoard(g);
            howToPlay(g);
            //players.get(0).drawMe(g);
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
        int x = 50;
        int y = 80;
        g.setColor(boardBeige);
        for(int i = 0; i < row0.length(); i++){
            if(row0.charAt(i) == '1'){
                g.setColor(boardBeige);
                board[0][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
        g.setColor(boardCamel);
        for(int i = 0; i < row1.length(); i++){
            if(row1.charAt(i) == '1'){
                g.setColor(boardCamel);
                board[1][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
        g.setColor(boardCinnamon);
        for(int i = 0; i < row2.length(); i++){
            if(row2.charAt(i) == '1'){
                g.setColor(boardCinnamon);
                board[2][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
        g.setColor(boardChocolate);
        for(int i = 0; i < row3.length(); i++){
            if(row3.charAt(i) == '1'){
                g.setColor(boardChocolate);
                board[3][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
        g.setColor(boardBeige);
        for(int i = 0; i < row4.length(); i++){
            if(row4.charAt(i) == '1'){
                g.setColor(boardBeige);
                board[4][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
       
        g.setColor(boardChocolate);
        for(int i = 0; i < row5.length(); i++){
            if(row5.charAt(i) == '1'){
                g.setColor(boardChocolate);
                board[5][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
   
        g.setColor( boardCinnamon);
        for(int i = 0; i < row6.length(); i++){
            if(row6.charAt(i) == '1'){
                g.setColor( boardCinnamon);
                board[6][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;
    
        g.setColor(boardBeige);
        for(int i = 0; i < row7.length(); i++){
            if(row7.charAt(i) == '1'){
                g.setColor(boardBeige);
                board[7][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y += 60;

        g.setColor(boardCamel);
        for(int i = 0; i < row8.length(); i++){
            if(row8.charAt(i) == '1'){
                g.setColor(boardCamel);
                board[8][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        x = 50;
        y +=60;
 
        g.setColor(boardChocolate);
        for(int i = 0; i < row9.length(); i++){
            if(row9.charAt(i) == '1'){
                g.setColor(boardChocolate);
                board[9][i] = true;
                g.fillRect(x,y,60,60);
                x+= 60;
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(x,y,60,60);
                x+=60;
            }
        }
        //ending box
        //josh straus's code for rectangle with border
        g.setColor(Color.BLACK);
        rectangleWithBorders(g, 290, 320, 120, 120, 10);
        //finishing square
        g.setColor(Color.WHITE);
        g.fillRect(295,325,110,110);

        
    }

    public void rectangleWithBorders(Graphics g, int x, int y, int width, int height, int borderThickness) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < borderThickness; i++) {
			g.drawRect(x + i, y + i, width - (2 * i), height - (2 * i));
		}
	}

    public void drawDie(Graphics g, int num){
        //add animation
        g.setColor(new Color(111, 78, 55));
        g.fillRect(690,180,50,50);
        g.setColor(Color.WHITE);
        Font font = new Font("Courier", Font.PLAIN,20);
        g.setFont(font);
        g.drawString(Integer.toString(num), 708,212);
        //num is what the method diceRolled in JavaLand returns
    }


    public void startScreen(Graphics g){
        g.setColor(backgroundTaupe);
        g.fillRect(0,0,1500,800);
    }

    public void endGameScreen(Graphics g){
        g.setColor(new Color(53, 30, 16));
        g.fillRect(0,0,1500,800);
        Font font = new Font("Courier", Font.PLAIN, 30);
        g.drawString("Game Over", 300,400);
    }
    
    public void howToPlay(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("Courier", Font.PLAIN, 25);
        g.drawString("INSTRUCTIONS:", 660, 300);
        g.drawString("1)Select a figurine!",660,325);
        g.drawString("2)Roll the dice and your figure will move forward!",660,350);
        g.drawString("3) If your figurine lands on an action or trivia card square,",660,375);
        g.drawString("follow the prompts to complete your turn!",660,400);
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
