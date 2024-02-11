package DataPoint;
import DataPoint.Point.DistanceCalculator;
import DataPoint.Point.IPoint;
import DataPoint.Orientation.Orientation;

/**
 * represents a data point in 3D space with an orientation
 */
public class DataPoint implements IPoint {
    private final IPoint Point;
    private final Orientation Orientation;

    /**
     * @param point the point in 3D space
     * @param orientation the orientation of the point
     */
    public DataPoint(final IPoint point, final Orientation orientation) {
        Point = point;
        Orientation = orientation;
    }
    /**
     * @return the x coordinate of point in 3D space
     */
    public double getX() {
        return Point.getX();
    }

    /**
     * @return the y coordinate of point in 3D space
     */
    public double getY() {
        return Point.getY();
    }

    /**
     * @return the z coordinate of point in 3D space
     */
    public double getZ() {
        return Point.getZ();
    }

    /**
     * @return the orientation of the point
     */
    public Orientation getOrientation() {
        return Orientation;
    }

    /**
     * @param other the other data point
     * @return the distance between this data point and the other point
     */
    public double distance(final IPoint other) {
        return DistanceCalculator.calculate(Point, other);
    }

    /**
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DataPoint))
            return false;
        DataPoint other = (DataPoint)o;
        return Point.equals(other.Point) && Orientation.equals(other.Orientation);
    }

    public String toString() {
        return Point.toString() + " " + Orientation.toString();
    }
}
