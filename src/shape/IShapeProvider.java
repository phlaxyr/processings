package shape;

public interface IShapeProvider<V extends IShape> extends IShape{
	V getShape();
	@Override
	default boolean isPointWithin(float x, float y) {
		return getShape().isPointWithin(x, y);
	}
	@Override
	default boolean isPointWithin(int x, int y) {
		return getShape().isPointWithin(x, y);
	}
}
