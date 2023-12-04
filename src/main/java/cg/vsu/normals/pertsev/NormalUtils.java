package cg.vsu.normals.pertsev;

import cg.vsu.math.pertsev.GeometryUtils;
import cg.vsu.model.Polygon;
import cg.vsu.render.math.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * Library for finding normals to a 3D model
 *
 * @author Pertsev Roman
 */
public class NormalUtils {
    /**
     * @param polygon  input polygon
     * @param vertices all model vertices list
     * @return normal vector to input polygon
     */
    public static Vector3f normalToPolygon(Polygon polygon, List<Vector3f> vertices) {
        List<Integer> vertexIndices = polygon.getVertexIndices();

        if (vertexIndices.size() < 3)
            throw new IllegalArgumentException("Polygon vertex count must be greater than or equal to 3");
        if (vertices.size() < 3)
            throw new IllegalArgumentException("Vertices count must be greater than or equal to 3");

        Vector3f vertex1 = vertices.get(vertexIndices.get(0));
        Vector3f vertex2 = vertices.get(vertexIndices.get(1));
        Vector3f vertex3 = vertices.get(vertexIndices.get(2));

        //vectors in the polygon flat
        Vector3f vector1 = new Vector3f(vertex2.x - vertex1.x, vertex2.y - vertex1.y, vertex2.z - vertex1.z);
        Vector3f vector2 = new Vector3f(vertex3.x - vertex1.x, vertex3.y - vertex1.y, vertex3.z - vertex1.z);

        return GeometryUtils.vectorProduct(vector1, vector2).nor();
    }

    /**
     * @param vertex   input vertex
     * @param vertices all model vertices list
     * @param polygons all model polygons list
     * @return normal vector to vertex relative to model
     */
    public static Vector3f normalToVertex(Vector3f vertex, List<Vector3f> vertices, List<Polygon> polygons) {
        List<Polygon> polygonsSurroundingVertex = selectPolygonsSurroundingVertex(vertex, vertices, polygons);

        Vector3f sumVector = new Vector3f();
        for (Polygon polygon : polygonsSurroundingVertex) {
            sumVector.add(normalToPolygon(polygon, vertices));
        }

        // return average vector
        return sumVector.div(polygonsSurroundingVertex.size()).nor();
    }

    /**
     * Support method for "normalToVertex"
     * @param vertex   input vertex
     * @param vertices all model vertices list
     * @param polygons all model polygons list
     * @return polygons which bordering input vertex
     */
    protected static List<Polygon> selectPolygonsSurroundingVertex(Vector3f vertex, List<Vector3f> vertices,
                                                                 List<Polygon> polygons) {
        if (vertices.isEmpty())
            throw new IllegalArgumentException("Vertex array must be not empty");
        if (polygons.isEmpty())
            throw new IllegalArgumentException("Polygon array must be not empty");

        List<Polygon> polygonsSurroundingVertex = new ArrayList<>();

        for (Polygon polygon : polygons) {
            for (Integer index : polygon.getVertexIndices()) {
                if (vertices.get(index).equals(vertex)) {
                    polygonsSurroundingVertex.add(polygon);
                    break;
                }
            }
        }

        return polygonsSurroundingVertex;
    }
}

