package DataPoint.Orientation;

/**
 * This enum represents the orientation of a data point
 */
public enum Orientation {
    NONE, FACE_UP, FACE_DOWN, PORTRAIT, PORTRAIT_UPSIDE_DOWN, LANDSCAPE_LEFT, LANDSCAPE_RIGHT;

    @Override
    public String toString() {
        switch (this) {
            case NONE:
                return "None";
            case FACE_UP:
                return "Face Up";
            case FACE_DOWN:
                return "Face Down";
            case PORTRAIT:
                return "Portrait";
            case PORTRAIT_UPSIDE_DOWN:
                return "Portrait Upside Down";
            case LANDSCAPE_LEFT:
                return "Landscape Left";
            case LANDSCAPE_RIGHT:
                return "Landscape Right";
            default:
                throw new RuntimeException("Unknown orientation");
        }
    }
}
