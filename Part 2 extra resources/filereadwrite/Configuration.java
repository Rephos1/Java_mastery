import java.util.*;
import java.io.*;

/**
 * reads from a text file which you can edit using any text editor
 * file name given as parameter to main()
 * NEEDS DE-BUGGING
 * @author Olenka Marczyk
 * @version 16/02/2009
 */
public class Configuration
{
    private BufferedReader reader;
    private ArrayList<Student> course = new ArrayList<Student>();
    
    public Configuration()
    {
        System.out.println("Reading from the text file config.txt\n");
    }
    
    /**
     * Load the Student configuration information.
     * @param fileName the file containing the data.
     */
    public void configure()
    {
        try
        {       
            reader = new BufferedReader (new FileReader ("config.txt"));  // filename used
            System.out.println ("Data read from the file");
            //read the file down to the first row of "*"s
            String line = reader.readLine();
            while (line != null)
            {
                StringTokenizer st = new StringTokenizer (line, ",");
                int sNumber = Integer.parseInt(st.nextToken());
                String sName = st.nextToken();
                double sFees = Double.parseDouble(st.nextToken());

                System.out.println (sNumber + ", " + sName + ", " + sFees );
                course.add(new Student(sName,sNumber,sFees));         
        
                line = reader.readLine();
            }                   
        }
        catch (Exception e) {System.out.println (e);}
        
    }
    
    public void printList()
    {
        System.out.println("\nData stored in the application ArrayList");
        System.out.println("Size : " + course.size()+ " students");
        for(Student ss : course)
        {
            System.out.println(ss.toString()); 
        }
    }
 
    public static void main(String[] args)
    {
        Configuration cc = new Configuration();
        cc.configure();
        cc.printList();
        System.out.println("\nRead the text file config.txt");
        System.out.println("Add an extra entry in config.txt");
        System.out.println("Then run again\n");
    }
}
