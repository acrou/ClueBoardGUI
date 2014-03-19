/**
 * Created by Marissa on 3/16/14.
 */
import java.io.FileNotFoundException;

public class ClueGameRunner  {
    public static void main(String args[]) throws FileNotFoundException {
    Board b = new Board("gameLayout.csv","legend.txt");
    ClueGame clueGame = new ClueGame(b); //initialize all data that needs to be read in
    System.out.println("size of deck: " + clueGame.getDeck().size());
        int counter = 0;
        for(Player p: clueGame.getPlayers() )
            System.out.println(p.getMyCards().size());



            System.out.println("Count: " + counter);

//    clueGame.generateNumTypes();
//    clueGame.passOutCards();
//    clueGame.getHuman();

    }

}
