package test.rover;

import org.junit.Before;
import org.junit.Test;
import rover.implementation.Coordinate;
import rover.implementation.Direction;
import rover.implementation.Point;
import rover.implementation.Rover;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    private Rover rover;
    private Coordinate coordinates;
    private final Direction direction = Direction.NORTH;
    private Point x;
    private Point y;

    @Before
    public void beforeRoverTest() {
        x = new Point(1);
        y = new Point(2);
        coordinates = new Coordinate(x, y, direction);
        rover = new Rover(coordinates);
    }

    @Test
    public void testNewInstanceSetCoordinatesAndDirection() {
        assertEquals(rover.retrieveCoordinates(), coordinates);
    }

    @Test
    public void testExecuteCommandShouldMoveForwardWhenCommandF() throws Exception {
        int result = y.getLocation() + 1;
        rover.executeCommand('F');
        assertEquals(rover.retrieveCoordinates().getY().getForwardLocation(), result);
    }

    @Test
    public void testExecuteCommandShouldMoveBackWhenCommandB() throws Exception {
        int result = y.getLocation() - 1;
        rover.executeCommand('B');
        assertEquals(rover.retrieveCoordinates().getY().getBackwardLocation(), result);
    }

    @Test
    public void testExecuteCommandShouldMoveLeftWhenCommandL() throws Exception {
        rover.executeCommand('L');
        assertEquals(rover.retrieveCoordinates().getDirection().rotateLeft(), Direction.WEST);
    }

    @Test
    public void testExecuteCommandShouldTurnRightWhenCommandR() throws Exception {
        rover.executeCommand('R');
        assertEquals(rover.retrieveCoordinates().getDirection().rotateRight(), Direction.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExecuteCommandThrowsExceptionWhenUnknown() throws Exception {
        rover.executeCommand('Z');
    }

    @Test
    public void testIgnoreCaseWhenExecuteCommand() {
        rover.executeCommand('l');
        assertEquals(rover.retrieveCoordinates().getDirection().rotateLeft(), Direction.WEST);
    }

    @Test
    public void testExecuteCommandsDealsWithASequenceOfCommands() throws Exception {
        x.setLocation(-2);
        y.setLocation(2);
        int retrievedX = x.getLocation();
        int retrievedY = y.getLocation();
        rover.execute("FFRRRFF");
        assertEquals(rover.retrieveCoordinates().getX().getLocation(), retrievedX);
        assertEquals(rover.retrieveCoordinates().getY().getLocation(), retrievedY);
        assertEquals(rover.retrieveCoordinates().getDirection(), Direction.NORTH);
    }

    @Test
    public void positionReturnsReturnsCoordinatesAndDirection() throws Exception {
        rover.execute("LFFFRFF");
        assertEquals(rover.getPosition(), "(1, 2) NORTH");
    }
}
