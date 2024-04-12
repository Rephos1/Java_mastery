package cwk4;
import cwk4.challenge.Challenge;
import cwk4.challenge.Type;
import cwk4.champion.*;

import java.util.*;
import java.io.*;
/**
 * This interface specifies the behaviour expected from CARE
 * as required for 5COM2007 Cwk 4
 * 
 * @author 
 * @version 
 */

public class Tournament implements CARE
{
   
    private String vizier;
    private boolean defeated = false;
    private int money = 1000;
    private HashMap<String, Champion> champions = new HashMap<>();
    private HashMap<Integer, Challenge> challenges = new HashMap<>();



//**************** CARE ************************** 
    /** Constructor requires the name of the vizier
     * @param viz the name of the vizier
     */  
    public Tournament(String viz)
    {
        setupChampions();
        setupChallenges();
    }
    
    /** Constructor requires the name of the vizier and the
     * name of the file storing challenges
     * @param viz the name of the vizier
     * @param filename name of file storing challenges
     */  
    public Tournament(String viz, String filename)  //Task 3.5
    {
      
        
       setupChampions();
       readChallenges(filename);
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        String s = "\nVizier: " + vizier +
                "\nTreasury: " + money +
                "\nDefeated: " + defeated +
                "\nChampion in Team: " + getTeam();
        return s;
    }
    
    
    /** returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     * @returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     */
    public boolean isDefeated()
    {
        return this.defeated;
    }
    
    /** returns the amount of money in the Treasury
     * @returns the amount of money in the Treasury
     */
    public int getMoney()
    {
        return this.money;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
        //String s = "************ Champions available in reserves********";
        StringBuilder sb = new StringBuilder("************ Champions available in reserves********");

        for(Champion ch : champions.values()) {
            if(ch.getState() != ChampionState.WAITING)
                continue;
            sb.append("\n");
            sb.append(ch);
        }
        return sb.toString();
    }
    
        
    /** Returns details of the champion with the given name. 
     * Champion names are unique.
     * @return details of the champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
        //inline if, learn it is useful!
        return champions.containsKey(nme) ? champions.get(nme).toString() : "No Champion with given name";
    }    
    
    /** returns whether champion is in reserve
    * @param nme champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme) {
        if(!champions.containsKey(nme))
            return false;
        return champions.get(nme).getState() == ChampionState.WAITING;
    }
 
    // ***************** Team champions ************************   
     /** Allows a champion to be entered for the vizier's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the vizier's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme)
    {
        if(!champions.containsKey(nme))
            return -1;
        Champion ch = champions.get(nme);
        if(ch.getState() != ChampionState.WAITING)
            return 1;
        if(ch.getEntryFee() > this.money)
            return 2;
        this.money -= ch.getEntryFee();
        ch.setState(ChampionState.ENTERED);
        return 0;
    }
        
     /** Returns true if the champion with the name is in 
     * the vizier's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the vizier's team, false otherwise.
     **/
    public boolean isInViziersTeam(String nme) {
        if(!champions.containsKey(nme))
            return false;
        return champions.get(nme).getState().equals(ChampionState.ENTERED);
    }
    
    /** Removes a champion from the team back to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because disqualified
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme) {
        if(!champions.containsKey(nme))
            return -1;
        Champion ch = champions.get(nme);
        if(ch.getState().equals(ChampionState.WAITING))
            return 2;
        if(ch.getState().equals(ChampionState.DISQUALIFIED))
            return 1;
        ch.setState(ChampionState.WAITING);
        this.money += ch.getEntryFee() / 2;
        return 0;
    }
        
    /**Returns a String representation of the champions in the vizier's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the vizier's team
     **/
    public String getTeam()
    {
        StringBuilder s = new StringBuilder("************ Vizier's Team of champions********");

//        ArrayList<Champion> chs = new ArrayList<>(champions.values());
//        for(int i = 0; i < chs.size(); i++) {
//            Champion ch = chs.get(i);
//
//        }


        for(Champion ch : champions.values()) {
            if(ch.getState().equals(ChampionState.ENTERED)){
                s.append("\n");
                s.append(ch);
            }
        }

        if(s.length() == 47) {
            s.append("\n");
            s.append("No champions entered");
        }
        return s.toString();
    }

