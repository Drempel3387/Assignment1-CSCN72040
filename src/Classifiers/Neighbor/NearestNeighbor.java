package Classifiers.Neighbor;

import DataPoint.DataPoint;
import DataPoint.Point.Point;
import DataPoint.Orientation.Orientation;
import Classifiers.IClassifier;

import java.util.List;

public class NearestNeighbor implements IClassifier {
    private final Point Point;
    private final List<DataPoint> trainingData;

    public NearestNeighbor(final Point dataPoint, final List<DataPoint> trainingData) {
        this.Point = dataPoint;
        this.trainingData = trainingData;
    }

    /**
     * @return the nearest data point in training data to the input dataPoint
     */
    private DataPoint nearest() {
        double minDistance = Double.MAX_VALUE;
        DataPoint nearestDataPoint = null;

        //finds the nearest data point in training data to dataPoint
        for (DataPoint point : trainingData) {
            if (point.distance(Point) < minDistance) {
                minDistance = point.distance(Point);
                nearestDataPoint = point;
            }
        }
        return nearestDataPoint;
    }

    /**
     * @return the orientation of the nearest data point in training data to dataPoint
     */
    @Override
    public Orientation classify() {
        DataPoint nearestDataPoint = nearest();
        if (nearestDataPoint == null) {
            return Orientation.NONE;
        }
        return nearestDataPoint.getOrientation();
    }
}
