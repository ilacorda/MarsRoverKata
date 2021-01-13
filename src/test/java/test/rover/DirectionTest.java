package test.rover;

import org.junit.Before;
import org.junit.Test;
import rover.implementation.Direction;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    Direction direction;
    Direction[] allEnums;

    @Before
    public void setUp(){
       allEnums = direction.values();
    }

    @Test
    public void testRetrievedDirectionOrdinalsAndChars() {

        assertEquals(allEnums[0].ordinal(), direction.NORTH.getOrdinal());
        assertEquals(allEnums[1].ordinal(), direction.EAST.getOrdinal());
        assertEquals(allEnums[2].ordinal(), direction.SOUTH.getOrdinal());
        assertEquals(allEnums[3].ordinal(), direction.WEST.getOrdinal());

        assertEquals('N', direction.NORTH.getNameValue());
        assertEquals('E', direction.EAST.getNameValue());
        assertEquals('S', direction.SOUTH.getNameValue());
        assertEquals('W', direction.WEST.getNameValue());
    }
    @Test
    public void testReturnsGoBackValue() {
        Direction backFromNorth = Direction.NORTH.backwardDirection();
        Direction backFromSouth = Direction.SOUTH.backwardDirection();

        assertEquals(Direction.SOUTH, backFromNorth);
        assertEquals(Direction.NORTH, backFromSouth);
    }

    @Test
    public void testRotateLeft() {
        Direction rotateLeftFromEast = Direction.EAST.rotateLeft();
        Direction rotateLeftFromWest = Direction.WEST.rotateLeft();

        assertEquals(Direction.NORTH, rotateLeftFromEast);
        assertEquals(Direction.SOUTH, rotateLeftFromWest);
    }

    @Test
    public void testRotateRight() {
        Direction rotateRightFromEast = Direction.EAST.rotateRight();
        Direction rotateRightFromWest = Direction.WEST.rotateRight();

        assertEquals(Direction.SOUTH, rotateRightFromEast);
        assertEquals(Direction.NORTH, rotateRightFromWest);
    }
}
