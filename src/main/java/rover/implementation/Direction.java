package rover.implementation;

/**
 *
 * Direction Enumeration class for all the enum direction ordinals and char values
 * It also includes getters and setters as well as direction methods for
 * backward, rotate left and rotate right
 *
 * @author  Ilaria Corda
 * @version 1.0
 * @since   2021-01-11
 */

public enum Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int ordinal;
    private char name;

    Direction(int ordinal, char nameValue) {
        this.ordinal = ordinal;
        this.name = nameValue;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public char getNameValue() {
        return name;
    }

    private static final Direction[] allEnums = Direction.values();
    private static final Direction FIRST_VALUE = allEnums[0];
    private static final Direction LAST_VALUE = allEnums[3];

    public Direction backwardDirection() {
        return allEnums[(this.getOrdinal() + 2) % 4];
    }

    public Direction rotateLeft() {
        return this == FIRST_VALUE ? LAST_VALUE : allEnums[this.getOrdinal() - 1];
    }

    public Direction rotateRight() {
        return this == LAST_VALUE
                ? FIRST_VALUE
                : values()[this.getOrdinal() + 1];
    }
}
