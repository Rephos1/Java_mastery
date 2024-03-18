/**
 * interface CARE specifies requirements for 5COM2007 Cwk 4
 *
 */

public interface CARE{

    /**
     * Returns all of the details of the CARE
     */
    public String toString();

    /**
     * Initializes the game and loads sample data.
     */
    public void startGame();


    public void enterName(String playerNme);


    //get Challenage number
    public int getChallengeNum();


    // 
    public void chooseChallenge(int unique_id);
    

    /**
     * Gets the details of a specific champion, which is available.
     * @param championName The name of the champion to get details for.
     * @return String containing the details of the specified champion.
     */
    public String getChampionDetails(String champ_Name);
   
    
    /**
     * Gets the current state of a single champion
     * @param champ_name
     * @return
     */

    public String getChampionState(String champ_name);





     /**
     * Gets the details of a specific champion, which is in the team.
     * @param championName The name of the champion to get details for.
     * @return String containing the details of the specified champion.
     */
    public String getTeamChampionDetails(String ch_name);

    //As the Vizier get the    
    //public Array getReserveList();
    
    /**
     * Provides the current balance of the treasury.
     * @return int indicating the current amount of gulden in the treasury.
     */
    public int getTreasuryStatus();

    /**
     * Lists all available champions not yet on the Vizier's team.
     * @return String listing all available champions.
     */
    public String listAvailableChampions();

    /**
     * Lists all champions currently on the Vizier's team.
     * @return String listing all champions in the team.
     */
    public String listTeamChampions();

    /**
     * Deduct gulden from the Viziers Treasury
     * @param amount The amount of gulden being deducted
     */
    public void deductGulden(int amount);

    public void changeChampionState(String name);

    public void retireChampion(String name);

    /**
     *  Enter champion into the tournament, check if its eligibility before entering
     * @param name The name of the champion
     * @return
     */    
    public void enterChampion(String name);

    /**
     * Checks whether the Champion can enter the tournament
     * @param name The name of the champion
     * @return true if the champion can enter, false if not
     */
    public boolean canChampionEnter(String name);


    /**
     * Gets all the challenge details for the Vizier.
     * @return Strings listing all the details of all the challenges
     */
    public String getAllChallengesDetails();

    /**
     * Terminate the game, displaying appropriate message
     */    
    public void endGame();

    /**
     * Vizier chooses which challenge to go for 
     * @return void
     */  




}