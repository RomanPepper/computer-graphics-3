package cg.vsu.normals.pertsev;

import cg.vsu.model.Model;
import cg.vsu.model.Polygon;
import cg.vsu.render.math.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * Library for calculating normals to a 3D model
 *
 * @author Pertsev Roman
 */
public class NormalUtils {
    /**
     * @param vertices all model vertices list
     * @param normals all model normals list
     * @param polygons all model polygons list
     */
    public static void calculateModelNormals(List<Vector3f> vertices, List<Vector3f> normals,
                                             List<Polygon> polygons) {
        for (int i = 0; i < vertices.size(); i++) {
            normals.set(i, vertexNormal(i, vertices, polygons));
        }
    }

    /**
     * @param polygon  input polygon
     * @param vertices all model vertices list
     * @return normal vector to input polygon
     */
    public static Vector3f polygonNormal(Polygon polygon, List<Vector3f> vertices) {
        List<Integer> vertexIndices = polygon.getVertexIndices();

        if (vertexIndices.size() < 3)
            throw new IllegalArgumentException("Polygon vertex count must be greater than or equal to 3");
        if (vertices.size() < 3)
            throw new IllegalArgumentException("Vertices count must be greater than or equal to 3");

        Vector3f vertex1 = vertices.get(vertexIndices.get(0));
        Vector3f vertex2 = vertices.get(vertexIndices.get(1));
        Vector3f vertex3 = vertices.get(vertexIndices.get(2));

        //vectors in the polygon flat
        Vector3f vector1 = new Vector3f(vertex2.x - vertex1.x, vertex2.y - vertex1.y, vertex2.z - vertex1.z).nor();
        Vector3f vector2 = new Vector3f(vertex3.x - vertex1.x, vertex3.y - vertex1.y, vertex3.z - vertex1.z).nor();

        return vector1.crs(vector2).nor();
    }

    /**
     * @param vertexIndex vertex index
     * @param vertices    all model vertices list
     * @param polygons    all model polygons list
     * @return normal vector to vertex relative to model
     */
    public static Vector3f vertexNormal(Integer vertexIndex, List<Vector3f> vertices, List<Polygon> polygons) {
        // Вариант, куда передают все вершины модели
        List<Polygon> polygonsSurroundingVertex = selectPolygonsSurroundingVertex(
                vertexIndex, vertices, polygons
        );

        Vector3f sumVector = new Vector3f();
        for (Polygon polygon : polygonsSurroundingVertex) {
            sumVector.add(polygonNormal(polygon, vertices).nor());
        }

        // return average vector
        return sumVector.div(polygonsSurroundingVertex.size()).nor();
    }

    /**
     * Support method for "normalToVertex"
     *
     * @param vertexIndex vertex index
     * @param vertices    all model vertices list
     * @param polygons    all model polygons list
     * @return polygons which bordering input vertex
     */
    protected static List<Polygon> selectPolygonsSurroundingVertex(Integer vertexIndex, List<Vector3f> vertices,
                                                                   List<Polygon> polygons) {
        if (vertices.isEmpty())
            throw new IllegalArgumentException("Vertex array must be not empty");
        if (polygons.isEmpty())
            throw new IllegalArgumentException("Polygon array must be not empty");

        List<Polygon> polygonsSurroundingVertex = new ArrayList<>();

        for (Polygon polygon : polygons) {
            for (Integer index : polygon.getVertexIndices()) {
                if (vertices.get(index).equals(vertices.get(vertexIndex))) {
                    polygonsSurroundingVertex.add(polygon);
                    break;
                }
            }
        }

        return polygonsSurroundingVertex;
    }
}

