import DataPoint.Point.Point;
import org.junit.jupiter.api.Test;
public class PointTests {
    @Test
    public void testPointGetters() {
        Point p = new Point(1, 2, 3);
        assert p.getX() == 1;
        assert p.getY() == 2;
        assert p.getZ() == 3;
    }

    @Test
    public void testPointDefaultConstructor() {
        Point p = new Point();
        assert p.getX() == 0;
        assert p.getY() == 0;
        assert p.getZ() == 0;
    }


    @Test
    public void testPointEquals() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 2, 3);
        Point p3 = new Point(1, 2, 4);
        assert p1.equals(p2);
    }

    @Test
    public void testPointHashCode() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 2, 3);
        Point p3 = new Point(1, 2, 4);
        assert p1.hashCode() == p2.hashCode();
    }

    @Test
    public void testPointEqualsNull() {
        Point p1 = new Point(1, 2, 3);
        assert !p1.equals(null);
    }

    @Test
    public void testPointEqualsOtherClass() {
        Point p1 = new Point(1, 2, 3);
        assert !p1.equals(new Object());
    }

    @Test
    public void testPointEqualsSame() {
        Point p1 = new Point(1, 2, 3);
        assert p1.equals(p1);
    }

    @Test
    public void testPointEqualsDifferent() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 2, 4);
        assert !p1.equals(p2);
    }

    @Test
    public void testPointEqualsLongPrecisionFloats() {
        Point p1 = new Point(1.3452353465323434f, 2.345f, 3.3453f);
        Point p2 = new Point(1.3452353465323434f, 2.345f, 3.3453f);
        assert p1.equals(p2);
    }

}
