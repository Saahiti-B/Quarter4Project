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

/*
win condition: whoever gets to the center first
roll die to move forward, ex. rolled 6, move 6 squares forward
action cards can move you forwards or backwards
trivia questions need to be correctly answered to advance
*/
//choose a better background color than white
public class Screen extends JPanel implements MouseListener, ActionListener{
    //arraylist of cards, (one for discard, one for to be used (polymorphism))
    ArrayList<ActionCard> actionCard;
    //players
    ArrayList<Character> players;
    Cappuccino cap;
    Americano ame;
    Mocha moc;
    Latte lat;
    //cards
    ActionCard am;
    ActionCard tq; //or TriviaQuestions?
    //image
    FinishCup fc;
    //sound
    Sound s;
    //buttons
    private JButton die;
    private JButton start;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    //booleans for trivia questions
    private Boolean showQ0;
    private Boolean showQ1;
    private Boolean showQ2;
    private int dieValue;
    //backend
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
    //choose a better background color than white
    private Color backgroundTaupe;
    private Color boardCamel;
    private Color boardBeige;
    private Color boardChocolate;
    private Color boardCinnamon;
    //figurine values
    private int capX;
    private int capY;
    private int ameX;
    private int ameY;
    private int latX;
    private int latY;
    private int mocX;
    private int mocY;
    //turns
    private int counterTemp;
    private int playerTurn;
    //die
    private boolean dieRoll;
    //textfields 
    private JTextField rField;

