package test.rover;

import org.junit.Before;
import org.junit.Test;
import rover.implementation.Point;

import static org.junit.Assert.assertEquals;

public class PointTest {

    Point point;
    int location;

    @Before
    public void setUp() {
        point = new Point(location = 6);
    }

    @Test
    public void testGetBackWardLocation() {
        int retrievedLocation = point.getBackwardLocation();
        assertEquals(retrievedLocation, 5);

    }

    @Test
    public void testGetForwardLocation() {
        int retrievedLocation = point.getForwardLocation();
        assertEquals(retrievedLocation, 7);
    }
}
