package cg.vsu.math.pertsev;

import cg.vsu.render.math.vector.Vector2f;
import cg.vsu.render.math.vector.Vector3f;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class GeometryUtilsTest {
    @Test
    public void scalarProductV2Number1() {
        Vector2f v1 = new Vector2f(1, 5);
        Vector2f v2 = new Vector2f(0, 1);

        double result = GeometryUtils.scalarProductV2(v1, v2);
        double expected = 5;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV2Number2() {
        Vector2f v1 = new Vector2f(0, 0);
        Vector2f v2 = new Vector2f(0, 0);

        double result = GeometryUtils.scalarProductV2(v1, v2);
        double expected = 0;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV2Number3() {
        Vector2f v1 = new Vector2f(61, 17);
        Vector2f v2 = new Vector2f(15, 4);

        double result = GeometryUtils.scalarProductV2(v1, v2);
        double expected = 983;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV2Number4() {
        Vector2f v1 = new Vector2f(1, 1);
        Vector2f v2 = new Vector2f(-1, 1);

        double result = GeometryUtils.scalarProductV2(v1, v2);
        double expected = 0;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV3Number1() {
        Vector3f v1 = new Vector3f(61, 17, 0);
        Vector3f v2 = new Vector3f(15, 4, 1);

        double result = GeometryUtils.scalarProductV3(v1, v2);
        double expected = 983;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV3Number2() {
        Vector3f v1 = new Vector3f(0, 1, 0);
        Vector3f v2 = new Vector3f(1, 1, 0);

        double result = GeometryUtils.scalarProductV3(v1, v2);
        double expected = 1;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void scalarProductV3Number3() {
        Vector3f v1 = new Vector3f(-2, 3, 2);
        Vector3f v2 = new Vector3f(6, 2, 3);

        double result = GeometryUtils.scalarProductV3(v1, v2);
        double expected = 0;

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void vectorProduct1() {
        Vector3f v1 = new Vector3f(1, 0, 2);
        Vector3f v2 = new Vector3f(6, 1, 0);

        Vector3f result = GeometryUtils.vectorProduct(v1, v2);
        Vector3f expected = new Vector3f(-2, 12, 1);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void vectorProduct2() {
        Vector3f v1 = new Vector3f(1, 1, 1);
        Vector3f v2 = new Vector3f(16, 16, 16);

        Vector3f result = GeometryUtils.vectorProduct(v1, v2);
        Vector3f expected = new Vector3f(0, 0, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void vectorProduct3() {
        Vector3f v1 = new Vector3f(-2, 3, 2);
        Vector3f v2 = new Vector3f(6, 2, 3);

        Vector3f result = GeometryUtils.vectorProduct(v1, v2);
        Vector3f expected = new Vector3f(5, 18, -22);

        Assertions.assertEquals(result, expected);
    }
}