    public Screen(){
        setLayout(null);
        capX = 9;
        capY = 0;
        ameX = 9;
        ameY = 0;
        latX = 9;
        latY = 0;
        mocX = 9;
        mocY = 0;

        playerTurn = 0;
        dieRoll = false;
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
        
        start = new JButton("Start"); //ask about start vs restart
        start.setBounds(670,370,100,30);
        start.addActionListener(this);
        this.add(start);
        
        aButton = new JButton("A");
        aButton.setBounds(800,220,100,30);
        aButton.addActionListener(this);
        this.add(aButton);
        aButton.setVisible(false);
        
        bButton = new JButton("B");
        bButton.setBounds(800,240,100,30);
        bButton.addActionListener(this);
        this.add(bButton);
        bButton.setVisible(false);
        
        cButton = new JButton("C");
        cButton.setBounds(800,260,100,30);
        cButton.addActionListener(this);
        this.add(cButton);
        cButton.setVisible(false);
        
        board = new boolean[10][10];
        actionCard = new ArrayList<ActionCard>();
        
        jl = new JavaLand();
        
        s = new Sound();
        
        cap = new Cappuccino(100,650);
        ame = new Americano(50, 650);
        moc = new Mocha(50, 700);
        lat = new Latte(100, 700);
        
        //cards
        am = new ActionMove(Color.WHITE,50,50);
        tq = new TriviaQuestions(Color.BLACK,50,50);
        
        //image
        fc = new FinishCup();
        
        players = new ArrayList<Character>(); //0 is cap, 1, is ame, 2 is moc, 3 is lat
        players.add(cap);
        players.add(ame);
        players.add(moc);
        players.add(lat);
        
        startVar = false;

        //booleans for trivia questions
        showQ0 = false;
        showQ1 = false;
        showQ2 = false;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1500,800);
    }
        
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //tq.questions(g,capX,capY,ameX,ameY,latX,latY,mocX,mocY);
        if(startVar){
            drawDie(g,dieValue);
            drawBoard(g);
            howToPlay(g);
            //0 is cap, 1, is ame, 2 is moc, 3 is lat
            players.get(0).drawMe(g);
            players.get(1).drawMe(g);
            players.get(2).drawMe(g);
            players.get(3).drawMe(g);
        }
        else if (startVar == false){
            startScreen(g);
        }
    }    
    public void drawBoard(Graphics g){
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
        
        //draw cards
        am.drawCard(g);
        tq.drawCard(g);
        
        //draw image
        fc.drawImage(g);
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
    public void checkMove(int index, int i, int j){
        int figurineX = 0;
        int figurineY = 0;
        if(index == 0){
            figurineX = capX;
            figurineY = capY;
        } else if(index == 1){
            figurineX = ameX;
            figurineY = ameY;
        } else if(index ==2){
            figurineX = mocX;
            figurineY = mocY;
        } else if(index == 3){
            figurineX = latX;
            figurineY = latY;
        }
        
        for(int x = 0;x < dieValue; x++){
            /*
                //move boxes
            if(figurineX == 9 && figurineY == 9){
                //trigger the card
                
            }
            else if(figurineX == 9 && figurineY == 0){
                //trigger 2nd
            }
            else if(figurineX == 0 && figurineY == 9 ){
                //3rd card
            }
            //question marks
            else if(figurineX == 3 && figurineY == 0){
                //trigger the card
                showQ0 = true;
                
            }
            else if(figurineX == 3 && figurineY == 9){
                //trigger the card
                showQ1 = true;
            }
            else if(figurineX ==  7&& figurineY == 6){
                //trigger the card
                showQ2 = true;
            }
            */
           System.out.println("i before move up: " + i);
           System.out.println("j : " + j);
           System.out.println("figurineY: " + figurineY);
           //j = j+9;
           //j = figurineY + 9;
            if((i - 1) >= 0 && board[i - 1][j] == true){ //if square directly above
                System.out.println("moving up 0");
                players.get(index).moveUp();
                figurineY--;
                i--;
                if(index == 0){
                    capX = figurineX;
                    capY = figurineY;
                } else if(index == 1){
                    ameX = figurineX;
                    ameY = figurineY;
                } else if(index ==2){
                    mocX = figurineX;
                    mocY = figurineY;
                } else if(index == 3){
                    latX = figurineX;
                    latY = figurineY;
                }
            }
            else if((j + 1) < 10 && board[i][j + 1] == true){ // if square to the right
                System.out.println("moving right 0");
                players.get(index).moveRight();
                figurineX++;
                j++;
                if(index == 0){
                    capX = figurineX;
                    capY = figurineY;
                } else if(index == 1){
                    ameX = figurineX;
                    ameY = figurineY;
                } else if(index ==2){
                    mocX = figurineX;
                    mocY = figurineY;
                } else if(index == 3){
                    latX = figurineX;
                    latY = figurineY;
                }
            }
            else if((i + 1) < 10 && board[i + 1][j] == true){ //if square directly below
                System.out.println("moving down 0");
                players.get(index).moveDown();
                if(index == 0){
                    capX = figurineX;
                    capY = figurineY;
                } else if(index == 1){
                    ameX = figurineX;
                    ameY = figurineY;
                } else if(index ==2){
                    mocX = figurineX;
                    mocY = figurineY;
                } else if(index == 3){
                    latX = figurineX;
                    latY = figurineY;
                }
                figurineY++;
                i++;
            }
            else if((j - 1) >= 0 && board[i][j - 1] == true){ //if square to the left
                System.out.println("moving left 0");
                players.get(index).moveLeft();
                if(index == 0){
                    capX = figurineX;
                    capY = figurineY;
                } else if(index == 1){
                    ameX = figurineX;
                    ameY = figurineY;
                } else if(index ==2){
                    mocX = figurineX;
                    mocY = figurineY;
                } else if(index == 3){
                    latX = figurineX;
                    latY = figurineY;
                }
                figurineX--;
                j--;
            }
            System.out.println("i = " + i + "\nj = " + j+"\ncapX= "+capX);

        }
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
        s.playEndSound();
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
    public void drawTriviaQuestions(){}
    //button methods
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == die){
            dieRoll = true;
            dieValue = jl.diceRolled();
            s.playSound();
            System.out.println("capX: " + capX + " capY: " + capY);
            checkMove(0,capX, capY);
        }
        else if(e.getSource() == start){
            startVar = true;
            start.setVisible(false);
            die.setVisible(true);
        }
        /*
        else if (showQ0 == true){
            aButton.setVisible(true);
            bButton.setVisible(true);
            cButton.setVisible(true);
            if(e.getSource(aButton) == start){
                //code 
            }
        }
        */
    //else if (showQuestionA = true){
        //code for whichever button is true and pressed then continue, for false options, set player invisible
        repaint();
    }
    //mouselistener methods
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    //create an animate method
    public void animate(){
        while(true){
            //have move methods for ame, cap, lat, moc in here
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            repaint();
        }
    }

}
