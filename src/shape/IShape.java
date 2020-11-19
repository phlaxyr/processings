package shape;

import trickery.ISetupable;

public interface IShape extends ISetupable{
	boolean isPointWithin(int x, int y);
	boolean isPointWithin(float x, float y);
}
