package DataPoint.Point.Read;

import DataPoint.Point.IPoint;
import DataPoint.Point.Point;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

//will read a point from a file
public class FilePointReader implements IPointReader {
    private final RandomAccessFile file;
    public FilePointReader(final RandomAccessFile file) {
        this.file = file;
    }

    public IPoint read() {
        double X, Y, Z;
        try {
            X = file.readDouble();
            Y = file.readDouble();
            Z = file.readDouble();
        }
        catch (NoSuchElementException | IllegalStateException | IOException e) {
            return null;
        }
        return new Point(X, Y, Z);
    }
}
