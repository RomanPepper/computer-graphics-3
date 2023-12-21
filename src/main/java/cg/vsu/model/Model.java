package cg.vsu.model;

import cg.vsu.render.math.vector.Vector2f;
import cg.vsu.render.math.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * Updated and redependencied to math library by Alexander Laptev
 *
 * @author Pertsev Roman (Alexander Laptev, Ivan Kosenko)
 */
public class Model {
    public List<Vector3f> vertices = new ArrayList<>();
    public List<Vector2f> textureVertices = new ArrayList<>();
    public List<Vector3f> normals = new ArrayList<>();
    public List<Polygon> polygons = new ArrayList<>();
}
