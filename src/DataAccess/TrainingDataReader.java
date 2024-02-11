package DataAccess;

import DataPoint.DataPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for reading training data from a file
 */
public class TrainingDataReader {
    private final DataPointReader dataPointReader;
    public TrainingDataReader(final DataPointReader dataPointReader) {
        this.dataPointReader = dataPointReader;
    }

    /**
     * @return all the data points in the file
     */
    public List<DataPoint> read() {
        DataPoint dataPoint;
        List<DataPoint> dataPoints = new ArrayList<>();
        while ((dataPoint = dataPointReader.read()) != null) {
            dataPoints.add(dataPoint);
        }//read all the data points
        return dataPoints;
    }
}
