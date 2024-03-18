

/**
 * interface CARE specifies requirements for 5COM2007 Cwk 4
 *
 */
public interface CARE {

    //Create Team
    public void createTeam(String name);

    //Get Team Name
    public String getTeamName();

    //Get treasury amount
    public int getTreasury();

    //get Challenage number
    public int getChallengeNum();
    


    /**
     * Player chooses which challenge to go for 
     * 
     */
    public void chooseChallenge(int unique_id);


}