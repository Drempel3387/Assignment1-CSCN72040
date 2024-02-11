package DataAccess;

import DataPoint.Point.IPoint;
import DataPoint.Point.Point;

import java.io.EOFException;
import java.io.IOException;

/**
 * This class is responsible for reading a point from a file
 */
public class FilePointReader {
    final FileReader fileReader;
    public FilePointReader(final FileReader reader) {
        fileReader = reader;
    }

    /**
     * @return the next point in the file
     * @throws IOException if an I/O error occurs
     */
    public IPoint read() throws IOException {
        double x, y, z;
        x = Double.parseDouble(fileReader.readUntilDelimiter());
        y = Double.parseDouble(fileReader.readUntilDelimiter());
        z = Double.parseDouble(fileReader.readUntilDelimiter());
        return new Point(x, y, z); //return the point
    }
}
