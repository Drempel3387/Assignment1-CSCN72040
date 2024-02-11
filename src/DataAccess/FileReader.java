package DataAccess;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

/**
 * This class is responsible for reading a file until a delimiter is found
 */
public class FileReader {
    private final RandomAccessFile file;
    private final Pattern pattern;

    /**
     * @param file the file to read
     * @param pattern the delimiter pattern to look for
     */
    public FileReader(final RandomAccessFile file, final Pattern pattern) {
        this.file = file;
        this.pattern = pattern;
    }

    /**
     * @return the next line of text in the file defined by the delimiter
     * @throws IOException if an I/O error occurs
     */
    public String readUntilDelimiter() throws IOException {
        StringBuilder result = new StringBuilder();
        byte currentByte;
        while (true) {
            currentByte = file.readByte();
            char currentChar = (char) currentByte;
            if (pattern.matcher(String.valueOf(currentChar)).matches()) {
                break;
            }
            result.append(currentChar);
        }
        return result.toString();
    }

}
