package DataAccess;

import DataPoint.DataPoint;

import java.io.EOFException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 *  This class is responsible for reading a data point from a file
 */
public class DataPointReader {
    final FileOrientationReader orientationReader;
    final FilePointReader pointReader;
    public DataPointReader(final FileOrientationReader orientationReader, final FilePointReader pointReader) {
        this.orientationReader = orientationReader;
        this.pointReader = pointReader;
    }

    /**
     * @return the next data point in the file
     */
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
        catch (EOFException e)
        {
            return null;
        }
        catch (Exception e) {
            System.out.println("Unknown error");
        }
        return null;
    }
}
