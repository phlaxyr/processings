package trickery;

import clickers.IClickable;
import shape.IShape;

public abstract class TangibleImpl2 extends TangibleImpl{

	public TangibleImpl2() {
		super(null, null);
		this.shape = createShape();
		this.drawer = createDrawer(shape);
	}
	
	public TangibleImpl2(IClickable clicker) {
		super(clicker, clicker);
	}

	public TangibleImpl2(IShape shape, IDrawHandler drawer) {
		super(shape, drawer);
	}

	public abstract IShape createShape();
	public abstract IDrawHandler createDrawer(IShape shape);

}
