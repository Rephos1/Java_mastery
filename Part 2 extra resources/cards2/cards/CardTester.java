package cards;

 


/**
 * Write a description of class CardTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTester
{   
    public void play()
    {
        Card myCard1 = new Card(Suit.CLUB, Card.JACK);
        Card myCard2 = new Card(Suit.SPADE, Card.JACK);
        System.out.println("Card1 : " + myCard1.getSuit());
        System.out.println("Card2 : " + myCard2.getSuit());
        // What is output here ?
        System.out.println("My face value is " + Card.JACK);
        System.out.println("Card1 : " + myCard1.getSuit());
        
        // Still OK but code simplifies in Card       
        System.out.println("Card1 : " + myCard1.getSuit());
        System.out.println("Card2 : " + myCard2.getSuit());
        System.out.println("Card1 : " + myCard1.getSuit());
        
        // Can no longer use int for Suit 
        //      Card myCard3 = new Card(2, 6); //what is created ? how would I know?
        
        Card myCard4 = new Card(Suit.CLUB, 11);
        //use of enum is "type"- safe as cannot use values outside enum
        Card myCard5 = new Card(Suit.CLUB, 23);   //compiles for face value  
        
        
        /** Still can't compare String and enum
        * but can write more readable code
        * see getSuit() in Card
        */
        if (myCard4.getSuit() == Suit.CLUB){
        System.out.println("Yes");
        }
        else {
        System.out.println("No");
        }
        
        System.out.println(myCard1.toString());
        System.out.println(myCard1.isHearts());
        System.out.println(myCard1.isClubs());
        Card myCard7 = new Card(Suit.SPADE, 7);
        System.out.println(myCard7.toString());
        
        //
        System.out.println("Show card: " + myCard1.displayCard());
        myCard1.turnDown();
        System.out.println("Turn down card: " + myCard1.displayCard());
        
        System.out.println("Cards of same suit:  " + myCard1.isSameSuit(myCard4));
        System.out.println("Cards of different suits:  " + myCard1.isSameSuit(myCard2));
        
        Card myCard8 = new Card(Suit.HEART, 7);
        System.out.println("Card is red  " + myCard8.toString() + " : " + myCard8.isRed());
        System.out.println("Card is not red  " + myCard1.toString() + " : " + myCard1.isRed());
        
    }
}   
