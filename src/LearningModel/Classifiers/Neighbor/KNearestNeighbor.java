package LearningModel.Classifiers.Neighbor;

import DataPoint.DataPoint;
import DataPoint.Orientation.Orientation;
import LearningModel.Classifiers.IClassifier;

import java.util.*;

public class KNearestNeighbor implements IClassifier {
    private final int K;
    private final DataPoint dataPoint;
    private final List<DataPoint> trainingData;

    public KNearestNeighbor(final DataPoint dataPoint, final List<DataPoint> trainingData, final int k) {
        this.dataPoint = dataPoint;
        this.trainingData = trainingData;
        K = k;
    }

    /**
     * @return a map of each point in training data to its distance from dataPoint
     */
    private Map<DataPoint, Double> pointDistanceMap() {
        Map<DataPoint, Double> pointDistanceMap = new HashMap<>();
        for (DataPoint point : trainingData) {
            pointDistanceMap.put(point, point.distance(dataPoint));
        }
        return pointDistanceMap;
    }

    /**
     * @param pointDistanceMap a map of each point in training data to its distance from dataPoint
     */
    private void sortTrainingDataByDistance(final Map<DataPoint, Double>pointDistanceMap) {
        trainingData.sort(new Comparator<DataPoint>() {
            @Override
            public int compare(DataPoint o1, DataPoint o2) {
                return pointDistanceMap.get(o1).compareTo(pointDistanceMap.get(o2));
            }
        });
    }

    /**
     * @return a map of each orientation to the number of points in training data with that orientation
     *  among the K nearest neighbors of dataPoint
     */

    private Map<Orientation, Integer> orientationCountMap()
    {
        Map<Orientation, Integer> orientationCountMap = new HashMap<>();
        for (int i = 0; i < K; i++) {
            Orientation orientation = trainingData.get(i).getOrientation();
            if (orientationCountMap.containsKey(orientation)) {
                orientationCountMap.put(orientation, orientationCountMap.get(orientation) + 1);
            } else {
                orientationCountMap.put(orientation, 1);
            }
        }
        return orientationCountMap;
    }

    private Orientation majorityOrientation(final Map<Orientation, Integer> orientationCountMap) {
        int maxCount = 0; //number of points for the current majority orientation
        Orientation majorityOrientation = Orientation.NONE;

        for (Map.Entry<Orientation, Integer> entry : orientationCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityOrientation = entry.getKey();
            }
        }
        return majorityOrientation;
    }
    @Override
    public Orientation classify() {
        Map<DataPoint, Double> pointDistanceMap = pointDistanceMap();
        sortTrainingDataByDistance(pointDistanceMap);
        Map<Orientation, Integer> orientationCountMap = orientationCountMap();

        return majorityOrientation(orientationCountMap);
    }
}
