    /**
     *  This class is the main class of the "World of Zuul" application. 
     *  "World of Zuul" is a very simple, text based adventure game.  Users 
     *  can walk around some scenery. That's all. It should really be extended 
     *  to make it more interesting!
     * 
     *  To play this game, create an instance of this class and call the "play"
     *  method.
     * 
     *  This main class creates and initialises all the others: it creates all
     *  rooms, creates the parser and starts the game.  It also evaluates and
     *  executes the commands that the parser returns.
     * 
     * @author  Michael Kölling and David J. Barnes
     * @version 2011.08.08
     */
    
    public class Game 
    {
        private Parser parser;
        private Room currentRoom;
        private static final String[] validSuspects = {
            "captain", "waiter", "owner", "madam"
        };
        private static final String killer = "madam";
            
        /**
         * Create the game and initialise its internal map.
         */
        public Game() 
        {
            createRooms();
            parser = new Parser();
        }
    
        /**
         * Create all the rooms and link their exits together.
         */
        private void createRooms()
        {
            Room navigation, hall, bar, firstfloor, nursery, spa, gym, playground, restaurant, kitchen, pantry, secondfloor, cabin, room001, room002, room003, room004, room005, room006, room007, room008, room009, room010, bathroom, lockerroom, lowerfloor, enginesroom, casino, securityroom, anchor, laundry;
            Npc victim, captain, barman, waiter, nurse, doctor, madam, chef, oldlady, lawyer, italian, teacher, journalist, singer, janitor, owner, security;
            Object panel, helm, pool, shelf, tables, cashier, stretcher, cabinet, hottub, equipments, toys, food, cookware, stove, bed, drawers, bedsidetable, saxophone, beds, journal, toilet, sink, showers, engines, slotmachines, notebook, screens, washingmachines, victim_obj, captain_obj, barman_obj, waiter_obj, nurse_obj, doctor_obj, madam_obj, chef_obj, oldlady_obj, lawyer_obj, italian_obj, teacher_obj, journalist_obj, singer_obj, janitor_obj, owner_obj, security_obj;
          
            // create the rooms
            
            // Top
            navigation = new Room("at the navigation room where the captain pilots the ship");
            hall = new Room("in a huge hall. It seems like a good place to relax, take a sunbath and have fun");
            bar = new Room("in a small bar, here the lights are soft");
            // First floor
            firstfloor = new Room("in the corridors of the first floor.");
            nursery = new Room("in a very clean nursery with bright lights.");
            spa = new Room("in a relaxing spa with soft lights and soft music playing in the background, the place feels warm.");
            gym = new Room("in the gym, a great place to exercise.");
            playground = new Room("in a playground, a good and fun place for kids.");
            restaurant = new Room("at the restaurant where all the ship's guests and most of the crew can dine or have lunch.");
            kitchen = new Room("in workplace where the food is made.");
            pantry = new Room("at the pantry where all the food and ingredients are stored.");
            // Second floor
            secondfloor = new Room("in th corridors of the second floor.");
            cabin = new Room("in the captain's cabin, a big and comfortable bedroom.");
            room001 = new Room("in a bedroom. After the captain's cabin, this is the biggest and most comfrotable bedroom of the ship. Here is where a madam is hosted.");
            room002 = new Room("in a small default bedroom bedroom. This is where a old lady is hosted.");
            room003 = new Room("in a small default bedroom bedroom. This is where a lawyer is hosted.");
            room004 = new Room("in a small default bedroom bedroom. This is where the victim was hosted.");
            room005 = new Room("in a small default bedroom bedroom. This is where a italian man is hosted.");
            room006 = new Room("in a small default bedroom bedroom. This is where a teacher is hosted.");
            room007 = new Room("in a small default bedroom bedroom. This is where journalist is hosted.");
            room008 = new Room("in a small default bedroom bedroom. This is where a famous singer is hosted.");
            room009 = new Room("in a spacious but not too comfortable bedroom. This room is where part of the ship's crew stays.");
            room010 = new Room("in a spacious but not too comfortable bedroom. This room is where part of the ship's crew stays.");
            bathroom = new Room("at the main bathroom of the ship.");
            lockerroom = new Room("at the main locker room of the ship. It's avaliable for tourists and crew.");
            // Lower floor
            lowerfloor = new Room ("in the corridors of the lower floor.");
            enginesroom = new Room("in a big room where all the main engines of the ship are operated.");
            casino = new Room("at the casino of the ship. Here's a place to play games, party and earn money... or lose it.");
            securityroom = new Room("in a room where only the security crew may enter.");
            anchor = new Room("in a big room where the anchor of the ship is mantained.");
            laundry = new Room("at the laundry of the ship, only available for crew members.");
            
            // create new character
            
            victim = new Npc("victim", " ");
            captain = new Npc("captain", "The victim? Uh... Well... Yeah, uh, I kinda knew him... I mean, from TV of course...");
            barman = new Npc("barman", "Well, the guy was very rude to all of us from the crew, but honestly, none of uf really care, we're used to it, but... *lowers voice* the waiter, right there... well, he was actually very mad with the way the guy was treating him.");
            waiter = new Npc("waiter", "Look, I was mad, the guy's a prick! And I admit I spit on all of his drinks, but that's all, I'd never be capable of... killing somoene.");
            nurse = new Npc("nurse", "Oh, poor boy... He was so young, I've been working on this ship for years, I'd never think of someone dying.");
            doctor = new Npc("doctor", "Yes, I agree, it's really weird, how could a olympics champion swimmer drown in a pool? But there's no bruise neither a sign of blood or anything, what else could've happened?");
            madam = new Npc("madam", "It's so sad, such a handsome young man, but I don't understand... what exactly are you investigating? There's no murder, he just uh... drown right? That's what I heard, I wasn't there...");
            chef = new Npc("chef", "Sorry, I didn't see anything, I'm always here in the kitchen, the restaurant or in the crew's bedroom, but, I always saw him having dinner or lunch with that madam, I think thay had someting going on.");  
            oldlady = new Npc("oldlady", "A swimmer what?? I can't hear you son."); 
            lawyer = new Npc("lawyer", "Oh, it might have been a murder? Well, I was at the gym last night but if someone is accused, let me know.");
            italian = new Npc("italian", "Non capisco una parola di quello che stai dicendo.");
            teacher = new Npc("teacher", "Sorry man, I didn't see anything, but I'm glad you're investigating this whole thing, it's ridiculous to think such a great swimmer like him would drown in a ordinary pool.");
            journalist = new Npc("journalist", "Honey, of course I can help! I write about famous people on Famous People Magazine, I heard the olympic champion swimmer, the rich and beautiful madam and the amazing rockstar singer would be here, so I came to follow them around and write about their vacations. Last night the swimmer told me to wait for him in my room cause he had some breaking news to tell, I waited for him all night but he didn't come. This morning I was shocked to know why he didn't come! I never got to know what he wanted to say, but if I could guess, I think he was dating the madam, I saw them togheter all the time with a romantic gaze. I just think it's weird, the madam's husband died like, less than a month ago and she's already flirting with someone else!");
            singer = new Npc("singer", "Look pal, I came here for a pocket show, turns out this cruise ended up a show of horrors! I'm never accepting to sing in a ship again!");
            janitor = new Npc("janitor", "Nah, I don't know anything about that guy he wouldn't even look at our faces. Wait a second... yes! I know something! He was friends with the captain, yes.");
            owner = new Npc("owner", "Yes, I own this asino but I don't really know anything about the people of the ship... why would I know anything, huh?!");
            security = new Npc("security", "Oh man, the cameras stopped working months ago. This is so frustating, I told tha captain to fix it so many times but he insists there's no need for cameras.");
            
            // create new object
            
            //Top
            panel = new Object("panel", "A control panel, it helps the captain pilot the ship.", true);
            helm = new Object("helm", "Wooden old helm, seems to be working just fine.", true);
            pool = new Object("pool", "The pool is normally filled with water, there's no sign of anything strange.", true);
            shelf = new Object("shelf", "A shelf with several bottles of alcoholic drinks.", true);
            tables = new Object("tables", "A few wooden tables.", true);
            cashier = new Object("cashier", "A balcony where drinks are made and paid.", true);
            // First floor
            stretcher = new Object("stretcher", "A normal hospital stretcher.", true);
            cabinet = new Object("cabinet", "A cabinet full of medicine. A bottle of medicine appears to be missing", true);
            hottub = new Object("huttub", "A hot tub full of a very warm and relaxing water", true);
            equipments = new Object("equipments", "Several gym equipments, they all seem to be new and working perfectly", true);
            toys = new Object("toys", "There are many toys all over the room, dools, a ball, lego pieces, crayons and more.", true);
            food = new Object("food", "There's a lot of food stored in shelfs. They're all fresh and clean.", true);
            cookware = new Object("cookware", "Many kitchen utensins and cookware such as spoons, knives and pans.", true);
            stove = new Object("stove", "A very old industrial stove. Besides being old not just the stove but the whole kitchen seems very clean.", true);
            //Second floor
            bed = new Object("bed", "A regular bed with some clean pillows.", true);
            drawers = new Object("drawers", "Wooden drawers, there's a picture of the captain and the victim. They seem to be festive and happy.", true);
            bedsidetable = new Object("bedsidetable", "A old wooden bedside table. There's a small glass bottle with no labels on it.", true);
            saxophone = new Object("saxophone", "A beautiful golden saxophone.", true);
            beds = new Object("beds", "There's a few small beds in the room.", true);
            journal = new Object("journal", "There's a journal on top of one of the beds. It belongs to the bar's waiter. In the last written page it says: 'I'm so frustrated! I was such a fan of this stupid swimmer, how could I imagine he's such a jerk? Today he spoke to me like I wasn't even really there!'.", true);
            toilet = new Object("toilet", "There are several regular toilet cabins.", true);
            sink = new Object("sink", "There are several sinks.", true);
            showers = new Object("showers", "There are several shower cabins.", true);
            // Lower floor
            engines = new Object("engines", "The main engines of the ship. They're big and noisy.", true);
            slotmachines = new Object("slotmachines", "There are several slot machines on the casino, each one with a different game.", true);
            notebook = new Object("notebook", "There's a small notebook on top of the casino's balcony. On the notebook, there's a list of debtors. On the top of the list with the biggest debt, the name of the swimmer.", true);
            screens = new Object("screens", "A panel with a few screens. They were supposed to show the cameras recordings, but they're all turned off.", true);
            washingmachines = new Object("washingmachines", "There's many washing machines on the room. Some are turned on, some are turned off.", true);
            // Characters descriptions
            victim_obj = new Object("victim", "The victim is a very famous olympic champion swimmer. He lays lifeless on the floow, close to the pool. His entire body is wet and there's no sign of bruises of blood", true);
            captain_obj = new Object("captain", "The captain is a short man with a dark beard. He's sweating and seems nervous and worried", false);
            barman_obj = new Object("barman", "The barman is a tall man with blue eyes. He's using a clean uniform. He seems very calm but yet curious.", false);
            waiter_obj = new Object("waiter", "The waiter is a strong looking man. He looks a little bit nervous and upset.", false);
            nurse_obj = new Object("nurse", "The nurse is a small and delicate woman. She has a very compassionate look in her eyes.", false);
            doctor_obj = new Object("doctor", "The doctor is a skinny man with dark and big glasses. He looks a little confused.", false);
            madam_obj = new Object("madam", "The madam is a beautiful bronze skined woman. She very classy and rich. This time tough she looks specifically anxious, her hands are trembling.", false);
            chef_obj = new Object("chef", "The chef is a fat and lovely man. He looks calm", false);
            oldlady_obj = new Object("oldlady", "The old lady is  a very small and skinny woman. She wears a blue dress and looks very confused.", false);
            lawyer_obj = new Object("lawyer", "The lawyer is a tall young man. He looks very interested on the case.", false);
            italian_obj = new Object("italian", "The italian is a handsome man with beautiful hazel eyes. He looks extremely confused though.", false);
            teacher_obj = new Object("teacher", "The teacher is a simple middle aged man using old clothes. He looks tired and upset.", false);
            journalist_obj = new Object("journalist", "The journalist is a young and energetic woman with a gorgeous big and natural afro hair. She speaks very fast and seems to be excited.", false); 
            singer_obj = new Object("singer", "The singer used to be a very famous musician. He looks very uninterested and bored.", false);
            janitor_obj = new Object("janitor", "The janitor of the ship is a old and bald man. He looks very kind and toughtfull.", false);
            owner_obj = new Object("owner", "The owner of the casino is a huge muscular man. He sweats and can't stop looking around as he speaks.", false); 
            security_obj = new Object("security", "The security is a tall woman, she looks very upset and frustrated.", false);
            
            // initialise room exits
            
            // Top
            hall.setExit("navigation", navigation);
            hall.setExit("bar", bar);
            hall.setExit("downstairs", secondfloor);
            navigation.setExit("outside", hall);
            bar.setExit("outside", hall);
            // First floor
            firstfloor.setExit("nursery", nursery);
            firstfloor.setExit("spa", spa);
            firstfloor.setExit("gym", gym);
            firstfloor.setExit("playground", playground);
            firstfloor.setExit("restaurant", restaurant);
            firstfloor.setExit("upstairs", hall);
            firstfloor.setExit("downstairs", secondfloor);
            nursery.setExit("outside", firstfloor);
            spa.setExit("outside", firstfloor);
            gym.setExit("outside", firstfloor);
            playground.setExit("outside", firstfloor);
            restaurant.setExit("kitchen", kitchen);
            restaurant.setExit("outside", firstfloor);
            kitchen.setExit("pantry", pantry);
            kitchen.setExit("outside", restaurant);
            pantry.setExit("outside", kitchen);
            // Second floor
            secondfloor.setExit("cabin", cabin);
            secondfloor.setExit("room001", room001);
            secondfloor.setExit("room002", room002);
            secondfloor.setExit("room003", room003);
            secondfloor.setExit("room004", room004);
            secondfloor.setExit("room005", room005);
            secondfloor.setExit("room006", room006);
            secondfloor.setExit("room007", room007);
            secondfloor.setExit("room008", room008);
            secondfloor.setExit("room009", room009);
            secondfloor.setExit("room010", room010);
            secondfloor.setExit("bathroom", bathroom);
            secondfloor.setExit("lockerroom", lockerroom);
            secondfloor.setExit("upstairs", firstfloor);
            secondfloor.setExit("downstairs", lowerfloor);
            cabin.setExit("outside", secondfloor);
            room001.setExit("outside", secondfloor);
            room002.setExit("outside", secondfloor);
            room003.setExit("outside", secondfloor);
            room004.setExit("outside", secondfloor);
            room005.setExit("outside", secondfloor);
            room006.setExit("outside", secondfloor);
            room007.setExit("outside", secondfloor); 
            room008.setExit("outside", secondfloor);
            room009.setExit("outside", secondfloor);
            room010.setExit("outside", secondfloor);
            bathroom.setExit("outside", secondfloor);
            lockerroom.setExit("outside", secondfloor);
            // lower floor
            lowerfloor.setExit("upstairs", secondfloor);
            lowerfloor.setExit("enginesroom", enginesroom);
            lowerfloor.setExit("casino", casino);
            lowerfloor.setExit("securityroom", securityroom);
            lowerfloor.setExit("anchor", anchor);
            lowerfloor.setExit("laundry", laundry);
            enginesroom.setExit("outside", lowerfloor);
            casino.setExit("outside", lowerfloor);
            securityroom.setExit("outside", lowerfloor);
            anchor.setExit("outside", lowerfloor);
            laundry.setExit("outside", lowerfloor);
    
            // initialise room characters
            
            // Top
            navigation.setCharacter("captain", captain);
            hall.setCharacter("victim", victim);
            bar.setCharacter("barman", barman);
            bar.setCharacter("waiter", waiter);
            // First floor
            nursery.setCharacter("nurse", nurse);
            nursery.setCharacter("doctor", doctor);
            spa.setCharacter("madam", madam);
            gym.setCharacter("italian", italian);
            restaurant.setCharacter("journalist", journalist);
            restaurant.setCharacter("teacher", teacher);
            kitchen.setCharacter("chef", chef);
            // Second floor
            room002.setCharacter("oldlady", oldlady);
            room003.setCharacter("lawyer", lawyer);
            room008.setCharacter("singer", singer);
            room009.setCharacter("janitor", janitor);
            // Lower floor
            casino.setCharacter("owner", owner);
            securityroom.setCharacter("security", security);
            
            // initialise room objects
            
            // Top
            navigation.setObject("panel", panel);
            navigation.setObject("helm", helm);
            hall.setObject("pool", pool);
            bar.setObject("shelf", shelf);
            bar.setObject("tables", tables);
            bar.setObject("cashier", cashier);
            // First floor
            nursery.setObject("stretcher", stretcher);
            nursery.setObject("cabinet", cabinet);
            spa.setObject("hottub", hottub);
            gym.setObject("equipments", equipments);
            playground.setObject("toys", toys);
            restaurant.setObject("tables", tables);
            kitchen.setObject("cookware", cookware);
            kitchen.setObject("stove", stove);
            pantry.setObject("food", food);
            // Second floor
            cabin.setObject("bed", bed);
            cabin.setObject("drawers", drawers);
            room001.setObject("bed", bed);
            room001.setObject("bedsidetable", bedsidetable);
            room002.setObject("bed", bed);
            room003.setObject("bed", bed);
            room004.setObject("bed", bed);
            room005.setObject("bed", bed);
            room006.setObject("bed", bed);
            room007.setObject("bed", bed);
            room008.setObject("bed", bed);
            room008.setObject("saxophone", saxophone);
            room009.setObject("beds", beds);
            room010.setObject("beds", beds);
            room010.setObject("journal", journal);
            bathroom.setObject("toilet", toilet);
            bathroom.setObject("sink", sink);
            lockerroom.setObject("showers", showers);
            // Lower floor
            enginesroom.setObject("engines", engines);
            casino.setObject("slotmachines", slotmachines);
            casino.setObject("notebook", notebook);
            securityroom.setObject("screens", screens);
            laundry.setObject("washingmachines", washingmachines);
            
            navigation.setObject("captain", captain_obj);
            hall.setObject("victim", victim_obj);
            bar.setObject("barman", barman_obj);
            bar.setObject("waiter", waiter_obj);
            // First floor
            nursery.setObject("nurse", nurse_obj);
            nursery.setObject("doctor", doctor_obj);
            spa.setObject("madam", madam_obj);
            gym.setObject("italian", italian_obj);
            restaurant.setObject("journalist", journalist_obj);
            restaurant.setObject("teacher", teacher_obj);
            kitchen.setObject("chef", chef_obj);
            // Second floor
            room002.setObject("oldlady", oldlady_obj);
            room003.setObject("lawyer", lawyer_obj);
            room008.setObject("singer", singer_obj);
            room009.setObject("janitor", janitor_obj);
            // Lower floor
            casino.setObject("owner", owner_obj);
            securityroom.setObject("security", security_obj);
            
            currentRoom = hall; // start game outside
        }
    
        /**
         *  Main play routine.  Loops until end of play.
         */
        public void play() 
        {            
            printWelcome();
    
            // Enter the main command loop.  Here we repeatedly read commands and
            // execute them until the game is over.
                    
            boolean finished = false;
            while (! finished) {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            System.out.println("Thank you for playing.  Good bye.");
        }
    
        /**
         * Print out the opening message for the player.
         */
        private void printWelcome()
        {
            System.out.println();
            System.out.println("Welcome to our cruise!");
            System.out.println("Something strange happened last night.");
            System.out.println("A very famous olympic champion swimmer has drowned in the pool and died.");
            System.out.println("But isn't it strange for someone like him to die like that? Something is wrong!");
            System.out.println("You are a detective and you should investigate the case. Walk around the ship, talk to people and inspect the people and objects!");
            System.out.println("Type 'help' if you need help.");
            System.out.println();
            System.out.println(currentRoom.getLongDescription());
        }
    
        /**
         * Given a command, process (that is: execute) the command.
         * @param command The command to be processed.
         * @return true If the command ends the game, false otherwise.
         */
        private boolean processCommand(Command command) 
        {
            boolean wantToQuit = false;
    
            if(command.isUnknown()) {
                System.out.println("I don't know what you mean...");
                return false;
            }
            String commandWord = command.getCommandWord();
            if (commandWord.equals("help")) {
                printHelp();
            }
            else if (commandWord.equals("go")) {
                goRoom(command);
            }
            else if (commandWord.equals("talk")) {
                talkTo(command);
            }
            else if (commandWord.equals("inspect")) {
                inspect(command);
            }
            else if (commandWord.equals("here")) {
                System.out.println(currentRoom.getLongDescription());
            }
            else if (commandWord.equals("veredict")) {
                wantToQuit = veredict(command);
            }
            else if (commandWord.equals("quit")) {
                wantToQuit = quit(command);
            }
            // else command not recognised.
            return wantToQuit;
        }
    
        // implementations of user commands:
    
        /**
         * Print out some help information.
         * Here we print some stupid, cryptic message and a list of the 
         * command words.
         */
        
        private void printHelp() 
        {
            System.out.println("Your command words are:");
            parser.showCommands();
        }
    
        /** 
         * Try to in to one direction. If there is an exit, enter the new
         * room, otherwise print an error message.
         */
        private void goRoom(Command command) 
        {
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Go where?");
                return;
            }
    
            String direction = command.getSecondWord();
    
            // Try to leave current room.
            Room nextRoom = currentRoom.getExit(direction);
    
            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        
        private void talkTo(Command command)
        {
            if(!command.hasSecondWord()) {
                System.out.println("Who do you want to talk to?");
                return;
            }
            
            String name = command.getSecondWord();
            
            // Try to get character
            Npc character = currentRoom.getCharacter(name);
            
            if(character == null)
            {
                System.out.println(name + " is not here.");
            }
            else
            {
                System.out.println(character.getText());
            }
        }
    
        private void inspect(Command command)
        {
            if(!command.hasSecondWord()) {
                System.out.println("What do you wish to inspect?");
                return;
            }
            
            String name = command.getSecondWord();
            
            Object object = currentRoom.getObject(name);
            
            if(object == null)
            {
                System.out.println("There is no " + name + " in here");
            }
            else
            {
                System.out.println(object.getDescription());
            }
            
        }
        
        private boolean veredict(Command command)
        {
            if(!command.hasSecondWord()) 
            {
                System.out.println("Who do you think killed the swimmer?");
                return false;
            }
            
            String name = command.getSecondWord();
            
            boolean valid = isValidSuspect(name);
            
            if(!valid)
            {
                System.out.println(name + " is not a suspect.");
                return false;
            }
            else
            {
                if(name.equals(killer))
                {
                    System.out.println("You accused the wright person!");
                    System.out.println("The madam had an affair with the victim during the cruise.");
                    System.out.println("He found out she actually killed her husband to get all of his money.");
                    System.out.println("After that, the swimmer started blackmailing her to get her money and pay his debt to the casino owner.");
                    System.out.println("He was about to tell the journalist about the madam's secret, but she was faster.");
                    System.out.println("The madam poisoned him at the bar and brought him at the pool so everybody would think he drowned."); 
                    return true;
                }
                else 
                {
                    System.out.println("Oops! You accused the wrong person.");
                    return false;
                }
            }
        }
        
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private boolean isValidSuspect(String suspect)
    {
        for(String validSuspect: validSuspects)
        {
            if(validSuspect.equals(suspect))
            {
                return true;
            }
        }
        return false;
    }
        
}
