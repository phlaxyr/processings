package shape;

import trickery.IDrawHandler;
import trickery.ISetupable;

public interface IDrawn extends IDrawHandler, ISetupable{
	IShape getShape();
	// void draw();

}
