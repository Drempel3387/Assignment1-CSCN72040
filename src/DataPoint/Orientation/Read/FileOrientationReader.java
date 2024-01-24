package DataPoint.Orientation.Read;

import DataPoint.Orientation.Orientation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileOrientationReader implements IOrientationReader {
    private final RandomAccessFile file;
    public FileOrientationReader( RandomAccessFile file) {
        this.file = file;
    }
    public Orientation read() {
        Orientation orientation;
        int orientationInt = 0;

        try {
            orientationInt = file.readInt();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        orientation = Orientation.values()[orientationInt];
        return orientation;
    }
}
