package trickery;

import clickers.IClickable;
import clickers.IMouseable;
import shape.IShape;

public abstract class TangibleImpl implements ITangible{

	protected IShape shape;
	protected IDrawHandler drawer;
	public TangibleImpl(IShape shape, IDrawHandler drawer) {
		this.shape = shape;
		this.drawer = drawer;
	}
	public TangibleImpl(IClickable clicker, IDrawHandler drawer) {
		this.shape = clicker.getShape();
		this.drawer = drawer;
	}
	

	
	
	@Override
	public IShape getShape() {
		return shape;
	}
	@Override
	public IDrawHandler getDrawer() {
		return drawer;
	}
	
	public IMouseable getMouseHandler() {
		return IMouseable.NONE;
	}
}
