 /**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private int id;
    // the amount of credits for study taken so far
    private int credits;
    // the fees
    private double fees;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, int studentID, double fs)
    {
        name = fullName;
        id = studentID;
        credits = 0;
        fees = fs;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the student ID of this student.
     */
    public int getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

 
    /**
     * return the student's name and ID number to the output terminal.
     */
    public String toString()
    {
        return (name + " (" + id + ")" + "\tcredits: " + credits + "  fees: " + fees);
    }
    

}
