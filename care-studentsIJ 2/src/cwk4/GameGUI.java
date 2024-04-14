package cwk4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/01/24
 */
public class GameGUI 
{
    private CARE tournament = new Tournament("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton meetBtn = new JButton("Meet Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();
    private JOptionPane selectChampion = new JOptionPane();
    private Component currentComponent = null;

    public static void main(String[] args)
    {
        new GameGUI();
    }
    
    public GameGUI()
    {
        EventQueue.invokeLater(() -> {
            makeFrame();
            makeMenuBar(myFrame);
        });
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(meetBtn);
        eastPanel.add(viewBtn);
        eastPanel.add(clearBtn);
        eastPanel.add(quitBtn);
        
        clearBtn.addActionListener(new ClearBtnHandler());
        meetBtn.addActionListener(new MeetBtnHandler());
        viewBtn.addActionListener((ActionEvent event) -> {
            String gameState = tournament.toString();
            listing.setText(gameState);
            setContent(listing);
        });
        quitBtn.addActionListener(new QuitBtnHandler());

        
        meetBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // building is done - arrange the components and show
        myFrame.setPreferredSize(new Dimension(600, 400));
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {

        JMenuItem listChampionItem = new JMenuItem("List Champions in reserve");
        listChampionItem.addActionListener(new ListReserveHandler());
        JMenuItem listChampionInTeamItem = new JMenuItem("List Champions in team");
        listChampionItem.addActionListener((ActionEvent event) -> {
            setContent(listing);
            String teamMembers = tournament.getTeam();
            listing.setText(teamMembers);
        });
        JMenuItem listChallengesItem = new JMenuItem("List Challenges");
        listChallengesItem.addActionListener((ActionEvent event) -> {
            setContent(listing);
            String challenges = tournament.getAllChallenges();
            listing.setText(challenges);
        });
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File menu
        JMenu championMenu = new JMenu("Champions");
        championMenu.add(listChampionItem);
        championMenu.add(listChampionInTeamItem);

        JMenu challengeMenu = new JMenu("Challenge");
        challengeMenu.add(listChallengesItem);

        menubar.add(championMenu);
        menubar.add(challengeMenu);
    }
    
    private class ListReserveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            setContent(listing);
            String xx = tournament.getReserve();
            listing.setText(xx);
        }
    }
    
   
    private class ClearBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText(" ");
        }
    }
    
    private class MeetBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String answer = "no such challenge";
            String inputValue = JOptionPane.showInputDialog("Challenge number ?: ");
            int num = Integer.parseInt(inputValue);
            result = tournament.meetChallenge(num);
            switch (result)
            {
                case 0:answer = "challenge won by champion"; break;
                case 1:answer = "challenge lost on skills, champion disqualified";break;
                case 2:answer = "challenge lost as no suitable champion is available";break;
                case 3:answer = "challenge lost and vizier completely defeated";break;
            }
            
            JOptionPane.showMessageDialog(myFrame,answer);    
        }
    }
    
    private class QuitBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }

    private void setContent(Component comp) {
        if(currentComponent != null) {
            currentComponent.setVisible(false);
            myFrame.remove(currentComponent);
        }
        currentComponent = comp;
        currentComponent.setVisible(true);
        myFrame.add(comp, BorderLayout.CENTER);
    }
    
}
   
