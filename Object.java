
/**
 * Write a description of class Object here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Object
{
    // instance variables - replace the example below with your own
    private String name;
    private String objDescription;
    public boolean listable;

    /**
     * Constructor for objects of class Object
     */
    public Object(String name, String objDescription, boolean listable)
    {
        // initialise instance variables
        this.name = name;
        this.objDescription = objDescription;
        this.listable = listable;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getDescription()
    {
        // put your code here
        return objDescription;
    }
    
    public String getObject()
    {
        return name;
    }
    
}
