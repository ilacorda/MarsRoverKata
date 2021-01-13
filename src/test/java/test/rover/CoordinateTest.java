package test.rover;

import org.junit.Before;
import org.junit.Test;
import rover.implementation.Coordinate;
import rover.implementation.Direction;
import rover.implementation.Point;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private Coordinate coordinates;
    private Point x;
    private Point y;
    private final Direction direction = Direction.NORTH;

    @Before
    public void beforeCoordinatesTest() {
        x = new Point(2);
        y = new Point(2);
        coordinates = new Coordinate(x, y, direction);
    }

    @Test
    public void testNewInstanceShouldSetPoints() {
        assertEquals(coordinates.getX(), x);
        assertEquals(coordinates.getY(), y);
    }

    @Test
    public void testNewInstanceShouldSetDirection() {
        assertEquals(coordinates.getDirection(), direction);
    }

    @Test
    public void testMoveForwardReturnsIncreasedYNorthDirection() {
        Point result = new Point(y.getLocation() + 1);
        coordinates.moveForward();
        assertEquals(coordinates.getY().getForwardLocation(), result.getLocation());
    }

    @Test
    public void testMoveBackwardReturnsDecreasedYNorthDirection() {
        Point result = new Point(y.getLocation() - 1);
        coordinates.moveBackward();
        assertEquals(coordinates.getY().getBackwardLocation(), result.getLocation());
    }

    @Test
    public void testMoveForwardReturnsIncreasedYWestDirection() {
        Point result = new Point(y.getLocation() + 1);
        coordinates.setDirection(Direction.WEST);
        coordinates.moveForward();
        assertEquals(coordinates.getY().getForwardLocation(), result.getLocation());
    }

    @Test
    public void testMoveBackwardReturnsDecreaseYWestDirection() {
        Point result = new Point(y.getLocation() - 1);
        coordinates.setDirection(Direction.WEST);
        coordinates.moveBackward();
        assertEquals(coordinates.getY().getBackwardLocation(), result.getLocation());
    }

    @Test
    public void testMoveForwardReturnsIncreaseXDirectionEast() {
        Point result = new Point(x.getLocation() + 1);
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertEquals(coordinates.getX().getForwardLocation(), result.getLocation());
    }

    @Test
    public void testMoveBackwardReturnsDecreaseXDirectionEast() {
        Point result = new Point(x.getLocation() - 1);
        coordinates.setDirection(Direction.EAST);
        coordinates.moveBackward();
        assertEquals(coordinates.getX().getBackwardLocation(), result.getLocation());
    }

    @Test
    public void testCustomToStringShouldFormatResult() {
        String result = "(" + x.getLocation() + ", " + y.getLocation() + ")" + " " + direction;
        assertEquals(coordinates.toString(), result);
    }
}
