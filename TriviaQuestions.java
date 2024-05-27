import java.awt.Graphics;
public class TriviaQuestions extends ActionCard{
//trivia questions are multiple choice
    String questions[][];

    public TriviaQuestions(String temp){
        super(temp);
         questions = {
                "What is a word used to describe cold coffee? a)hot b)iced c) frothy", //iced
                "What is a word for a machine used to make foamy milk? a)roaster b)espresso c)frother", //frother
                "What is a word used to describe a ceramic cup often used for coffee? a)tumbler b)mug c)bowl", //mug
                "What is a word to describe a coffee seed? a)bag b)box c)bean" //bean
                "What is the main ingredient that is used for alertness in coffee? a)chocolate b)milk c)caffeine" //caffeine
        };
    }
    public void card(Graphics g){

    }

    public void questions(){
        
    }
}
