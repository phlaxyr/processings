package trickery;

import shape.IShape;

public interface ITangible {
	public IShape getShape();
	public IDrawHandler getDrawer();
}
