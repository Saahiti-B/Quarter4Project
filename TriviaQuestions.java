import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class TriviaQuestions extends ActionCard{
//trivia questions are multiple choice
    //ArrayList<String> questions;
    String[] questions;
    private Color temp;
    private int x;
    private int y;
    private BufferedImage questionMark;


    public TriviaQuestions(Color temp, int x, int y){
        super(temp, x, y);
        //questions = new ArrayList<String>();
        //questions.add("What is a word used to describe cold coffee? a)hot b)iced c) frothy");
        //questions.add("What is a word for a machine used to make foamy milk? a)roaster b)espresso c)frother");
        //questions.add()

         try{
            questionMark = ImageIO.read(new File("questionMarkImage.png"));
        }catch(IOException e){
            System.out.println(e);
        }

        questions = new String[5];
        questions[0] = "What is a word used to describe cold coffee? a)hot b)iced c) frothy"; //iced
        questions[1] = "What is a word for a machine used to make foamy milk? a)roaster b)espresso c)frother"; //frother
        questions[2] = "What is a word used to describe a ceramic cup often used for coffee? a)tumbler b)mug c)bowl"; //mug
        questions[3] =  "What is a word to describe a coffee seed? a)bag b)box c)bean"; //bean
        questions[4] = "What is the main ingredient that is used for alertness in coffee? a)chocolate b)milk c)caffeine"; //caffeine
    }
    public void drawCard(Graphics g){
        g.drawImage(questionMark,55,207, null);
        g.drawImage(questionMark,595,207, null);
        g.drawImage(questionMark,400,505, null);
    }

    public void questions(){
        
    }
}
