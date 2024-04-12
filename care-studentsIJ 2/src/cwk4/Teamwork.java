package cwk4; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "CS08";
        
        details[1] = "Choudhury";
        details[2] = "Fahad";
        details[3] = "21051782";

        details[4] = "Pinter";
        details[5] = "Kitti";
        details[6] = "21062343";

        details[7] = "Lachezarov Barzakov";
        details[8] = "Radostin";
        details[9] = "22010580";


        details[10] = "Dani";
        details[11] = "Mihaly";
        details[12] = "21055390";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
