package DataPoint.Read;

import DataPoint.DataPoint;
import DataPoint.Orientation.Read.FileOrientationReader;
import DataPoint.Orientation.Read.IOrientationReader;
import DataPoint.Point.Read.FilePointReader;
import DataPoint.Point.Read.IPointReader;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class DataPointReader {
    IOrientationReader orientationReader;
    IPointReader pointReader;
    public DataPointReader(IOrientationReader orientationReader, IPointReader pointReader) {
        this.orientationReader = orientationReader;
        this.pointReader = pointReader;
    }


    public DataPoint read() {
        try {
            return new DataPoint(pointReader.read(), orientationReader.read());
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        catch (NoSuchElementException e) {
            System.out.println("File ended unexpectedly");
        }
        catch (IllegalStateException e) {
            System.out.println("Scanner closed");
        }
        catch (Exception e) {
            System.out.println("Unknown error");
        }
        return null;
    }
}