     /**Returns a String representation of the disqualified champions in the vizier's team
     * or the message "No disqualified champions "
     * @return a String representation of the disqualified champions in the vizier's team
     **/
    public String getDisqualified()
    {
        StringBuilder s = new StringBuilder("************ Vizier's Team of disqualified champions ********");

        for(Champion ch : champions.values()){
            if(ch.getState().equals(ChampionState.DISQUALIFIED)){
                s.append("\n");
                s.append(ch);
            }
        }

        if(s.length() == 61) {
            s.append("\n");
            s.append("No disqualified champions ");
        }

        return s.toString();
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the  number of the challenge
     * @return true if the  number represents a challenge
     **/
     public boolean isChallenge(int num) {
         return challenges.containsKey(num);
     }    
   
    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num) {
        if(!isChallenge(num))
            return "\nNo such challenge";
        return challenges.get(num).toString();
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        StringBuilder s = new StringBuilder("************ All Challenges ************");
        for(Challenge ch : challenges.values()){
            s.append("\n");
            s.append(ch);
        }

        return s.toString();
    }
    
    
       /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team who can meet the 
     * challenge. The results of meeting a challenge will be 
     * one of the following:  
     * 0 - challenge won by champion, add reward to the treasury, 
     * 1 - challenge lost on skills  - deduct reward from
     * treasury and record champion as "disqualified"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and vizier completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int meetChallenge(int chalNo)
    {
        if(!champions.containsKey(chalNo)) {
            return -1;
        }
        Challenge ch = challenges.get(chalNo);
        //if(!champions.containsKey())

        return 0;
    }
 

    //****************** private methods for Task 3 functionality*******************
    //*******************************************************************************
    private void setupChampions() {
        champions.put("Ganfrank", new Wizard("Ganfrank", 7, 400, true, SpellSpecialities.TRANSMUTATION));
        champions.put("Rudolf", new Wizard("Rudolf", 6, 400, true, SpellSpecialities.INVISIBILITY));
        champions.put("Elblond", new Warrior("Elblond", 1, 150, Weapons.SWORD));
        champions.put("Flimsi", new Warrior("Flimsi", 2, 200, Weapons.BOW));
        champions.put("Drabina", new Dragon("Drabina", 7, 500, false));
        champions.put("Golum", new Dragon("Golum", 7, 500, true));
        champions.put("Argon", new Warrior("Argon", 9, 900, Weapons.MACE));
        champions.put("Neon", new Wizard("Neon", 2, 300, false, SpellSpecialities.TRANSLOCATION));
        champions.put("Xenon", new Dragon("Xenon", 7, 500, true));
        champions.put("Atlanta", new Warrior("Atlanta", 5, 500, Weapons.BOW));
        champions.put("Krypton", new Wizard("Krypton", 8, 300, false, SpellSpecialities.FIREBALLS));
        champions.put("Hedwig", new Wizard("Hedwig", 1, 400, true, SpellSpecialities.FLYING));
    }
     
    private void setupChallenges() {
        challenges.put(1, new Challenge("Borg", Type.MAGIC, 1, 3, 100));
        challenges.put(2, new Challenge("Huns", Type.FIGHT, 2, 3, 120));
        challenges.put(3, new Challenge("Ferengi", Type.MYSTERY, 3, 3, 150));
        challenges.put(4, new Challenge("Vandal", Type.MAGIC, 4, 9, 200));
        challenges.put(5, new Challenge("Borg", Type.MYSTERY, 5, 7, 90));
        challenges.put(6, new Challenge("Goth", Type.FIGHT, 6, 8, 45));
        challenges.put(7, new Challenge("Frank", Type.MAGIC, 7, 10, 200));
        challenges.put(8, new Challenge("Sith", Type.FIGHT, 8, 10, 170));
        challenges.put(9, new Challenge("Cardashian", Type.MYSTERY, 9, 9, 300));
        challenges.put(10, new Challenge("Jute", Type.FIGHT, 10, 2, 300));
        challenges.put(11, new Challenge("Celt", Type.MAGIC, 11, 2, 250));
        challenges.put(12, new Challenge("Celt", Type.MYSTERY, 12, 1, 250));
    }
        
    // Possible useful private methods
//     private Challenge getAChallenge(int no)
//     {
//         
//         return null;
//     }
//    
//     private Champion getChampionForChallenge(Challenge chal)
//     {
//         
//         return null;
//     }

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3.5 ************************************************/  
    
    // ***************   file write/read  *********************
    /**
     * reads challenges from a comma-separated textfile and stores in the game
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                //First line: Magic,Borg,3,100
                String[] parts = line.split(",");
                Type type = Type.valueOf(parts[0].toUpperCase());
                String name = parts[1];
                int skillRequired = Integer.parseInt(parts[2]);
                int reward = Integer.parseInt(parts[3]);

                challenges.put(i, new Challenge(name, type, i, skillRequired, reward));
                i++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }   
    
     /** reads all information about the game from the specified file 
     * and returns a CARE reference to a Tournament object, or null
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public Tournament loadGame(String fname)
    {   // uses object serialisation 
       Tournament yyy = null;
       
       return yyy;
   } 
   
   /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
   public void saveGame(String fname){
        // uses object serialisation 
        
    }
 

}



