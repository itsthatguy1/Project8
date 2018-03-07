/**
 * @author Sean Stock
 * @version 3.6.18
 */

public class Game
{
    private String currentRoom;

    /**
     * The main method in class Game
     * @param args
     */
    public static void main(String[] args)
    {
        String hall = "Hall";
        Game game = new Game(hall);
    }

    /**
     *  The constructor of class game. Creates a room object, then runs the moveTo method of that object.
     *  Will loop infinitely
     */
    public Game(String hall)
    {
        currentRoom = hall + ".csv";
        int i = 1;
        while (i == 1)
        {
            Room room = new Room(currentRoom);
            currentRoom = room.moveTo() + ".csv";
        }
    }
}
