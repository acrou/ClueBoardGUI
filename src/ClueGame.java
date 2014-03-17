import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
//Trying to confirm successfull construction of a ClueGame object.
//Failing at loading computer people if hasNext method.

/**
 * Created by Marissa on 3/10/14.
 */
public class ClueGame
{
    //This includes the list of cards, list of computer players, one human player, and an indicator of whose turn it is.
    private ArrayList<Card> deck;
    private Map<Card.CardType, Integer> numTypes;
    private ArrayList<Player> players;
    private Player human;
    private Player current;
    private Board board;
    private Solution solution;
    private String peopleFileName;
    private ArrayList<Integer> startingLocation;




    public ClueGame(Board b) throws FileNotFoundException {
        board = b;
        peopleFileName ="playerNames.txt";
        players = new ArrayList<Player>();
        startingLocation = new ArrayList<Integer>();
        readnInStartingLocations();
        loadPeople();

    }
    public void readnInStartingLocations() throws FileNotFoundException {
        File file = new File ("startLocations.txt");
        Scanner scan = new Scanner (file);
        int count  = 0;
        while(count<6){
           startingLocation.add(Integer.parseInt(scan.nextLine()));
           count++;
        }

    }
    public void readInHuman(){
        Scanner scan = new Scanner (System.in);
//        System.out.println("Enter your name: ");
//        String name  = scan.next();
        String name = "Test name";
        BoardCell start = board.getCellAt(0);
        HumanPlayer middleEarthAdventurist = new HumanPlayer(name, start, Color.RED);
        middleEarthAdventurist.setLocation(startingLocation.get(0), board);
        players.add(middleEarthAdventurist);
        //Enter Name
        //Color and Room be predetermined, no free will

    }
    public void loadPeople () throws FileNotFoundException {
        readInHuman();
        FileReader people = new FileReader (peopleFileName);
        Scanner scan = new Scanner (people);

        while (scan.hasNext()){
            ComputerPlayer computer = new ComputerPlayer();
            computer.setLocation(startingLocation.get(ComputerPlayer.counter), board);
            computer.setName(scan.nextLine());
            players.add(computer);


        }
        scan.close();


    }
    public Solution getSolution (){
        solution = new Solution("Gandalf Grey", "Gondor", "Aeglos");
        return solution;

    }
    public boolean isCorrectSolution(Solution accusation){
        return solution.equals(accusation);
    }
    public ArrayList<Integer> getStartingLocation(){
        return startingLocation;
    }

    public Player getPlayer(int row, int column){

        for(Player p: players){
            if(p.getLocation().getRow()==row && p.getLocation().getColumn()==column)
                return p;
        }
        return  null;


    }
    public Player getHuman (){
        return human;
    }
    public ArrayList<Card> getDeck (){

        return deck;
    }
    public ArrayList <Player> getPlayers(){
        return players;
    }
    public Map<Card.CardType, Integer> getNumTypes (){
        return numTypes;
    }
    public boolean hasInDeck(String name){
        for(Card c: deck){
            if(c.getName().equals(name))
                return true;
        }
        return false;
    }
}
