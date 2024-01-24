import DataPoint.DataPoint;
import DataPoint.Orientation.Read.FileOrientationReader;
import DataPoint.Orientation.Read.IOrientationReader;
import DataPoint.Point.Read.FilePointReader;
import DataPoint.Point.Read.IPointReader;
import DataPoint.Read.DataPointReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile file = new RandomAccessFile(new File("C:\\Users\\Devon\\Assignment1-CSCN72040\\src\\trainingData.txt"), "r");
        file.
        IPointReader pointReader = new FilePointReader(file);
        IOrientationReader orientationReader = new FileOrientationReader(file);
        DataPointReader dataPointReader = new DataPointReader(orientationReader, pointReader);

        DataPoint dataPoint = dataPointReader.read();
        while (dataPoint != null) {
            System.out.println(dataPoint);
            dataPoint = dataPointReader.read();
        }
    }
}