package clickers;

import rect.IDrawnShape;
import rect.IShapeProvider;
import trickery.IRegistered;

public interface IClickable<V extends IDrawnShape> extends IMouseHandler, IShapeProvider<V>, IRegistered {

//	public void setElement(V v);
	
	
	
}
