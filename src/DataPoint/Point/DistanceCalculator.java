package DataPoint.Point;


/**
 * calculates the distance between two points
 */
public class DistanceCalculator{
    public static double calculate(IPoint firstPoint, IPoint secondPoint) {
        double x = firstPoint.getX() - secondPoint.getX();
        double y = firstPoint.getY() - secondPoint.getY();
        double z = firstPoint.getZ() - secondPoint.getZ();
        return Math.sqrt(x*x + y*y + z*z);
    }
}
