package cg.vsu.math.pertsev;

import cg.vsu.render.math.vector.Vector2f;
import cg.vsu.render.math.vector.Vector3f;

/**
 * Minimal geometry operations
 *
 * @author Roman Pertsev
 */
public class GeometryUtils {
    /**
     * @param v1 the first two-dimensional vector
     * @param v2 the second two-dimensional vector
     * @return scalar result
     */
    public static double scalarProductV2(Vector2f v1, Vector2f v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    /**
     * @param v1 the first three-dimensional vector
     * @param v2 the second three-dimensional vector
     * @return scalar result
     */
    public static double scalarProductV3(Vector3f v1, Vector3f v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    /**
     * @param v1 the first three-dimensional vector
     * @param v2 the second three-dimensional vector
     * @return vector orthogonal to the first and second vectors (right-hand for Cartesian right-system)
     */
    public static Vector3f vectorProduct(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }
}
