/**
 * @author Sean Stock
 * @version 3.6.18
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Room
{
    private String roomDescription;
    private String connection1;
    private String connection2;
    private String connection3;
    private String connection4;
    private int roomNumber;
    private int chanceOccupied;
    private int chanceItem;
    private boolean roomOccupied;
    private boolean roomHasItem;
    private Random rand;
    private Scanner input;
    private Scanner reader;
    private File room;
    private static final int MAX_PERCENT = 100;

    /**
     * Constructor of class Room
     * @param currentRoom
     */
    public Room(String currentRoom)
    {
        rand = new Random();
        reader = new Scanner(System.in);
        try {
            room = new File("C:\\Java Projects\\Project8\\Data\\" + currentRoom);
            input = new Scanner(room);
            populateRoomInfo();
            determineOccuppied();
            determineHasItem();
            printInfo();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Oops");
        }
    }

    /**
     * Reads the information from the file containing information of the room.
     */
    public void populateRoomInfo()
    {
        roomDescription = input.nextLine();
        roomNumber = input.nextInt();
        chanceOccupied = input.nextInt();
        chanceItem = input.nextInt();
        input.nextLine();
        connection1 = input.nextLine();
        connection2 = input.nextLine();
        connection3 = input.nextLine();
        connection4 = input.nextLine();
    }

    /**
     * Determine whether the room is occupied or not.
     */
    public void determineOccuppied()
    {
        int percent = rand.nextInt(MAX_PERCENT) + 1;
        if (percent <= chanceOccupied)
        {
            roomOccupied = true;
        }
        else
        {
            roomOccupied = false;
        }
    }

    /**
     * Determines whether a room has a collectible item or not.
     */
    public void determineHasItem()
    {
        int percent = rand.nextInt(MAX_PERCENT) + 1;
        if (percent <= chanceItem)
        {
            roomHasItem = true;
        }
        else
        {
            roomHasItem= false;
        }
    }

    /**
     * Prints the relevant information about a room.
     */
    public void printInfo()
    {
        System.out.println("You entered " + roomDescription);
        System.out.println("Room is occupied: " + roomOccupied);
        System.out.println("You found an item: " + roomHasItem);
        System.out.println("Room connects to:");
        if (!connection1.equals("None"))
        {
            System.out.println("1. " + connection1);
        }
        if (!connection2.equals("None"))
        {
            System.out.println("2. " + connection2);
        }
        if (!connection3.equals("None"))
        {
            System.out.println("3. " + connection3);
        }
        if (!connection4.equals("None"))
        {
            System.out.println("4. " + connection4);
        }
    }

    /**
     * Prompts uer for which room they would like to move to.
     * There is a small chance that the user will enter a random room.
     * @return moveTo
     */
    public String moveTo()
    {
        final int RANDOM_ROOM_PERCENT = 5;
        final int NUMEBER_ROOMS = 4;
        String moveTo = reader.nextLine();
        while (!moveTo.equals(connection1) && !moveTo.equals(connection2) && !moveTo.equals(connection3) && !moveTo.equals(connection4) || moveTo.equals("None"))
        {
            System.out.println("You must enter a valid room.");
            moveTo = reader.nextLine();
        }
        int percent = rand.nextInt(MAX_PERCENT) + 1;
        if (percent <= RANDOM_ROOM_PERCENT)
        {
            int nextRoomNumber = rand.nextInt(NUMEBER_ROOMS) + 1 ;
            switch (nextRoomNumber)
            {
                case 1:
                    moveTo = "Hall";
                    break;
                case 2:
                    moveTo = "Dining Room";
                    break;
                case 3:
                    moveTo = "Kitchen";
                    break;
                case 4:
                    moveTo = "Library";
                    break;
            }
        }
        return moveTo;
    }

}
