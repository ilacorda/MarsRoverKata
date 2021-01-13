package rover.implementation;

/**
 * A Point is a two-dimensional location
 * The class includes forward and backwards location methods
 *
 * @author  Ilaria Corda
 * @version 1.0
 * @since   2021-01-11
 */

public class Point {

    private int location;
    public void setLocation(int value) { location = value; }
    public int getLocation() { return location; }

    public Point(int locationValue) {
        setLocation(locationValue);
    }

    public int getForwardLocation() {
        return (getLocation() + 1);
    }

    public int getBackwardLocation() {
        return getLocation() - 1;
    }
}
