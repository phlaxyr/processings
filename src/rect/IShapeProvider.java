package rect;

public interface IShapeProvider<V extends IDrawnShape> extends IDrawnShape{
	V getShape();
	@Override
	default void draw() {
		getShape().draw();
	}
	@Override
	default boolean isPointWithin(float x, float y) {
		return getShape().isPointWithin(x, y);
	}
	@Override
	default boolean isPointWithin(int x, int y) {
		return getShape().isPointWithin(x, y);
	}
}
