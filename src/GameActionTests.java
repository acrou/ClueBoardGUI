//import org.junit.Before;
//import org.junit.Test;
//
///**
//* Created by Marissa on 3/11/14.
//*/
//public class GameActionTests {
//    /**
//     * Testing accusations
//     */
//    @Before
//    public void initGame (){
//        //that sets up the board and a variety of cards (of each type) that will be needed for testing.
//        ClueGame myGame = new ClueGame();
//
//
//    }
//    @Test
//    public void testAccusations(){
//      Solution mySolution=  myGame.getSolution();
//      Solution wrongSolution = new Solution("Frodo Baggins", "Gondor", "Barrow-blades");
//      assertTrue(myGame.isCorrectSolution(mySolution));
//      assertFalse(myGame.isCorrectSolution(wrongSolution));
//
//
//
//
//  }
//    @Test
//    public void testTargetRandomSelection() {
//        ComputerPlayer player = new ComputerPlayer();
//        // Pick a location with no rooms in target, just three targets
//        board.calcTargets(14, 0, 2);
//        int loc_12_0Tot = 0;
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
