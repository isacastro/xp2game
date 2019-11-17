
/**
 * Write a description of class Npc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Npc
{
    // instance variables - replace the example below with your own
    private String name;
    private String text;

    /**
     * Constructor for objects of class Npc
     */
    public Npc(String name, String text)
    {
        // initialise instance variables
        this.name = name;
        this.text = text;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getText ()
    {
        // put your code here
        return name + ": " + text;
    }
    
    public String getName ()
    {
        return name;
    }
   
}
