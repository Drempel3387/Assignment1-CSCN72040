package LearningModel.Classifiers.Neighbor;

import DataPoint.DataPoint;
import DataPoint.Orientation.Orientation;
import LearningModel.Classifiers.IClassifier;

import java.util.Collection;
import java.util.List;

public class NearestNeighbor implements IClassifier {
    private final DataPoint dataPoint;
    private final List<DataPoint> trainingData;

    public NearestNeighbor(final DataPoint dataPoint, final List<DataPoint> trainingData) {
        this.dataPoint = dataPoint;
        this.trainingData = trainingData;
    }

    /**
     * @return the nearest data point in training data to dataPoint
     */
    private DataPoint nearest() {
        double minDistance = Double.MAX_VALUE;
        DataPoint nearestDataPoint = null;

        //finds the nearest data point in training data to dataPoint
        for (DataPoint point : trainingData) {
            if (point.distance(dataPoint) < minDistance) {
                minDistance = point.distance(dataPoint);
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
