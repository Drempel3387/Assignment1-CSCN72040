import Classifiers.IClassifier;
import Classifiers.Neighbor.KNearestNeighbor;
import DataAccess.*;
import DataPoint.DataPoint;
import DataPoint.Point.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Dependency Creation + Injection
        RandomAccessFile file = new RandomAccessFile(new File("C:\\Users\\Devon\\Assignment1-CSCN72040\\src\\trainingData.txt"), "r");
        Pattern pattern = Pattern.compile(",|\r");//delimit a line of text by comma or new line

        FileReader reader = new FileReader(file, pattern);
        FilePointReader filePointReader = new FilePointReader(reader);
        FileOrientationReader fileOrientationReader = new FileOrientationReader(reader);

        DataPointReader dataPointReader = new DataPointReader(fileOrientationReader, filePointReader);
        TrainingDataReader trainingDataReader = new TrainingDataReader(dataPointReader);
        List<DataPoint> dataPoints = trainingDataReader.read();

        IClassifier classifier = new KNearestNeighbor(new Point(-0.99256,0.10287,-0.06515), dataPoints, 40);
        System.out.println(classifier.classify());
    }
}