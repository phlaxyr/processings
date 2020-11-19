package shape;

import main.Main;
import trickery.IDrawHandler;
import trickery.ISetupable;

public class RectDrawer implements IDrawHandler, ISetupable{
	public static Main main;
	public RectShape r;
	public RectDrawer(int x, int y, int sizex, int sizey) {
		this.r = new RectShape(x, y, sizex, sizey);
	}
	public RectDrawer(RectShape shape) {
		this.r = shape;
	}

	public void draw() {
		RectShape.draw(main, r);
	}
	
	public IShape getShape() {
		return r;
	}
	@Override
	public void onSetup() {
		
	}

}
