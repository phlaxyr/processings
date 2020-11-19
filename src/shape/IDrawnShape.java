package shape;

public interface IDrawnShape extends IDrawn, IShape{

	@Override
	default IShape getShape() {
		return this;
	}
}
