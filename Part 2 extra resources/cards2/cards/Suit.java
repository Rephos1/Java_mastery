package cards;


/**
 * Enumeration class Suit - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Suit  //public inner class - there could be problems with this
{
    // A value for each suit along with its + faceValue
    
    // corresponding user interface string.
    CLUB("Clubs"), DIAMOND("Diamonds"), HEART("Hearts"),SPADE("Spades"), UNKNOWN("Unknown");

    // The suit.
    private String suitString;

    /**
     * Initialise with the corresponding suit string.
     * @param suitString The suit string.
     */
    Suit(String suitString)
    {
        this.suitString = suitString;
    } 

    /**
     * @return The Suit word as a string.
     */
    public String toString()
    {
        return suitString;
    }
}
