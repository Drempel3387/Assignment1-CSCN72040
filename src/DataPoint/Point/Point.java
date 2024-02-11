package DataPoint.Point;

import java.util.Objects;


/**
 * A point in 3D space
 */
public class Point implements IPoint {
    private final double X;
    private final double Y;
    private final double Z;

    /**
     * @param X the x coordinate of the point
     * @param Y the y coordinate of the point
     * @param Z the z coordinate of the point
     */
    public Point(double X, double Y, double Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    /**
     *  Creates a point at the origin if no parameters are given
     */
    public Point() {
        this(0, 0, 0);
    }

    /**
     * @return the x coordinate of the point
     */
    public double getX() {
        return X;
    }

    /**
     * @return the y coordinate of the point
     */
    public double getY() {
        return Y;
    }

    /**
     * @return the z coordinate of the point
     */
    public double getZ() {
        return Z;
    }

    /**
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return Double.compare(X, p.X) == 0 && Double.compare(Y, p.Y) == 0 && Double.compare(Z, p.Z) == 0;
    }

    @Override
    public String toString() {
        return "X: " + X + " Y: " + Y + " Z: " + Z;
    }
}
