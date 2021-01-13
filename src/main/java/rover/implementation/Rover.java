package rover.implementation;

/**
 * Core Rover Class including methods for executing a single command and
 * multiple commands
 *
 * @author  Ilaria Corda
 * @version 1.0
 * @since   2021-01-11
 */

public class Rover {
    protected Coordinate coordinates;

    public void setCoordinates(Coordinate input) {
        coordinates = input;
    }

    public Coordinate retrieveCoordinates() {
        return coordinates;
    }

    public Rover(Coordinate coordinatesValue) {
        setCoordinates(coordinatesValue);
    }

    public void execute(String moves) throws Exception {
        for (char code : moves.toCharArray()) {
            executeCommand(code);
        }
    }

    public boolean executeCommand(char command) throws IllegalArgumentException {
        switch (Character.toUpperCase(command)) {
            case 'F':
                return retrieveCoordinates().moveForward();
            case 'B':
                return retrieveCoordinates().moveBackward();
            case 'R':
                retrieveCoordinates().moveRight();
                return true;
            case 'L':
                retrieveCoordinates().moveLeft();
                return true;
            default:
                throw new IllegalArgumentException("The provided command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return retrieveCoordinates().toString();
    }
}

