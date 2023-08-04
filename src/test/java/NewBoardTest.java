import example.NewBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewBoardTest {

    //Tests the bord created correctly with specified features

    @Test
    public void testNewBoardCorrect() {
        NewBoard newBoard = new NewBoard();
        int[] expected = {6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0};
        assertArrayEquals(expected, newBoard.board);
    }

    //Tests the correct number of stones in pit selected start

    @Test
    public void testGetStones() {
        NewBoard newBoard = new NewBoard();
        assertEquals(6, newBoard.getStones(0));
    }

    @Test
    public void testGetStonesFalse() {
        NewBoard newBoard = new NewBoard();
        assertNotEquals(3, newBoard.getStones(1));
    }

    //Tests correct number of stones according to pit of parameter (via index)

    @Test
    public void testSetStones() {
        NewBoard newBoard = new NewBoard();
        newBoard.setStones(0, 5);
        assertEquals(5, newBoard.getStones(0));
    }

    @Test
    public void testSetStonesFalse() {
        NewBoard newBoard = new NewBoard();
        newBoard.setStones(0, 4);
        assertNotEquals(5, newBoard.getStones(0));
    }

    //Adds one stone to pit using parameter pix (its index)

    @Test
    public void testAddStone() {
        NewBoard newBoard = new NewBoard();
        newBoard.addStone(0);
        assertEquals(7, newBoard.getStones(0));
    }

    @Test
    public void testAddStoneFalse() {
        NewBoard newBoard = new NewBoard();
        newBoard.addStone(0);
        assertNotEquals(8, newBoard.getStones(1));
    }
}
