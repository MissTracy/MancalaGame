import example.NewBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewBoardTest {
    @Test
    public void testNewBoardCorrect() {
        NewBoard newBoard = new NewBoard();
        int[] expected = {6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0};
        assertArrayEquals(expected, newBoard.board);
    }


    @Test
    public void testGetStones() {
        NewBoard newBoard = new NewBoard();
        assertEquals(6, newBoard.getStones(0));
    }

    @Test
    public void testSetStones() {
        NewBoard newBoard = new NewBoard();
        newBoard.setStones(0, 5);
        assertEquals(5, newBoard.getStones(0));
    }

    @Test
    public void testAddStone() {
        NewBoard newBoard = new NewBoard();
        newBoard.addStone(0);
        assertEquals(7, newBoard.getStones(0));
    }
}
