package rover.implementation;

/**
 * Coordinates class including all the direction move methods as well as
 * an overridden toString() method to format the resulting coordinates and direction
 *
 * @author  Ilaria Corda
 * @version 1.0
 * @since   2021-01-11
 */

public class Coordinate {

    private Direction direction;

    private Point x;

    public void setX(Point value) {
        x = value;
    }

    public Point getX() {
        return x;
    }

    private Point y;

    public void setY(Point value) {
        y = value;
    }

    public Point getY() {
        return y;
    }

    public void setDirection(Direction value) {
        direction = value;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinate(Point x,
                      Point y,
                      Direction directionValue) {
        setX(x);
        setY(y);
        setDirection(directionValue);
    }

    protected boolean move(Direction directionValue) {
        int xPoint = x.getLocation();
        int yPoint = y.getLocation();
        switch (directionValue) {
            case NORTH:
                yPoint = y.getForwardLocation();
                break;
            case EAST:
                xPoint = x.getForwardLocation();
                break;
            case SOUTH:
                yPoint = y.getBackwardLocation();
                break;
            case WEST:
                xPoint = x.getBackwardLocation();
                break;
        }
        return true;
    }

    public boolean moveForward() {
        return move(direction);
    }

    public boolean moveBackward() {
        return move(direction.backwardDirection());
    }

    public boolean moveRight() {
        return move(direction.rotateRight());
    }

    public boolean moveLeft() {
        return move(direction.rotateLeft());
    }

    @Override
    public String toString() {
        String status = "";
        return "(" + getX().getLocation() + ", " + getY().getLocation() + ")" + " " + getDirection() + status;
    }
}
