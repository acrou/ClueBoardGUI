import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;


import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
* Created by Marissa on 3/11/14.
*/
public class GameSetupTests {
//    Loading the people
//    Loading the cards
//    Dealing the cards
    private static Board b;
    private static ClueGame myGame;


    @BeforeClass
    public static void setUp() throws FileNotFoundException {
         b = new Board("gameLayout.csv","legend.txt");
        myGame = new ClueGame (b);

    }
    /**
     * Testing loading people
     */
    @Test

    public void testHumanPlayer(){
         //test the name has first and last
        assertEquals(myGame.getHuman().getName().split(" ").length, 2);
        //test the color is red
        assertEquals(myGame.getHuman().getColor(), Color.RED);
        assertEquals(myGame.getHuman().getLocation().getPosition(), 473 );
    }
    @Test
    public void testComputerPlayerOne(){
        //test the name has first and last
        Player computer = myGame.getPlayer(12,4);
        assertEquals(computer.getName(), "Elessar Telcontal");//aka Aragorn
        //test the color is red
        assertEquals(computer.getColor(), Color.BLUE);
    }
    @Test
    public void testComputerPlayerTwo(){
        //test the name has first and last
        Player computer = myGame.getPlayer(16,15);
        assertEquals(computer.getName(), "Frodo Baggins");
        //test the color is red
        assertEquals(computer.getColor(), Color.YELLOW);
    }
    /**
     * Loading the cards
     */
    @Test
    public void testDeckLoading (){
        ArrayList<Card> myDeck = myGame.getDeck();
        Map<Card.CardType, Integer> myNumTypes = myGame.getNumTypes();
        assertEquals(myDeck.size(), 21);

        assertEquals(myNumTypes.get(Card.CardType.PERSON), (Integer)6);
        assertEquals(myNumTypes.get(Card.CardType.WEAPON),(Integer) 6);
        assertEquals(myNumTypes.get(Card.CardType.ROOM),(Integer) 9);

        assertTrue(myGame.hasInDeck("Gandalf Grey"));
        assertTrue(myGame.hasInDeck("Gondor"));
        assertTrue(myGame.hasInDeck("Aeglos"));
    }
    /**
     * Test dealing the cards
     */

    @Test
    public void testAllCardsDealt(){
        Map<Card.CardType, Integer> myNumTypes = myGame.getNumTypes();

        assertEquals(myNumTypes.get(Card.CardType.PERSON), (Integer)0);
        assertEquals(myNumTypes.get(Card.CardType.WEAPON), (Integer)0);
        assertEquals(myNumTypes.get(Card.CardType.ROOM), (Integer)0);

    }
    @Test
    public void testDistributionEvenness(){
        for(Player p: myGame.getPlayers() )
            assertTrue(p.getMyCards().size() == 3 || p.getMyCards().size() == 4);//21/6 = 3.5
    }
    @Test
    public void testCardUniquenessOne (){
        Random seed = new Random();
        int rand = seed.nextInt()%myGame.getDeck().size();
        Card randCard = myGame.getDeck().get(rand);
        int occurence =0;
        for(Player p: myGame.getPlayers()){
              if(p.getMyCards().contains(randCard))
                  occurence++;

        }
        assertEquals(occurence, 1);
    }

}
