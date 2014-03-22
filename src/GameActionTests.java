import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Ally and Marissa on 3/11/14.
 */
public class GameActionTests {
    /**
     * Testing accusations
     */

    private static ClueGame myGame;
    private static Board board;
    private static Card narsil, morgul_blade, mordor, shire, gandalf, gollum;
    @BeforeClass
    public static void setUp () throws FileNotFoundException {
        //that sets up the board and a variety of cards (of each type) that will be needed for testing.
        board = new Board("gameLayout.csv","legend.txt");
        myGame = new ClueGame(board);
        //test weapons
        narsil = new Card("Narsil", Card.CardType.WEAPON);
        morgul_blade = new Card("Morgul Blade", Card.CardType.WEAPON);
        //test rooms
        mordor = new Card("Mordor", Card.CardType.ROOM);
         shire = new Card("The Shire", Card.CardType.ROOM);
        //test people
         gandalf = new Card("Gandalf Grey", Card.CardType.PERSON);
         gollum = new Card("Gollum Trahald", Card.CardType.PERSON);
     }

    /**Tests 1 correct solution and 3
     * fake ones by using helper function in ClueGame
     */
    @Test
    public void testAccusations(){
        //correct solution
        Solution mySolution=  myGame.getSolution();
        //false solutions
        Solution wrongSolutionOne = new Solution("Frodo Baggins", "Gondor", "Aeglos");
        Solution wrongSolutionTwo = new Solution("Gandalf Grey", "Gondor", "Sting");
        Solution wrongSolutionThree = new Solution("Gandalf Grey", "Mirkwood", "Aeglos");

        assertTrue(myGame.isCorrectSolution(mySolution));
        assertFalse(myGame.isCorrectSolution(wrongSolutionOne));
        assertFalse(myGame.isCorrectSolution(wrongSolutionTwo));

        assertFalse(myGame.isCorrectSolution(wrongSolutionThree));

    }



//  }
//    @Test
//    public void testTargetRandomSelection() {
//        ComputerPlayer player = new ComputerPlayer();
//        // Pick a location with no rooms in target, just three targets
//        board.calcTargets(14, 0, 2);
//        int loc_12_0Tot = 0;1
//        int loc_14_2Tot = 0;
//        int loc_15_1Tot = 0;
//        // Run the test 100 times
//        for (int i=0; i<100; i++) {
//            BoardCell selected = player.pickLocation(board.getTargets());
//            if (selected == board.getCellAt(12, 0))
//                loc_12_0Tot++;
//            else if (selected == board.getCellAt(14, 2))
//                loc_14_2Tot++;
//            else if (selected == board.getCellAt(15, 1))
//                loc_15_1Tot++;
//            else
//                fail("Invalid target selected");
//        }
//        // Ensure we have 100 total selections (fail should also ensure)
//        assertEquals(100, loc_12_0Tot + loc_14_2Tot + loc_15_1Tot);
//        // Ensure each target was selected more than once
//        assertTrue(loc_12_0Tot > 10);
//        assertTrue(loc_14_2Tot > 10);
//        assertTrue(loc_15_1Tot > 10);
//    }
//}

    /**Tests that are used for the
     *the game's preference for rooms
     */

    //----------------------------------------------------------------------------------------------------------------//

    //ensures that if a room is present in a test it is selected
    @Test
    public void roomPresentTest(){
        myGame.getBoard().calcTargets(3,0,2);
        Set<BoardCell> containsRoom = myGame.getBoard().getTargets();//location: 3,0, 2 steps

        //Now, the test must ensure that the room is selected each time
        for(Player p: myGame.getPlayers()){
            if(p instanceof ComputerPlayer){
                //The returned cell must be an instance of a room cell
                BoardCell selected = ((ComputerPlayer)p).pickLocation(new ArrayList<BoardCell>(containsRoom), myGame.getBoard());
                assertTrue(selected instanceof RoomCell);
            }
        }
    }
        /**Disproving suggestions with
         *
         */
        @Test
        public void onePlayerOneMatch(){
            Player test = new Player();

            Solution mySuggestionOne = new Solution(gollum.getName(), "Gondor", "Sting");
            Solution mySuggestionTwo = new Solution("Frodo Baggins", mordor.getName(), "Sting");
            Solution mySuggestionThree = new Solution("Frodo Baggins", "Gondor", morgul_blade.getName());
            Solution mySuggestionFour = new Solution("Frodo Baggins", "Gondor", narsil.getName());

            test.addCard(gollum);
            test.addCard(narsil);
            test.addCard(gandalf);
            test.addCard(morgul_blade);
            test.addCard(mordor);
            test.addCard(shire);

            assertEquals(gollum, test.disproveSuggestion(mySuggestionOne));
            assertEquals(mordor, test.disproveSuggestion(mySuggestionTwo));
            assertEquals(morgul_blade, test.disproveSuggestion(mySuggestionThree));
            assertEquals(narsil, test.disproveSuggestion(mySuggestionFour));


           }


        public void onePlayerMultipleMathes(){
            
        }
}