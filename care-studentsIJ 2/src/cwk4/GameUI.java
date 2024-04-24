package cwk4;
import java.io.*;
import java.util.*;
/**
 * Command line interface
 * 
 * @author A.A.Marczyk
 * @version 10/03/2024
 */
public class GameUI
{
    
    private Scanner myIn = new Scanner(System.in);

    public void runGame()
    {
        Tournament tr ;
        int choice;
        String vizierName;
        String output = "";
        int result = -1; 
        try
        {
            System.out.println("Enter vizier's name");
            String s = myIn.nextLine();
            //myIn.nextLine();
            tr = new Tournament(s); // create
            //tr = new Tournament(s,"challengesAM.txt"); // alternative create task 3.5
            choice = 100;
            while (choice != 0 )
            {
                choice = getMenuItem();
                if (choice == 1)
                {
                    System.out.println(tr.getReserve());
                }
                else if (choice == 2)
                {
                    System.out.println(tr.getTeam());
                }
                else if (choice == 3)
                {
                    System.out.println("Enter Champion name");
                    String ref = (myIn.nextLine()).trim();
                    System.out.println(tr.getChampionDetails(ref));
                } 
                else if (choice == 4)
                {
                    System.out.println("Enter the Champion name");
                    String name = (myIn.nextLine()).trim();
                    result = tr.enterChampion(name);
                    if (result == 0) {
                        output = "Your Champion: " + name + " is entered in the team";
                    } else if (result == 1) {
                        output = "The Champion: " + name + " not in reserve";
                    } else if (result == 2) {
                        output = "You are poor! You don't have enough money to buy this champion.";
                    } else {
                        output = "No such champion found";
                    }
                    System.out.println("\n" + output);
                    System.out.println("Your new Treasury Balance is: " + tr.getMoney());

                }
                else if (choice == 5)
                {
                    // provide code here
                    // output should be meaningful
                    System.out.println("Type the number of a challenge you wish to enter: ");
                    String challengeNumber = (myIn.nextLine()).trim();
                    int number = Integer.parseInt(challengeNumber);

                    if (tr.isChallenge(number)) {
                        result = tr.meetChallenge(number);
                    }

                    output = processChallengeResult(result);
                    System.out.println("\n" + output);
                    System.out.println("Your new Treasury Balance is: " + tr.getMoney());

                }
                else if (choice==6)
                {
                    // provide code here
                    // output should be meaningful
                    System.out.println("Enter Champion name");
                    String championName = (myIn.nextLine()).trim();
                    result = tr.retireChampion(championName);
                    if (result == 0) {
                        output = "\nChampion " + championName + " is retired";
                    } else if (result == 1) {
                        output = "\nChampion " + championName + " has already dead. Cannot retire him.";
                    } else if (result == 2) {
                        output = "\nChampion " + championName + " cannot be retired as he is not in the team";
                    } else {
                        output = "\nNo such champion found ";
                    }
                    System.out.println("\n" + output);
                    System.out.println("Your new Treasury Balance is: " + tr.getMoney());
                }  
                else if (choice==7)
                {
                    // provide code here
                    System.out.println(tr);
                }
                else if (choice==8)
                {
                    System.out.println(tr.getAllChallenges());
                }
                else if (choice == 9) // Task 3.5 only
                {
                    System.out.println("Write to file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    tr.saveGame(filename);
                }
                else if (choice == 10) // Task 3.5 only
                {
                    System.out.println("Restore from file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    CARE tr2= tr.loadGame(filename);
                    if (tr2 != null)
                    {
                        System.out.println(tr2.toString());
                    }
                    else
                    {
                        System.out.println("No such file");
                    }
                }
            }     
        }
        catch (IOException e) {System.out.println (e);}   
        System.out.println("Thank-you");
    }
    
    private int getMenuItem()throws IOException
    {   int choice = 100;  
        System.out.println("\nMain Menu");
        System.out.println("0. Quit");
        System.out.println("1. List champions in reserve");
        System.out.println("2. List champions in viziers team"); 
        System.out.println("3. View a champion");
        System.out.println("4. Enter champion into vizier's team");
        System.out.println("5. Meet a challenge");
        System.out.println("6. Retire a champion");
        System.out.println("7. View game state");
        System.out.println("8. See all challenges");
        System.out.println("9. Save this game");
        System.out.println("10. Load this game");
       
        
        while (choice < 0 || choice  > 10)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        myIn.nextLine();
        return choice;        
    }  
    
    private String processChallengeResult(int res) {
    
        String out;
        if (res ==0)
        {
            out = "Challenge won";
        }
        else if (res ==1)
        {
            out = "Challenge lost on skill level";
        }
        else if (res ==2)
        {
            out = "Challenge lost as no champion available";
        }
        else if (res ==3)
        {
            out = "Challenge lost with no further resources. You lose the game ";
        }
        else if (res == -1)
        {
            out = "No such challenge";
        }
        else
        {
            out = "No such result";
        }
        return out; 
    }
    
    public static void main(String[] args)
    {
        new GameUI().runGame();
    }
}