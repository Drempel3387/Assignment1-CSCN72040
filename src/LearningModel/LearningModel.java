package LearningModel;

import DataPoint.DataPoint;
import DataPoint.Orientation.Orientation;
import LearningModel.Classifiers.IClassifier;

import java.util.List;

public class LearningModel {
    private final List<DataPoint> TrainingData;
    public LearningModel(final List<DataPoint> trainingData) {
        TrainingData = trainingData;
    }
    public Orientation classify(final DataPoint dataPoint, final IClassifier classifier) {
        return classifier.classify();
    }

}
