    import java.util.Set;
    import java.util.HashMap;
    
    /**
     * Class Room - a room in an adventure game.
     *
     * This class is part of the "World of Zuul" application. 
     * "World of Zuul" is a very simple, text based adventure game.  
     *
     * A "Room" represents one location in the scenery of the game.  It is 
     * connected to other rooms via exits.  For each existing exit, the room 
     * stores a reference to the neighboring room.
     * 
     * @author  Michael Kölling and David J. Barnes
     * @version 2011.08.08
     */
    
    public class Room 
    {
        private String description;
        private HashMap<String, Room> exits;        // stores exits of this room.
        private HashMap<String, Npc> characters;    // stores the characters in this room
        private HashMap<String, Object> objects;    // stores the objects in this room
    
        /**
         * Create a room described "description". Initially, it has
         * no exits. "description" is something like "a kitchen" or
         * "an open court yard".
         * @param description The room's description.
         */
        public Room(String description) 
        {
            this.description = description;
            exits = new HashMap<String, Room>();
            characters = new HashMap<String, Npc>();
            objects = new HashMap<String, Object>();
        }
    
        /**
         * Define an exit from this room.
         * @param direction The direction of the exit.
         * @param neighbor  The room to which the exit leads.
         */
        public void setExit(String direction, Room neighbor) 
        {
            exits.put(direction, neighbor);
        }
    
        public void setCharacter(String name, Npc character) 
        {
            characters.put(name, character);
        }
        
        public void setObject(String name, Object object)
        {
            objects.put(name, object); 
        }
        
        /**
         * @return The short description of the room
         * (the one that was defined in the constructor).
         */
        public String getShortDescription()
        {
            return description;
        }
    
        /**
         * Return a description of the room in the form:
         *     You are in the kitchen.
         *     Exits: north west
         * @return A long description of this room
         */
        public String getLongDescription()
        {
            return "You are " + description + ".\n" + getExitString() + "\n" + getCharacterString() + "\n" + getObjectString();
        }
    
        /**
         * Return a string describing the room's exits, for example
         * "Exits: north west".
         * @return Details of the room's exits.
         */
        private String getExitString()
        {
            String returnString = "Exits:\n";
            Set<String> keys = exits.keySet();
            for(String exit : keys) {
                returnString += "    " + exit + "\n";
            }
            return returnString;
        }
        
        private String getCharacterString()
        {
            String returnString = "People:\n";
            Set<String> keys = characters.keySet();
            for(String character : keys) {
                returnString += "    " + character + "\n";
            }
            return returnString;
        }
    
        private String getObjectString()
        {
            String returnString = "Objects:\n";
            Set<String> keys = objects.keySet();
            for(String object : keys) {
            Object object_value = objects.get(object);
            if(object_value.listable)
            {
                returnString += "    " + object + "\n";
            }
        }
        return returnString;
    }
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public Npc getCharacter(String name)
    {
        return characters.get(name);
    }
    
    public Object getObject(String name)
    {
        return objects.get(name);
    }
}

