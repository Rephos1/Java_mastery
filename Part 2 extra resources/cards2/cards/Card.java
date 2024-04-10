package cards;

 

import java.util.*;
/**
 * One possible implementation of playing cards
 * public static final model picture cards
 * enum class Suit used model card suit 
 * 
 * @author A.Marczyk 
 * @version March 2024
 */
public class Card
{   
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    private Suit cardSuit;   // "type safe"
    private int faceValue;   // use of int is not "type safe" 
    private boolean faceUp;  // allows for change of state

    public Card(Suit st, int fv) //Note s is NOT int!!
    {  
        cardSuit = st;
        faceValue = fv; 
        faceUp = true;
    }
    
    public Card(Suit st, int fv, boolean fUp) //Note s is NOT int!!
    {  
        cardSuit = st;
        faceValue = fv; 
        faceUp = fUp;
    }
 
    public boolean isFaceUP() //report on state
    {  
        return faceUp;
    }
    
    public void turnDown()    // change state
    {
        faceUp = false;
    }
    
    public void turnUp()    // change state
    {
        faceUp = true;
    }
    
    
    public Suit getSuit()
    {  
        return cardSuit;
    }
    
    public boolean isHearts()
    {
        return cardSuit == Suit.HEART;
    }
    
    public boolean isSpades()
    {
        return cardSuit == Suit.SPADE;
    }
    
    public boolean isDiamonds()
    {
        return cardSuit == Suit.DIAMOND;
    }
    
    public boolean isClubs()
    {
        return cardSuit == Suit.CLUB;
    }
    
    public boolean isSameSuit(Card c)
    {
        return this.getSuit() == c.getSuit();
    }
    
    public boolean isRed()
    {
        return cardSuit == Suit.HEART || cardSuit == Suit.DIAMOND;
    }
    
    public String toString()
    {
        String s = "";
        
        // Notice how complex faceValue is
        if (faceValue >1 && faceValue <= 10)
        {
            s = s + " " + faceValue ;
        }
        else
        {
            if (faceValue ==1){s = " Ace ";}
            if (faceValue ==11){s = " Jack ";}
            if (faceValue ==12){s = " Queen ";}
            if (faceValue ==13){s = " King ";}
            
        }
        // Notice how simple suit using enum classis
        return s + " of " + cardSuit.toString();
    }
    
    public String displayCard()
    {
        String s = "";
        if (faceUp) {s =toString();}
        else {s= "\nCard face down";}
        return s;
    }
            
        
            
            
            
    
    
    
}

