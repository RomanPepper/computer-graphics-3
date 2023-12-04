package cg.vsu.normals.pertsev;

import cg.vsu.math.pertsev.GeometryUtils;
import cg.vsu.model.Model;
import cg.vsu.model.Polygon;
import cg.vsu.render.math.vector.Vector3f;
import com.cgvsu.objreader.ObjReader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class NormalUtilsTest {
    @Test
    public void normalToPolygon1() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\brick.obj");

        Polygon randomPolygon = model.polygons.get(0);

        Vector3f result = NormalUtils.normalToPolygon(randomPolygon, model.vertices);

        Vector3f vertex1 = model.vertices.get(randomPolygon.getVertexIndices().get(0));
        Vector3f vertex2 = model.vertices.get(randomPolygon.getVertexIndices().get(1));
        Vector3f randomPolygonVector = new Vector3f(vertex2.x - vertex1.x,
                vertex2.y - vertex1.y, vertex2.z - vertex1.z);

        Assertions.assertTrue(GeometryUtils.scalarProductV3(randomPolygonVector, result) == 0);
    }

    @Test
    public void normalToPolygon2() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\brick.obj");

        Polygon randomPolygon = model.polygons.get(1);

        Vector3f result = NormalUtils.normalToPolygon(randomPolygon, model.vertices);

        Vector3f vertex1 = model.vertices.get(randomPolygon.getVertexIndices().get(0));
        Vector3f vertex2 = model.vertices.get(randomPolygon.getVertexIndices().get(1));
        Vector3f randomPolygonVector = new Vector3f(vertex2.x - vertex1.x,
                vertex2.y - vertex1.y, vertex2.z - vertex1.z);

        Assertions.assertTrue(GeometryUtils.scalarProductV3(randomPolygonVector, result) == 0);
    }

    @Test
    public void normalToPolygon3() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\pyramid.obj");

        Polygon randomPolygon = model.polygons.get(0);

        Vector3f result = NormalUtils.normalToPolygon(randomPolygon, model.vertices);

        Vector3f vertex1 = model.vertices.get(randomPolygon.getVertexIndices().get(0));
        Vector3f vertex2 = model.vertices.get(randomPolygon.getVertexIndices().get(1));
        Vector3f randomPolygonVector = new Vector3f(vertex2.x - vertex1.x,
                vertex2.y - vertex1.y, vertex2.z - vertex1.z);

        Assertions.assertTrue(GeometryUtils.scalarProductV3(randomPolygonVector, result) == 0);
    }

    @Test
    public void normalToPolygon4() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\pyramid.obj");

        Polygon randomPolygon = model.polygons.get(1);

        Vector3f result = NormalUtils.normalToPolygon(randomPolygon, model.vertices);

        Vector3f vertex1 = model.vertices.get(randomPolygon.getVertexIndices().get(0));
        Vector3f vertex2 = model.vertices.get(randomPolygon.getVertexIndices().get(1));
        Vector3f randomPolygonVector = new Vector3f(vertex2.x - vertex1.x,
                vertex2.y - vertex1.y, vertex2.z - vertex1.z);

        Assertions.assertTrue(GeometryUtils.scalarProductV3(randomPolygonVector, result) == 0);
    }

    @Test
    public void selectPolygonsSurroundingVertex1() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\pyramid.obj");

        List<Polygon> result = NormalUtils.selectPolygonsSurroundingVertex(
                model.vertices.get(0), model.vertices, model.polygons
        );

        List<Polygon> expected = new ArrayList<>();
        expected.add(model.polygons.get(0));
        expected.add(model.polygons.get(1));
        expected.add(model.polygons.get(2));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void normalToVertex1() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\brick.obj");

        Vector3f result = NormalUtils.normalToVertex(
                model.vertices.get(7), model.vertices, model.polygons
        );

        Vector3f expected = new Vector3f((float) -1 / 3, (float) -1 / 3, (float) -1 / 3).nor();

        Assertions.assertTrue(expected.nor().epsEquals(result.nor(), (float) 1e-7));
    }

    @Test
    public void normalToVertex2() throws FileNotFoundException {
        Model model = ObjReader.read("D:\\vsu\\3rd_semester\\cg\\" +
                "_3rd_task\\src\\main\\resources\\obj\\pyramid.obj");

        Vector3f result = NormalUtils.normalToVertex(
                model.vertices.get(3), model.vertices, model.polygons
        );

        Vector3f expected = new Vector3f(
                (float) (2 * Math.sqrt(6) / 9), (float) (-Math.sqrt(2) / 6), (float) (Math.sqrt(2) / 6)
        ).nor();

        Assertions.assertTrue(expected.nor().epsEquals(result.nor(), (float) 1e-7));
    }
}
