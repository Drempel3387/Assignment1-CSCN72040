package DataAccess;

import DataPoint.Orientation.Orientation;

import java.io.IOException;

/**
 * This class is responsible for reading an orientation from a file
 */
public class FileOrientationReader {
    final FileReader fileReader;
    public FileOrientationReader(final FileReader reader) {
        fileReader = reader;
    }
    public Orientation read() throws IOException {
        Orientation orientation;
        switch (fileReader.readUntilDelimiter()) {
            case "1":
                orientation = Orientation.FACE_UP;
                break;
            case "2":
                orientation = Orientation.FACE_DOWN;
                break;
            case "3":
                orientation = Orientation.PORTRAIT;
                break;
            case "4":
                orientation = Orientation.PORTRAIT_UPSIDE_DOWN;
                break;
            case "5":
                orientation = Orientation.LANDSCAPE_LEFT;
                break;
            case "6":
                orientation = Orientation.LANDSCAPE_RIGHT;
                break;
            default:
                orientation = Orientation.NONE;
                break;
        }
        return orientation;
    }
}
